package jw795.ast;

import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import jw795.Visitor;

public class Null extends Expr{
    public Null(int li, int co) {
        super(li, co);
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.printAtom("null");
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        visitor.visitNull(this);
    }
}
