package jw795.assembly;

public class AAMove extends AAInstruction {

    public AAMove(AAOperand opr1, AAOperand opr2) {
        super(opr1, opr2);
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
