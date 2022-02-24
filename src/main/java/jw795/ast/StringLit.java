package jw795.ast;

import jw795.typechecker.Visitor;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

public class StringLit extends Expr{
    String str;

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
