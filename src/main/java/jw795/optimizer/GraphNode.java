package jw795.optimizer;

import jw795.assembly.AAOperand;
import jw795.assembly.AAReg;

enum set {precolored, initial, simplifyWorklist, spillWorklist, spillledNodes, coalescedNodes, coloredNodes, selectStack}

public class GraphNode {
    private AAOperand operand;
    private AAReg register;
    private set set;
}
