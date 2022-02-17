package jw795.ast;

/**
 * Interface for Xi language expressions and extends ASTNode.
 * All expressions implements this interface.
 */
public abstract class Expr extends ASTNode {
    public int left() {
        return line;
    }

    public int right() {
        return col;
    }

    Expr(int li, int co) {
        super(li, co);
    }

}
