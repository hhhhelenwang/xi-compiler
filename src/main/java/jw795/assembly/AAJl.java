package jw795.assembly;

public class AAJl extends AAInstruction{
    /**
     * jump if less than
     * @param opr
     */
    public AAJl(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "jl " + operand1.get();
    }
}
