package jw795.ast;

/**
 * Representations of variables in AST. Implements interface Expr and LValue.
 */
public class VarExpr implements Expr, LValue{
    String identifier;

    VarExpr(String id) {
        identifier = id;
    }
}
