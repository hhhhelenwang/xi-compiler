package jw795.ast;

/**
 * Representation of a high-multiplication binary operation.
 */
public class HighMult extends BinOpExpr{
    HighMult(Expr e1, Expr e2, int line, int col) {
        super(e1, e2, line, col);
    }
}
