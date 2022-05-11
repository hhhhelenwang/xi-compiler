package jw795.assembly;

public class AARet extends AAInstruction{

    public AARet () {
        super();
    }

    public AARet (AAOperand opr) {
        super(opr);
    }

    @Override
    public String toString() {
        return this.operand1.map(operand -> "ret " + operand).orElse("ret");
    }
}
