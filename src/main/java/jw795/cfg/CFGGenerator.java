package jw795.cfg;

import edu.cornell.cs.cs4120.xic.ir.*;
import jw795.assembly.*;

import java.util.HashMap;
import java.util.List;

public class CFGGenerator {

    public CFGGenerator(){

    }

    /**
     * build an IRCFG from a list of AAInstruction of a function
     * @param asm list of instructions of a function body
     * @return CFG graph made up of list of CFGNode<AAInstruction>
     */
    public AsmCFG toAsmCFG(List<AAInstruction> asm){
        int size = asm.size();
        HashMap<AAInstruction, CFGNode<AAInstruction>> map = new HashMap<>();
        HashMap<String, AALabelInstr> labels = new HashMap<>();
        for (AAInstruction instruct : asm){
            map.put(instruct, new CFGNode<>(instruct));
            if (instruct instanceof AALabelInstr){
                labels.put(((AALabelInstr)instruct).getName(), (AALabelInstr) instruct);
            }
        }

        for (int i = 0; i < size; i++){
            AAInstruction curAsm = asm.get(i);
            CFGNode<AAInstruction> curNode = map.get(curAsm);

            if (curAsm instanceof AAJmp || curAsm instanceof AAJa || curAsm instanceof AAJae || curAsm instanceof AAJb
                    || curAsm instanceof AAJbe || curAsm instanceof AAJe || curAsm instanceof AAJg || curAsm instanceof AAJge
                    || curAsm instanceof AAJl || curAsm instanceof AAJle || curAsm instanceof AAJne){
                String label = curAsm.operand1.toString();
                CFGNode<AAInstruction> nextNode = map.get(labels.get(label));
                if(nextNode == null || curNode == null){
                    System.out.println("ASM CFG: jump CFG node == null");
                }
                connectAAInstr(curNode, nextNode);
//            } else if (){

            } else {
                if (i < size - 1){
                    AAInstruction nextAsm = asm.get(i + 1);
                    CFGNode<AAInstruction> nextNode = map.get(nextAsm);
                    if(nextNode == null || curNode == null){
                        System.out.println("ASM CFG: regular CFG node == null");
                    }
                    connectAAInstr(curNode, nextNode);
                }
            }
        }

        return new AsmCFG(map.get(asm.get(0)));
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

                    connectIR(curNode, nextNode);
                } else if (curStmt instanceof IRCJump){
                    String targetLabel = ((IRCJump) curStmt).trueLabel();
                    nextStmt = labels.get(targetLabel);
                    connectIR(curNode, map.get(nextStmt));

                    //add fall through node
                    if (i != size - 1){
                        nextStmt = stmts.get(i+1);
                        connectIR(curNode, map.get(nextStmt));
                    }
                } else if (curStmt instanceof IRReturn){
                    continue;
                } else {
                    // if cur is not the last stmt, connect with the next ir stmt
                    if (i != size - 1){
                        connectIR(curNode, map.get(stmts.get(i+1)));
                    }
                }
            }
            cfg = new IRCFG(map.get(stmts.get(0)));
        } else {
            cfg = new IRCFG(new CFGNode<>(body));
        }

        return cfg;
    }

    /**
     * Helper to connect two CFGNodes. Specifically, make next to cur's successor, and cur to next's predecessor
     * @param cur
     * @param next
     */
    void connectIR(CFGNode<IRStmt> cur, CFGNode<IRStmt> next){
        next.addPredecessor(cur);
        cur.addSuccessor(next);
    }

    /**
     * Helper to connect two CFGNodes. Specifically, make next to cur's successor, and cur to next's predecessor
     * @param cur
     * @param next
     */
    void connectAAInstr(CFGNode<AAInstruction> cur, CFGNode<AAInstruction> next){
        next.addPredecessor(cur);
        cur.addSuccessor(next);
    }


}
