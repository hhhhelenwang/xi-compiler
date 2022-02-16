package jw795.ast;

import java.util.List;

/**
 * Representation of function calls in AST.
 */
public class FunCallExpr extends Expr{
    String name;
    List<Expr> arguments;

    FunCallExpr(String n, List<Expr> args, int line, int col) {
        super(line, col);
        name = n;
        arguments = args;
    }
}
