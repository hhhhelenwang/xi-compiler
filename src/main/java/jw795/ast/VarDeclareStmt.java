package jw795.ast;

import java.util.Optional;

/**
 * Representation of a variable declaration.
 */
public class VarDeclareStmt extends Statement implements LValue {
    String identifier;
    Type type;
    Optional<Expr> value;

    VarDeclareStmt(String id, Type t, Optional<Expr> val, int line, int col) {
        super(line, col);
        identifier = id;
        type = t;
        value = val;
    }
}
