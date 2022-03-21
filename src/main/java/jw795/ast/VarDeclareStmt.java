package jw795.ast;

import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import edu.cornell.cs.cs4120.xic.ir.IRExpr;
import jw795.Visitor;

/**
 * Representation of a variable declaration.
 */
public class VarDeclareStmt extends Statement implements LValue {
    public String identifier;
    public Type varType;

    public VarDeclareStmt(String id, Type t, int line, int col) {
        super(line, col);
        identifier = id;
        varType = t;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom(identifier);
        varType.prettyPrint(printer);
        printer.endList();
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        varType.accept(visitor);
        visitor.visitVarDecl(this);
    }

    @Override
    //implement this
    public IRExpr getir() {
        return (IRExpr) this.ir;
    }
}
