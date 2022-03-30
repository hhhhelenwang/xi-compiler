package jw795.assembly;

public class AAJne extends AAInstruction{

    public AAJne(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "jne " + operand1.get();
    }
}
