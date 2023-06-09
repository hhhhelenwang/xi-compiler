package jw795.ast;

import jw795.Visitor;
import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

import java.util.List;

/**
 * Representation of an array in AST.
 */
public class ArrayExpr extends Expr{
    public List<Expr> arrayElements;

    public ArrayExpr(List<Expr> elements, int line, int col) {
        super(line, col);
        arrayElements = elements;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        for (Expr e : arrayElements) {
            e.prettyPrint(printer);
        }
        printer.endList();
    }

    @Override
    public void accept(Visitor v) throws Exception {
        for (Expr e : arrayElements) {
            e.accept(v);
        }
        v.visitArrayExpr(this);
    }

}
