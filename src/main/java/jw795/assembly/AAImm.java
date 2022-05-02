package jw795.assembly;

public class AAImm extends AAOperand{

    public long val;

    public AAImm(long value) {
        super();
        val = value;
    }

    public long val() {
        return val;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
