package jw795.ast;

import jw795.typechecker.Visitor;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

import java.util.List;

/**
 * Representation of function calls in AST.
 */
public class FunCallExpr extends Expr{
    public String name;
    public List<Expr> arguments;

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

    @Override
    public void accept(Visitor visitor) {
        for ( Expr arg: arguments ){
            arg.accept(visitor);
        }
        if(this.name.equals("length")){
            visitor.visitLength(this);
        }else{
        visitor.visitFunCallExpr(this);
        }
    }
}
