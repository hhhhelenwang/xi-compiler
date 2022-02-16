package jw795.ast;

import java.util.List;

/**
 * Representation of a procedure call.
 */
public class ProcCallStmt extends Statement {
    String name;
    List<Expr> arguments;

    ProcCallStmt(String n, List<Expr> args, int line, int col) {
        super(line, col);
        name = n;
        arguments = args;
    }
}
