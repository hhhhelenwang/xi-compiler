package jw795.assembly;

public class AAOr extends AAInstruction{

    public AAOr(AAOperand opr1, AAOperand opr2) {
        super(opr1, opr2);
    }

    @Override
    public String toString() {
        return "or" + " " + operand1.get() + ", " + operand2.get();
    }
}
