package jw795.irgenerator;

import edu.cornell.cs.cs4120.xic.ir.IRStmt;

import java.util.ArrayList;
import java.util.List;

/**
 * A representation of a basic block.
 */
public class BasicBlock {
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
