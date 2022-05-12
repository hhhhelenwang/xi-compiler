package jw795.ast;

import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import jw795.Visitor;
import jw795.typechecker.TypeChecker;

public class BreakStmt extends  Statement{

    public BreakStmt(int li, int co) {
        super(li, co);
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.printAtom("break");
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        visitor.visitBreak(this);
    }
}
