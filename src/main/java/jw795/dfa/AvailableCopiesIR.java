package jw795.dfa;

import edu.cornell.cs.cs4120.xic.ir.*;
import jw795.cfg.CFG;
import jw795.cfg.CFGNode;
import polyglot.util.Pair;

import java.util.LinkedHashSet;
import java.util.List;

public class AvailableCopiesIR extends DataFlowAnalysis<LinkedHashSet<Pair<IRTemp, IRTemp>>, IRStmt>{

    public AvailableCopiesIR(CFG<IRStmt> cfg) {
        super(cfg);
        top = computeTop();
    }

    /**
     * Compute all possible equalities to be used as the top of this avail copies dfa
     * @return the set of all possible equalities
     */
    private LinkedHashSet<Pair<IRTemp, IRTemp>> computeTop() {
        // get the set of all variables
        LinkedHashSet<IRTemp> allVars = new LinkedHashSet<>();
        for (CFGNode<IRStmt> node : cfg.flatten()) {
            allVars.addAll(node.getStmt().vars());
        }

        LinkedHashSet<Pair<IRTemp, IRTemp>> allEqualities = new LinkedHashSet<>();
        for (IRTemp var1 : allVars) {
            for (IRTemp var2: allVars) {
                if (!var1.equals(var2)) {
                    Pair<IRTemp, IRTemp> newEq = new Pair<>(var1, var2);
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
    public LinkedHashSet<Pair<IRTemp, IRTemp>> meet(List<LinkedHashSet<Pair<IRTemp, IRTemp>>> input) {
        LinkedHashSet<Pair<IRTemp, IRTemp>> metSet = new LinkedHashSet<>();
        if (input.size() != 0) {
            metSet.addAll(input.get(0));
            for (LinkedHashSet<Pair<IRTemp, IRTemp>> in : input) {
                // retainAll keeps elements in metSet that are also in the set in
                metSet.retainAll(in);
                return metSet;
            }
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
    public LinkedHashSet<Pair<IRTemp, IRTemp>> fn(LinkedHashSet<Pair<IRTemp, IRTemp>> l,
                                                  LinkedHashSet<Pair<IRTemp, IRTemp>> gen,
                                                  LinkedHashSet<Pair<IRTemp, IRTemp>> kill) {
        LinkedHashSet<Pair<IRTemp, IRTemp>> fn_l = new LinkedHashSet<>(l);
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
    public LinkedHashSet<Pair<IRTemp, IRTemp>> gen(CFGNode<IRStmt> node,
                                                   LinkedHashSet<Pair<IRTemp, IRTemp>> l) {

        LinkedHashSet<Pair<IRTemp, IRTemp>> gen_n = new LinkedHashSet<>();
        IRStmt stmt = node.getStmt();
        if (stmt instanceof IRMove) {
            IRExpr dest = ((IRMove) stmt).target();
            IRExpr src = ((IRMove) stmt).source();
            if (dest instanceof IRTemp && src instanceof IRTemp
                    && !((IRTemp) src).name().startsWith("_")) {
                // do not propagate special variables that represents registers
                gen_n.add(new Pair<>((IRTemp) dest, (IRTemp) src));
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
    public LinkedHashSet<Pair<IRTemp, IRTemp>> kill(CFGNode<IRStmt> node,
                                                    LinkedHashSet<Pair<IRTemp, IRTemp>> l) {

        LinkedHashSet<Pair<IRTemp, IRTemp>> kill_n = new LinkedHashSet<>();

        IRStmt stmt = node.getStmt();
        if (stmt instanceof IRStart) {
            // kill everything
            kill_n.addAll(l);
            return kill_n;
        }

        if (stmt instanceof IRMove) {
            IRExpr dest = ((IRMove) stmt).target();
            if (dest instanceof IRTemp) {
                // kill all equalities that contains
                for (Pair<IRTemp, IRTemp> pair : l) {
                    if (pair.part1().equals(dest) || pair.part2().equals(dest)) {
                        kill_n.add(pair);
                    }
                }
            }
        }

        return kill_n;
    }


}
