package jw795.assembly;

public class AAJae extends AAInstruction{

    public AAJae(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "jae " + operand1.get();
    }
}
