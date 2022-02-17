package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

import java.util.List;

/**
 * A representation of a list of variable declaration used when assigning multiple return results to variables.
 * For example:
 * a:int, b:int = fun_that_returns_two_ints() -> LeftValueList.declares = {a:int, b:int}
 * _, b:int = fun_that_returns_two_ints() -> LeftValueList.declares = {_, b:int}
 */
public class LeftValueList extends ASTNode implements LValue{
    List<LValue> declares;

    LeftValueList(List<LValue> variables, int line, int col) {
        super(line, col);
        declares = variables;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        for (LValue lv: declares) {
            lv.prettyPrint(printer);
        }
        printer.endList();
    }
}
