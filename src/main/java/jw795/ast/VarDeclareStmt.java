package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

import java.util.Optional;

/**
 * Representation of a variable declaration.
 */
public class VarDeclareStmt extends Statement implements LValue {
    String identifier;
    Type type;

    public VarDeclareStmt(String id, Type t, int line, int col) {
        super(line, col);
        identifier = id;
        type = t;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom(identifier);
        type.prettyPrint(printer);
        printer.endList();
    }
}
