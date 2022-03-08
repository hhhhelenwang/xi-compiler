package jw795.ast;

import jw795.Visitor;
import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

import java.util.List;

public class ProcedureDeclare extends ASTNode implements ProcFuncDecl{
    public String name;
    public List<FunProcArgs> arguments;

    public ProcedureDeclare(String n, List<FunProcArgs> args, int li, int co) {
        super(li, co);
        name = n;
        arguments = args;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom(name);
        printer.startList();
        for (FunProcArgs arg : arguments) {
            arg.prettyPrint(printer);
        }
        printer.endList();
        printer.startList();
        printer.endList();
        printer.endList();
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        visitor.visitPrDecl(this);
    }
}
