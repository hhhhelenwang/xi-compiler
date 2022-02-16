package jw795.ast;

/**
 * Representation of an if-else statement in AST.
 */
public class IfElseStmt extends Statement {
    Expr condition;
    Statement ifClause;
    Statement elseClause;

    IfElseStmt(Expr cond, Statement clause1, Statement clause2, int line, int col) {
        super(line, col);
        condition = cond;
        ifClause = clause1;
        elseClause = clause2;
    }

}
