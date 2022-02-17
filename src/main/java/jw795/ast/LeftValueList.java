package jw795.ast;

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
}
