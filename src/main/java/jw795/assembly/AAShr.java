package jw795.assembly;

public class AAShr extends  AAInstruction{
    public AAShr(AAOperand opr1, AAOperand opr2) {
        super(opr1,opr2);
    }

    @Override
    public String toString() {
        return "shr " + operand1.get() +  ", " + operand2.get();
    }
}
