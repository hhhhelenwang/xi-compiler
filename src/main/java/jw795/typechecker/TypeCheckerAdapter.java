package jw795.typechecker;
import jw795.lexer.Lexwrapper;
import jw795.parser.parser;
import jw795.typechecker.TypeChecker;
import jw795.ast.*;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import util.edu.cornell.cs.cs4120.util.FileUtil;
import util.polyglot.util.CodeWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Reader;


public class TypeCheckerAdapter {
    TypeChecker checker;
    parser cup_parser;
    Lexwrapper scanner;
    CodeWriter writer;
    String parsedPath; // the path to put the parsed file in
    String fileName;

    public TypeCheckerAdapter(Reader reader, String name, String path){
        this.checker = new TypeChecker();

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

        // parse
        try {
            ASTNode node = (ASTNode) cup_parser.parse().value;
            Visitor vis = new TypeChecker();
        } catch (Exception e) {
            printer.printAtom(e.getMessage());
            printer.flush();
            printer.close();
        }
    }
}
