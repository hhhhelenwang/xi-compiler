package jw795.ast;

/**
 * Representation of a not equal comparison.
 */
public class NotEqual extends BinOpExpr{
    NotEqual(Expr e1, Expr e2) {
        super(e1, e2);
    }
}
