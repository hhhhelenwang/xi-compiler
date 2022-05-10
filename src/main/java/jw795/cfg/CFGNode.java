package jw795.cfg;

import edu.cornell.cs.cs4120.xic.ir.IRStmt;
import jw795.assembly.AAInstruction;

import java.util.ArrayList;
import java.util.List;

public class CFGNode<T> {
    private String name;
    private T stmt;
    private List<CFGNode<T>> predecessors;
    private List<CFGNode<T>> successors;

    public CFGNode(T stmt){
        this.name = stmt.toString();
        this.stmt = stmt;
        this.predecessors = new ArrayList<>();
        this.successors = new ArrayList<>();
    }

    public String getName() {
        return name;
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

    private String generateName(T stmt) {
        String name = "";
        if (stmt instanceof IRStmt){
            name = stmt.toString();
        } else if(stmt instanceof AAInstruction){


        } else {
            System.out.println("Unsupported type was passed into CFGNode");
        }

        return name;
    }
}
