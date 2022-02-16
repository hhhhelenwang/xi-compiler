package jw795.ast;

/**
 * Representation of a return statement.
 */
public class ReturnStmt extends Statement {
    Expr returnVal;

    ReturnStmt(Expr val, int line, int col) {
        super(line, col);
        returnVal = val;
    }
}
