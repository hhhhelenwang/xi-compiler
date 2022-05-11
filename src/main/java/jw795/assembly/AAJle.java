package jw795.assembly;

import java.util.HashSet;

public class AAJle extends AAInstruction{
    /**
     * jump if less than or equal
     * @param opr
     */
    public AAJle(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "jle " + operand1.get();
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
