package jw795.ast;

import jw795.typechecker.Visitor;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representation of a while statement in AST.
 */
public class WhileStmt extends Statement {
    public Expr condition;
    public Statement loopBody;

    public WhileStmt(Expr cond, Statement body, int line, int col) {
        super(line, col);
        condition = cond;
        loopBody = body;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom("while");
        condition.prettyPrint(printer);
        loopBody.prettyPrint(printer);
        printer.endList();
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        condition.accept(visitor);
        visitor.enterScope();
        loopBody.accept(visitor);
        visitor.leaveScope();
        visitor.visitWhileStmt(this);

    }
}
