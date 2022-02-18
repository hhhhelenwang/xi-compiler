package jw795.lexer;
import java_cup.runtime.*;
import jw795.lexer.Lexer;
import jw795.lexer.Lexer.TokenType;
import java_cup.runtime.Symbol;
import jw795.parser.sym;

public class Lexwrapper implements java_cup.runtime.Scanner {

    Lexer thelexer;
    String filename;
    boolean started;

    public Lexwrapper(java.io.Reader in, String name){
        thelexer = new Lexer(in);
        filename = name;
        started = false;
    }

    public Symbol next_token() throws java.io.IOException {
        if (started) {
            return thelexer.next_token();
        } else {
            started = true;
            String end = filename.substring(filename.length()-3, filename.length());
            if (end.equals("ixi")) {
                return new Symbol(sym.INTERFACE_FILE,999,999);
            } else {
                return new Symbol(sym.PROGRAM_FILE,888,888);
            }
        }
    }
}