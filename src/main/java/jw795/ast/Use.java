package jw795.ast;

/**
 * Representation of a use command.
 */
public class Use implements ASTNode{
    String interfaceName;

    Use() { }

    Use(String name) {
        interfaceName = name;
    }
}
