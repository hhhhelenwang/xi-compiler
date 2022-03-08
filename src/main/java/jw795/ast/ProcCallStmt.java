package jw795.ast;

import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import jw795.typechecker.Visitor;

import java.util.List;

/**
 * Representation of a procedure call.
 */
public class ProcCallStmt extends Statement {
    public String name;
    public List<Expr> arguments;

    public ProcCallStmt(String n, List<Expr> args, int line, int col) {
        super(line, col);
        name = n;
        arguments = args;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom(name);
        for (Expr arg : arguments) {
            arg.prettyPrint(printer);
        }
        printer.endList();
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        for (Expr arg: arguments){
            arg.accept(visitor);
        }
        visitor.visitPrCall(this);
    }
}
