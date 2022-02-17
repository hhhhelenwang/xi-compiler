package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

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
}
