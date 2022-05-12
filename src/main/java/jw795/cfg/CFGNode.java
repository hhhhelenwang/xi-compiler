package jw795.cfg;

import edu.cornell.cs.cs4120.xic.ir.IRStmt;
import jw795.assembly.AAInstruction;

import java.util.ArrayList;
import java.util.List;

public class CFGNode<T> {
    private String name; //used to distinguish start or end
    private T stmt;
    private List<CFGNode<T>> predecessors;
    private List<CFGNode<T>> successors;

    public CFGNode(T stmt){
        this.name = stmt.toString();
        this.stmt = stmt;
        this.predecessors = new ArrayList<>();
        this.successors = new ArrayList<>();
    }

    public CFGNode(T stmt, String name){
        this.name = name;
        this.stmt = stmt;
        this.predecessors = new ArrayList<>();
        this.successors = new ArrayList<>();
    }

    public T getStmt(){
        return this.stmt;
    }

    public String getName() {
        return this.name;
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


//    private String generateName(T stmt) {
//        if (stmt instanceof IRStmt){
//            switch (stmt){
//
//            }
//        } else if (stmt instanceof AAInstruction){
//
//        }
//    }
}
