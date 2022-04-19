package jw795.assembly;

public class AAAdd extends AAInstruction{

    public AAAdd(AAOperand opr1, AAOperand opr2){
        super(opr1, opr2);
    }

    @Override
    public String toString() {
        if (operand2.get() instanceof AAImm) {
            return "addq" + " " + operand1.get().toString() + ", " + operand2.get().toString();
        } else {
        return "add " + operand1.get() + ", " +  operand2.get();}
    }
}
