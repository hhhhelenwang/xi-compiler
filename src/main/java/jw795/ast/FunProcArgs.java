package jw795.ast;

import jw795.typechecker.Tau;
import jw795.typechecker.Visitor;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Represent a parameter in function/procedure definition.
 */
public class FunProcArgs extends ASTNode {
    public String identifier;
    public Type argType;
    public Tau type;

    public FunProcArgs(String id, Type type, int line, int col) {
        super(line, col);
        identifier = id;
        argType = type;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom(identifier);
        argType.prettyPrint(printer);
        printer.endList();
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        visitor.visitFunProcArgs(this);
    }
}
