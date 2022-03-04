package jw795.typechecker;
import jw795.lexer.Lexwrapper;
import jw795.parser.parser;
import jw795.ast.*;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import util.FileUtil;
import util.LexicalErrorException;
import util.SyntacticErrorException;
import util.SemanticErrorException;
import util.polyglot.util.CodeWriter;

import java.io.*;
import java.util.*;


public class TypeCheckerAdapter {
    parser cup_parser;
    Lexwrapper scanner;
    CodeWriter writer;
    String destPath; // the path to put the typed file in
    String libPath; // path to find the interface files in
    String fileName; // already contains source dir + file name

    public TypeCheckerAdapter(Reader reader, String name, String dest, String lib){
        // paths and files
        this.destPath = dest;
        this.libPath = lib;
        this.fileName = name;
        // build parser
        this.scanner = new Lexwrapper(reader, name);
        this.cup_parser = new parser(scanner);

    }

    public void gentypecheck(){
        //generate the target .parsed file
        File targetParsed = FileUtil.generateTargetFile(fileName, destPath, "typed");
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(targetParsed);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // build CodeWriter, default width 80 col
        CodeWriterSExpPrinter printer = new CodeWriterSExpPrinter(pw);

        // Keep track of current file been processed
        String curFile = fileName;

        // parse and type check program and interfaces
        try {
            // parse the program
            Program node = (Program) cup_parser.parse().value;

            TypeChecker visitor = new TypeChecker();

            // first pass of top level definitions
            programFirstPass(node, visitor);

            // to resolve dependencies, find imported interface files, parse them, and type check them
            HashMap<String, Interface> dependencies = new HashMap<>();
            for (Use use : node.uses) {
                try {
                    if (!use.interfaceName.equals("io")) {
                        // check for repeated use of interface
                        if (dependencies.containsKey(use.interfaceName)) {
                            String pos = visitor.errorstart(use.getLine(), use.getCol());
                            curFile = fileName;
                            throw new SemanticErrorException(pos + "Interface already used");
                        }
                        curFile = use.interfaceName;
                        String interfaceFileName = libPath + use.interfaceName + ".ixi";
                        Reader interfaceReader = new FileReader(interfaceFileName);
                        Lexwrapper interfaceScanner = new Lexwrapper(interfaceReader, interfaceFileName);
                        parser interfaceParser = new parser(interfaceScanner);
                        Interface interfaceNode = (Interface) interfaceParser.parse().value;
                        dependencies.put(use.interfaceName, interfaceNode);
                    }
                } catch (FileNotFoundException e) {
                    String pos = visitor.errorstart(use.getLine(), use.getCol());
                    throw new Exception(pos + "Interface " + use.interfaceName + " not found");
                } catch (SemanticErrorException e) {
                    // interface used twice
                    throw e;
                }
            }

            // check all interfaces and add them to context
            for (Use use : node.uses) {
                curFile = use.interfaceName;
                Interface interfaceNode = dependencies.get(use.interfaceName);
                interfaceNode.accept(visitor); // type check interface using the same visitor
            }

            // type check the entire program
            node.accept(visitor);

            printer.printAtom("Valid Xi Program");
            printer.flush();
            printer.close();
        } catch (LexicalErrorException e){
            String errMsg = stdOutError("Lexical", curFile, e.getMessage());
            System.out.println(errMsg);
            printer.printAtom(errMsg);
            printer.flush();
            printer.close();
        } catch (SyntacticErrorException e) {
            String errMsg = stdOutError("Syntax", curFile, e.getMessage());
            System.out.println(errMsg);
            printer.printAtom(errMsg);
            printer.flush();
            printer.close();
        } catch (SemanticErrorException e) {
            String errMsg = stdOutError("Semantic", curFile, e.getMessage());
            System.out.println(errMsg);
            printer.printAtom(errMsg);
            printer.flush();
            printer.close();
        } catch (Exception e) {
            // no idea what error so just report
            printer.printAtom(e.getMessage());
            printer.flush();
            printer.close();
        }
    }

    /** Standard output error message. <kind> error beginning at <filename>:<line>:<column>: <description> */
    private String stdOutError(String errorKind, String fileName, String error) {
        return errorKind + "error beginning at" + fileName + ":" + error;
    }


    /** The first pass of type checking global definitions in a program. */
    public void programFirstPass(Program node, TypeChecker visitor) throws Exception {
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

    /** First pass of function definition. */
    private void funDefFirstPass(FunctionDefine node, TypeChecker visitor) {
        if (!visitor.env.containsFun(node.name)){
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
            // TODO: error
        }

    }

    /** First pass of procedure definition. */
    private void procDefFirstPass(ProcedureDefine node, TypeChecker visitor) {
        // TODO: check if procedure exist
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
    }

    /** First pass of procedure definition. */
    private void globDeclFirstPass(GlobDeclare globDecl, TypeChecker visitor) throws Exception {
        if(visitor.env.containsVar(globDecl.identifier)){
            String res = visitor.errorstart(globDecl.getLine(),globDecl.getCol());
            res += "variable already been declared";
            throw new Exception(res);
        }else{
            globDecl.value.accept(visitor);

        }


    }

}
