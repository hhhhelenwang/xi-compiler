package jw795.ast;

/**
 * Representation of variable types in the AST.
 * All types (int, bool, array) implements this interface.
 */
public class Type extends ASTNode{
    Type(int li, int co) {
        super(li, co);
    }
}
