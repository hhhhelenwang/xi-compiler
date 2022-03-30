package jw795.assembly;

public class AANot extends AAInstruction{

    public AANot(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "not" + " " + operand1.get();
    }
}
