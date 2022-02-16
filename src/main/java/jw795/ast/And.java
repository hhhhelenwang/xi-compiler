package jw795.ast;

/**
 * Representation of a logical and operation.
 */
public class And extends BinOpExpr{
    And(Expr e1, Expr e2, int line, int col) {
        super(e1, e2, line, col);
    }
}
