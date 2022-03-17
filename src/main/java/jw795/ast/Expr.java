package jw795.ast;

import edu.cornell.cs.cs4120.xic.ir.IRExpr_c;
import jw795.typechecker.T;

/**
 * Interface for Xi language expressions and extends ASTNode.
 * All expressions implements this interface.
 */
public abstract class Expr extends ASTNode {
    public T type;
    public IRExpr_c ir;

    Expr(int li, int co) {
        super(li, co);
    }

}
