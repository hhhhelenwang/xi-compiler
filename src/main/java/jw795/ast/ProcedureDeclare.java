package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

import java.util.List;

public class ProcedureDeclare extends ASTNode implements ProcFuncDecl{
    String name;
    List<FunProcArgs> arguments;

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
        printer.endList();
    }
}
