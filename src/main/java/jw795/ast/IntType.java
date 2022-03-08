package jw795.ast;

import jw795.Visitor;
import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Represent of int type in AST.
 */
public class IntType extends Type {
    public IntType(int li, int co) {
        super(li, co);
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.printAtom("int");
    }

    @Override
    public void accept(Visitor visitor) {
        // should not be called
    }

}
