package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Represent a parameter in function/procedure definition.
 */
public class FunProcArgs extends ASTNode {
    String identifier;
    Type argType;

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
}
