package jw795.assembly;

public class AASar extends AAInstruction{
    public AASar(AAOperand opr1, AAOperand opr2) {
        super(opr1,opr2);
    }

    @Override
    public String toString() {
        return "sar " + operand1.get()+ ", " + operand2.get();
    }
}
