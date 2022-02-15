package jw795.parser;

import jw795.lexer.Lexer;

import java.io.Reader;
import java_cup.runtime.Scanner;

public class ParserAdapter {
    Parser parser;
    Scanner scanner;

    ParserAdapter(Reader reader) {
        scanner = new Lexer(reader);
        parser = new Parser(scanner);
    }
}
