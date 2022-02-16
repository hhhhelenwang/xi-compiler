package jw795.ast;

/**
 * Representation of a greater than or equal to binary operation.
 */
public class GreaterEq extends BinOpExpr{
    GreaterEq(Expr e1, Expr e2, int line, int col) {
        super(e1, e2, line, col);
    }
}
