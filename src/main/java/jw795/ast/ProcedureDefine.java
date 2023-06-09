package jw795.ast;

import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import edu.cornell.cs.cs4120.xic.ir.IRFuncDecl;
import jw795.Visitor;
import jw795.typechecker.*;

import java.util.List;

public class ProcedureDefine extends ASTNode implements Definition{
    public String name;
    public List<FunProcArgs> arguments;
    public BlockStmt procBody;
    public IRFuncDecl ir;

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
        if (visitor instanceof TypeChecker) {
            Sigma ret = new Ret(new Unit());
            ((TypeChecker) visitor).env.addVar("return", ret);
        }
        procBody.accept(visitor);
        visitor.leaveScope();

        visitor.visitPrDef(this);
    }
}
