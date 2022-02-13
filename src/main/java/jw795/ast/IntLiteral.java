package jw795.ast;

/**
 * Representation of an integer in AST.
 */
public class IntLiteral implements Expr{
    int value;

    IntLiteral(int val) {
        value = val;
    }
}
