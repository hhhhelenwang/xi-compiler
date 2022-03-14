package jw795.ast;

import edu.cornell.cs.cs4120.xic.ir.IRExp;
import edu.cornell.cs.cs4120.xic.ir.IRExpr;
import edu.cornell.cs.cs4120.xic.ir.IRExpr_c;
import jw795.Visitor;
import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representations of variables in AST. Implements interface Expr and LValue.
 */
public class VarExpr extends Expr implements LValue{
    public String identifier;
    public IRExpr_c ir;

    public VarExpr(String id, int line, int col) {
        super(line, col);
        identifier = id;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.printAtom(identifier);
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        visitor.visitVar(this);
    }

    @Override
    public IRExpr getir() {
        return this.ir;
    }
}
