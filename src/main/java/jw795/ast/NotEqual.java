package jw795.ast;

/**
 * Representation of a not equal comparison.
 */
public class NotEqual extends BinOpExpr{
    NotEqual(Expr e1, Expr e2, int line, int col) {
        super(e1, e2, line, col);
    }
}
