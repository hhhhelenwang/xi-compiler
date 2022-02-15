package jw795.ast;

/**
 * Representation of an assignment statement.
 */
public class AssignStmt implements Statement{
    LValue leftVal;
    Expr expr;

    AssignStmt(LValue left, Expr e) {
        leftVal = left;
        expr = e;
    }
}
