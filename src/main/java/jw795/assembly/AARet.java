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
        if (this.operand1.isPresent()) {
            return "ret " + this.operand1.get();
        }
        else {
            return "ret";
        }
    }
}