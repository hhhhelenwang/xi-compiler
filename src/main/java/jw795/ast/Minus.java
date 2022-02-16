package jw795.ast;

/**
 * Representation of a minus binary operation.
 */
public class Minus extends BinOpExpr{
    Minus(Expr e1, Expr e2, int line, int col) {
        super(e1, e2, line, col);
    }
}
