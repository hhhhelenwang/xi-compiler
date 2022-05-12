package jw795.dfa;
import jw795.asmgenerator.Tiler;
import jw795.assembly.*;
import jw795.cfg.AsmCFG;
import jw795.cfg.CFGNode;
import jw795.asmgenerator.Tiler.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class LiveVariableAnalysis extends DataFlowAnalysis<HashSet<AAOperand>, AAInstruction> {
    public LiveVariableAnalysis(AsmCFG cfg) {
        super(cfg);
    }

    @Override
    public HashSet<AAOperand> meet(List<HashSet<AAOperand>> input) {
        HashSet<AAOperand> result = new HashSet<>();
        for (HashSet<AAOperand> in : input) {
            result.addAll(in);
        }
        return result;
    }

    @Override
    public HashSet<AAOperand> fn(HashSet<AAOperand> l, HashSet<AAOperand> gen, HashSet<AAOperand> kill) {
        HashSet<AAOperand> result = new HashSet<>();
        result.addAll(l);
        result.removeAll(kill);
        result.addAll(gen);

        return result;
    }

    @Override
    public HashSet<AAOperand> gen(CFGNode<AAInstruction> node, HashSet<AAOperand> l) {
        AAInstruction ins = node.getStmt();
        return ins.use();
    }

    @Override
    public HashSet<AAOperand> kill(CFGNode<AAInstruction> node, HashSet<AAOperand> l) {
        AAInstruction ins = node.getStmt();
        return ins.def();
    }
}
