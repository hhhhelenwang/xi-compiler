package jw795.ast;

import jw795.Visitor;

/**
 * Representation of a binary operation in AST.
 */
public abstract class BinOpExpr extends Expr{
    public Expr expr1;
    public Expr expr2;

    BinOpExpr(Expr e1, Expr e2, int line, int col) {
        super(line, col);
        expr1 = e1;
        expr2 = e2;
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        expr1.accept(visitor);
        expr2.accept(visitor);
    }
}
