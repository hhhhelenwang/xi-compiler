package jw795.cfg;

import edu.cornell.cs.cs4120.xic.ir.*;
import jw795.assembly.AAInstruction;

import java.util.HashMap;
import java.util.List;

public class IRCFG extends CFG<IRStmt> {

    public IRCFG(CFGNode<IRStmt> start, HashMap<IRStmt, CFGNode<IRStmt>> instrToCFG) {
        super(start, instrToCFG);
    }
}
