package jw795.assembly;

public class AAIdiv extends AAInstruction{

    public AAIdiv(AAOperand opr1) {
        super(opr1);
    }

    @Override
    public String toString() {
        return "idivq " + operand1.get();
    }
}
