package jw795.ast;

import edu.cornell.cs.cs4120.xic.ir.IRExpr;
import jw795.Visitor;

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
    public void accept(Visitor visitor) throws Exception {
        expr.accept(visitor);
    }
}
