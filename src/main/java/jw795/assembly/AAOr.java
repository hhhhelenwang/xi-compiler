package jw795.assembly;

public class AAOr extends AAInstruction{

    public AAOr(AAOperand opr1, AAOperand opr2) {
        super(opr1, opr2);
    }

    @Override
    public String toString() {
        if (operand2.get() instanceof AAImm) {
            return "orq" + " " + operand1.get().toString() + ", " + operand2.get().toString();
        } else {
            return "or " + operand1.get() + ", " + operand2.get();
        }
    }
}
