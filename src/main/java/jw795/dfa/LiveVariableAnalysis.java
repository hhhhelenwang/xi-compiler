package jw795.dfa;
import jw795.assembly.*;
import jw795.cfg.AsmCFG;
import jw795.cfg.CFG;
import jw795.cfg.CFGNode;

import java.util.HashSet;
import java.util.List;

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
    public HashSet<AAOperand> gen(CFGNode<AAInstruction> node) {
        HashSet<AAOperand> result = new HashSet<>();
        AAInstruction ins = node.getStmt();
        if (ins instanceof AALabelInstr) {
            return result;
        } else if ((ins instanceof AAMove) && (ins.operand1.get() instanceof AAMem)) {
            result.addAll(vars(ins.operand1.get()));
            result.addAll(vars(ins.operand2.get()));
            return result;
        } else {
            if (ins.operand2.isPresent()) {
                result.addAll(vars(ins.operand2.get()));
                return result;
            } else if (ins.operand1.isPresent()) {
                result.addAll(vars(ins.operand1.get()));
                return result;
            } else {
                return result;
            }
        }
    }

    private HashSet<AAOperand> vars(AAOperand e) {
        HashSet<AAOperand> result = new HashSet<>();
        if (e instanceof AAImm || e instanceof AADynamic) {
            return result;
        } else if (e instanceof AAReg || e instanceof AATemp) {
            result.add(e);
            return result;
        } else if (e instanceof AAMem) {
            if (((AAMem) e).base.isPresent()) {
                result.add(e);
            }
            if (((AAMem) e).index.isPresent()) {
                result.add(e);
            }
            return result;
        }
        return result;
    }

    @Override
    public HashSet<AAOperand> kill(CFGNode<AAInstruction> node) {
        HashSet<AAOperand> result = new HashSet<>();
        AAInstruction ins = node.getStmt();
        if ((ins instanceof AAMove) && ((ins.operand1.get() instanceof AATemp) || (ins.operand1.get() instanceof AAReg))) {
            result.add(ins.operand1.get());
            return result;
        }
        return result;
    }
}
