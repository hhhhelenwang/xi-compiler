package jw795.assembly;

import jw795.asmgenerator.Tiler;

import java.util.HashSet;

public class AAPop extends AAInstruction{

    public AAPop(AAOperand opr) {
        super(opr);
    }
    @Override
    public HashSet<AAOperand> use() {
        return new HashSet<>();
    }

    @Override
    public String toString() {
        return "pop" + " " + operand1.get();
    }
}
