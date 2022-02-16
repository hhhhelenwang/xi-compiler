package jw795.ast;

/**
 * Representation of an if statement with no else branch in AST.
 */
public class IfStmt extends Statement {
    Expr condition;
    Statement clause;

    IfStmt(Expr cond, Statement cls, int line, int col) {
        super(line, col);
        condition = cond;
        clause = cls;
    }

}
