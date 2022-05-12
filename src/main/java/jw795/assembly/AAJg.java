package jw795.assembly;

import java.util.HashSet;

public class AAJg extends AAInstruction{
    /**
     * jump if greater
     * @param opr
     */
    public AAJg(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "jg "+ operand1.get();
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
