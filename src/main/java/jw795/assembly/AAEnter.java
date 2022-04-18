package jw795.assembly;

public class AAEnter extends AAInstruction{

    public AAEnter(AAOperand opr1, AAOperand opr2){
        super(opr1, opr2);
    }

    @Override
    public String toString() {
        return "enter" + this.operand1.toString() + this.operand2.toString();
    }
}
