package jw795.assembly;

public class AADiv extends AAInstruction{

    public AADiv(AAOperand opr1) {
        super(opr1);
    }

    @Override
    public String toString() {
        return "div " + operand1.get();
    }
}
