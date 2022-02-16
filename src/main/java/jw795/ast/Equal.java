package jw795.ast;

/**
 * Representation of a equal comparison.
 */
public class Equal extends BinOpExpr{
    Equal(Expr e1, Expr e2, int line, int col) {
        super(e1, e2, line, col);
    }
}
