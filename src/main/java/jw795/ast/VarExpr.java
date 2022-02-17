package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representations of variables in AST. Implements interface Expr and LValue.
 */
public class VarExpr extends Expr implements LValue{
    String identifier;

    public VarExpr(String id, int line, int col) {
        super(line, col);
        identifier = id;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.printAtom(identifier);
    }
}
