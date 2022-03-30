package jw795.assembly;

public class AAInc extends AAInstruction{

    public AAInc(AAOperand opr){
        super(opr);
    }

    @Override
    public String toString() {
        return "inc "+ operand1.get();
    }
}
