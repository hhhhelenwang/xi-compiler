package jw795.ast;

/**
 * Representation of a binary operation in AST.
 */
public class BinOpExpr extends Expr{
    Expr expr1;
    Expr expr2;

    BinOpExpr(Expr e1, Expr e2, int line, int col) {
        super(line, col);
        expr1 = e1;
        expr2 = e2;
    }
}
