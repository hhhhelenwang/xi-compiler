package jw795.parser;

import java_cup.runtime.Symbol;
import jw795.ast.ASTNode;
import jw795.ast.Expr;
import jw795.lexer.Lexer;
import jw795.lexer.Lexwrapper;
import jw795.parser.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Reader;
import java_cup.runtime.Scanner;
//import java_cup.runtime.Parser;
import util.polyglot.util.CodeWriter;
import util.polyglot.util.OptimalCodeWriter;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

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
        // build output file
        // build the full directory to put the lexed file in
        String[] dirs = fileName.split("/");
        String fullPath = parsedPath + "/";
        for (int i = 0; i < dirs.length - 1; i ++) {
            fullPath += dirs[i] + "/";
        }
        // build the name of the lexed file
        String file = dirs[dirs.length - 1];
        String parsedFile;
        String end = file.substring(file.length()-3);
        if (end.equals(".xi")) {
            parsedFile = file.substring(0, file.length()-3)  + ".parsed";
        } else {
            parsedFile = file.substring(0, file.length()-4)  + ".parsed";
        }

        // check if directory to put the lexed file in exists, create a new dir if doesn't
        File directory = new File(fullPath);
        if (!directory.exists()) {
            directory.mkdir();
        }

        // build file and a PrintWriter to be used by CodeWriter
        File targetParsed = new File(fullPath + parsedFile);
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
            Symbol node = cup_parser.parse(); // TODO: ????????????

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
