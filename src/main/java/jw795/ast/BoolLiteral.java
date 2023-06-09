package jw795.ast;

import jw795.Visitor;
import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

public class BoolLiteral extends Expr{
    public boolean value;

    public BoolLiteral(boolean val, int line, int col) {
        super(line, col);
        value = val;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.printAtom(String.valueOf(value));
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitBoolLiteral(this);
    }
}
