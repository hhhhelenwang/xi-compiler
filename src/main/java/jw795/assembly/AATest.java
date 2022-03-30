package jw795.assembly;

public class AATest extends AAInstruction{

    public AATest (AAOperand opr1, AAOperand opr2) {
        super(opr1, opr2);
    }

    @Override
    public String toString() {
        return "test " + operand1.get() + operand2.get();
    }
}
