package jw795.ast;

/**
 * Representation of a multiplication binary operation.
 */
public class Mult extends BinOpExpr{
    Mult(Expr e1, Expr e2, int line, int col) {
        super(e1, e2, line, col);
    }
}
