package jw795.dfa;

import jw795.assembly.*;
import jw795.cfg.CFG;
import jw795.cfg.CFGNode;
import polyglot.util.Pair;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * Implementation for available copies analysis
 * Data flow value: set of equalities
 */
public class AvailableCopiesAA
        extends DataFlowAnalysis<LinkedHashSet<Pair<AAOperand, AAOperand>>, AAInstruction> {
    // use LinkedHashSet to preserve the order of addition
    public AvailableCopiesAA(CFG<AAInstruction> cfg) {
        super(cfg);
        // set up top
        top = computeTop();

    }

    /**
     * Compute all possible equalities to be used as top.
     * @return all possible equalities
     */
    private LinkedHashSet<Pair<AAOperand, AAOperand>> computeTop() {
        // get the set of all variables
        LinkedHashSet<AAOperand> allVars = new LinkedHashSet<>();
        for (CFGNode<AAInstruction> node : cfg.flatten()) {
            AAInstruction instr = node.getStmt();
            if (instr instanceof AAMove) {
                AAOperand dest = instr.operand1.get();
                AAOperand src = instr.operand2.get();
                if (dest instanceof AAReg || dest instanceof AATemp) {
                    allVars.add(dest);
                }
                if (src instanceof AAReg || src instanceof AATemp) {
                    allVars.add(src);
                }
            }
        }
        // iterate through all vars to get all possible equalities
        LinkedHashSet<Pair<AAOperand, AAOperand>> allEqualities = new LinkedHashSet<>();
        for (AAOperand var1 : allVars) {
            for (AAOperand var2: allVars) {
                if (!var1.equals(var2)) {
                    Pair<AAOperand, AAOperand> newEq = new Pair<>(var1, var2);
                    allEqualities.add(newEq);
                }
            }
        }
        return allEqualities;
    }

    /**
     * meet = intersection for available copies analysis
     * @param input lattice elements/data flow values to take meet on
     * @return intersection of all sets in input
     */
    @Override
    public LinkedHashSet<Pair<AAOperand, AAOperand>> meet(List<LinkedHashSet<Pair<AAOperand, AAOperand>>> input) {
        LinkedHashSet<Pair<AAOperand, AAOperand>> metSet = new LinkedHashSet<>(input.get(0));
        for (LinkedHashSet<Pair<AAOperand, AAOperand>> in : input) {
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
     * @return fn(in[n])
     */
    @Override
    public LinkedHashSet<Pair<AAOperand, AAOperand>> fn(LinkedHashSet<Pair<AAOperand, AAOperand>> l,
                                                        LinkedHashSet<Pair<AAOperand, AAOperand>> gen,
                                                        LinkedHashSet<Pair<AAOperand, AAOperand>> kill) {
        LinkedHashSet<Pair<AAOperand, AAOperand>> fn_l = new LinkedHashSet<>(l);
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
     * @param l in set
     * @return gen[node]
     */
    @Override
    public LinkedHashSet<Pair<AAOperand, AAOperand>> gen(CFGNode<AAInstruction> node,
                                                         LinkedHashSet<Pair<AAOperand, AAOperand>> l) {
        LinkedHashSet<Pair<AAOperand, AAOperand>> gen_n = new LinkedHashSet<>();
        AAInstruction instr = node.getStmt();
        if (instr instanceof AAMove) {
            AAOperand dest = instr.operand1.get(); // AAMove must have two operands so get() should not throw exn
            AAOperand src = instr.operand2.get();
            if (dest instanceof AATemp || dest instanceof AAReg
                    && src instanceof AATemp || src instanceof AAReg) {
                gen_n.add(new Pair<>(dest, src)); // toString give the name of temp or reg
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
     * @param l in set
     * @return kill[node]
     */
    @Override
    public LinkedHashSet<Pair<AAOperand, AAOperand>> kill(CFGNode<AAInstruction> node,
                                                    LinkedHashSet<Pair<AAOperand, AAOperand>> l) {

        LinkedHashSet<Pair<AAOperand, AAOperand>> kill_n = new LinkedHashSet<>();

        //on start node, kill everything
        if (node.getStmt() instanceof AAStart) {
            kill_n.addAll(l);
            return kill_n;
        }

        AAInstruction instr = node.getStmt();
        if (instr instanceof AAMove) {
            AAOperand dest = instr.operand1.get();
            if (dest instanceof AATemp || dest instanceof AAReg) {
                // kill all equalities involving dest as long as dest is def-ed
                for (Pair<AAOperand, AAOperand> pair : l) {
                    if (pair.part1().equals(dest) || pair.part2().equals(dest)) {
                        kill_n.add(pair);
                    }
                }
            }
        }
        return kill_n;
    }

}
