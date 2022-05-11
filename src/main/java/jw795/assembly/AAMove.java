package jw795.assembly;

import java.util.HashSet;

public class AAMove extends AAInstruction {

    public AAMove(AAOperand opr1, AAOperand opr2) {
        super(opr1, opr2);
    }

    @Override
    public HashSet<AAOperand> use() {
        HashSet<AAOperand> result = new HashSet<>();
        if (operand1.get() instanceof AAMem) {
            result.addAll(vars(operand1.get()));
        }
        result.addAll(vars(operand2.get()));
        return result;
    }

    @Override
    public String toString() {
        if (operand2.get() instanceof AAImm) {
            return "movq" + " " + operand1.get().toString() + ", " + operand2.get().toString();
        } else {
            return "mov" + " " + operand1.get().toString() + ", " + operand2.get().toString();
        }
    }
}
