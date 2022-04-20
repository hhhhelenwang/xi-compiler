package jw795.assembly;

public class AAMul extends AAInstruction{

    public AAMul(AAOperand opr1) {
        super(opr1);
    }

    @Override
    public String toString() {
        return "mul " + operand1.get();

    }
}
