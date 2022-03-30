package jw795.assembly;

public class AAJe extends AAInstruction{

    public AAJe(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "je" + operand1.get();
    }
}
