package jw795.typechecker;
import jw795.lexer.Lexwrapper;
import jw795.parser.parser;
import jw795.typechecker.TypeChecker;
import jw795.ast.*;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import util.edu.cornell.cs.cs4120.util.FileUtil;
import util.edu.cornell.cs.cs4120.util.LexicalErrorException;
import util.edu.cornell.cs.cs4120.util.SyntacticErrorException;
import util.polyglot.util.CodeWriter;

import javax.sound.midi.SysexMessage;
import java.io.*;
import java.util.*;


public class TypeCheckerAdapter {
    parser cup_parser;
    Lexwrapper scanner;
    CodeWriter writer;
    String parsedPath; // the path to put the parsed file in
    String fileName;

    public TypeCheckerAdapter(Reader reader, String name, String path){
        this.scanner = new Lexwrapper(reader, name);
        this.cup_parser = new parser(scanner);
        this.fileName = name;
        this.parsedPath = path;

    }

    public void gentypecheck(){
        //generate the target .parsed file
        File targetParsed = FileUtil.generateTargetFile(fileName, parsedPath, "typed");
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(targetParsed);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // build CodeWriter, default width 80 col
        CodeWriterSExpPrinter printer = new CodeWriterSExpPrinter(pw);

        // parse and type check program and interfaces
        try {
            // parse the program
            Program node = (Program) cup_parser.parse().value;

            TypeChecker visitor = new TypeChecker();

            // to resolve dependencies, find imported interface files, parse them, and type check them
            HashMap<String, Interface> dependencies = new HashMap<>();
            for (Use use : node.uses) {
                try {
                    if (use.interfaceName != "io") {
                        // check for repeated use of interface
                        if (dependencies.containsKey(use.interfaceName)) {
                            String pos = visitor.errorstart(use.getLine(), use.getCol());
                            throw new Exception(pos + "Interface already used");
                        }
                        String interfaceFileName = use.interfaceName + ".ixi";
                        Reader interfaceReader = new FileReader(interfaceFileName);
                        Lexwrapper interfaceScanner = new Lexwrapper(interfaceReader, interfaceFileName);
                        parser interfaceParser = new parser(interfaceScanner);
                        Interface interfaceNode = (Interface) interfaceParser.parse().value;
                        dependencies.put(use.interfaceName, interfaceNode);
                    }
                } catch (FileNotFoundException e) {
                    String pos = visitor.errorstart(use.getLine(), use.getCol());
                    throw new Exception(pos + "Interface " + use.interfaceName + " not found");
                } catch (Exception e) {
                    // interface used twice
                    throw e;
                }
            }

            // check all interfaces and add them to context
            for (Use use : node.uses) {
                Interface interfaceNode = dependencies.get(use.interfaceName);
                interfaceNode.accept(visitor); // type check interface using the same visitor
            }

            // first pass of top level definitions
            programFirstPass(node, visitor);

            // type check the entire program
            node.accept(visitor);



            printer.printAtom("Valid Xi Program");
            printer.flush();
            printer.close();
        } catch (LexicalErrorException | SyntacticErrorException e){
            System.out.println(e.getMessage());
            printer.flush();
            printer.close();
        } catch (Exception e) {
            printer.printAtom(e.getMessage());
            printer.flush();
            printer.close();
        }
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
