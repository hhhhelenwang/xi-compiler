package edu.cornell.cs.cs4120.xic.ir;

import java.util.HashSet;

public interface IRExpr extends IRNode {
    boolean isConstant();

    long constant();

    /**
     * @return set of variables in this expression
     */
    HashSet<IRTemp> vars();
}
