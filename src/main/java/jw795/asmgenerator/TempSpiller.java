package jw795.asmgenerator;

import edu.cornell.cs.cs4120.xic.ir.IRTemp;
import jw795.assembly.AAImm;
import jw795.assembly.AAMem;
import jw795.assembly.AAReg;
import jw795.assembly.AATemp;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Handles spilling temporaries onto stack.
 */
public class TempSpiller {
    long tempCounter;

    long nameCounter;
    long topOfStack;
    HashMap<String, Long> stackOffsetOfTemp;

    HashMap<String, String> tempNames;

    long wordSize = 8L;

    public TempSpiller() {
        tempCounter = 0;
        nameCounter = 0;
        topOfStack = 48;
        stackOffsetOfTemp = new HashMap<>();
        tempNames = new HashMap<>();
    }

    /**
     * Return a new abstract assembly temp. Does not spill the temp onto the stack.
     * @return name of a fresh temp
     */
    public AATemp newTemp() {
        nameCounter ++;
        return new AATemp("t_asm" + nameCounter);
    }

    public AATemp newTemp(String name) {
        if (tempNames.containsKey(name)) {
            return new AATemp(tempNames.get(name));
        } else {
            nameCounter ++;
            String newName = "t_asm" + nameCounter;
            tempNames.put(name, newName);
            return new AATemp(newName);
        }
    }

    /**
     * Spill a temp onto a stack by storing it onto the map that maps name of temp to stack offset.
     * @param temp the temp to spill on the stack
     */
    public void spillTemp(AATemp temp) {
        String name = temp.name();
        if (!stackOffsetOfTemp.containsKey(name)) {
            tempCounter++;
            topOfStack += wordSize;
            stackOffsetOfTemp.put(temp.name(), topOfStack);
        }
    }

    /**
     * Get the offset of where temp is spilled on. Requires the temp has been spilled onto the stack.
     * @param temp the temp to find addr for
     * @return the mem for where the temp is spilled.
     */
    public AAImm getOffsetOfTemp(AATemp temp) {
        long offset = stackOffsetOfTemp.get(temp.name());
        AAImm offset_imm = new AAImm(offset);
        return offset_imm;
    }
}
