package jw795.ast;

/**
 * Representation of unary operations in AST.
 */
public class UnOpExpr implements Expr{
    public enum UnOp {
        INTNEG,
        BOOLNEG,
    }

    UnOp unOp;
    Expr value;

    UnOpExpr(UnOp op, Expr val) {
        unOp = op;
        value = val;
    }
}
