package jw795.ast;

/**
 * Representation of unary operations in AST.
 */
public abstract class UnOpExpr extends Expr{
    Expr value;

    UnOpExpr(Expr val, int line, int col) {
        super(line, col);
        value = val;
    }
}
