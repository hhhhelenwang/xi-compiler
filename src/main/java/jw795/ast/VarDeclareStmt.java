package jw795.ast;

import jw795.typechecker.R;
import jw795.typechecker.Visitor;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

import java.util.Optional;

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
    public void accept(Visitor visitor) {
        visitor.visitVarDecl(this);
    }
}
