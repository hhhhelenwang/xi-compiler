package jw795.lexer;
import java.io.Reader;
import jw795.lexer.Lexer;

public class LexerAdapt {
    Lexer lexer;

    public LexerAdapt (Reader reader) {
        lexer = new Lexer(reader);
    }



}
