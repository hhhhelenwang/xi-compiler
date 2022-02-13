package jw795.ast;

import java.util.List;

/**
 * Representation of function calls in AST.
 */
public class FunCallExpr implements Expr{
    String name;
    List<Expr> arguments;

    FunCallExpr(String n, List<Expr> args) {
        name = n;
        arguments = args;
    }
}
