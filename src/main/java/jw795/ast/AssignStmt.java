package jw795.ast;

/**
 * Representation of an assignment statement.
 */
public class AssignStmt implements Statement{
    LValue leftVal;
    RValue rightVal;

    AssignStmt(LValue left, RValue right) {
        leftVal = left;
        rightVal = right;
    }

}
