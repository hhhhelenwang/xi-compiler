package jw795.assembly;

public class AAJle extends AAInstruction{
    /**
     * jump if less than or equal
     * @param opr
     */
    public AAJle(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "jle " + operand1.get();
    }
}
