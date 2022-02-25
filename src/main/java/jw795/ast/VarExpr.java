package jw795.ast;

import jw795.typechecker.Visitor;
import jw795.typechecker.XiType;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representations of variables in AST. Implements interface Expr and LValue.
 */
public class VarExpr extends Expr implements LValue{
    public String identifier;

    public VarExpr(String id, int line, int col) {
        super(line, col);
        identifier = id;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.printAtom(identifier);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitVar(this);
    }
}
