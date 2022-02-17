package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representation of an integer in AST.
 */
public class IntLiteral extends Expr{
    long value;

    public IntLiteral(long val, int line, int col) {
        super(line, col);
        value = val;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.printAtom(String.valueOf(value));
    }
}
