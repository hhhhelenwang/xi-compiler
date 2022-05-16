package jw795.cfg;

import edu.cornell.cs.cs4120.xic.ir.*;
import jw795.assembly.*;

import java.util.*;

public class CFGGenerator {

    public CFGGenerator(){ }

    /**
     * build an IRCFG from a list of AAInstruction of a function
     * @param asm list of instructions of a function body
     * @return CFG graph made up of list of CFGNode<AAInstruction>
     */
    public AsmCFG toAsmCFG(List<AAInstruction> asm){
        HashMap<AAInstruction, CFGNode<AAInstruction>> instrToCFG = new HashMap<>();
        HashMap<String, AALabelInstr> labels = new HashMap<>();

        Queue<AAInstruction> asmWithEnd = new LinkedList<>(asm);
        AAEnd endInstr = new AAEnd();
        asmWithEnd.add(endInstr);

        AAInstruction startInstr = new AAStart();
        CFGNode<AAInstruction> start = new CFGNode<>(startInstr, "start");
        CFGNode<AAInstruction> end = new CFGNode<>(endInstr, "end");

        instrToCFG.put(startInstr, start);
        instrToCFG.put(endInstr, end);

        for (AAInstruction instruct : asm){
            instrToCFG.put(instruct, new CFGNode<>(instruct, instruct.toString()));
            if (instruct instanceof AALabelInstr){
                labels.put(((AALabelInstr)instruct).getName(), (AALabelInstr) instruct);
            }
        }

        connectAAInstr(start, instrToCFG.get(asmWithEnd.peek()));
        CFGNode<AAInstruction> curNode;

        while(!asmWithEnd.isEmpty()){
            AAInstruction curAsm = asmWithEnd.poll();
            curNode = instrToCFG.get(curAsm);

            if (curAsm instanceof AAJmp){
                String label = curAsm.operand1.get().toString();
                CFGNode<AAInstruction> nextNode = instrToCFG.get(labels.get(label));
                connectAAInstr(curNode, nextNode);
            } else if (curAsm instanceof AAJa || curAsm instanceof AAJae || curAsm instanceof AAJb
                    || curAsm instanceof AAJbe || curAsm instanceof AAJe || curAsm instanceof AAJg || curAsm instanceof AAJge
                    || curAsm instanceof AAJl || curAsm instanceof AAJle || curAsm instanceof AAJne){
                String label = curAsm.operand1.get().toString();
                CFGNode<AAInstruction> nextNode = instrToCFG.get(labels.get(label));
                connectAAInstr(curNode, nextNode);

                // connect to fallthrough instructions
                AAInstruction nextAsm = asmWithEnd.peek();
                nextNode = instrToCFG.get(nextAsm);
                connectAAInstr(curNode, nextNode);

            } else if (curAsm instanceof AARet){
                connectAAInstr(curNode, end);
            } else if (curAsm instanceof AAEnd) {
                // do nothing
            } else {
                AAInstruction nextAsm = asmWithEnd.peek();
                CFGNode<AAInstruction> nextNode = instrToCFG.get(nextAsm);
                connectAAInstr(curNode, nextNode);
            }
        }

        AsmCFG cfg = new AsmCFG(start, end, instrToCFG);
        //temporary dot format generation
//        cfg.toDotFormat("./test/pa5/testbasicarray.xi", "./", "_Imain_paai", "asm");
        return cfg;
    }

    /**
     * build an IRCFG from an IRFuncDecl node
     * @param funcDecl IR node
     * @return CFG graph for given IRFuncDecl
     */
    public IRCFG toIRCFG (IRFuncDecl funcDecl){
        HashMap<IRStmt, CFGNode<IRStmt>> irToNode = new HashMap<>();
        // a map storing all IRStmt to CFGNode
        HashMap<String, IRLabel> labels = new HashMap<>();

        IRStart startStmt = new IRStart();
        IREnd endStmt = new IREnd();

        CFGNode<IRStmt> start = new CFGNode(startStmt, "start");
        CFGNode<IRStmt> end = new CFGNode(endStmt, "end");

        irToNode.put(startStmt, start);
        irToNode.put(endStmt, end);

        IRStmt body = funcDecl.body();
        if (body instanceof IRSeq){
            Queue<IRStmt> stmts = new LinkedList<>(((IRSeq)body).stmts());
            stmts.add(endStmt);

            for (IRStmt stmt : stmts){
                irToNode.put(stmt, new CFGNode<>(stmt));
                if (stmt instanceof IRLabel){
                    labels.put(((IRLabel) stmt).name(), (IRLabel) stmt);
                }
            }

            connectIR(start, irToNode.get(stmts.peek()));
            IRStmt nextStmt;
            while(!stmts.isEmpty()) {
                IRStmt curStmt = stmts.poll();
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
                    nextStmt = stmts.peek();
                    connectIR(curNode, irToNode.get(nextStmt));
                } else if (curStmt instanceof IRReturn){
                    connectIR(curNode, end);
                } else if (curStmt instanceof IREnd){
                    //DO NOTHING
                } else {
                    // if cur is not the last stmt, connect with the next ir stmt
                    connectIR(curNode, irToNode.get(stmts.peek()));
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
