package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representation of an if-else statement in AST.
 */
public class IfElseStmt extends Statement {
    Expr condition;
    Statement ifClause;
    Statement elseClause;

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
}
