package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representation of a while statement in AST.
 */
public class WhileStmt extends Statement {
    Expr condition;
    Statement loopBody;

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
}
