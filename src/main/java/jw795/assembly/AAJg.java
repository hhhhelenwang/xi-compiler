package jw795.assembly;

public class AAJg extends AAInstruction{
    /**
     * jump if greater
     * @param opr
     */
    public AAJg(AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return "jg "+ operand1.get();
    }
}
