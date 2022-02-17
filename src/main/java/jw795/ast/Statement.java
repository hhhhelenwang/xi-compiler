package jw795.ast;

/**
 * Interface for all statement representation in the AST.
 * All statement implement this interface.
 */
public abstract class Statement extends ASTNode{
    public Statement(int li, int co) {
        super(li, co);
    }
}
