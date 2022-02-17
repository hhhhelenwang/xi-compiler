package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representation of an assignment statement.
 */
public class AssignStmt extends Statement {
    LValue leftVal;
    Expr expr;

    public AssignStmt(LValue left, Expr e, int line, int col) {
        super(line, col);
        leftVal = left;
        expr = e;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom("=");
        leftVal.prettyPrint(printer);
        expr.prettyPrint(printer);
        printer.endList();
    }
}
