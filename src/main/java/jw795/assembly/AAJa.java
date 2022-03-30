package jw795.assembly;

public class AAJa extends AAInstruction{

    public AAJa(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "ja " + operand1.get();
    }
}
