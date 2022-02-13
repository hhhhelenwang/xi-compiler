package jw795.ast;

import java.util.List;

/**
 * Representation of a block of statements.
 */
public class BlockStmt implements Statement {
    List<Statement> statements;

    BlockStmt(List<Statement> stmts) {
        statements = stmts;
    }
}
