package jw795.assembly;

public class AAImul extends AAInstruction{

    public AAImul(AAOperand opr1) {
        super(opr1);
    }

    @Override
    public String toString() {
        return "imulq " + operand1.get();
    }
}
