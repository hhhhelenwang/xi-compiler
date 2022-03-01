package jw795.ast;

import jw795.typechecker.Visitor;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

import java.util.List;

/**
 * Representation of a block of statements.
 */
public class BlockStmt extends Statement {
    public List<Statement> statements;

    public BlockStmt(List<Statement> stmts, int line, int col) {
        super(line, col);
        statements = stmts;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        for (Statement statement : statements) {
            statement.prettyPrint(printer);
        }
        printer.endList();
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        visitor.enterScope();
        for(Statement s: statements){
            s.accept(visitor);
        }
        visitor.visitBlockStmt(this);
        visitor.leaveScope();
    }
}
