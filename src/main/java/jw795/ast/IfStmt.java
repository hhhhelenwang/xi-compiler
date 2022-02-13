package jw795.ast;

/**
 * Representation of an if statement with no else branch in AST.
 */
public class IfStmt implements Statement{
    Expr condition;
    Statement clause;

    IfStmt(Expr cond, Statement cls) {
        condition = cond;
        clause = cls;
    }

}
