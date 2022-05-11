package jw795.ast;

import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import edu.cornell.cs.cs4120.xic.ir.IRExpr;
import jw795.Visitor;

public class Dot extends Expr implements LValue{
    public String recordname;
    public String fieldname;

    public Dot(String i, String d, int li, int co) {
        super(li, co);
        recordname = i;
        fieldname = d;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.printAtom(recordname);
        printer.printAtom(".");
        printer.printAtom(fieldname);
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        visitor.visitDot(this);
    }

    @Override
    public IRExpr getir() {
        System.out.println("Not yet implemented");
        return null;
    }
}
