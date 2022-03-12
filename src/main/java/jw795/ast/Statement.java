package jw795.ast;

import edu.cornell.cs.cs4120.xic.ir.IRStmt;
import jw795.typechecker.R;

/**
 * Interface for all statement representation in the AST.
 * All statement implement this interface.
 */
public abstract class Statement extends ASTNode{
    public R type;
    public IRStmt ir;

    public Statement(int li, int co) {
        super(li, co);
    }
}
