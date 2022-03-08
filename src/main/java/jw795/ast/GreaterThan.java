package jw795.ast;

import jw795.typechecker.Visitor;
import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representation of a greater-than comparison.
 */
public class GreaterThan extends BinOpExpr{
    public GreaterThan(Expr e1, Expr e2, int line, int col) {
        super(e1, e2, line, col);
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom(">");
        expr1.prettyPrint(printer);
        expr2.prettyPrint(printer);
        printer.endList();
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        super.accept(visitor);
        visitor.visitGreaterThan(this);
    }
}
