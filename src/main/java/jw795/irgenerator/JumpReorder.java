package jw795.irgenerator;

import edu.cornell.cs.cs4120.xic.ir.*;

import java.util.*;

public class JumpReorder {

    /**
     * Representation of a basic block
     */
    static class BasicBlock {
        //TODO: have zero idea how this would work
        List<IRStmt> statements;
        Optional<IRStmt> endingStatement; // An endingStatement is either CJUMP, JUMP or RETURN
        Optional<String> nextBlockLabel;
        boolean visited = false;
        List<BasicBlock> children = new ArrayList<>();


        public BasicBlock(List<IRStmt> stmts, IRStmt endingStmt) {
            statements = stmts;
            nextBlockLabel = Optional.empty();
            endingStatement = Optional.of(endingStmt);
        }

        public BasicBlock(List<IRStmt> stmts, String lb) {
            statements = stmts;
            nextBlockLabel = Optional.of(lb);
            endingStatement = Optional.empty();
        }
    }

    // TODO: notes on building cfg:
    //  1. build one cfg per function body?
    //  2. need to first separate ir into basic block
    //  3. and then connect the basic block into cfg according to their control flow
    //      -> how to decides which block should connect to which other blocks?

    HashMap<String, BasicBlock> basicBlocksMap;// basicBlocksMap maps Label string to its basicBlock

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
        Map<String, IRFuncDecl> reorderedFunDecl = new HashMap<>();
        for (IRFuncDecl function : node.functions().values()){
            IRStmt body = function.body();
            if ( body instanceof IRSeq){
                basicBlocksMap = new HashMap<>();
                BasicBlock root = buildCFG(((IRSeq)function.body()));
                List<BasicBlock> trace = buildTrace(root);
                body = fixJumps(trace);
            }
            reorderedFunDecl.put(function.name(), new IRFuncDecl(function.name(), body));
            //TODO: double check if this is function.name() OR function.label()
        }

        return new IRCompUnit(node.name(), reorderedFunDecl, node.ctors(), node.dataMap());
    }

    /**
     * Fix the jumps in given trace
     * @param trace A trace of basic blocks
     * @return IRSeq with jumps between blocks fixed according to the given trace
     */
    public IRSeq fixJumps (List<BasicBlock> trace) {
        List<IRStmt> stmts = new ArrayList<>();
        //TODO: follow https://www.cs.cornell.edu/courses/cs4120/2022sp/notes.html?id=traces

        return new IRSeq(stmts);
    }

        /**
         * Construct a CFG from the given IRSeq node
         * @param ir sequence
         * @return cfg
         */
    public BasicBlock buildCFG(IRSeq ir){
        List<BasicBlock> basicBlocks = getBasicBlocks(ir);
        BasicBlock root = connectBlocks(basicBlocks);
        return root;
    }

    /**
     * Break an IR Sequence into a list of basic blocks.
     * @return a list of basic blocks
     */
    public List<BasicBlock> getBasicBlocks(IRSeq node) {
        List<BasicBlock> blocks = new ArrayList<>();
        List<IRStmt> stmtsBlock = new ArrayList<>();
        String curLabel = "L0";

        for (IRStmt stmt : node.stmts()){
            if (stmt instanceof IRCJump || stmt instanceof IRJump || stmt instanceof IRReturn){
                //always end a block
                stmtsBlock.add(stmt);
                BasicBlock block = new BasicBlock(stmtsBlock, stmt);
                //populate basicBlocksMap for connectBlocks() to use
                basicBlocksMap.put(curLabel, block);
                blocks.add(block);
            } else if (stmt instanceof IRLabel) {
                // always start a block && end previous block if not ended by jump/return
                if (stmtsBlock.size() != 0){
                    BasicBlock block = new BasicBlock(stmtsBlock, ((IRLabel) stmt).name());
                    basicBlocksMap.put(curLabel, block);
                    blocks.add(block);
                }
                curLabel = ((IRLabel) stmt).name();
                stmtsBlock = new ArrayList<>();
                stmtsBlock.add(stmt);
            } else {
                stmtsBlock.add(stmt);
            }
        }
        return blocks;
    }

    /**
     * Connect the basic blocks in blocks according to their control flow.
     * @param blocks List of BasicBlock to connect
     * @return the root node for the connected CFG
     */
    public BasicBlock connectBlocks(List<BasicBlock> blocks) {
        for (BasicBlock block: blocks) {
            Optional<IRStmt> endingStmt = block.endingStatement;
            if (endingStmt.isPresent()){
                if (endingStmt.get() instanceof IRCJump){
                    block.children.add(basicBlocksMap.get(((IRCJump) endingStmt.get()).trueLabel()));
                    block.children.add(basicBlocksMap.get(((IRCJump) endingStmt.get()).falseLabel()));
                } else if (endingStmt.get() instanceof IRJump){
                    block.children.add(basicBlocksMap.get(((IRJump) endingStmt.get()).target()));
                }
                //IRReturn has no children
            } else {
                //Blocks not end with IRCJUMP, IRJUMP, or IRRETURN has the follow up block as their child
                String nextLabel = block.nextBlockLabel.get();
                block.children.add(basicBlocksMap.get(nextLabel));
            }
        }

        return blocks.get(0);
    }

    /**
     *  Greedily construct a trace from the CFG.
     * @param root the root of a CFG
     * @return the trace
     */
    public List<BasicBlock> buildTrace(BasicBlock root) {
        //TODO: optimize traces around loops?
        List<BasicBlock> trace = new ArrayList<>();
        BasicBlock cur = root;
        if (cur == null) { return trace; }

        if (!cur.visited){
            cur.visited = true;
            trace.add(cur);
            if (cur.children.size() != 0){
                for (BasicBlock child : cur.children){
                    trace.addAll(buildTrace(child));
                }
            }
        }

        return trace;
    }

}
