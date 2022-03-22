package jw795.irgenerator;

import edu.cornell.cs.cs4120.xic.ir.IRCompUnit;
import edu.cornell.cs.cs4120.xic.ir.IRSeq;
import edu.cornell.cs.cs4120.xic.ir.IRStmt;

import java.util.ArrayList;
import java.util.List;

public class JumpReorder {

    /**
     * Representation of a basic block
     */
    static class BasicBlock {
        //TODO: have zero idea how this would work
        List<IRStmt> statements;
        int index;
        boolean visited;
        List<BasicBlock> children;


        public BasicBlock(List<IRStmt> stmts, int idx) {
            statements = stmts;
            index = idx;
            visited = false;
            children = new ArrayList<>();
        }
    }

    // TODO: notes on building cfg:
    //  1. build one cfg per function body?
    //  2. need to first separate ir into basic block
    //  3. and then connect the basic block into cfg according to their control flow
    //      -> how to decides which block should connect to which other blocks?

    IRCompUnit ir; // the ir to reorder
    BasicBlock cfg; // the control flow graph built from ir

    public JumpReorder() {

    }

    /**
     * Reorder the given IR. Call this function to reorder a lowered IR.
     * @param node IR
     * @return reordered IR
     */
    public IRCompUnit reorder(IRCompUnit node) {
        // TODO: go through all functions in node, build cfg for each function body, and generate a new
        //  IRCompUnit from the new reordered function body
        return null;
    }

    /**
     * Construct a CFG from the given IRSeq node
     * @param ir sequence
     * @return cfg
     */
    public BasicBlock buildCFG(IRSeq ir){
        //TODO: call getBasicBlocks and connectBlocks
        return null;
    }

    /**
     * Break an IR Sequence into a list of basic blocks.
     * @return a list of basic blocks
     */
    public List<BasicBlock> getBasicBlocks(IRSeq node) {
        return null;
    }

    /**
     * Connect the basic blocks in blocks according to their control flow.
     * @param blocks a list of basic blocks
     * @return the root node for the connected CFG
     */
    public BasicBlock connectBlocks(List<BasicBlock> blocks) {
        // TODO
        for (BasicBlock block: blocks) {

        }

        return null;
    }

    /**
     *  Greedily construct a trace from the CFG.
     * @param root the root of a CFG
     * @return the trace
     */
    public List<BasicBlock> buildTrace(BasicBlock root) {
        //TODO
        return null;
    }

}
