package util;

/** Signals that a syntactic error appears while parsing the file. */
public class SyntacticErrorException extends Exception {
    public SyntacticErrorException(String message) {
        super(message);
    }
}
