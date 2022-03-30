package jw795.asmgenerator;

import edu.cornell.cs.cs4120.xic.ir.*;
import edu.cornell.cs.cs4120.xic.ir.visit.IRVisitor;

/**
 * A visitor that traverse an IR tree and translate IR into tiles of abstract assembly.
 */
public class Tiler extends IRVisitor {
    public Tiler(IRNodeFactory inf) {
        super(inf);

    }

    /**
     * Translate an IR node into a tile of abstract assembly instructions.
     * @param parent The parent AST node of {@code n} or {@code null} when it is the root.
     * @param n The original node in the input AST
     * @param n2 The node returned by {@link IRNode#visitChildren(IRVisitor)}, which should
     *    look like n except that the children have been visited.
     * @param v2 The new node visitor created by {@link #enter(IRNode, IRNode)}, or {@code this}.
     * @return this node but visited
     */
    @Override
    protected IRNode leave(IRNode parent, IRNode n, IRNode n2, IRVisitor v2) {
        // TODO: translate IR node to tile for each kinds of IR node:
        //  (lower IR only)
        //  stmt: move, call_m, jump, cjump, label, return, seq
        //  expr: const, temp, mem, name, binop

        //  can have helper functions for each nodes if this methods gets too big

        if (n2 instanceof IRCompUnit) {
            // whatever need to be done for CompUnit
        } else if (n2 instanceof IRSeq){
            // same pattern for other nodes
        } else if (n2 instanceof IRMove) {

        } else if (n2 instanceof IRCallStmt) {

        } else if (n2 instanceof IRJump) {

        } else if (n2 instanceof IRCJump) {

        } else if (n2 instanceof IRLabel) {

        } else if (n2 instanceof IRReturn) {

        }
        // expressions
        else if (n2 instanceof IRConst) {

        } else if (n2 instanceof IRTemp) {

        } else if (n2 instanceof IRMem) {

        } else if (n2 instanceof IRName) {

        } else if (n2 instanceof IRBinOp) {

        } else {
            System.out.println("IR is not lowered.");
            return null;
        }
        return null;
    }
}
