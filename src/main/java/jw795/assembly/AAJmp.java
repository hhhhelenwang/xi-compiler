package jw795.assembly;

public class AAJmp extends AAInstruction{

    public AAJmp(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "jmp " + operand1.get();
    }
}
