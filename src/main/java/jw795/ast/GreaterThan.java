package jw795.ast;

/**
 * Representation of a greater-than comparison.
 */
public class GreaterThan extends BinOpExpr{
    GreaterThan(Expr e1, Expr e2, int line, int col) {
        super(e1, e2, line, col);
    }
}
