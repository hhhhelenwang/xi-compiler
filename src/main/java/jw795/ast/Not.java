package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representation of Not, the boolean negation.
 */
public class Not extends UnOpExpr{
    public Not(Expr val, int line, int col) {
        super(val, line, col);
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom("!");
        expr.prettyPrint(printer);
        printer.endList();
    }
}
