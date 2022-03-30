package jw795.assembly;

public class AAPop extends AAInstruction{

    public AAPop(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "pop" + " " + operand1.get();
    }
}
