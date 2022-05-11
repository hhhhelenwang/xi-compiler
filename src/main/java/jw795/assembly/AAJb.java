package jw795.assembly;

import java.util.HashSet;

public class AAJb extends AAInstruction{

    public AAJb(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "jb " + operand1.get();
    }

    @Override
    public HashSet<AAOperand> use() {
        return new HashSet<>();
    }
}
