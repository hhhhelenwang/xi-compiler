package jw795.util;

/** Signals that a syntactic error appears while parsing the file. */
public class SyntacticErrorException extends RuntimeException {
    public SyntacticErrorException(String message) {
        super(message);
    }
}
