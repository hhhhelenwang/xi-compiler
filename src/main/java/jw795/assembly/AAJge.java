package jw795.assembly;

public class AAJge extends  AAInstruction{
    /**
     * jump if greater or equal
     * @param opr
     */
    public AAJge(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "jge " + operand1.get();
    }
}
