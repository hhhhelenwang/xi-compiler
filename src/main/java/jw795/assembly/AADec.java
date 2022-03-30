package jw795.assembly;

public class AADec extends AAInstruction{
    public AADec(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "dec "+ operand1.get();
    }
}
