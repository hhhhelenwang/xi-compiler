package jw795.ast;

/**
 * Interface definition for an AST node. All nodes extends this interface.
 */
public abstract class ASTNode {
    int line;
    int column;

    ASTNode (int li, int co) {
        line = li;
        column = co;
    }
}
