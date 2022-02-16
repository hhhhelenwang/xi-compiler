package jw795.ast;

import java.util.List;

/**
 * A representation of a list of variable declaration used when assigning multiple return results to variables.
 */
public class VarDeclareList implements Expr, LValue {
    List<VarDeclareStmt> declares;

    VarDeclareList(List<VarDeclareStmt> variables) {
        declares = variables;
    }
}
