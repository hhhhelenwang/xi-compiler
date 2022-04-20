package jw795.assembly;

public class AASub extends AAInstruction{

    public AASub(AAOperand opr1, AAOperand opr2) {
        super(opr1, opr2);
    }

    @Override
    public String toString() {
        if (operand2.get() instanceof AAImm) {
            return "subq" + " " + operand1.get().toString() + ", " + operand2.get().toString();
        } else {
            return "sub " + operand1.get() + ", " +  operand2.get();
        }
    }
}
