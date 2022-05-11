package jw795.assembly;

import java.util.HashSet;

public class AAJa extends AAInstruction{

    public AAJa(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "ja " + operand1.get();
    }

    @Override
    public HashSet<AAOperand> use() {
        return new HashSet<>();
    }
}
