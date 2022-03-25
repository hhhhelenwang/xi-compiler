package jw795.irgenerator;

import edu.cornell.cs.cs4120.xic.ir.*;

import java.util.*;

import static edu.cornell.cs.cs4120.xic.ir.IRBinOp.OpType.XOR;

public class JumpReorder {

    /**
     * Representation of a basic block
     */
    static class BasicBlock {
        String label; //label l0, l1, ...., l_n, done0, done1, .., done_n
        List<IRStmt> statements;
        Optional<IRStmt> endingStatement; // An endingStatement is either CJUMP, JUMP or RETURN
        Optional<String> nextBlockLabel; // Label of the next block after getBasicBlocks
        boolean visited = false;
        boolean connected = false;
        List<BasicBlock> children = new ArrayList<>();


        public BasicBlock(String label, List<IRStmt> statements,
                          Optional<IRStmt> endingStatement,
                          Optional<String> nextBlockLabel) {
            this.label = label;
            this.statements = statements;
            this.nextBlockLabel = nextBlockLabel;
            this.endingStatement = endingStatement;
        }

        private BasicBlock(String label, List<IRStmt> statements, IRStmt endingStatement) {
            this.label = label;
            this.statements = statements;
            this.nextBlockLabel = Optional.empty();
            this.endingStatement = Optional.of(endingStatement);
        }

        private BasicBlock(String label, List<IRStmt> statements, Optional<String> nextBlockLabel) {
            this.label = label;
            this.statements = statements;
            this.nextBlockLabel = nextBlockLabel;
            this.endingStatement = Optional.empty();
        }
    }

    private HashMap<String, BasicBlock> basicBlocksMap;// basicBlocksMap maps Label string to its basicBlock
    private List<BasicBlock> originalBasicBlocks; // the list of basicBlocks after grouping IR codes to block
    private String doneLable;
    private IRNodeFactory_c irFactory;

    public JumpReorder() {
        this.irFactory = new IRNodeFactory_c();
        this.basicBlocksMap = new HashMap<>();
    }

    /**
     * helper function for printing Block
     * */
    public void printBlock(BasicBlock block){
        for (IRStmt stmt : block.statements) {
            System.out.println(stmt);
        }
    }

    /**
     * helper function for printing list of BasicBlocks
     * */
    public void printBlocks(List<BasicBlock> blocks){
        for (BasicBlock block: blocks) {
            System.out.println("======new block=======");
            printBlock(block);
        }
    }

    /**
     * Reorder the given IR. Call this function to reorder a lowered IR.
     * @param node IR
     * @return reordered IR
     */
    public IRCompUnit reorder(IRCompUnit node) {
        //fix jumps in each function body
        Map<String, IRFuncDecl> reorderedFunDecl = new HashMap<>();
        int labelCounter = 0;
        for (IRFuncDecl function : node.functions().values()){
            IRStmt body = function.body();
            if ( body instanceof IRSeq){
                doneLable = "done" + labelCounter;
                labelCounter++;
                basicBlocksMap = new HashMap<>();
                BasicBlock root = buildCFG(((IRSeq)function.body()));
                List<BasicBlock> trace = buildTrace(root);
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
        List<BasicBlock> removeJumpsTrace = removeJumps(addedJumpTrace);
        List<BasicBlock> cleanUpedTrace = removeLabels(removeJumpsTrace);
        List<IRStmt> finalTrace = flatten(cleanUpedTrace);
        return irFactory.IRSeq(finalTrace);
    }

    /**
     * Flatten a list of basicBlock to a list of IRStmt
     * @param blocks list of Basic Blocks
     * @return list of IRStmt
     */
    private List<IRStmt> flatten(List<BasicBlock> blocks){
        List<IRStmt> flattened = new ArrayList<>();
        for (BasicBlock b : blocks){
            flattened.addAll(b.statements);
        }
        return flattened;
    }

    /**
     * remove redundant labels from the block
     * @param trace list of Basic Blocks with redundant jumps removed
     * @return list of BasicBlock
     */
    private List<BasicBlock> removeLabels(List<BasicBlock> trace) {
        HashSet<String> labels = findUsedLabels(trace);
        return removeUnusedLabels(labels, trace);
    }

    /**
     * remove unused labels in IRSeq
     * @param labels labels used
     * @param trace list of Basic Blocks with redundant jumps removed
     * @return BasicBlocks
     */
    private List<BasicBlock> removeUnusedLabels(HashSet<String> labels, List<BasicBlock> trace) {
        for (BasicBlock block : trace){
            if (!labels.contains(block.label) && block.statements.get(0) instanceof IRLabel){
                block.statements.remove(0);
            }
        }
        return trace;
    }

    /**
     *  gather all used labels
     * @param trace list of Basic Blocks with redundant jumps removed
     * @return used labels
     */
    private HashSet<String> findUsedLabels(List<BasicBlock> trace) {
        HashSet<String> labels = new HashSet<>();
        for (BasicBlock block : trace){
            if (block.endingStatement.isPresent()){
                IRStmt endingStmt = block.endingStatement.get();
                if ( endingStmt instanceof IRCJump){
                    labels.add(((IRCJump) endingStmt).trueLabel());
                } else if (endingStmt instanceof IRJump){
                    labels.add(getIRJumpLabel((IRJump)endingStmt));
                }
            }

        }
        return labels;
    }

    /**
     * Remove unnecessary LABELs and IRJUMPs
     * @param trace A list of basic blocks
     * @return BasicBlocks
     */
    private List<BasicBlock> removeJumps(List<BasicBlock> trace) {
        BasicBlock curBlock;
        BasicBlock nxtBlock;
        List<BasicBlock> blocks = new ArrayList<>();
        boolean prevIsCjump = false;

        for (int i = 0; i < trace.size() - 1; i++) {
            curBlock = trace.get(i);
            nxtBlock =  trace.get(i+1);

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
                    curBlock.statements.remove(curBlock.statements.size()-1);
                    curBlock.statements.add(newCjump);
                    curBlock.endingStatement = Optional.of(newCjump);
                } else if (curEndingStmt instanceof IRJump){
                    //check if the next basic block has same label, if so, remove the jump
                    String nxtLabel = nxtBlock.label;
                    String curLabel = getIRJumpLabel((IRJump)curEndingStmt);
                    if (nxtLabel.equals(curLabel)){
                        curBlock.statements.remove((curBlock.statements.size()-1));
                        curBlock.endingStatement = Optional.empty();
                    }
                }
            }
            blocks.add(curBlock);
        }

        blocks.add(trace.get(trace.size()-1));
        return blocks;
    }

