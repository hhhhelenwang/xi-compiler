package jw795.ast;

/**
 * Represent a parameter in function/procedure definition.
 */
public class FunProcArgs implements ASTNode {
    String identifier;
    Type argType;

    FunProcArgs(String id, Type type) {
        identifier = id;
        argType = type;
    }
}
