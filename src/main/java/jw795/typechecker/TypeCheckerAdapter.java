package jw795.typechecker;
import jw795.lexer.Lexwrapper;
import jw795.parser.parser;
import jw795.typechecker.TypeChecker;
import jw795.ast.*;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import util.edu.cornell.cs.cs4120.util.FileUtil;
import util.polyglot.util.CodeWriter;

import java.io.*;
import java.util.HashMap;


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

            // to resolve dependencies, find imported interface files, parse them, and type check them
            HashMap<String, Interface> dependencies = new HashMap<>();
            for (Use use : node.uses) {
                try {
                    String interfaceFileName = use.interfaceName + ".ixi";
                    Reader interfaceReader = new FileReader(interfaceFileName);
                    Lexwrapper interfaceScanner = new Lexwrapper(interfaceReader, interfaceFileName);
                    parser interfaceParser = new parser(interfaceScanner);
                    Interface interfaceNode = (Interface) interfaceParser.parse().value;
                    dependencies.put(use.interfaceName, interfaceNode);
                } catch (FileNotFoundException e) {
                    String pos = errorstart(use.getLine(), use.getCol());
                    throw new Exception(pos + "Interface " + use.interfaceName + " not found");
                }
            }

            // check all interfaces and add them to context
            TypeChecker visitor = new TypeChecker();
            for (Use use : node.uses) {
                Interface interfaceNode = dependencies.get(use.interfaceName);
                interfaceNode.accept(visitor); // type check interface using the same visitor
            }

            // first pass of top level definitions
            programFirstPass(node, visitor);
            // type check the entire program
            node.accept(visitor);

        } catch (Exception e) {
            printer.printAtom(e.getMessage());
            printer.flush();
            printer.close();
        }
    }


    /** The first pass of type checking global definitions in a program. */
    public void programFirstPass(Program node, TypeChecker visitor) {
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
    private void funDefFirstPass(FunctionDefine funDef, TypeChecker visitor) {

    }

    /** First pass of procedure definition. */
    private void procDefFirstPass(ProcedureDefine procDef, TypeChecker visitor) {

    }

    /** First pass of procedure definition. */
    private void globDeclFirstPass(GlobDeclare globDecl, TypeChecker visitor) {

    }

    private String errorstart(int line, int colmn){
        return (line + ":" + colmn +" error: " );
    }
}
