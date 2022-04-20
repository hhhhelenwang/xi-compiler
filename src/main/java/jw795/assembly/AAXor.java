package jw795.assembly;

public class AAXor extends AAInstruction{

    public AAXor(AAOperand opr1, AAOperand opr2) {
        super(opr1, opr2);
    }

    @Override
    public String toString() {
        if (operand2.get() instanceof AAImm) {
            return "xorq" + " " + operand1.get().toString() + ", " + operand2.get().toString();
        } else {
            return "xor" + " " + operand1.get() + ", " + operand2.get();
        }
    }
}
