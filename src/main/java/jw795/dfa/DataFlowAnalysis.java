package jw795.dfa;

import jw795.cfg.CFG;
import jw795.cfg.CFGNode;

import java.util.*;


/**
 * Data flow analysis framework
 * @param <V> the type of data flow value
 * @param <R> program representation to perform the analysis on
 */
public abstract class DataFlowAnalysis<V, R> {
    CFG<R> cfg;
    Map<CFGNode<R>, V> nodeToValueMap; // map each node to its value set (out set for forward, in set for backward analysis)

    public DataFlowAnalysis(CFG<R> cfg) {
        this.cfg = cfg;
        this.nodeToValueMap = new HashMap<>();
    }

    public abstract void initialize ();

    /**
     * forward analysis
     * @return hashmap of cfg node to value
     */
    public Map<CFGNode<R>, V> forward (Map<CFGNode<R>, V> T) {
        Queue<CFGNode<R>> worklist = new LinkedList<>(cfg.getAllSuccessors(cfg.start(), new HashSet<>()));
        initialize();

        while (!worklist.isEmpty()) {
            CFGNode<R> cur = worklist.poll();
            List<CFGNode<R>> predecessors = cur.getPredecessors();
            List<V> outSets = new ArrayList<>();
            for (CFGNode<R> pred : predecessors) {
               outSets.add(nodeToValueMap.get(pred));
            }
            V in = meet(outSets);
            V newOut = fn(in, gen(cur, in), kill(cur, in));
            V oldOut = nodeToValueMap.get(cur);
            if (oldOut == null || !oldOut.equals(newOut)) {
                nodeToValueMap.put(cur, newOut);
                worklist.addAll(cur.getSuccessors());
            }
        }

        return nodeToValueMap;
    }

    /**
     * backward analysis
     * @return hashmap of cfg node to value
     */
    public Map<CFGNode<R>, V> backward (Map<CFGNode<R>, V> T) {
        Queue<CFGNode<R>> worklist = new LinkedList<>(cfg.getAllPredecessors(cfg.exit(), new HashSet<>()));
        initialize();

        while (!worklist.isEmpty()) {
            CFGNode<R> cur = worklist.poll();
            List<CFGNode<R>> successors = cur.getSuccessors();
            List<V> inSets = new ArrayList<>();
            for (CFGNode<R> succ : successors) {
                inSets.add(nodeToValueMap.get(succ));
            }
            V out = meet(inSets);
            V newIn = fn(out, gen(cur, out), kill(cur, out));
            V oldIn = nodeToValueMap.get(cur);
            if (oldIn == null || !oldIn.equals(newIn)) {
                nodeToValueMap.put(cur, newIn);
                worklist.addAll(cur.getPredecessors());
            }
        }
        return nodeToValueMap;
    }

    /**
     * The meet operator of the analysis lattice
     * @param input lattice elements/data flow values to take meet on
     * @return met values
     */
    public abstract V meet(List<V> input);

    /**
     * The transfer function of the data flow analysis on a single node n.
     * @param l input data flow value/lattice element
     * @param gen gen set
     * @param kill kill set
     * @return F_n(l)
     */
    public abstract V fn(V l, V gen, V kill);

    /**
     * Get the gen set for a cfg node
     * @param node cfg node
     * @param l input data flow value to the transfer function
     * @return gen set of the cfg node
     */
    public abstract V gen(CFGNode<R> node, V l);

    /**
     * Get the kill set for a cfg node
     * @param node cfg node
     * @param l input data flow value to the transfer function
     * @return kill set of the cfg node
     */
    public abstract V kill(CFGNode<R> node, V l);
}
