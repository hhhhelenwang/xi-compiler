package jw795.ast;

/**
 * Representation of a less-than comparison.
 */
public class LessThan extends BinOpExpr{
    LessThan(Expr e1, Expr e2, int line, int col) {
        super(e1, e2, line, col);
    }
}
