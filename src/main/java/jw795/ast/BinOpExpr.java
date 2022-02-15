package jw795.ast;

/**
 * Representation of a binary operation in AST.
 */
public abstract class BinOpExpr implements Expr{
    Expr expr1;
    Expr expr2;

    BinOpExpr(Expr e1, Expr e2) {
        expr1 = e1;
        expr2 = e2;
    }
}

