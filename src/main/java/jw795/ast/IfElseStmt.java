package jw795.ast;

import jw795.typechecker.R;
import jw795.typechecker.Visitor;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representation of an if-else statement in AST.
 */
public class IfElseStmt extends Statement {
    public Expr condition;
    public Statement ifClause;
    public Statement elseClause;

    public IfElseStmt(Expr cond, Statement clause1, Statement clause2, int line, int col) {
        super(line, col);
        condition = cond;
        ifClause = clause1;
        elseClause = clause2;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom("if");
        condition.prettyPrint(printer);
        ifClause.prettyPrint(printer);
        elseClause.prettyPrint(printer);
        printer.endList();
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        condition.accept(visitor);

        visitor.enterScope();
        ifClause.accept(visitor);
        visitor.leaveScope();

        visitor.enterScope();
        elseClause.accept(visitor);
        visitor.leaveScope();

        visitor.visitIfElseStmt(this);
    }
}
