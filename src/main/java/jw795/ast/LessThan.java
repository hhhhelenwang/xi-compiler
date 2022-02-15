package jw795.ast;

/**
 * Representation of a less-than comparison.
 */
public class LessThan extends BinOpExpr{
    LessThan(Expr e1, Expr e2) {
        super(e1, e2);
    }
}
