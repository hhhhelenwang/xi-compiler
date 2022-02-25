package jw795.ast;

import jw795.typechecker.Visitor;
import jw795.typechecker.XiType;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

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
    public void accept(Visitor visitor) {
        super.accept(visitor);
        visitor.visitIntNeg(this);
    }
}
