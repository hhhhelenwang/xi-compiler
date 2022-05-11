package jw795.optimizer;

import jw795.assembly.AAOperand;

import static jw795.optimizer.NodeColor.*;
import static jw795.optimizer.NodeSet.*;

public class GraphNode {
    private AAOperand operand;
    private NodeSet set;
    private NodeColor color = unassigned;


    public GraphNode (AAOperand operand, NodeSet set) {
        this.operand = operand;
        this.set = set;
    }

    public GraphNode (AAOperand operand, NodeSet set, NodeColor color) {
        this.operand = operand;
        this.set = set;
        this.color = color;
    }

    public void setOperand(AAOperand operand) {
        this.operand = operand;
    }

    public AAOperand getOperand() {
        return operand;
    }

    public void setSet(NodeSet set) {
        this.set = set;
    }

    public NodeSet getSet() {
        return set;
    }

    public void setColor(NodeColor color) {
        this.color = color;
    }

    public NodeColor getColor() {
        return color;
    }
}
