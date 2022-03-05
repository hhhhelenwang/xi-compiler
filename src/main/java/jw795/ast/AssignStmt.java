package jw795.ast;

import jw795.typechecker.Visitor;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representation of an assignment statement.
 */
public class AssignStmt extends Statement implements Definition {
    public LValue leftVal;
    public Expr expr;

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

    @Override
    public void accept(Visitor visitor) throws Exception {
        leftVal.accept(visitor);
        expr.accept(visitor);
        visitor.visitAssign(this);
    }
}
