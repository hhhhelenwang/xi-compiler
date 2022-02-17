package jw795.ast;

/**
 * Representation of unary operations in AST.
 */
public abstract class UnOpExpr extends Expr{
    Expr expr;

    UnOpExpr(Expr e, int line, int col) {
        super(line, col);
        expr = e;
    }
}
