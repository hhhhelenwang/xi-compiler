package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

public class GlobDeclare extends ASTNode implements Definition, LValue{
    String identifier;
    Type type;

    public GlobDeclare(String id, Type t, int li, int co) {
        super(li, co);
        identifier = id;
        type = t;

    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom(":global");
        printer.printAtom(identifier);
        type.prettyPrint(printer);
        printer.endList();
    }
}
