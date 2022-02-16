package jw795.ast;

/**
 * Representation of a logical or operation.
 */
public class Or extends BinOpExpr{
    Or(Expr e1, Expr e2, int line, int col) {
        super(e1, e2, line, col);
    }
}
