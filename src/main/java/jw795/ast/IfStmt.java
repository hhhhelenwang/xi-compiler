package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representation of an if statement with no else branch in AST.
 */
public class IfStmt extends Statement {
    Expr condition;
    Statement clause;

    public IfStmt(Expr cond, Statement cls, int line, int col) {
        super(line, col);
        condition = cond;
        clause = cls;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom("if");
        condition.prettyPrint(printer);
        clause.prettyPrint(printer);
        printer.endList();
    }
}
