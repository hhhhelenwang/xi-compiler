package jw795.assembly;

import java.util.Optional;

public class AADataDecl extends AAInstruction{

    private String name;
    private Optional<Long> value;

    public AADataDecl(String dataName) {
        name = dataName;
        value = Optional.empty();
    }

    public AADataDecl(String dataName, long val) {
        name = dataName;
        value = Optional.of(val);
    }


    @Override
    public String toString() {
        if (value.isPresent()) {
            return name + "  " + "DD" + " " + value; // DD = 4-byte value
        } else {
            return name + "  " + "DD" + " " + "?";
        }
    }
}
