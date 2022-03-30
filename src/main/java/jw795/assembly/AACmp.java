package jw795.assembly;

public class AACmp extends AAInstruction{

    public AACmp (AAOperand opr1, AAOperand opr2) {
        super(opr1, opr2);
    }

    @Override
    public String toString() {
        return "test commit cmp " + this.operand1.get() + this.operand2.get();
    }
}
