package jw795.irgenerator;

import edu.cornell.cs.cs4120.xic.ir.IRCompUnit;
import edu.cornell.cs.cs4120.xic.ir.IRNode;
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

    public BasicBlock buildCFG(IRNode ir){
        return null;
    }
}
