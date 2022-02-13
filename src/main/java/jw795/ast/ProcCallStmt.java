package jw795.ast;

import java.util.List;

/**
 * Representation of a procedure call.
 */
public class ProcCallStmt implements Statement{
    String name;
    List<Expr> arguments;

    ProcCallStmt(String n, List<Expr> args) {
        name = n;
        arguments = args;
    }

}
