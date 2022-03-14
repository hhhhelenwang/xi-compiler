package jw795.ast;

import edu.cornell.cs.cs4120.xic.ir.IRExpr;
import jw795.Visitor;
import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representation of array elements in AST. Implements Expr and RValue.
 */
public class ArrIndexExpr extends Expr implements LValue{
    public Expr array;
    public Expr index;

    public ArrIndexExpr(Expr arr, Expr i, int line, int col) {
        super(line, col);
        array = arr;
        index = i;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom("[]");
        array.prettyPrint(printer);
        index.prettyPrint(printer);
        printer.endList();
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        array.accept(visitor);
        index.accept(visitor);
        visitor.visitArrIndexExpr(this);
    }

    @Override
    //TODO: implement this
    public IRExpr getir() {
        return null;
    }
}
