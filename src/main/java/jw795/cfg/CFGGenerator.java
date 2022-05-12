package jw795.cfg;

import edu.cornell.cs.cs4120.xic.ir.*;
import jw795.assembly.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CFGGenerator {

    public CFGGenerator(){ }

    /**
     * build an IRCFG from a list of AAInstruction of a function
     * @param asm list of instructions of a function body
     * @return CFG graph made up of list of CFGNode<AAInstruction>
     */
    public AsmCFG toAsmCFG(List<AAInstruction> asm){
        AAEnd endInstr = new AAEnd();
        List<AAInstruction> asmWithEnd = new ArrayList<>();
        asmWithEnd.addAll(asm);
        asmWithEnd.add(endInstr);

        int size = asmWithEnd.size();

        HashMap<AAInstruction, CFGNode<AAInstruction>> instrToCFG = new HashMap<>();
        HashMap<String, AALabelInstr> labels = new HashMap<>();

        CFGNode<AAInstruction> start = new CFGNode(new AAStart(), "start");
        CFGNode<AAInstruction> end = new CFGNode(endInstr, "end");

        for (AAInstruction instruct : asmWithEnd){
            instrToCFG.put(instruct, new CFGNode<>(instruct));
            if (instruct instanceof AALabelInstr){
                labels.put(((AALabelInstr)instruct).getName(), (AALabelInstr) instruct);
            }
        }

        connectAAInstr(start, instrToCFG.get(asmWithEnd.get(0)));

        for (int i = 0; i < size; i++){
            AAInstruction curAsm = asmWithEnd.get(i);
            CFGNode<AAInstruction> curNode = instrToCFG.get(curAsm);

            if (curAsm instanceof AAJmp){
                String label = curAsm.operand1.toString();
                CFGNode<AAInstruction> nextNode = instrToCFG.get(labels.get(label));
                connectAAInstr(curNode, nextNode);
            } else if (curAsm instanceof AAJa || curAsm instanceof AAJae || curAsm instanceof AAJb
                    || curAsm instanceof AAJbe || curAsm instanceof AAJe || curAsm instanceof AAJg || curAsm instanceof AAJge
                    || curAsm instanceof AAJl || curAsm instanceof AAJle || curAsm instanceof AAJne){
                String label = curAsm.operand1.toString();
                CFGNode<AAInstruction> nextNode = instrToCFG.get(labels.get(label));
                connectAAInstr(curNode, nextNode);

                // connect to fallthrough instructions
                AAInstruction nextAsm = asmWithEnd.get(i + 1);
                nextNode = instrToCFG.get(nextAsm);
                connectAAInstr(curNode, nextNode);

            } else if (curAsm instanceof AARet){
                connectAAInstr(curNode, end);
            } else {
                if (i < size - 1){
                    AAInstruction nextAsm = asmWithEnd.get(i + 1);
                    CFGNode<AAInstruction> nextNode = instrToCFG.get(nextAsm);
                    connectAAInstr(curNode, nextNode);
                }
            }
        }

        return new AsmCFG(start, end, instrToCFG);
    }

    /**
     * build an IRCFG from an IRFuncDecl node
     * @param funcDecl IR node
     * @return CFG graph for given IRFuncDecl
     */
    public IRCFG toIRCFG (IRFuncDecl funcDecl){
        IRStmt body = funcDecl.body();
        CFGNode<IRStmt> start = new CFGNode(new IRStart(), "start");
        IRStmt endStmt = new IREnd();
        CFGNode<IRStmt> end = new CFGNode(endStmt, "end");
        HashMap<IRStmt, CFGNode<IRStmt>> irToNode = new HashMap<>();

        if (body instanceof IRSeq){
            List<IRStmt> stmts = ((IRSeq) body).stmts();
            stmts.add(endStmt);

            // a map storing all IRStmt to CFGNode
            HashMap<String, IRLabel> labels = new HashMap<>();
            for (IRStmt stmt : stmts){
                irToNode.put(stmt, new CFGNode<>(stmt));
                if (stmt instanceof IRLabel){
                    labels.put(((IRLabel) stmt).name(), (IRLabel) stmt);
                }
            }

            connectIR(start, irToNode.get(stmts.get(0)));

            int size = stmts.size();
            IRStmt nextStmt;
            for (int i = 0; i < size; i++) {
                IRStmt curStmt = stmts.get(i);
                CFGNode<IRStmt> curNode = irToNode.get(curStmt);

                if (curStmt instanceof IRJump) {
                    String targetLabel = ((IRName)((IRJump) curStmt).target()).name();
                    nextStmt = labels.get(targetLabel);
                    CFGNode<IRStmt> nextNode = irToNode.get(nextStmt);
                    connectIR(curNode, nextNode);
                } else if (curStmt instanceof IRCJump){
                    String targetLabel = ((IRCJump) curStmt).trueLabel();
                    nextStmt = labels.get(targetLabel);
                    connectIR(curNode, irToNode.get(nextStmt));

                    //add fall through node
                    nextStmt = stmts.get(i+1);
                    connectIR(curNode, irToNode.get(nextStmt));
                } else if (curStmt instanceof IRReturn){
                    connectIR(curNode, end);
                } else {
                    // if cur is not the last stmt, connect with the next ir stmt
                    if (i != size - 1){
                        connectIR(curNode, irToNode.get(stmts.get(i+1)));
                    }
                }
            }
        } else {
            CFGNode curNode = new CFGNode(body);
            connectIR(start, curNode);
            connectIR(curNode, end);

            irToNode.put(body, curNode);
        }

        IRCFG cfg = new IRCFG(start, end, irToNode);
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
