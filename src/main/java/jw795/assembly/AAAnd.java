package jw795.assembly;

public class AAAnd extends AAInstruction{

    public AAAnd (AAOperand opr1, AAOperand opr2) {
        super(opr1, opr2);
    }

    @Override
    public String toString() {
        if (operand2.get() instanceof AAImm) {
            return "andq" + " " + operand1.get().toString() + ", " + operand2.get().toString();
        } else {
            return "and" + " " + operand1.get() + ", " + operand2.get();
        }
    }
}
