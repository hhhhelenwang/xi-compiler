package jw795.ast;

import jw795.Visitor;
import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import jw795.irgenerator.IRGenerator;
import jw795.typechecker.TypeChecker;

/**
 * Representation of a while statement in AST.
 */
public class WhileStmt extends Statement {
    public Expr condition;
    public Statement loopBody;

    public WhileStmt(Expr cond, Statement body, int line, int col) {
        super(line, col);
        condition = cond;
        loopBody = body;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom("while");
        condition.prettyPrint(printer);
        loopBody.prettyPrint(printer);
        printer.endList();
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        condition.accept(visitor);
        visitor.enterScope();
        if(visitor instanceof TypeChecker){((TypeChecker) visitor).env.getinloop();}
        if(visitor instanceof IRGenerator){((IRGenerator) visitor).addlooplayer();}
        loopBody.accept(visitor);
        if(visitor instanceof TypeChecker){ ((TypeChecker) visitor).env.getoutloop();}
        if(visitor instanceof IRGenerator){((IRGenerator) visitor).peeklooplayer();}
        visitor.leaveScope();
        visitor.visitWhileStmt(this);

    }
}
