package jw795.ast;

import jw795.Visitor;
import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representation of integer negation.
 */
public class IntNeg extends UnOpExpr{
    public IntNeg(Expr val, int line, int col) {
        super(val, line, col);
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom("-");
        expr.prettyPrint(printer);
        printer.endList();
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        super.accept(visitor);
        visitor.visitIntNeg(this);
    }
}
