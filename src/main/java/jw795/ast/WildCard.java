package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

public class WildCard extends ASTNode implements LValue{
    public WildCard(int li, int co) {
        super(li, co);
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.printAtom("_");
    }
}
