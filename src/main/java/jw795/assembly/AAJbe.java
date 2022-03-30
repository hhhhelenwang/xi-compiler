package jw795.assembly;

public class AAJbe extends AAInstruction{

    public AAJbe(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "jbe " + operand1.get();
    }
}
