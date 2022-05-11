package jw795.assembly;

import java.util.HashSet;

public class AAJae extends AAInstruction{

    public AAJae(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "jae " + operand1.get();
    }

    @Override
    public HashSet<AAOperand> use() {
        return new HashSet<>();
    }
}
