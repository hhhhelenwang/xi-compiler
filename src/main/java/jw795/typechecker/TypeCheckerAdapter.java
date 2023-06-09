package jw795.typechecker;

import jw795.ast.*;
import jw795.lexer.Lexwrapper;
import jw795.parser.parser;
import jw795.util.LexicalErrorException;
import jw795.util.SemanticErrorException;
import jw795.util.SyntacticErrorException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static jw795.util.FileUtil.generateTargetFile;

/**
 * Take in a single source file and perform type-checking on the file.
 */
public class TypeCheckerAdapter {
    parser cup_parser;
    Lexwrapper scanner;
    String destPath; // the path to put the typed file in
    String libPath; // path to find the interface files in
    String fileName; // already contains source dir + file name
    boolean genFile; // if a type check diagnostic file need to be generated
    TypeChecker visitor;
    String ending;

    public TypeCheckerAdapter(Reader reader, String name, String dest, String lib, boolean gen, String ending) {
        // paths and files
        this.destPath = dest;
        this.libPath = lib;
        this.fileName = name;
        // build parser
        this.scanner = new Lexwrapper(reader, name);
        this.cup_parser = new parser(scanner);
        this.genFile = gen;
        this.visitor = new TypeChecker();
        this.ending = ending;
    }

    /**
     * Type check the file taken in by the class.
     * @return return the type-checked AST of the input file
     */
    public ASTNode generateTypeCheck() {
        //generate the target .parsed file
        FileWriter targetWriter = null;
        try {
            if (genFile) {
                File targetParsed = generateTargetFile(fileName, destPath, "typed");
                targetWriter = new FileWriter(targetParsed);
            }

            // Keep track of current file been processed
            String curFile = fileName;

            // parse and type check program and interfaces
            try {
                // parse the program
                Program node = (Program) cup_parser.parse().value;

                // first pass of top level definitions
                programFirstPass(node, visitor);

                for (Use use : node.uses) {
                    try {
                        if (!use.interfaceName.equals("io")) {
                            String interfaceFileName;
                            if(use.interfaceName.equals("conv")){
                                interfaceFileName = libPath + use.interfaceName + ".ixi";
                            }else{
                                interfaceFileName = libPath + use.interfaceName + ending;
                            }
                            curFile = interfaceFileName;
                            Reader interfaceReader = new FileReader(interfaceFileName);
                            Lexwrapper interfaceScanner = new Lexwrapper(interfaceReader, interfaceFileName);
                            parser interfaceParser = new parser(interfaceScanner);
                            ASTNode interfaceNode = (ASTNode) interfaceParser.parse().value;
                            interfaceNode.accept(visitor);
                        }
                    } catch (FileNotFoundException e) {
                        curFile = fileName;
                        String pos = visitor.errorstart(use.getLine(), use.getCol());
                        throw new SemanticErrorException(pos + "Interface " + use.interfaceName + " not found");
                    } catch (Exception e) {
                        throw e;
                    }
                }
                curFile = fileName;
                node.accept(visitor);
                if (genFile) {
                    targetWriter.write("Valid Xi Program" + "\n");
                    targetWriter.close();
                }
                return node;
            } catch (LexicalErrorException e) {
                String errMsg = stdOutError("Lexical ", curFile, e.getMessage());
                System.out.println(errMsg);
                if (genFile) {
                    targetWriter.write(e.getMessage());
                    targetWriter.write("\n");
                    targetWriter.close();
                }
            } catch (SyntacticErrorException e) {
                String errMsg = stdOutError("Syntax ", curFile, e.getMessage());
                System.out.println(errMsg);
                if (genFile) {
                    targetWriter.write(e.getMessage());
                    targetWriter.write("\n");
                    targetWriter.close();
                }
            } catch (SemanticErrorException e) {
                String errMsg = stdOutError("Semantic ", curFile, e.getMessage());
                System.out.println(errMsg);
                if (genFile) {
                    targetWriter.write(e.getMessage());
                    targetWriter.write("\n");
                    targetWriter.close();
                }
            } catch (Exception e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
                System.out.println("Unknown error while type checking " + fileName);
                if (genFile) {
                    targetWriter.write("Unknown error");
                    targetWriter.write("\n");
                    targetWriter.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Compiler error: target file not found");
        }
        return null; // should not reach here
    }

    /**
     * Standard output error message in the format of
     * <kind> error beginning at <filename>:<line>:<column>: <description>
     * @param errorKind error kind
     * @param fileName file name
     * @param error error
     * @return a stdout error message
     */
    private String stdOutError(String errorKind, String fileName, String error) {
        return errorKind + "error beginning at " + fileName + ":" + error;
    }


    /**
     * The first pass of type checking global definitions in a program to add the types into the context
     * @param node a program ast
     * @param visitor a type-checker visitor that is going to be used to type check the rest of the program
     * @throws SemanticErrorException
     */
    public void programFirstPass(Program node, TypeChecker visitor) throws SemanticErrorException {
        for (Definition def : node.definitions) {
            if (def instanceof FunctionDefine) {
                funDefFirstPass((FunctionDefine) def, visitor);
            } else if (def instanceof ProcedureDefine) {
                procDefFirstPass((ProcedureDefine) def, visitor);
            } else if (def instanceof GlobDeclare) {
                globDeclFirstPass((GlobDeclare) def, visitor);
            } else if (def instanceof RecordDeclare){
                recordDeclFirstPass((RecordDeclare) def, visitor);
            }
        }
    }

    /**
     * First pass of function definitions to add the types into context
     * @param node a function definition ast
     * @param visitor a type-checker visitor that is going to be used to type check the rest of the program
     * @throws SemanticErrorException
     */
    private void funDefFirstPass(FunctionDefine node, TypeChecker visitor) throws SemanticErrorException {
        if (!visitor.env.containsFun(node.name)) {
            T input;
            T output;
            if (node.arguments.size() == 0) {
                input = new Unit();
            } else if (node.arguments.size() == 1) {
                input = visitor.typeToTau(node.arguments.get(0).argType);
            } else {
                List<Tau> eletype = new ArrayList<>();
                for (FunProcArgs fp : node.arguments) {
                    eletype.add(visitor.typeToTau(fp.argType));
                }
                input = new Prod(eletype);
            }

            if (node.returnTypes.size() == 1) {
                output = visitor.typeToTau(node.returnTypes.get(0));
            } else {
                List<Tau> rettype = new ArrayList<>();
                for (Type e : node.returnTypes) {
                    rettype.add(visitor.typeToTau(e));
                }
                output = new Prod(rettype);
            }

            Fn result = new Fn(input, output);
            visitor.env.addFun(node.name, result);
        } else {
            throw new SemanticErrorException(visitor.errorstart(node.getLine(), node.getCol())
                    + "function name " + node.name + " is already used.");
        }
    }

    /**
     * First pass of procedure definitions to add the types into context
     * @param node a procedure definition ast
     * @param visitor a type-checker visitor that is going to be used to type check the rest of the program
     * @throws SemanticErrorException
     */
    private void procDefFirstPass(ProcedureDefine node, TypeChecker visitor) throws SemanticErrorException {
        if (!visitor.env.containsFun(node.name)) {
            T input;
            if (node.arguments.size() == 0) {
                input = new Unit();
            } else if (node.arguments.size() == 1) {
                input = visitor.typeToTau(node.arguments.get(0).argType);
            } else {
                List<Tau> eletype = new ArrayList<>();
                for (FunProcArgs fp : node.arguments) {
                    eletype.add(visitor.typeToTau(fp.argType));
                }
                input = new Prod(eletype);
            }

            Fn result = new Fn(input, new Unit());
            visitor.env.addFun(node.name, result);
        } else {
            throw new SemanticErrorException(visitor.errorstart(node.getLine(), node.getCol())
                    + "function name " + node.name + " is already used.");
        }
    }

    /**
     * First pass of global declarations to add the types into context
     * @param globDecl a global declaration ast
     * @param visitor a type-checker visitor that is going to be used to type check the rest of the program
     * @throws SemanticErrorException
     */
    private void globDeclFirstPass(GlobDeclare globDecl, TypeChecker visitor) throws SemanticErrorException {
        if (visitor.env.containsVar(globDecl.identifier)) {
            String res = visitor.errorstart(globDecl.getLine(), globDecl.getCol());
            res += "variable has already been declared";
            throw new SemanticErrorException(res);
        } else {
            visitor.env.addVar(globDecl.identifier, new Var(visitor.typeToTau(globDecl.varType)));
        }
    }

    /**
     * First pass and the only pass for record declare
     * add the record type to visitor's symboltable
     * @param def the node for recorddeclare
     * @param visitor the visitor, should be a typechecker
     * @throws SemanticErrorException
     */
    private void recordDeclFirstPass(RecordDeclare def, TypeChecker visitor) throws SemanticErrorException{
        visitor.env.addRecord(def.name, def.fieldtypelst);
    }

    /**
     * getter for hashmap of function
     * @return
     */
    public HashMap<String, Sigma> getFunctions() {
        return visitor.env.getFunctions();
    }

    /**
     * getter for hashmap of records
     * @return
     */
    public HashMap<String, Record> getRecords() {
        return visitor.env.records;
    }
}
