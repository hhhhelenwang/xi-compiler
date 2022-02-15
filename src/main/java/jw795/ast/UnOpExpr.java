package jw795.ast;

/**
 * Representation of unary operations in AST.
 */
public abstract class UnOpExpr implements Expr{
    Expr value;

    UnOpExpr(Expr val) {
        value = val;
    }
}
