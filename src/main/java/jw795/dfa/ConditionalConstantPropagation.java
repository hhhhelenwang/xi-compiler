package jw795.dfa;

import jw795.assembly.AAInstruction;
import jw795.cfg.CFG;
import jw795.cfg.CFGNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// TODO: the current lattice value is not right
// the lattice: a tuple
// first of tuple: boolean
// second of tuple: a map from variable names to its possible values
// done on AA
public class ConditionalConstantPropagation
        extends DataFlowAnalysis<HashMap<String, HashSet<Integer>>, AAInstruction> {

    public ConditionalConstantPropagation(CFG<AAInstruction> cfg) {
        super(cfg);
    }

    @Override
    public HashMap<String, HashSet<Integer>> meet(List<HashMap<String, HashSet<Integer>>> input) {
        return null;
    }

    @Override
    public HashMap<String, HashSet<Integer>> fn(HashMap<String, HashSet<Integer>> l,
                                                HashMap<String, HashSet<Integer>> gen,
                                                HashMap<String, HashSet<Integer>> kill) {
        return null;
    }

    @Override
    public HashMap<String, HashSet<Integer>> gen(CFGNode<AAInstruction> node,
                                                 HashMap<String, HashSet<Integer>> l) {
        return null;
    }

    @Override
    public HashMap<String, HashSet<Integer>> kill(CFGNode<AAInstruction> node,
                                                  HashMap<String, HashSet<Integer>> l) {
        return null;
    }
}
