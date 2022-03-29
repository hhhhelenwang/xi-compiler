package jw795.asmgenerator;

import java.util.HashMap;

/**
 * Handles spilling temporaries onto stack.
 */
public class TempSpiller {
    int tempCounter;
    HashMap<String, Integer> stackOffsetOfTemp;

    public TempSpiller() {
        tempCounter = 0;
        stackOffsetOfTemp = new HashMap<>();
    }

    /**
     * Spill a temp onto the stack and return a new abstract assembly temp
     * @return name of a fresh temp
     */
    public String newTemp() {
        tempCounter ++;
        return "t" + tempCounter;
    }

    //TODO: there's a bunch of other things to do here that i have not figured out yet


}
