package jw795.ast;

import jw795.typechecker.XiType;

/**
 * Interface for Xi language expressions and extends ASTNode.
 * All expressions implements this interface.
 */
public abstract class Expr extends ASTNode {
    public XiType type;

    Expr(int li, int co) {
        super(li, co);
    }

}
