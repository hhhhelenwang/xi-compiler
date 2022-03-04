package util;

/** Signals that a lexical error appears while lexing the file. */
public class LexicalErrorException extends RuntimeException{
    public LexicalErrorException(String message) {
        super(message);
    }
}
