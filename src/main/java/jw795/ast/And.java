package jw795.ast;

/**
 * Representation of a logical and operation.
 */
public class And extends BinOpExpr{
    And(Expr e1, Expr e2) {
        super(e1, e2);
    }
}
