package jw795.ast;

/**
 * Representation of a division binary operation.
 */
public class Div extends BinOpExpr{
    Div(Expr e1, Expr e2, int line, int col) {
        super(e1, e2, line, col);
    }
}