    /**
     * Add jumps to restore the original program flow
     * @param trace of reordered blocks
     * @return BasicBlocks with Jumps added to restore program flow
     */
    private List<BasicBlock> addJumps(List<BasicBlock> trace) {
        BasicBlock curBlock;
        BasicBlock nxtBlock;
        List<BasicBlock> blocks = new ArrayList<>();

        for (int i = 0; i < trace.size() - 1; i++) {
            curBlock = trace.get(i);
            nxtBlock = trace.get(i + 1);
            if (!curBlock.endingStatement.isPresent() && curBlock.nextBlockLabel.isPresent()) {
                // check if we need to add JUMP: not followed by next label in original trace
                String nxtLabel = ((IRLabel) nxtBlock.statements.get(0)).name();
                String expectedNxt = curBlock.nextBlockLabel.get();
                if (!nxtLabel.equals(expectedNxt) && !expectedNxt.equals(doneLable)) {
                    IRJump newJump = irFactory.IRJump(irFactory.IRName(expectedNxt));
                    curBlock.statements.add(newJump);
                    curBlock.endingStatement = Optional.of(newJump);
                }
            }
            blocks.add(curBlock);
        }

        blocks.add(trace.get(trace.size()-1));
        return blocks;
    }


    /**
     * Enable CJUMP and JUMP fall through if applicable
     * @param trace of reordered blocks
     * @return blocks with CJUMP and JUMP fall through
     */
    private List<BasicBlock> enableFallThrough(List<BasicBlock> trace){
        List<BasicBlock> blocks = new ArrayList<>();
        BasicBlock curBlock;
        BasicBlock nxtBlock;

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
                        IRBinOp newCond = irFactory.IRBinOp(XOR, ((IRCJump) curEndingStmt).cond(),
                                irFactory.IRConst(1));
                        newCjump = irFactory.IRCJump(newCond, ((IRCJump) curEndingStmt).falseLabel(),
                                ((IRCJump) curEndingStmt).trueLabel());
                    } else {
                        newCjump = irFactory.IRCJump(((IRCJump) curEndingStmt).cond(),
                                ((IRCJump) curEndingStmt).trueLabel(),
                                ((IRCJump) curEndingStmt).falseLabel());
                    }

                    curBlock.statements.remove(curBlock.statements.size()-1);
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
     * @return CDF
     */
    private BasicBlock buildCFG(IRSeq ir){
        List<BasicBlock> basicBlocksInit = getBasicBlocks(ir);
        List<BasicBlock> basicBlocks = addNextLabel(basicBlocksInit);
        originalBasicBlocks = basicBlocks;
        BasicBlock root = basicBlocks.get(0);
        return connectBlocks(root);
    }


    /**
     * Populate basicBlockMap with blocks initialized with their next block's label
     * @param basicBlocks basic blocks
     * @return BasicBlocks with nextLabel added to each block
     */
    private List<BasicBlock> addNextLabel(List<BasicBlock> basicBlocks) {
        List<BasicBlock> blocks = new ArrayList<>();

        for (int i = 0; i < basicBlocks.size()-1; i++){
            BasicBlock cur = basicBlocks.get(i);
            BasicBlock nxt = basicBlocks.get(i+1);
            BasicBlock withLabel = new BasicBlock(cur.label,
                    cur.statements,
                    cur.endingStatement,
                    Optional.of(nxt.label));

            basicBlocksMap.put(cur.label, withLabel);
            blocks.add(withLabel);
        }
        // handle epilogue
        BasicBlock lastBlock = basicBlocks.get(basicBlocks.size()-1);
        BasicBlock lastBlockWLabel = new BasicBlock(lastBlock.label,
                lastBlock.statements,
                lastBlock.endingStatement,
                Optional.empty());
        basicBlocksMap.put(lastBlock.label, lastBlockWLabel);
        blocks.add(lastBlockWLabel);

        return blocks;
    }

