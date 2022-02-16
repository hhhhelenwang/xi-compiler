package jw795.ast;

/**
 * Representation of an integer in AST.
 */
public class IntLiteral extends Expr{
    long value;

    IntLiteral(long val, int line, int col) {
        super(line, col);
        value = val;
    }
}
