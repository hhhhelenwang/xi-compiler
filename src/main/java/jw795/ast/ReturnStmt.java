package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

import java.util.List;

/**
 * Representation of a return statement.
 */
public class ReturnStmt extends Statement {
    List<Expr> returnVals;

    public ReturnStmt(List<Expr> vals, int line, int col) {
        super(line, col);
        returnVals = vals;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom("return");
        for (Expr val : returnVals) {
            val.prettyPrint(printer);
        }
        printer.endList();
    }
}
