package jw795.optimizer;

import jw795.assembly.AAInstruction;
import jw795.assembly.AAMove;
import jw795.assembly.AAOperand;
import jw795.cfg.AsmCFG;
import jw795.cfg.CFGGenerator;
import jw795.cfg.CFGNode;
import jw795.dfa.LiveVariableAnalysis;

import java.util.*;

public class RegisterAllocator {
    List<AAInstruction> instructionList;
    AsmCFG cfg;
    HashMap<CFGNode<AAInstruction>, HashSet<AAOperand>> liveVar;
    HashSet<AAOperand> precolored;
    HashSet<AAOperand> initial;
    HashSet<AAOperand> simplifyWorklist;
    HashSet<AAOperand> freezeWorklist;
    HashSet<AAOperand> spillWorklist;
    HashSet<AAOperand> spilledNodes;
    HashSet<AAOperand> coalescedNodes;
    HashSet<AAOperand> coloredNodes;
    Stack<AAOperand> selectStack;

    //move sets
    HashSet<AAMove> coalescedMoves;
    HashSet<AAMove> constrainedMoves;
    HashSet<AAMove> frozenMoves;
    HashSet<AAMove> worklistMoves;
    HashSet<AAMove> activeMoves;

    HashSet<GraphEdge> adjSet;
    HashMap<AAOperand, HashSet<AAOperand>> adjList;
    HashMap<AAOperand, Long> degree;
    HashMap<AAOperand, HashSet<AAMove>> moveList;
    HashMap<AAOperand, AAOperand> alias;

    HashMap<AAOperand, NodeColor> color;

    int K = 16; //number of usable registers

    public RegisterAllocator(List<AAInstruction> instructionList) {
        this.instructionList = instructionList;
        this.liveVar = new HashMap<>();
        this.precolored = new HashSet<>();
        this.initial = new HashSet<>();
        this.simplifyWorklist = new HashSet<>();
        this.freezeWorklist = new HashSet<>();
        this.spillWorklist = new HashSet<>();
        this.spilledNodes = new HashSet<>();
        this.coalescedNodes = new HashSet<>();
        this.coloredNodes = new HashSet<>();
        this.selectStack = new Stack<>();
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
        this.color = new HashMap<>();
    }

    public void registerAllocate() {
        //TODO: assign precolored and initial
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
        liveVar = liveVariableAnalysis.backward();
    }

    public void build() {
        for (AAInstruction ins : instructionList) {
            CFGNode<AAInstruction> node = cfg.getNode(ins);
            HashSet<AAOperand> live = new HashSet<>();
            for (CFGNode<AAInstruction> suc : node.getSuccessors()) {
                live.addAll(liveVar.get(suc));
            }
            if (ins instanceof AAMove) {
                live.removeAll(ins.use());
                HashSet<AAOperand> mentioned = new HashSet<>();
                mentioned.addAll(ins.def());
                mentioned.addAll(ins.use());
                for (AAOperand n : mentioned) {
                    HashSet<AAMove> newMoveList = new HashSet<>(moveList.get(n));
                    newMoveList.add((AAMove) ins);
                    moveList.put(n, newMoveList);
                }
                worklistMoves.add((AAMove) ins);
            }
            live.addAll(ins.def());
            for (AAOperand d : ins.def()) {
                for (AAOperand l : live) {
                    addEdge(l, d);
                }
            }
        }
    }


    private void addEdge(AAOperand u, AAOperand v){
        GraphEdge uvEdge = new GraphEdge(u, v);
        if (!adjSet.contains(uvEdge) && !u.equals(v)){
            adjSet.add(uvEdge);
            adjSet.add(new GraphEdge(v, u));

            if (!precolored.contains(u)){
                adjList.get(u).add(v);
                degree.put(u, degree.get(u)+1);
            }
            if (!precolored.contains(v)){
                adjList.get(v).add(u);
                degree.put(v, degree.get(v)+1);
            }
        }
    }

