package jw795.ast;

import jw795.typechecker.R;

/**
 * Interface for all statement representation in the AST.
 * All statement implement this interface.
 */
public abstract class Statement extends ASTNode{
    public R type;

    public Statement(int li, int co) {
        super(li, co);
    }
}