    /**
     * Break an IR Sequence into a list of basic blocks.
     * @param node the IRSeq in a function/procedure body
     * @return a list of basic blocks
     */
    private List<BasicBlock> getBasicBlocks(IRSeq node) {
        List<BasicBlock> blocks = new ArrayList<>();
        List<IRStmt> stmts = new ArrayList<>();
        String curLabel = "l0";

        for (IRStmt stmt : node.stmts()){
            if (stmt instanceof IRCJump || stmt instanceof IRJump){
                //always end a block and start the next block
                stmts.add(stmt);
                BasicBlock block = new BasicBlock(curLabel, stmts, stmt);
                blocks.add(block);
                stmts = new ArrayList<>();
            } else if (stmt instanceof IRLabel) {
                // always start a block && end previous block if not ended by jump/return
                if (stmts.size() != 0){
                    BasicBlock block = new BasicBlock(curLabel, stmts, Optional.of(((IRLabel) stmt).name()));
                    blocks.add(block);
                }
                curLabel = ((IRLabel) stmt).name();
                stmts = new ArrayList<>();
                stmts.add(stmt);
            } else {
                stmts.add(stmt);
            }
        }

        // add blocks not ended with jump
        if (stmts.size() != 0){
            IRJump newJump = irFactory.IRJump(irFactory.IRName(doneLable));
            stmts.add(newJump);
            BasicBlock block = new BasicBlock(curLabel, stmts, Optional.of(newJump), Optional.of(doneLable));
            blocks.add(block);
        }

        //create epilogue
        blocks.add(new BasicBlock(doneLable, new ArrayList<>(List.of(irFactory.IRLabel(doneLable))), Optional.empty()));

        return blocks;
    }

        /**
         * Recursively connect the basic blocks in blocks according to their control flow.
         * @param block first basic block in trace
         * @return root of CFG
         */
    private BasicBlock connectBlocks(BasicBlock block){
        Optional<IRStmt> endingStmt = block.endingStatement;

        // mark this block as connected
        block.connected = true;
        basicBlocksMap.put(block.label, block);

        if (endingStmt.isPresent()) {
                if (endingStmt.get() instanceof IRCJump) {
                    BasicBlock trueChild = basicBlocksMap.get(((IRCJump) endingStmt.get()).trueLabel());
                    BasicBlock falseChild = basicBlocksMap.get(((IRCJump) endingStmt.get()).falseLabel());
                    if (!basicBlocksMap.get(trueChild.label).connected){
                        block.children.add(connectBlocks(trueChild));
                    }
                    if (!basicBlocksMap.get(falseChild.label).connected){
                        block.children.add(connectBlocks(falseChild));
                    }
                } else if (endingStmt.get() instanceof IRJump){
                    BasicBlock child = basicBlocksMap.get(getIRJumpLabel((IRJump)endingStmt.get()));
                    if (!basicBlocksMap.get(child.label).connected) {
                        block.children.add(connectBlocks(child));
                    }
                }
            } else {
                //Blocks not end with IRCJUMP, IRJUMP has the follow up block as their child
                if (block.nextBlockLabel.isPresent()){
                    String nextLabel = block.nextBlockLabel.get();
                    block.children.add(connectBlocks((basicBlocksMap.get(nextLabel))));
                }
            }

        return block;
    }

    /**
     *  Construct the final trace which includes an epilogue.
     * @param root the root of a CFG
     * @return the trace with n epilogue
     */
    private List<BasicBlock> buildTrace(BasicBlock root) {
        List<BasicBlock> trace = buildTraceBody(root);
        BasicBlock epilogueBlock = originalBasicBlocks.get(originalBasicBlocks.size()-1);
        trace.add(epilogueBlock);
        return trace;
    }

    /**
     *  Greedily construct a trace from the CFG.
     * @param root the root of a CFG
     * @return the trace body
     */
    private List<BasicBlock> buildTraceBody(BasicBlock root) {
        List<BasicBlock> trace = new ArrayList<>();
        BasicBlock cur = root;
        if (cur == null) { return trace; }

        if (!cur.visited){
            cur.visited = true;
            if (cur.nextBlockLabel.isPresent()){
                trace.add(cur);
            }
            if (cur.children.size() != 0){
                for (BasicBlock child : cur.children){
                    trace.addAll(buildTraceBody(child));
                }
            }
        }
        return trace;
    }

    /**
     *  Get the label of the target of IRJump.
     * @param stmt IRJump
     * @return IRJump target label
     */
    private String getIRJumpLabel (IRJump stmt){
        String curLabel = stmt.target().label();
        return curLabel.substring(5, curLabel.length()-1);
    }

}
