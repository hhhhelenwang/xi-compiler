package jw795.assembly;

import java.util.HashSet;

public class AAJmp extends AAInstruction{

    public AAJmp(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "jmp " + operand1.get();
    }

    @Override
    public HashSet<AAOperand> use() {
        return new HashSet<>();
    }
}
