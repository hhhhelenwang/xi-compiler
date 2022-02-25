package jw795.ast;

import jw795.typechecker.Visitor;

/**
 * Representation of unary operations in AST.
 */
public abstract class UnOpExpr extends Expr{
    public Expr expr;

    UnOpExpr(Expr e, int line, int col) {
        super(line, col);
        expr = e;
    }

    @Override
    public void accept(Visitor visitor) {
        expr.accept(visitor);
    }
}
