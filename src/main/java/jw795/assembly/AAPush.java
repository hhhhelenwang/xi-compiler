package jw795.assembly;

public class AAPush extends AAInstruction{

    public AAPush(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "push" + " " + operand1.get();
    }
}
