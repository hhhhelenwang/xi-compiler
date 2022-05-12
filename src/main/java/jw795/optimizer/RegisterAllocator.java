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
    AsmCFG cfg;
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
    HashMap<GraphNode, HashSet<AAMove>> moveList;
    HashMap<GraphNode, GraphNode> alias;

    int K = 16; //number of usable registers

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
        livenessAnalysis();
        build();
        makeWorklist();
        while (!(simplifyWorklist.isEmpty() && worklistMoves.isEmpty() && freezeWorklist.isEmpty() && spillWorklist.isEmpty())) {
            if (!simplifyWorklist.isEmpty()) simplify();
            else if (!worklistMoves.isEmpty()) coalesce();
            else if (!freezeWorklist.isEmpty()) freeze();
            else selectSpill();
        }
        assignColors();
        if (!spilledNodes.isEmpty()) {
            rewriteProgram(spilledNodes);
            registerAllocate();
        }
    }

    public void livenessAnalysis() {
        CFGGenerator cfgGenerator = new CFGGenerator();
        cfg = cfgGenerator.toAsmCFG(instructionList);
        LiveVariableAnalysis liveVariableAnalysis = new LiveVariableAnalysis(cfg);
        HashMap<CFGNode<AAInstruction>, HashSet<AAOperand>> analysis = liveVariableAnalysis.backward();
        liveVar = new HashMap<>();
        for (Map.Entry<CFGNode<AAInstruction>, HashSet<AAOperand>> entry : analysis.entrySet()) {
            liveVar.put(entry.getKey().getStmt(), entry.getValue());
        }
    }

    public void build() {
        HashSet<AAOperand> live = new HashSet<>();
        for (AAInstruction ins : instructionList) {
            for ()
        }
    }

    public void coalesce() {

    }
    public void freeze() {

    }
    public void selectSpill() {

    }

    public void assignColors() {

    }

    public void rewriteProgram(HashSet<GraphNode> spilledNodes) {

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

    private HashSet<GraphNode> adjacent(GraphNode n){
        HashSet adjSet = new HashSet(adjList.get(n));
        HashSet union = new HashSet(selectStack);
        union.addAll(coalescedNodes);
        adjSet.removeAll(union);
        return adjSet;
    }

    private void makeWorklist() {
        for (GraphNode n : initial){
            initial.remove(n);
            if (degree.get(n) >= K){
                spillWorklist.add(n);
            } else if (moveRelated(n)){
                freezeWorklist.add(n);
            } else {
                simplifyWorklist.add(n);
            }
        }
    }

    private boolean moveRelated(GraphNode n) {
        return nodeMoves(n).size() != 0;
    }

    private HashSet<AAMove> nodeMoves(GraphNode n) {
        HashSet<AAMove> activeM = new HashSet<>(activeMoves);
        HashSet<AAMove> worklistM = new HashSet<>(worklistMoves);
        HashSet<AAMove> moveLst = new HashSet<>(moveList.get(n));

        activeM.addAll(worklistM);
        moveLst.removeAll(activeM);

        return moveLst;
    }

    private void simplify(){
        for (GraphNode n : simplifyWorklist){
            simplifyWorklist.remove(n);
            selectStack.add(n);

            for (GraphNode m : adjacent(n)){
                decrementDegree(m);
            }
        }
    }

    private void decrementDegree(GraphNode m) {
        Long d = degree.get(m);
        degree.put(m, degree.get(m)-1);
        if (d == K){
            HashSet adjNodes = adjacent(m);
            adjNodes.add(m);
            enableMoves(adjNodes);
            spillWorklist.remove(m);
            if (moveRelated(m)){
                freezeWorklist.add(m);
            } else {
                simplifyWorklist.add(m);
            }
        }
    }

    private void enableMoves(HashSet<GraphNode> nodes) {
        for (GraphNode n : nodes){
            for (AAMove m : nodeMoves(n)){
                if (activeMoves.contains(m)){
                    activeMoves.remove(m);
                    worklistMoves.add(m);
                }
            }
        }
    }

    private void addWorkList(GraphNode u){
        if (!precolored.contains(u) && !(moveRelated(u) && degree.get(u) < K)){
            freezeWorklist.remove(u);
            simplifyWorklist.add(u);
        }
    }

    private boolean ok(GraphNode t, GraphNode r){
        // TODO: double check adjSet.contains(new GraphEdge) would work: compare by value
        return degree.get(r) < K && precolored.contains(t) && adjSet.contains(new GraphEdge(t, r));
    }

    private boolean conservative(HashSet<GraphNode> nodes){
        int k = 0;
        for (GraphNode n : nodes){
            if (degree.get(n) >= K){
                k++;
            }
        }
        return k<K;
    }

}
