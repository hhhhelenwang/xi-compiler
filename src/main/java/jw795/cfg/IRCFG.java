package jw795.cfg;

import edu.cornell.cs.cs4120.xic.ir.*;

import java.util.HashMap;
import java.util.List;

public class IRCFG extends CFG<IRStmt> {

    public IRCFG(CFGNode<IRStmt> start) {
        super(start);
    }

    /**
     * build an IRCFG from an IRFuncDecl node
     * @param funcDecl IR node
     * @return CFG graph for given IRFuncDecl
     */
    public IRCFG toIRCFG (IRFuncDecl funcDecl){
        IRStmt body = funcDecl.body();
        IRCFG cfg;
        if (body instanceof IRSeq){
            List<IRStmt> stmts = ((IRSeq) body).stmts();

            // a map storing all IRStmt to CFGNode
            HashMap<IRStmt, CFGNode<IRStmt>> map = new HashMap<>();
            HashMap<String, IRLabel> labels = new HashMap<>();
            for (IRStmt stmt : stmts){
                map.put(stmt, new CFGNode<>(stmt));
                if (stmt instanceof IRLabel){
                    labels.put(((IRLabel) stmt).name(), (IRLabel) stmt);
                }
            }

            int size = stmts.size();
            IRStmt nextStmt;
            for (int i = 0; i < size; i++) {
                IRStmt curStmt = stmts.get(i);
                CFGNode<IRStmt> curNode = map.get(curStmt);

                if (curStmt instanceof IRJump) {
                    String targetLabel = ((IRName)((IRJump) curStmt).target()).name();
                    nextStmt = labels.get(targetLabel);
                    CFGNode<IRStmt> nextNode = map.get(nextStmt);

                    connect(curNode, nextNode);
                } else if (curStmt instanceof IRCJump){
                    String targetLabel = ((IRCJump) curStmt).trueLabel();
                    nextStmt = labels.get(targetLabel);
                    connect(curNode, map.get(nextStmt));

                    //add fall through node
                    if (i != size - 1){
                        nextStmt = stmts.get(i+1);
                        connect(curNode, map.get(nextStmt));
                    }
                } else if (curStmt instanceof IRReturn){
                    continue;
                } else {
                    // if cur is not the last stmt, connect with the next ir stmt
                    if (i != size - 1){
                        connect(curNode, map.get(stmts.get(i+1)));
                    }
                }
            }
            cfg = new IRCFG(map.get(stmts.get(0)));
        } else {
            cfg = new IRCFG(new CFGNode<>(body));
        }

        return cfg;
    }


}
