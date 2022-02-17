package jw795.parser;

import jw795.ast.ASTNode;
import jw795.ast.Expr;
import jw795.lexer.Lexer;
import jw795.lexer.Lexwrapper;
import jw795.parser.parser;

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
    String parsedPath;
    String fileName;

    public ParserAdapter(Reader reader, String name, String path) {
        scanner = new Lexwrapper(reader, name);
        cup_parser = new parser(scanner);
        fileName = name;
        parsedPath = path;
    }
//
    public void generatesyntree(){
        cup_parser.parse();
    }

    public void traverseAST(ASTNode node) {


    }

}
