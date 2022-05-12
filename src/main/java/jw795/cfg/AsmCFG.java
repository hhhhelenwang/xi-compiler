package jw795.cfg;

import jw795.assembly.*;

import java.util.HashMap;
import java.util.List;

public class AsmCFG extends CFG<AAInstruction> {

    public AsmCFG(CFGNode<AAInstruction> start, CFGNode<AAInstruction> exit, HashMap<AAInstruction, CFGNode<AAInstruction>> insToCFG) {
        super(start, exit, insToCFG);
    }

}
