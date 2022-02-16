package jw795.ast;

/**
 * Representation of a use command.
 */
public class Use extends ASTNode {
    String interfaceName;

    Use(String name, int line, int col) {
        super(line, col);
        interfaceName = name;
    }
}
