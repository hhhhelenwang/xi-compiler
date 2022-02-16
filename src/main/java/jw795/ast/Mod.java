package jw795.ast;

/**
 * Representation of a mod binary operation.
 */
public class Mod extends BinOpExpr {
    Mod(Expr e1, Expr e2, int line, int col) {
        super(e1, e2, line, col);
    }
}
