package jw795.optimizer;

import jw795.asmgenerator.TempSpiller;
import jw795.asmgenerator.Tiler;
import jw795.assembly.*;
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

    public HashMap<AAOperand, NodeColor> color;

    TempSpiller tmpsp;

    int iteration = 0;

    int K = NodeColor.values().length; //number of usable registers

    public RegisterAllocator(List<AAInstruction> instructionList, TempSpiller tempSpiller) {
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
        this.tmpsp = tempSpiller;
    }

    public void registerAllocate() {
//        System.out.println("new iteration");
//        System.out.println(instructionList);
        livenessAnalysis();
//        System.out.println("live var values: " + liveVar.values());
        for (AAInstruction ins : instructionList) {
            for (AAOperand o : union(ins.use(), ins.def())) {
                if (o instanceof AATemp) {
                    initial.add(o);
                }
                if (o instanceof AAReg && ((AAReg) o).toColor() != null) {
                    precolored.add(o);
                    color.put(o, ((AAReg) o).toColor());
                }
                degree.put(o, 0L);
                adjList.put(o, new HashSet<>());
            }
        }
//        System.out.println("initial: " + initial);
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
//            System.out.println(spilledNodes);
            rewriteProgram();
//            if (iteration < 3) {
//                try {
//                    FileWriter fw = new FileWriter("iteration" + iteration + ".txt");
//                    for (AAInstruction ins : instructionList) {
//                        fw.write(ins.toString() + '\n');
//                    }
//                    fw.flush();
//                } catch (Exception e) {
//                    System.out.println("fw failed");
//                }
//                iteration++;
//                registerAllocate();
//            }
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
            if (isMoveInstruction(ins)) {
                live.removeAll(ins.use());
                HashSet<AAOperand> mentioned = new HashSet<>();
                mentioned.addAll(ins.def());
                mentioned.addAll(ins.use());
                for (AAOperand n : mentioned) {
                    HashSet<AAMove> newMoveList = new HashSet<>(moveList.getOrDefault(n, new HashSet<>()));
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

    private boolean isMoveInstruction(AAInstruction ins) {
        if (ins instanceof AAMove) {
            AAOperand o1 = ins.operand1.get();
            AAOperand o2 = ins.operand2.get();
            return ((o1 instanceof AATemp) || ((o1 instanceof AAReg) && (((AAReg) o1).toColor() != null))) &&
                    ((o2 instanceof AATemp) || ((o2 instanceof AAReg) && (((AAReg) o2).toColor() != null)));
        } else {
            return false;
        }
    }

    private void addEdge(AAOperand u, AAOperand v){
        GraphEdge uvEdge = new GraphEdge(u, v);
        if (!adjSet.contains(uvEdge) && !u.equals(v)){
            adjSet.add(uvEdge);
            adjSet.add(new GraphEdge(v, u));

            if (!precolored.contains(u)){
                if (adjList.containsKey(u)) {
                    adjList.get(u).add(v);
                } else {
                    adjList.put(u, new HashSet<>(List.of(v)));
                }
                degree.put(u, degree.getOrDefault(u, 0L)+1);
            }
            if (!precolored.contains(v)){
                if (adjList.containsKey(v)) {
                    adjList.get(v).add(u);
                } else {
                    adjList.put(v, new HashSet<>(List.of(u)));
                }
                degree.put(v, degree.getOrDefault(v, 0L)+1);
            }
        }
    }

    private void makeWorklist() {
        HashSet<AAOperand> initialCopy = new HashSet<>(initial);
        for (AAOperand n : initialCopy){
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
        HashSet<AAMove> moveLst = new HashSet<>(moveList.getOrDefault(n, new HashSet<>()));
        moveLst.removeAll(activeM);
        return moveLst;
    }

    private boolean moveRelated(AAOperand n) {
        return !nodeMoves(n).isEmpty();
    }

    private void simplify(){
        AAOperand n = simplifyWorklist.iterator().next();
        simplifyWorklist.remove(n);
        selectStack.push(n);

        for (AAOperand m : adjacent(n)){
            decrementDegree(m);
        }
    }

    private void decrementDegree(AAOperand m) {
        Long d = degree.get(m);
        degree.put(m, d-1);
        if (d == K){
            HashSet<AAOperand> adjNodes = adjacent(m);
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
        return degree.get(t) < K || precolored.contains(t) || adjSet.contains(new GraphEdge(t, r));
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
        AAMove m = worklistMoves.iterator().next();
        AAOperand x = m.operand1.get();
        AAOperand y = m.operand2.get();

        // getAlias of node corresponding to the AAexpr
        x = getAlias(x);
        y = getAlias(y);

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
        } else if ((precolored.contains(u) && (adjacent(v).stream().allMatch(entry -> ok(entry, u))))
                || (!precolored.contains(u) && conservative(union(adjacent(u), adjacent(v))))) {
            constrainedMoves.add(m);
            combine(u, v);
            addWorkList(u);
        } else {
            activeMoves.add(m);
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
        enableMoves(new HashSet<>(List.of(v)));

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
        AAOperand u = freezeWorklist.iterator().next();
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
            frozenMoves.add(m);
            if(freezeWorklist.contains(v) && nodeMoves(v).isEmpty()){
                freezeWorklist.remove(v);
                simplifyWorklist.add(v);
            }
        }
    }

    public void selectSpill() {
        Long maxDegree = 0L;
        AAOperand m = spillWorklist.iterator().next();
        for (AAOperand node : spillWorklist) {
            if (degree.get(node) > maxDegree) {
                maxDegree = degree.get(node);
                m = node;
            }
        }
        spillWorklist.remove(m);
        simplifyWorklist.add(m);
        freezeMoves(m);
    }

    public void assignColors() {
        while(!selectStack.isEmpty()){
            AAOperand n = selectStack.pop();
            Set<NodeColor> okColors = new HashSet<>(EnumSet.allOf(NodeColor.class));

            for (AAOperand w : adjList.get(n)){
                if (union(coloredNodes, precolored).contains(getAlias(w))){
                    okColors.remove(color.get(getAlias(w)));
                }
            }

            if (okColors.isEmpty()){
                spilledNodes.add(n);
            } else {
                coloredNodes.add(n);
                NodeColor assignedColor = okColors.iterator().next();
                color.put(n, assignedColor);
            }

            for(AAOperand coleasedNode : coalescedNodes){
                color.put(coleasedNode, color.get(getAlias(coleasedNode)));
            }
        }
    }

    public void rewriteProgram() {
        HashSet<AAOperand> newTemps = new HashSet<>();
        for (int i = 0; i < instructionList.size(); i++) {
            AAInstruction a = instructionList.get(i);
            AAOperand a1;
            AAOperand a2;

            if (a.operand1.isPresent()) {
                a1 = a.operand1.get();
                if (a1 instanceof AATemp && spilledNodes.contains(a1)) {
                    tmpsp.spillTemp((AATemp) a1);
                    AAImm offset = tmpsp.getOffsetOfTemp((AATemp) a1);
                    AAMem mem = new AAMem();
                    mem.setBase(Tiler.rbp);
                    mem.setImmediate(offset);
                    AATemp newTemp = tmpsp.newTemp();
                    newTemps.add(newTemp);
                    if (a.use().contains(a1)) {
                        instructionList.add(i, new AAMove(newTemp, mem));
                        i++;
                    }
                    if (a.def().contains(a1)) {
                        i++;
                        instructionList.add(i, new AAMove(mem, newTemp));
                    }
                    a.reseta1(newTemp);
                }
            }
            if (a.operand2.isPresent()) {
                a2 = a.operand2.get();
                if (a2 instanceof AATemp && spilledNodes.contains(a2)) {
                    tmpsp.spillTemp((AATemp) a2);
                    AAImm offset = tmpsp.getOffsetOfTemp((AATemp) a2);
                    AAMem mem = new AAMem();
                    mem.setBase(Tiler.rbp);
                    mem.setImmediate(offset);
                    AATemp newTemp = tmpsp.newTemp();
                    newTemps.add(newTemp);
                    if (a.use().contains(a2)) {
                        instructionList.add(i, new AAMove(newTemp, mem));
                        i++;
                    }
                    if (a.def().contains(a2)) {
                        i++;
                        instructionList.add(i, new AAMove(mem, newTemp));
                    }
                    a.reseta2(newTemp);
                }
            }
        }
        spilledNodes = new HashSet<>();
        initial = union(union(coloredNodes, coalescedNodes), newTemps);
        coloredNodes = new HashSet<>();
        coalescedNodes = new HashSet<>();
    }

    public List<AAInstruction> allocateAndRemove() {
//        System.out.println(color);
//        System.out.println("spilled: " + spilledNodes);
//        System.out.println("colored: " + coloredNodes);
//        System.out.println("coalesced: " + coalescedNodes);
//        System.out.println("selectStack: " + selectStack);
//        System.out.println("initial: " + initial);
        List<AAInstruction> remove = new ArrayList<>();
        for (AAInstruction a : instructionList) {
            AAOperand a1;
            AAOperand a2;

            if (a.operand1.isPresent()) {
                a1 = a.operand1.get();
                if (a1 instanceof AATemp) {
                    NodeColor c = color.get(a1);
                    a.reseta1(c.colorToReg());
                }
            }
            if (a.operand2.isPresent()) {
                a2 = a.operand2.get();
                if (a2 instanceof AATemp) {
                    NodeColor c = color.get(a2);
                    a.reseta2(c.colorToReg());
                }
            }
//            if (a instanceof AAMove && a.operand1.get().equals(a.operand2.get())) {
//                remove.add(a);
//            }
        }
//        instructionList.removeAll(remove);
        return instructionList;
    }

    /**
     * Helper function to take the union of two sets
     * @param set1 first set
     * @param set2 second set
     * @return a hashset that is the union of two set
     * */
    private <T> HashSet<T> union(HashSet<T> set1, HashSet<T> set2){
        HashSet<T> union = new HashSet<>(set1);
        union.addAll(set2);
        return union;
    }
}
