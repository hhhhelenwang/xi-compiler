package jw795.optimizer;

import jw795.assembly.AAInstruction;
import jw795.assembly.AAMove;
import jw795.assembly.AAOperand;
import jw795.cfg.AsmCFG;
import jw795.cfg.CFGGenerator;
import jw795.cfg.CFGNode;
import jw795.dfa.LiveVariableAnalysis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class RegisterAllocator {
    List<AAInstruction> instructionList;
    HashMap<AAInstruction, HashSet<AAOperand>> liveVar = new HashMap<>();

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

    public void registerAllocate() {
        CFGGenerator cfgGenerator = new CFGGenerator();
        AsmCFG cfg = cfgGenerator.toAsmCFG(instructionList);
        LiveVariableAnalysis liveVariableAnalysis = new LiveVariableAnalysis(cfg);
        HashMap<CFGNode<AAInstruction>, HashSet<AAOperand>> analysis = liveVariableAnalysis.backward();
        liveVar = new HashMap<>();
        for (Map.Entry<CFGNode<AAInstruction>, HashSet<AAOperand>> entry : analysis.entrySet()) {
            liveVar.put(entry.getKey().getStmt(), entry.getValue());
        }
        build();
        makeWorklist();
        do {
            if (!simplifyWorklist.isEmpty()) Simplify();
            else if (!worklistMoves.isEmpty()) Coalesce();
            else if (!freezeWorklist.isEmpty()) Freeze();
            else if (!spillWorklist.isEmpty()) SelectSpill();
        } while (true);

        return null;
    }

    public void build() {

    }

    public void makeWorklist() {

    }
}
