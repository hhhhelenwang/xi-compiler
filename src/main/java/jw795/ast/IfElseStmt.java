package jw795.ast;

/**
 * Representation of an if-else statement in AST.
 */
public class IfElseStmt implements Statement{
    Expr condition;
    Statement ifClause;
    Statement elseClause;

    IfElseStmt(Expr cond, Statement clause1, Statement clause2) {
        condition = cond;
        ifClause = clause1;
        elseClause = clause2;
    }

}
