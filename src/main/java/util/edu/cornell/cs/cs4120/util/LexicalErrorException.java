package util.edu.cornell.cs.cs4120.util;

/** Signals that a lexical error appears while lexing the file. */
public class LexicalErrorException extends Exception{
    public LexicalErrorException(String message) {
        super(message);
    }
}