    private void makeWorklist() {
        for (AAOperand n : initial){
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

    private HashSet<AAOperand> adjacent(AAOperand n){
        HashSet<AAOperand> adjSet = new HashSet<>(adjList.get(n));
        selectStack.forEach(adjSet::remove);
        coalescedNodes.forEach(adjSet::remove);
        return adjSet;
    }

    private HashSet<AAMove> nodeMoves(AAOperand n) {
        HashSet<AAMove> activeM = new HashSet<>(activeMoves);
        activeM.addAll(worklistMoves);
        HashSet<AAMove> moveLst = new HashSet<>(moveList.get(n));
        moveLst.removeAll(activeM);
        return moveLst;
    }

    private boolean moveRelated(AAOperand n) {
        return !nodeMoves(n).isEmpty();
    }

    private void simplify(){
        for (AAOperand n : simplifyWorklist){
            simplifyWorklist.remove(n);
            selectStack.push(n);

            for (AAOperand m : adjacent(n)){
                decrementDegree(m);
            }
        }
    }

    private void decrementDegree(AAOperand m) {
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

    private void enableMoves(HashSet<AAOperand> nodes) {
        for (AAOperand n : nodes){
            for (AAMove m : nodeMoves(n)){
                if (activeMoves.contains(m)){
                    activeMoves.remove(m);
                    worklistMoves.add(m);
                }
            }
        }
    }

    private void addWorkList(AAOperand u){
        if (!precolored.contains(u) && !(moveRelated(u) && degree.get(u) < K)){
            freezeWorklist.remove(u);
            simplifyWorklist.add(u);
        }
    }

    private boolean ok(AAOperand t, AAOperand r){
        // TODO: double check adjSet.contains(new GraphEdge) would work: compare by value
        return degree.get(r) < K && precolored.contains(t) && adjSet.contains(new GraphEdge(t, r));
    }

    private boolean conservative(HashSet<AAOperand> nodes){
        int k = 0;
        for (AAOperand n : nodes){
            if (degree.get(n) >= K){
                k++;
            }
        }
        return k<K;
    }

    public void coalesce() {
        //conservative coalescing
        AAMove m = worklistMoves.stream().findFirst().orElse(null);

        if (m != null) {

            AAOperand xOp = m.operand1.get();
            AAOperand yOp = m.operand2.get();

            // getAlias of node corresponding to the AAexpr
            AAOperand x = getAlias(xOp);
            AAOperand y = getAlias(yOp);

            AAOperand u;
            AAOperand v;
            if (precolored.contains(y)) {
                u = y;
                v = x;
            } else {
                u = x;
                v = y;
            }

            worklistMoves.remove(m);

            if (u.equals(v)) {
                coalescedMoves.add(m);
                addWorkList(u);
            } else if (precolored.contains(v) || adjSet.contains(new GraphEdge(u, v))) {
                constrainedMoves.add(m);
                addWorkList(u);
                addWorkList(v);
            } else if ((precolored.contains(u) && adjacent(u).stream().allMatch(entry -> ok(entry, u)))
                    || (!precolored.contains(u) && conservative(union(adjacent(u), adjacent(v))))) {
                constrainedMoves.add(m);
                combine(u, v);
                addWorkList(u);
            } else {
                activeMoves.add(m);
            }
        } else {
            return;
        }

    }

    private void combine(AAOperand u, AAOperand v){
        if (freezeWorklist.contains(v)){
            freezeWorklist.remove(v);
        } else {
            spillWorklist.remove(v);
        }
        coalescedNodes.add(v);
        alias.put(v, u);
        moveList.put(u, union(moveList.get(u), moveList.get(v)));
        enableMoves(new HashSet<>(Arrays.asList(v)));

        for (AAOperand t : adjacent(v)){
            addEdge(t, u);
            decrementDegree(t);
        }

        if (degree.get(u) >= K && freezeWorklist.contains(u)){
            freezeWorklist.remove(u);
            spillWorklist.add(u);
        }
    }

    private AAOperand getAlias(AAOperand n) {
        if (coalescedNodes.contains(n)){
            return getAlias(alias.get(n));
        }
        return n;
    }

    public void freeze() {
        AAOperand u = freezeWorklist.stream().findFirst().orElse(null);
        if (u == null) return;
        
        freezeWorklist.remove(u);
        simplifyWorklist.add(u);
        freezeMoves(u);
    }

    private void freezeMoves(AAOperand u) {
        for (AAMove m : nodeMoves(u)){
            AAOperand x = m.operand1.get();
            AAOperand y = m.operand2.get();
            AAOperand v;
            if (getAlias(y).equals(getAlias(u))){
                v = getAlias(x);
            } else {
                v = getAlias(y);
            }

            activeMoves.remove(m);
            activeMoves.add(m);
            if( freezeWorklist.contains(v) && nodeMoves(v).size() == 0){
                freezeWorklist.remove(v);
                simplifyWorklist.add(v);
            }
        }
    }

    public void selectSpill() {
        //TODO: select which temp to spill: choose the one with longest live range

        AAOperand m;
        spillWorklist.remove(m);
        simplifyWorklist.add(m);
        freezeMoves(m);
    }

    public void assignColors() {
        while(!selectStack.isEmpty()){
            AAOperand n = selectStack.pop();
        }
    }

    public void rewriteProgram(HashSet<AAOperand> spilledNodes) {

    }

    /**
     * Helper function to take the union of two sets
     * @param set1
     * @param set2
     * @return a hashset that is the union of two set
     * */
    private HashSet union(HashSet set1, HashSet set2){
        HashSet union = new HashSet(set1);
        union.addAll(set2);
        return union;
    }
}
