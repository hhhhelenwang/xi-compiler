package jw795.irgenerator;

import edu.cornell.cs.cs4120.xic.ir.*;

import java.util.*;

import static edu.cornell.cs.cs4120.xic.ir.IRBinOp.OpType.XOR;

public class JumpReorder {

    /**
     * Representation of a basic block
     */
    static class BasicBlock {
        //TODO: have zero idea how this would work
        List<IRStmt> statements;
        Optional<IRStmt> endingStatement; // An endingStatement is either CJUMP, JUMP or RETURN
        Optional<String> nextBlockLabel; // Label of the next block after getBasicBlocks
        boolean visited = false;
        List<BasicBlock> children = new ArrayList<>();


        public BasicBlock(List<IRStmt> statements, IRStmt endingStatement) {
            this.statements = statements;
            this.nextBlockLabel = Optional.empty();
            this.endingStatement = Optional.of(endingStatement);
        }

        public BasicBlock(List<IRStmt> statements, String nextBlockLabel) {
            this.statements = statements;
            this.nextBlockLabel = Optional.of(nextBlockLabel);
            this.endingStatement = Optional.empty();
        }
    }

    HashMap<String, BasicBlock> basicBlocksMap;// basicBlocksMap maps Label string to its basicBlock
    IRNodeFactory_c irFactory;


    IRCompUnit ir; // the ir to reorder
    BasicBlock cfg; // the control flow graph built from ir

    public JumpReorder() {
        this.irFactory = new IRNodeFactory_c();
        this.basicBlocksMap = new HashMap<>();
    }

    public void printBlock(BasicBlock block){
        for (IRStmt stmt : block.statements) {
//            System.out.println(stmt);
        }
    }

