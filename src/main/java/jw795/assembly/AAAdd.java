package jw795.assembly;

public class AAAdd extends AAInstruction{

    public AAAdd(AAOperand opr1, AAOperand opr2){
        super(opr1, opr2);
    }

    @Override
    public String toString() {
        return "add " + operand1.get() + ", " +  operand2.get();
    }
}
