package jw795.ast;

/**
 * Representations of variables in AST. Implements interface Expr and LValue.
 */
public class VarExpr extends Expr implements LValue{
    String identifier;

    VarExpr(String id, int line, int col) {
        super(line, col);
        identifier = id;
    }
}
