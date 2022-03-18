package jw795.typechecker;

import jw795.ast.*;
import jw795.lexer.Lexwrapper;
import jw795.parser.parser;
import jw795.util.LexicalErrorException;
import jw795.util.SemanticErrorException;
import jw795.util.SyntacticErrorException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static jw795.util.FileUtil.generateTargetFile;


public class TypeCheckerAdapter {
    parser cup_parser;
    Lexwrapper scanner;
    String destPath; // the path to put the typed file in
    String libPath; // path to find the interface files in
    String fileName; // already contains source dir + file name
    boolean genFile; // if a type check diagnostic file need to be generated
    TypeChecker visitor;

    public TypeCheckerAdapter(Reader reader, String name, String dest, String lib, boolean gen) {
        // paths and files
        this.destPath = dest;
        this.libPath = lib;
        this.fileName = name;
        // build parser
        this.scanner = new Lexwrapper(reader, name);
        this.cup_parser = new parser(scanner);
        this.genFile = gen;
        this.visitor = new TypeChecker();
    }

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
                            String interfaceFileName = libPath + use.interfaceName + ".ixi";
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
                e.printStackTrace();
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
                System.out.println("Unknown error while type checking " + fileName);
                if (genFile) {
                    targetWriter.write("Unknown error");
                    targetWriter.write("\n");
                    targetWriter.close();
                }
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Compiler error: target file not found");
        }
        return null; // should not reach here
    }

    /**
     * Standard output error message. <kind> error beginning at <filename>:<line>:<column>: <description>
     */
    private String stdOutError(String errorKind, String fileName, String error) {
        return errorKind + "error beginning at " + fileName + ":" + error;
    }


    /**
     * The first pass of type checking global definitions in a program.
     */
    public void programFirstPass(Program node, TypeChecker visitor) throws SemanticErrorException {
        for (Definition def : node.definitions) {
            if (def instanceof FunctionDefine) {
                funDefFirstPass((FunctionDefine) def, visitor);
            } else if (def instanceof ProcedureDefine) {
                procDefFirstPass((ProcedureDefine) def, visitor);
            } else if (def instanceof GlobDeclare) {
                globDeclFirstPass((GlobDeclare) def, visitor);
            }
        }
    }

    /**
     * First pass of function definition.
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
     * First pass of procedure definition.
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
     * First pass of procedure definition.
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

    public HashMap<String, Sigma> getFunctions() {
        return visitor.env.getFunctions();
    }
}
