package jw795.dfa;

import jw795.cfg.CFG;
import jw795.cfg.CFGNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Data flow analysis framework
 * @param <V> the type of data flow value
 * @param <R> program representation to perform the analysis on
 */
public abstract class DataFlowAnalysis<V, R> {
    CFG<R> cfg;
    Map<CFGNode<R>, V> nodeToValueMap; // map each node to its data flow value = out set
    List<CFGNode<R>> listOfNodes; // ?? keep it here for now but not sure if we need this

    public DataFlowAnalysis(CFG<R> cfg) {
        this.cfg = cfg;
        this.nodeToValueMap = new HashMap<>();
    }

    /**
     * The meet operator of the analysis lattice
     * @param input lattice elements/data flow values to take meet on
     * @return met values
     */
    public abstract V meet(List<V> input);

    /**
     * Compute the in set of a cfg node by taking in = meet(out(n')) for all n' where n'
     * is the predecessor or successor of n, depending on direction of analysis. Here we implemented
     * the case of predecessor since we only implemented forward analysis.
     * @return in set of node
     */
    public V inSet(CFGNode<R> node) {
        List<CFGNode<R>> predecessors = node.getPredecessors();
        // get all the out sets of predecessors
        List<V> outSets = new ArrayList<>();
        for (CFGNode<R> pred : predecessors) {
            outSets.add(nodeToValueMap.get(pred));
        }
        // take a meet on the out sets
        return meet(outSets);
    }

    /**
     * Get the out set of a cfg node
     * @param node cfg node
     * @return out set of the cfg node
     */
    public V outSet(CFGNode<V> node) {
        return nodeToValueMap.get(node);
    }

    /**
     * The transfer function of the data flow analysis on a single node n.
     * @param l input data flow value/lattice element
     * @param gen gen set
     * @param kill kill set
     * @return F_n(l)
     */
    public abstract V F_n(V l, V gen, V kill);

    /**
     * Get the gen set for a cfg node
     * @param node cfg node
     * @return gen set of the cfg node
     */
    public abstract V gen(CFGNode<R> node);

    /**
     * Get the kill set for a cfg node
     * @param node cfg node
     * @return kill set of the cfg node
     */
    public abstract V kill(CFGNode<R> node);

    /**
     * The transfer function applied to all nodes in a cfg.
     * @return true if applying the function to all nodes make changes on the data
     * flow values, false otherwise
     */
    public abstract boolean F_all();

    /**
     * The iterative solving algorithm. Repeatedly apply F_all to the cfg until converges.
     */
    public void iterativeSolving() {
        boolean notConverged = false;
        while (notConverged) {
            notConverged = F_all();
        }

    }







}
