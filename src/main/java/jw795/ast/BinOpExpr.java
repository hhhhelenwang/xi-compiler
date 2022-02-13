package jw795.ast;

/**
 * Representation of a binary operation in AST.
 */
public class BinOpExpr implements Expr{
    public enum BinOp {
        MULT,
        HIGHMULT,
        DIV,
        MOD,
        ADD,
        MINUS,
        LT,
        LE,
        GE,
        GT,
        EQ,
        NEQ,
        AND,
        OR
    }

    BinOp binOp;
    Expr expr1;
    Expr expr2;

    BinOpExpr(BinOp op, Expr e1, Expr e2) {
        binOp = op;
        expr1 = e1;
        expr2 = e2;
    }
}

