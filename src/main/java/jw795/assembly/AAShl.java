package jw795.assembly;

public class AAShl extends  AAInstruction{
    public AAShl(AAOperand opr1, AAOperand opr2) {
        super(opr1,opr2);
    }

    @Override
    public String toString() {
        return "shl " + operand1.get()+ ", " + operand2.get();
    }
}
