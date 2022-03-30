package jw795.assembly;

public class AACall extends AAInstruction{
    public AACall (AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "call " + this.operand1.get();
    }
}
