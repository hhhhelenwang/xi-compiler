package jw795.assembly;

public class AAJb extends AAInstruction{

    public AAJb(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "jb " + operand1.get();
    }
}
