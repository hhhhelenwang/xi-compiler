package jw795.irgenerator;

import edu.cornell.cs.cs4120.xic.ir.*;

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
        List<BasicBlock> blocks = new ArrayList<>();
        List<IRStmt> block = new ArrayList<>();
        int counter = 0;
        for (IRStmt stmt : node.stmts()){
            if (stmt instanceof IRCJump || stmt instanceof IRJump || stmt instanceof IRReturn){
                //always end a block
                block.add(stmt);
                blocks.add(new BasicBlock(block, counter));
                counter++;
            } else if (stmt instanceof IRLabel) {
                // always start a block && end previous block if not ended by jump/return
                if (block.size() != 0){
                    blocks.add(new BasicBlock(block, counter));
                    counter++;
                }
                block = new ArrayList<>();
                block.add(stmt);
            } else {
                block.add(stmt);
            }
        }
        return blocks;
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
