package jw795.assembly;

import java.util.HashSet;

public class AAJl extends AAInstruction{
    /**
     * jump if less than
     * @param opr
     */
    public AAJl(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "jl " + operand1.get();
    }

    @Override
    public HashSet<AAOperand> use() {
        return new HashSet<>();
    }

    @Override
    public HashSet<AAOperand> def() {
        return new HashSet<>();
    }
}
