package jw795.dfa;
import jw795.asmgenerator.Tiler;
import jw795.assembly.*;
import jw795.cfg.AsmCFG;
import jw795.cfg.CFGNode;
import jw795.asmgenerator.Tiler.*;

import java.util.HashSet;
import java.util.List;

public class LiveVariableAnalysis extends DataFlowAnalysis<HashSet<AAOperand>, AAInstruction> {
    public LiveVariableAnalysis(AsmCFG cfg) {
        super(cfg);
    }

    @Override
    public void initialize() {
        for (CFGNode<AAInstruction> node : worklist) {
            nodeToValueMap.put(node, new HashSet<>());
        }
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

    private HashSet<AAOperand> vars(AAOperand e) {
        HashSet<AAOperand> result = new HashSet<>();
        if (e instanceof AAImm || e instanceof AADynamic) {
            return result;
        } else if (e instanceof AAReg || e instanceof AATemp) {
            result.add(e);
            return result;
        } else if (e instanceof AAMem) {
            ((AAMem) e).base.ifPresent(result::add);
            ((AAMem) e).index.ifPresent(result::add);
            return result;
        } else if (e instanceof AALabel) {
            return result;
        }
        return result;
    }

    @Override
    public HashSet<AAOperand> kill(CFGNode<AAInstruction> node, HashSet<AAOperand> l) {
        HashSet<AAOperand> result = new HashSet<>();
        AAInstruction ins = node.getStmt();
        if ((ins instanceof AAMove) && ((ins.operand1.get() instanceof AATemp) || (ins.operand1.get() instanceof AAReg))) {
            result.add(ins.operand1.get());
            return result;
        }
        return result;
    }
}
