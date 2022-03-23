package jw795.irgenerator;

import edu.cornell.cs.cs4120.util.SExpPrinter;
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

    // TODO: notes on building cfg:
    //  1. build one cfg per function body?
    //  2. need to first separate ir into basic block
    //  3. and then connect the basic block into cfg according to their control flow
    //      -> how to decides which block should connect to which other blocks?

    HashMap<String, BasicBlock> basicBlocksMap;// basicBlocksMap maps Label string to its basicBlock
    IRNodeFactory_c irFactory;


    IRCompUnit ir; // the ir to reorder
    BasicBlock cfg; // the control flow graph built from ir

    public JumpReorder() {
        this.irFactory = new IRNodeFactory_c();
        this.basicBlocksMap = new HashMap<>();
    }

    public void printSeq(IRSeq seq) {
        List<IRStmt> stmts = seq.stmts();
        for (IRStmt stmt : stmts) {
            System.out.println(stmt.toString()); // Added here for debugging purpose
//            stmt.printSExp(p);
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
//                printSeq((IRSeq)body);
                basicBlocksMap = new HashMap<>();
                BasicBlock root = buildCFG(((IRSeq)function.body()));
                List<BasicBlock> trace = buildTrace(root);

                System.out.println(trace.size());

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
        List<IRStmt> stmts = new ArrayList<>();
        BasicBlock curBlock;
        BasicBlock nxtBlock;
        boolean prevIsCjump = false;
        System.out.println("total number of blocks " + trace.size());

        // only need to worry about fixing jumps if there exist a next block
        for (int i = 0; i < trace.size()-1; i++){
            System.out.println("enter block " + i);
            System.out.println("block size " + trace.get(i).statements.size());
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
                        newCjump = new IRCJump(newCond, ((IRCJump) curEndingStmt).falseLabel());
                    } else {
                        newCjump = new IRCJump(((IRCJump) curEndingStmt).cond(), ((IRCJump) curEndingStmt).trueLabel());
                    }

                    prevIsCjump = true;
                    // update block with correct ending stmt
                    curBlock.statements.remove(curBlock.statements.size()-1); //remove last stmt
//                    System.out.println();
                    stmts.addAll(curBlock.statements);
                    stmts.add(newCjump);
                } else if (curEndingStmt instanceof IRJump){

                    //check if the next basic block has same label, if so, remove the jump
                    String nxtLabel = ((IRLabel) nxtBlock.statements.get(0)).name();
                    if (nxtLabel.equals(((IRJump) curEndingStmt).target())){
                        curBlock.statements.remove((curBlock.statements.size()-1));
                        stmts.addAll(curBlock.statements);
                    }


                } else {
                    stmts.addAll(curBlock.statements);
                }

                // do nothing for IRReturn
            } else {
                if (prevIsCjump){
                    curBlock.statements.remove(0); //remove first stmt (LABEL)
                } else {
                    // check if we need to add JUMP if does not transfer control && not followed by next label
                    String nxtLabel = ((IRLabel) nxtBlock.statements.get(0)).name();
                    String expectedNxt = curBlock.nextBlockLabel.get();
                    if (!nxtLabel.equals(expectedNxt)) {
                        curBlock.statements.add(irFactory.IRJump(irFactory.IRName(expectedNxt)));
                    }
                }
                stmts.addAll(curBlock.statements);
            }
        }

        stmts.addAll(trace.get(trace.size()-1).statements);

        return new IRSeq(stmts);
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
     * @return a list of basic blocks
     */
    private List<BasicBlock> getBasicBlocks(IRSeq node) {
        List<BasicBlock> blocks = new ArrayList<>();
        List<IRStmt> stmts = new ArrayList<>();
        String curLabel = "L0";

        for (IRStmt stmt : node.stmts()){
            if (stmt instanceof IRCJump || stmt instanceof IRJump || stmt instanceof IRReturn){
                //always end a block
                stmts.add(stmt);
                BasicBlock block = new BasicBlock(stmts, stmt);
                //populate basicBlocksMap for connectBlocks() to use
                basicBlocksMap.put(curLabel, block);
                blocks.add(block);
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
