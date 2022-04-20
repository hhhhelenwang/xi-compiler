package jw795.assembly;

public class AAAnd extends AAInstruction{

    public AAAnd (AAOperand opr1, AAOperand opr2) {
        super(opr1, opr2);
    }

    @Override
    public String toString() {
        return "and" + " " + operand1.get() + ", " + operand2.get();

    }
}
