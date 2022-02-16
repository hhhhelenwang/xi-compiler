package jw795.ast;

/**
 * Representation of a while statement in AST.
 */
public class WhileStmt extends Statement {
    Expr condition;
    Statement loopBody;

    WhileStmt(Expr cond, Statement body, int line, int col) {
        super(line, col);
        condition = cond;
        loopBody = body;
    }
}
