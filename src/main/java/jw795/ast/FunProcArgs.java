package jw795.ast;

/**
 * Represent a parameter in function/procedure definition.
 */
public class FunProcArgs extends ASTNode {
    String identifier;
    Type argType;

    FunProcArgs(String id, Type type, int line, int col) {
        super(line, col);
        identifier = id;
        argType = type;
    }
}
