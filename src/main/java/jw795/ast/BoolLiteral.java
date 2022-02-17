package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

public class BoolLiteral extends Expr{
    boolean value;

    public BoolLiteral(boolean val, int line, int col) {
        super(line, col);
        value = val;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.printAtom(String.valueOf(value));
    }
}
