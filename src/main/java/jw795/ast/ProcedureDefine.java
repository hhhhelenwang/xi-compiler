package jw795.ast;

import jw795.typechecker.*;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

import java.util.ArrayList;
import java.util.List;

public class ProcedureDefine extends ASTNode implements Definition{
    public String name;
    public List<FunProcArgs> arguments;
    public BlockStmt procBody;

    public ProcedureDefine(String n, List<FunProcArgs> args, BlockStmt body, int li, int co) {
        super(li, co);
        name = n;
        arguments = args;
        procBody = body;
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

        procBody.prettyPrint(printer);
        printer.endList();
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        visitor.enterScope();
        for (FunProcArgs arg : arguments) {
            arg.accept(visitor);
        }
        procBody.accept(visitor);
        visitor.leaveScope();

        visitor.visitPrDef(this);
    }
}
