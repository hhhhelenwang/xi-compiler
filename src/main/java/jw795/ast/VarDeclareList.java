package jw795.ast;

import java.util.List;

/**
 * A representation of a list of variable declaration used when assigning multiple return results to variables.
 */
public class VarDeclareList implements Expr, LValue {
    List<LValue> declares;

    VarDeclareList(List<LValue> variables) {
        declares = variables;
    }
}
