package jw795.optimizer;

import jw795.assembly.AAInstruction;
import jw795.assembly.AAMove;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RegisterAllocator {
    List<AAInstruction> instructionList;
    HashSet<GraphNode> precolored;
    HashSet<GraphNode> initial;
    HashSet<GraphNode> simplifyWorklist;
    HashSet<GraphNode> freezeWorklist;
    HashSet<GraphNode> spillWorklist;
    HashSet<GraphNode> spilledNodes;
    HashSet<GraphNode> coalescedNodes;
    HashSet<GraphNode> coloredNodes;
    HashSet<GraphNode> selectStack;

    //move sets
    HashSet<AAMove> coalescedMoves;
    HashSet<AAMove> constrainedMoves;
    HashSet<AAMove> frozenMoves;
    HashSet<AAMove> worklistMoves;
    HashSet<AAMove> activeMoves;

    HashSet<GraphEdge> adjSet;
    HashMap<GraphNode, HashSet<GraphNode>> adjList;
    HashMap<GraphNode, Long> degree;
    HashMap<GraphNode, AAMove> moveList;
    HashMap<GraphNode, GraphNode> alias;


    public RegisterAllocator(List<AAInstruction> instructionList) {

        this.instructionList = instructionList;
    }

    public List<AAInstruction> registerAllocate() {
        return null;
    }
}
