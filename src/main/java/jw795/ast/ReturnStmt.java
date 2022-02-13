package jw795.ast;

/**
 * Representation of a return statement.
 */
public class ReturnStmt implements Statement{
    Expr returnVal;

    ReturnStmt(Expr val) {
        returnVal = val;
    }
}
