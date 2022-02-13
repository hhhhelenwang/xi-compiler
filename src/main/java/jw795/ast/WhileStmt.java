package jw795.ast;

/**
 * Representation of a while statement in AST.
 */
public class WhileStmt implements Statement {
    Expr condition;
    Statement loopBody;

    WhileStmt(Expr cond, Statement body) {
        condition = cond;
        loopBody = body;
    }
}
