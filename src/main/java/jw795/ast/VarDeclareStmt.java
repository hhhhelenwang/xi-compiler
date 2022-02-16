package jw795.ast;

import java.util.Optional;

/**
 * Representation of a variable declaration.
 */
public class VarDeclareStmt implements Statement, LValue {
    String identifier;
    Type type;
    Optional<Expr> value;

    VarDeclareStmt(String id, Type t, Optional<Expr> val) {
        identifier = id;
        type = t;
        value = val;
    }
}
