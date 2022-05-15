package jw795.dfa;
import jw795.asmgenerator.Tiler;
import jw795.assembly.AAInstruction;
import jw795.assembly.AAOperand;
import jw795.cfg.AsmCFG;
import jw795.cfg.CFGNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Live variable analysis on abstract assembly
 */
public class LiveVariableAnalysis extends DataFlowAnalysis<HashSet<AAOperand>, AAInstruction> {
    public LiveVariableAnalysis(AsmCFG cfg) {
        super(cfg);
        top = new HashSet<>();
    }

    /**
     * meet = union
     * @param input lattice elements/data flow values to take meet on
     * @return union of input list
     */
    @Override
    public HashSet<AAOperand> meet(List<HashSet<AAOperand>> input) {
        HashSet<AAOperand> result = new HashSet<>();
        for (HashSet<AAOperand> in : input) {
            result.addAll(in);
        }
        return result;
    }

    /**
     * Transfer function F(l) = gen U (l - kill), gen = use, kill = def
     * @param l input data flow value/lattice element
     * @param gen gen set
     * @param kill kill set
     * @return F(l)
     */
    @Override
    public HashSet<AAOperand> fn(HashSet<AAOperand> l, HashSet<AAOperand> gen, HashSet<AAOperand> kill) {
        HashSet<AAOperand> result = new HashSet<>(l);
        result.removeAll(kill);
        result.addAll(gen);

        return result;
    }

    /**
     * gen(n) = use(n)
     * @param node cfg node
     * @param l input data flow value to the transfer function
     * @return use set of node
     */
    @Override
    public HashSet<AAOperand> gen(CFGNode<AAInstruction> node, HashSet<AAOperand> l) {
        AAInstruction ins = node.getStmt();
        return ins.use();
    }

    /**
     * kill(n) = def(n)
     * @param node cfg node
     * @param l input data flow value to the transfer function
     * @return def set of node
     */
    @Override
    public HashSet<AAOperand> kill(CFGNode<AAInstruction> node, HashSet<AAOperand> l) {
        AAInstruction ins = node.getStmt();
        return ins.def();
    }
}
