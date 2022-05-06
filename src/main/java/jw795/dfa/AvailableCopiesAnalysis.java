package jw795.dfa;

import jw795.assembly.AAInstruction;
import jw795.cfg.CFG;
import jw795.cfg.CFGNode;
import polyglot.util.Pair;

import java.util.HashSet;
import java.util.List;

/**
 * Implementation for available copies analysis
 * Data flow value: set of equalities
 */
public class AvailableCopiesAnalysis
        extends DataFlowAnalysis<HashSet<Pair<String, String>>, AAInstruction> {
    public AvailableCopiesAnalysis(CFG<AAInstruction> cfg) {
        super(cfg);
    }

    @Override
    public HashSet<Pair<String, String>> meet(List<HashSet<Pair<String, String>>> input) {
        return null;
    }

    @Override
    public HashSet<Pair<String, String>> F_n(HashSet<Pair<String, String>> l,
                                             HashSet<Pair<String, String>> gen,
                                             HashSet<Pair<String, String>> kill) {
        return null;
    }

    @Override
    public HashSet<Pair<String, String>> gen(CFGNode<AAInstruction> node) {
        return null;
    }

    @Override
    public HashSet<Pair<String, String>> kill(CFGNode<AAInstruction> node) {
        return null;
    }

    @Override
    public boolean F_all() {
        return false;
    }
}
