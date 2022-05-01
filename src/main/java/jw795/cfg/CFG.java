package jw795.cfg;

import edu.cornell.cs.cs4120.xic.ir.IRStmt;
import jw795.irgenerator.JumpReorder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public abstract class CFG<T> {
    private CFGNode<T> start;

    public CFG(CFGNode<T> start){
        this.start = start;
    }

    /**
     * Getter for start node of CFG
     * @return the start node of CFG
     */
    public CFGNode<T> start(){
        return start;
    }

    /**
     * Flatten a CFG to a list of CFGNode
     * @return list of IRStmt
     */
    public List<CFGNode<T>> flatten(){
        List<CFGNode<T>> res = getAllSuccessors(this.start, new HashSet<>());
        return res;
    }

    /**
     * Helper that uses dfs to get all CFG nodes
     * @param cur current CFGNode
     * @param visited visited CFGNode
     * @return list of IRStmt
     */
    private List<CFGNode<T>> getAllSuccessors(CFGNode<T> cur, HashSet<CFGNode<T>> visited){
        List<CFGNode<T>> res = new ArrayList<>();

        if (!visited.contains(cur)){
            res.add(cur);
            visited.add(cur);
            for (CFGNode<T> successor: cur.getSuccessors()){
                res.addAll(getAllSuccessors(successor, visited));
            }
        }

        return res;
    }

    // TODO: work in progress
//    public toDotFormat(){
//
//    }

}
