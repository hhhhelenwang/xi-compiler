package util;

/** Signals that a semantic error appears when type checking the file. */
public class SemanticErrorException extends Exception{
    public SemanticErrorException(String message) {
        super(message);
    }
}
