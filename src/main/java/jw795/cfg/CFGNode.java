package jw795.cfg;

import java.util.ArrayList;
import java.util.List;

public class CFGNode<T> {
    private T stmt;
    private List<CFGNode<T>> predecessors;
    private List<CFGNode<T>> successors;

    public CFGNode(T stmt){
        this.stmt = stmt;
        this.predecessors = new ArrayList<>();
        this.successors = new ArrayList<>();
    }

    public T getStmt(){
        return this.stmt;
    }

    public List<CFGNode<T>> getPredecessors(){
        return this.predecessors;
    }

    public List<CFGNode<T>> getSuccessors(){
        return this.successors;
    }

    public void addPredecessor(CFGNode<T> node){
        this.predecessors.add(node);
    }

    public void addSuccessor(CFGNode <T> node){
        this.successors.add(node);
    }
}
