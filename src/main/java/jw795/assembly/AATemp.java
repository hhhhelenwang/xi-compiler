package jw795.assembly;

/**
 * A temp in abstract assembly
 */
public class AATemp extends AAOperand{
    String tempName;

    public AATemp(String name) {
        tempName = name;
    }

    public String name() {
        return  tempName;
    }

    @Override
    public String toString() {
        return tempName;
    }
}
