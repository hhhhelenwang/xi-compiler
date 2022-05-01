package jw795.ast;

import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import jw795.Visitor;

public class RecordType extends Type{
    public String name;

    public RecordType(String n, int li, int co) {
        super(li, co);
        name = n;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.printAtom(name);
    }

    @Override
    public void accept(Visitor visitor) throws Exception {

    }
}
