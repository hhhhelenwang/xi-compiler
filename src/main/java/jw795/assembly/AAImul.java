package jw795.assembly;

import jw795.asmgenerator.Tiler;

import java.util.HashSet;

public class AAImul extends AAInstruction{

    public AAImul(AAOperand opr1) {
        super(opr1);
    }

    @Override
    public HashSet<AAOperand> use() {
        HashSet<AAOperand> useset = super.use();
        useset.add(Tiler.rax);
        return useset;
    }

    @Override
    public HashSet<AAOperand> def() {
        HashSet<AAOperand> defSet = super.def();
        defSet.add(Tiler.rax);
        defSet.add(Tiler.rdx);
        return defSet;
    }

    @Override
    public String toString() {
        return "imulq " + operand1.get();
    }
}
