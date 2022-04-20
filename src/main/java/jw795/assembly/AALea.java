package jw795.assembly;

public class AALea extends AAInstruction{

    private AAReg dest;
    private AAMem src;

    public AALea(AAReg d, AAMem s) {
        dest = d;
        src = s;
    }

    @Override
    public String toString() {
        return "lea" + " " + dest + ", " + src + ";";
    }
}
