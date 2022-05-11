package jw795.dfa;

import jw795.assembly.AAInstruction;
import jw795.cfg.CFG;
import jw795.cfg.CFGNode;
import polyglot.util.Pair;

import java.util.HashMap;
import java.util.List;

// TODO: the current lattice value is not right
// the lattice: a tuple
// first of tuple: boolean
// second of tuple: a map from variable names to its possible values
// done on AA
public class ConditionalConstantPropagation
        extends DataFlowAnalysis<Pair<Boolean, HashMap<String, Long>>, AAInstruction> {

    public ConditionalConstantPropagation(CFG<AAInstruction> cfg) {
        super(cfg);
    }

    @Override
    public void initialize() {

    }

    /**
     *
     * @param input lattice elements/data flow values to take meet on
     * @return
     */
    @Override
    public Pair<Boolean, HashMap<String, Long>> meet(List<Pair<Boolean, HashMap<String, Long>>> input) {
        boolean newFlag = input.get(0).part1();
        HashMap<String, Long> newMap = new HashMap<>();

        return null;
    }

    @Override
    public Pair<Boolean, HashMap<String, Long>> fn(Pair<Boolean, HashMap<String, Long>> l,
                                                   Pair<Boolean, HashMap<String, Long>> gen,
                                                   Pair<Boolean, HashMap<String, Long>> kill) {
        return null;
    }

    @Override
    public Pair<Boolean, HashMap<String, Long>> gen(CFGNode<AAInstruction> node,
                                                    Pair<Boolean, HashMap<String, Long>> l) {
        return null;
    }

    @Override
    public Pair<Boolean, HashMap<String, Long>> kill(CFGNode<AAInstruction> node,
                                                     Pair<Boolean, HashMap<String, Long>> l) {
        return null;
    }


}
