package jw795.assembly;

import java.util.HashSet;

public class AAJne extends AAInstruction{

    public AAJne(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "jne " + operand1.get();
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
