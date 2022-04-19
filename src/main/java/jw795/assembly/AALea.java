package jw795.assembly;

public class AALea extends AAInstruction{

    private AAReg dest;
    private AAOperand src;

    @Override
    public String toString() {
        return "lea" + " " + dest + ", " + src + ";";
    }
}
