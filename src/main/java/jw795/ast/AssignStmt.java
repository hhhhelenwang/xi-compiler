package jw795.ast;

/**
 * Representation of an assignment statement.
 */
public class AssignStmt extends Statement {
    LValue leftVal;
    Expr expr;

    AssignStmt(LValue left, Expr e, int line, int col) {
        super(line, col);
        leftVal = left;
        expr = e;
    }
}
