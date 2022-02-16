package jw795.ast;

import java.util.List;

/**
 * Representation of a block of statements.
 */
public class BlockStmt extends Statement {
    List<Statement> statements;

    BlockStmt(List<Statement> stmts, int line, int col) {
        super(line, col);
        statements = stmts;
    }
}
