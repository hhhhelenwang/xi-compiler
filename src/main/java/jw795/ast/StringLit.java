package jw795.ast;

import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import jw795.Visitor;

public class StringLit extends Expr{
    public String str;

    public StringLit(String s, int li, int co) {
        super(li, co);
        str = s;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.printAtom("\"" + str + "\"");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitStringLit(this);
    }
}
