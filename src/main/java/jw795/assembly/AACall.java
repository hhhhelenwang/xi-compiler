package jw795.assembly;

import java.util.HashSet;

public class AACall extends AAInstruction{
    public AACall (AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "call " + this.operand1.get();
    }

    @Override
    public HashSet<AAOperand> use() {
        return new HashSet<>();
    }
}
