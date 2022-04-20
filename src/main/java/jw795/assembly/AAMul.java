package jw795.assembly;

public class AAMul extends AAInstruction{

    public AAMul(AAOperand opr1) {
        super(opr1);
    }

    @Override
    public String toString() {
        if (operand2.get() instanceof AAImm) {
            return "mulq" + " " + operand1.get().toString() + ", " + operand2.get().toString();
        } else {
            return "mul " + operand1.get();
        }

    }
}
