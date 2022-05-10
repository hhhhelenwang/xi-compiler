package jw795.dfa;

import jw795.assembly.*;
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

    /**
     * meet = intersection for available copies analysis
     * @param input lattice elements/data flow values to take meet on
     * @return intersection of all sets in input
     */
    @Override
    public HashSet<Pair<String, String>> meet(List<HashSet<Pair<String, String>>> input) {
        HashSet<Pair<String, String>> metSet = new HashSet<>(input.get(0));
        for (HashSet<Pair<String, String>> in : input) {
            // retainAll remove keeps elements in metSet that are also in the set in
            metSet.retainAll(in);
        }
        return metSet;
    }

    /**
     * fn(in[n]) = out[n] = gen[n] U (in[n] - kill[n])
     * l = in[n]
     * @param l input data flow value/lattice element
     * @param gen gen set
     * @param kill kill set
     * @return
     */
    @Override
    public HashSet<Pair<String, String>> fn(HashSet<Pair<String, String>> l,
                                            HashSet<Pair<String, String>> gen,
                                            HashSet<Pair<String, String>> kill) {
        HashSet<Pair<String, String>> fn_l = new HashSet<>(l);
        fn_l.removeAll(kill);
        fn_l.addAll(gen);
        return fn_l;
    }

    /**
     * n                    |  gen[n]
     * -------------------------------------
     * x = y                |  {x = y}
     * x <- e where e != y  |  empty set
     * [e1] <- [e2]         |  empty set
     * if e                 |  empty set
     * start                |  empty set
     * return e1, ..., e2   |  empty set
     * @param node cfg node
     * @return gen[node]
     */
    @Override
    public HashSet<Pair<String, String>> gen(CFGNode<AAInstruction> node) {
        HashSet<Pair<String, String>> gen_n = new HashSet<>();
        AAInstruction instr = node.getStmt();
        if (instr instanceof AAMove) {
            AAOperand dest = instr.operand1.get(); // AAMove must have two operands so get() should not throw exn
            AAOperand src = instr.operand2.get();
            if (dest instanceof AATemp  || dest instanceof AAReg && src instanceof AATemp) {
                gen_n.add(new Pair<>(((AATemp) dest).name(), ((AATemp) src).name()));
            }
        }
        return gen_n;
    }

    /**
     * n                    |  kill[n]
     * -------------------------------------
     * x = y                |  x = z, z = x for all z
     * x <- e where e != y  |  x = z, z = x
     * [e1] <- [e2]         |  empty set
     * if e                 |  empty set
     * start                |  all nodes
     * return e1, ..., e2   |  empty set
     * @param node cfg node
     * @return gen[node]
     */
    @Override
    public HashSet<Pair<String, String>> kill(CFGNode<AAInstruction> node) {
        HashSet<Pair<String, String>> kill_n = new HashSet<>();
        AAInstruction instr = node.getStmt();
        return null;
    }

}
