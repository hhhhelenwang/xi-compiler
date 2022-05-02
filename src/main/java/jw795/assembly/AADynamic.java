package jw795.assembly;

public class AADynamic extends AAOperand{
    public long val;

    public AADynamic() {
        super();
    }

    public AADynamic(long value) {
        super();
        val = value;
    }

    public void setVal(long val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
