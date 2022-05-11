package jw795.assembly;

import java.util.HashSet;

public class AAJbe extends AAInstruction{

    public AAJbe(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "jbe " + operand1.get();
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