    public void printBlocks(List<BasicBlock> blocks){
        for (BasicBlock block: blocks) {
//            System.out.println("======new block=======");
            printBlock(block);
        }
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
//                System.out.println("===THIS IS TRACE===");
//                printBlocks(trace);
                body = fixJumps(trace);
            }
            reorderedFunDecl.put(function.name(), irFactory.IRFuncDecl(function.name(), body));
        }

        //restore Data
        IRCompUnit unit = irFactory.IRCompUnit(node.name(), reorderedFunDecl);
        for (IRData value : node.dataMap().values()) {
            unit.appendData(value);
        }

        return unit;
    }

    /**
     * Fix the jumps in given trace
     * @param trace A trace of basic blocks
     * @return the function body with jumps between blocks fixed according to the given trace
     */
    private IRSeq fixJumps (List<BasicBlock> trace) {
        List<BasicBlock> fallThroughedTrace = enableFallThrough(trace);
        List<BasicBlock> addedJumpTrace = addJumps(fallThroughedTrace);
        List<BasicBlock> cleanUpedTrace = cleanUp(addedJumpTrace);
        return irFactory.IRSeq(flatten(cleanUpedTrace));
    }

    private List<IRStmt> flatten(List<BasicBlock> blocks){
        List<IRStmt> flattened = new ArrayList<>();
        for (BasicBlock b : blocks){
            flattened.addAll(b.statements);
        }
        return flattened;
    }

    private List<BasicBlock> cleanUp(List<BasicBlock> trace) {
        BasicBlock curBlock;
        List<BasicBlock> blocks = new ArrayList<>();
        boolean prevIsCjump = false;

        for (int i = 0; i < trace.size() - 1; i++) {
            curBlock = trace.get(i);

            if (prevIsCjump){
                curBlock.statements.remove(0); //remove first stmt (LABEL)
                prevIsCjump = false;
            }

            if (curBlock.endingStatement.isPresent()){
                IRStmt curEndingStmt = curBlock.endingStatement.get();
                if (curEndingStmt instanceof IRCJump){

                    IRCJump newCjump = irFactory.IRCJump(((IRCJump) curEndingStmt).cond(),
                            ((IRCJump) curEndingStmt).trueLabel());
                    prevIsCjump = true;
                    // update block with new CJUMP
                    curBlock.statements.remove(curBlock.statements.size()-1); //remove last stmt
                    curBlock.statements.add(newCjump);
                }
            }
            blocks.add(curBlock);
        }
        blocks.add(trace.get(trace.size()-1));
        return blocks;
    }

    private List<BasicBlock> addJumps(List<BasicBlock> trace) {
        BasicBlock curBlock;
        BasicBlock nxtBlock;
        List<BasicBlock> blocks = new ArrayList<>();

        for (int i = 0; i < trace.size() - 1; i++) {
            curBlock = trace.get(i);
            nxtBlock = trace.get(i + 1);
            if (!curBlock.endingStatement.isPresent()) {
                // check if we need to add JUMP if not followed by next label in original trace
                String nxtLabel = ((IRLabel) nxtBlock.statements.get(0)).name();
                String expectedNxt = curBlock.nextBlockLabel.get();
                if (!nxtLabel.equals(expectedNxt)) {
                    curBlock.statements.add(irFactory.IRJump(irFactory.IRName(expectedNxt)));
                }
            }
            blocks.add(curBlock);
        }
        blocks.add(trace.get(trace.size()-1));
        return blocks;

    }

    private List<BasicBlock> enableFallThrough(List<BasicBlock> trace){
        List<BasicBlock> blocks = new ArrayList<>();
        BasicBlock curBlock;
        BasicBlock nxtBlock;

        // only need to worry about fixing jumps if there exist a next block
        for (int i = 0; i < trace.size()-1; i++){
            curBlock = trace.get(i);
            nxtBlock = trace.get(i+1);

            if (curBlock.endingStatement.isPresent()){
                IRStmt curEndingStmt = curBlock.endingStatement.get();
                if (curEndingStmt instanceof IRCJump){
                    // check if the following block's label is a true label, if so, invert e
                    String curTrueLabel = ((IRCJump) curEndingStmt).trueLabel();
                    String nxtLabel = ((IRLabel) nxtBlock.statements.get(0)).name();

                    IRCJump newCjump;
                    if (curTrueLabel.equals(nxtLabel)){
                        IRBinOp newCond = irFactory.IRBinOp(XOR, ((IRCJump) curEndingStmt).cond(), irFactory.IRConst(1));
                        newCjump = irFactory.IRCJump(newCond, ((IRCJump) curEndingStmt).falseLabel(), ((IRCJump) curEndingStmt).trueLabel());
                    } else {
                        newCjump = irFactory.IRCJump(((IRCJump) curEndingStmt).cond(), ((IRCJump) curEndingStmt).trueLabel(), ((IRCJump) curEndingStmt).falseLabel());
                    }

                    // update block with new CJUMP
                    curBlock.statements.remove(curBlock.statements.size()-1); //remove last stmt
                    curBlock.statements.add(newCjump);
                    curBlock.endingStatement = Optional.of(newCjump);
                } else if (curEndingStmt instanceof IRJump){
                    //check if the next basic block has same label, if so, remove the jump
                    String nxtLabel = ((IRLabel) nxtBlock.statements.get(0)).name();
                    if (nxtLabel.equals(((IRJump) curEndingStmt).target())){
                        curBlock.statements.remove((curBlock.statements.size()-1));
                    }
                }
            }
            blocks.add(curBlock);

        }
        blocks.add(trace.get(trace.size()-1));

        return blocks;
    }

    /**
     * Construct a CFG from the given IRSeq node
     * @param ir sequence
     * @return cfg
     */
    private BasicBlock buildCFG(IRSeq ir){
        List<BasicBlock> basicBlocks = getBasicBlocks(ir);
        BasicBlock root = connectBlocks(basicBlocks);
        return root;
    }

    /**
     * Break an IR Sequence into a list of basic blocks.
     * @param node the IRSeq in a function/procedure body
     * @return a list of basic blocks
     */
    private List<BasicBlock> getBasicBlocks(IRSeq node) {
        List<BasicBlock> blocks = new ArrayList<>();
        List<IRStmt> stmts = new ArrayList<>();
        String curLabel = "L0";

        for (IRStmt stmt : node.stmts()){
            if (stmt instanceof IRCJump || stmt instanceof IRJump){
                //always end a block and start the next block
                stmts.add(stmt);
                BasicBlock block = new BasicBlock(stmts, stmt);
                //populate basicBlocksMap for connectBlocks() to use
                basicBlocksMap.put(curLabel, block);
                blocks.add(block);
                stmts = new ArrayList<>();
            } else if (stmt instanceof IRLabel) {
                // always start a block && end previous block if not ended by jump/return
                if (stmts.size() != 0){
                    BasicBlock block = new BasicBlock(stmts, ((IRLabel) stmt).name());
                    basicBlocksMap.put(curLabel, block);
                    blocks.add(block);
                }
                curLabel = ((IRLabel) stmt).name();
                stmts = new ArrayList<>();
                stmts.add(stmt);
            } else {
                stmts.add(stmt);
            }
        }

        if (stmts.size() !=0){
            BasicBlock block = new BasicBlock(stmts, curLabel);
            basicBlocksMap.put(curLabel, block);
            blocks.add(block);
        }

//        System.out.println("===THIS IS BASICBLOCKS===");
//        printBlocks(blocks);
        return blocks;
    }

    /**
     * Connect the basic blocks in blocks according to their control flow.
     * @param blocks List of BasicBlock to connect
     * @return the root node for the connected CFG
     */
    private BasicBlock connectBlocks(List<BasicBlock> blocks) {
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
    private List<BasicBlock> buildTrace(BasicBlock root) {
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
