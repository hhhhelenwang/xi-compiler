package jw795.ast;

/**
 * Representation of a less than or equal to comparison.
 */
public class LessEq extends BinOpExpr{
    LessEq(Expr e1, Expr e2) {
        super(e1, e2);
    }
}
