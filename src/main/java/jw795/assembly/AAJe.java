package jw795.assembly;

import java.util.HashSet;

public class AAJe extends AAInstruction{

    public AAJe(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "je " + operand1.get();
    }

    @Override
    public HashSet<AAOperand> use() {
        return new HashSet<>();
    }
}
