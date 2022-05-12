package edu.cornell.cs.cs4120.xic.ir;

import java.util.HashSet;

/** An intermediate representation for statements */
public abstract class IRStmt extends IRNode_c {

    /**
     * @return The use set of this stmt
     */
    public abstract HashSet<IRTemp> use();

    /**
     * @return The def set of this stmt.
     */
    public abstract HashSet<IRTemp> def();

    /**
     * @return Set of variables that occur in this statement
     */
    public abstract HashSet<IRTemp> vars();

}
