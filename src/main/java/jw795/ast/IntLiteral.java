package jw795.ast;

/**
 * Representation of an integer in AST.
 */
public class IntLiteral implements Expr{
    long value;

    IntLiteral(long val) {
        value = val;
    }
}
