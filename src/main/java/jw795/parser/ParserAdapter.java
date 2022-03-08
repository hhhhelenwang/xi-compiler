package jw795.parser;

import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import jw795.ast.ASTNode;
import jw795.lexer.Lexwrapper;
import jw795.util.FileUtil;
import polyglot.util.CodeWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Reader;

public class ParserAdapter {
    parser cup_parser;
    Lexwrapper scanner;
    CodeWriter writer;
    String parsedPath; // the path to put the parsed file in
    String fileName;

    public ParserAdapter(Reader reader, String name, String path) {
        scanner = new Lexwrapper(reader, name);
        cup_parser = new parser(scanner);
        fileName = name;
        parsedPath = path;
    }

    public void generateAST(){
        //generate the target .parsed file
        File targetParsed = FileUtil.generateTargetFile(fileName, parsedPath, "parsed");

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
            node.prettyPrint(printer);
            printer.flush();
            printer.close();
        } catch (Exception e) {
            printer.printAtom(e.getMessage());
            printer.flush();
            printer.close();
        }
    }
}
