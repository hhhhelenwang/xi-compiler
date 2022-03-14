package jw795.ast;

import edu.cornell.cs.cs4120.xic.ir.IRData;
import edu.cornell.cs.cs4120.xic.ir.IRExpr;
import jw795.Visitor;
import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

public class GlobDeclare extends ASTNode implements Definition{
    public String identifier;
    public Type varType;
    public Expr value;
    public IRData ir;

    public GlobDeclare(String id, Type t, int li, int co) {
        super(li, co);
        identifier = id;
        varType = t;

    }

    public GlobDeclare(String id, Type t, Expr v, int li, int co) {
        super(li, co);
        identifier = id;
        varType = t;
        value = v;

    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom(":global");
        printer.printAtom(identifier);
        varType.prettyPrint(printer);
        if (value != null) {
            value.prettyPrint(printer);
        }
        printer.endList();
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        if (value != null) {
            value.accept(visitor);
        }
        visitor.visitGlobDecl(this);
    }
}
