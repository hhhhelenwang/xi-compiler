package jw795.ast;

import jw795.Visitor;
import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representation of boolean type.
 */
public class BoolType extends Type {
    public BoolType(int li, int co) {
        super(li, co);
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.printAtom("bool");
    }

    @Override
    public void accept(Visitor visitor) {
        // should not be called
    }
}
