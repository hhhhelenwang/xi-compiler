package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representation of a plus binary operation.
 */
public class Add extends BinOpExpr{
    public Add(Expr e1, Expr e2, int line, int col) {
        super(e1, e2, line, col);
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom("+");
        expr1.prettyPrint(printer);
        expr2.prettyPrint(printer);
        printer.endList();

    }
}