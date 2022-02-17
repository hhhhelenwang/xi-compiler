package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

import java.util.List;

/**
 * Representation of function calls in AST.
 */
public class FunCallExpr extends Expr{
    String name;
    List<Expr> arguments;

    public FunCallExpr(String n, List<Expr> args, int line, int col) {
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
}
