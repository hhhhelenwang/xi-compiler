package jw795.ast;

/**
 * Representation of a plus binary operation.
 */
public class Plus extends BinOpExpr{
    Plus(Expr e1, Expr e2, int line, int col) {
        super(e1, e2, line, col);
    }
}
