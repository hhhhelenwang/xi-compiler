package jw795.asmgenerator;

import jw795.assembly.AAImm;
import jw795.assembly.AAMem;
import jw795.assembly.AAReg;
import jw795.assembly.AATemp;

import java.util.HashMap;

/**
 * Handles spilling temporaries onto stack.
 */
public class TempSpiller {
    int tempCounter;
    int topOfStack;
    HashMap<String, Integer> stackOffsetOfTemp;

    int wordSize = 8;
    AAReg stackPointer = new AAReg("rsp");

    public TempSpiller() {
        tempCounter = 0;
        topOfStack = 0;
        stackOffsetOfTemp = new HashMap<>();
    }

    /**
     * Return a new abstract assembly temp. Does not spill the temp onto the stack.
     * @return name of a fresh temp
     */
    public AATemp newTemp() {
        tempCounter ++;
        return new AATemp("t_asm" + tempCounter);
    }

    /**
     * Spill a temp onto a stack by storing it onto the map that maps name of temp to stack offset.
     * @param temp the temp to spill on the stack
     */
    public void spillTemp(AATemp temp) {
        String name = temp.name();
        if (!stackOffsetOfTemp.containsKey(name)) {
            topOfStack += wordSize;
            stackOffsetOfTemp.put(temp.name(), topOfStack);
        }
    }

    /**
     * Get the mem address where temp is spilled on. Requires the temp has been spilled onto the stack.
     * @param temp the temp to find addr for
     * @return the mem for where the temp is spilled.
     */
    public AAMem getMemOfTemp(AATemp temp) {
        int offset = stackOffsetOfTemp.get(temp.name());
        AAMem mem = new AAMem();
        mem.setBase(stackPointer);
        mem.setImmediate(new AAImm(offset));

        return mem;
    }

    //TODO: there's a bunch of other things to do here that i have not figured out yet


}
