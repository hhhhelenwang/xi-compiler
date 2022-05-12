package jw795.assembly;

import java.util.HashSet;

public class AALea extends AAInstruction{

    // Requires: opr1 is an AAReg, opr2 is an AAMem
    public AALea(AAOperand opr1, AAOperand opr2) {
        super(opr1, opr2);
    }

    @Override
    public String toString() {
        return "lea" + " " + operand1.get() + ", " + operand2.get();
    }

    @Override
    public HashSet<AAOperand> use() {
        return vars(operand2.get());
    }
}
