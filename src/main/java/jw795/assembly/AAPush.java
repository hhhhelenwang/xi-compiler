package jw795.assembly;

import java.util.HashSet;

public class AAPush extends AAInstruction{

    public AAPush(AAOperand opr) {
        super(opr);
    }

    @Override
    public HashSet<AAOperand> def() {
        return new HashSet<>();
    }

    @Override
    public String toString() {
        return "push" + " " + operand1.get();
    }
}
