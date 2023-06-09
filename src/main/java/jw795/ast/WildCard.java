package jw795.ast;

import edu.cornell.cs.cs4120.xic.ir.IRExpr;
import jw795.Visitor;
import jw795.typechecker.*;
import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

public class WildCard extends ASTNode implements LValue{
    public Unit type;

    public WildCard(int li, int co) {
        super(li, co);
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.printAtom("_");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitWildCard(this);
    }

    @Override
    // wildcar should have no ir node for representation
    public IRExpr getir() {
        return null;
    }
}
