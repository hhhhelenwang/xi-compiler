package jw795.ast;

import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import jw795.typechecker.Visitor;

import java.util.List;

/**
 * Representation of a return statement.
 */
public class ReturnStmt extends Statement {
    public List<Expr> returnVals;

    public ReturnStmt(List<Expr> vals, int line, int col) {
        super(line, col);
        returnVals = vals;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom("return");
        for (Expr val : returnVals) {
            val.prettyPrint(printer);
        }
        printer.endList();
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        for (Expr arg: returnVals){
            arg.accept(visitor);
        }
        visitor.visitRet(this);
    }
}
