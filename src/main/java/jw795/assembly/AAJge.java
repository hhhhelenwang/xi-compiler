package jw795.assembly;

import java.util.HashSet;

public class AAJge extends  AAInstruction{
    /**
     * jump if greater or equal
     * @param opr
     */
    public AAJge(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "jge " + operand1.get();
    }

    @Override
    public HashSet<AAOperand> use() {
        return new HashSet<>();
    }
}
