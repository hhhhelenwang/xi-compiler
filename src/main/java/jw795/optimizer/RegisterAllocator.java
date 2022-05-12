package jw795.optimizer;

import jw795.assembly.AAInstruction;
import jw795.assembly.AAMove;
import jw795.assembly.AAOperand;
import jw795.assembly.AATemp;
import jw795.cfg.AsmCFG;
import jw795.cfg.CFGGenerator;
import jw795.cfg.CFGNode;
import jw795.dfa.LiveVariableAnalysis;
import polyglot.util.Pair;

import java.util.*;

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

    List<String> regs = Arrays.asList("rax", "rbx", "rcx", "rdx", "r8", "r9", "r10", "r11", "r12",
            "r13", "r14", "r15","rsi","rdi","rsp","rbp");

    public RegisterAllocator(List<AAInstruction> instructionList) {
        this.instructionList = instructionList;
        this.precolored = new HashSet<>();
        this.initial = new HashSet<>();
        this.simplifyWorklist = new HashSet<>();
        this.freezeWorklist = new HashSet<>();
        this.spillWorklist = new HashSet<>();
        this.spilledNodes = new HashSet<>();
        this.coalescedNodes = new HashSet<>();
        this.coloredNodes = new HashSet<>();
        this.selectStack = new HashSet<>();
        this.coalescedMoves = new HashSet<>();
        this.constrainedMoves = new HashSet<>();
        this.frozenMoves = new HashSet<>();
        this.worklistMoves = new HashSet<>();
        this.activeMoves = new HashSet<>();
        this.adjSet = new HashSet<>();
        this.adjList = new HashMap<>();
        this.degree = new HashMap<>();
        this.moveList = new HashMap<>();
        this.alias = new HashMap<>();
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

    }

    private void SelectSpill() {
    }

    private void Freeze() {
    }

    private void Coalesce() {
    }

    private void Simplify() {
    }

    public void build() {
    }

    public void makeWorklist() {

    }

    private void addEdge(AATemp u, AATemp v){
        //TODO: get uNode and vNode from interference graph, null init is temp
        GraphNode uNode = null;
        GraphNode vNode = null;
        GraphEdge uvEdge = new GraphEdge(uNode, vNode);
        if (!adjSet.contains(uvEdge) && !u.equals(v)){
            adjSet.add(uvEdge);
            adjSet.add(new GraphEdge(vNode, uNode));

            if (precolored.contains(uNode)){
                adjList.get(uNode).add(vNode);
                degree.put(uNode, degree.get(uNode)+1);
            }
            if (precolored.contains(vNode)){
                adjList.get(vNode).add(uNode);
                degree.put(vNode, degree.get(vNode)+1);
            }
        }
    }
}
