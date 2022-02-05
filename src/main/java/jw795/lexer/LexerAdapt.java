package jw795.lexer;
import java.io.Reader;

public class LexerAdapt {
    Lexer lexer;

    LexerAdapt (Reader reader) {
        lexer = new Lexer(reader);
    }



}
