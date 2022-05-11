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
    public AsmCFG toAsmCFG(List<AAInstruction> asm, String funcName){
        int size = asm.size();

        HashMap<AAInstruction, CFGNode<AAInstruction>> instrToCFG = new HashMap<>();
        HashMap<String, AALabelInstr> labels = new HashMap<>();
        //maps from label to the starting stmt following the label
        HashMap<AALabelInstr, AAInstruction> firstIntrs = new HashMap<>();

        CFGNode<AAInstruction> start = new CFGNode(new AALabel("start"), "start");
        CFGNode<AAInstruction> end = new CFGNode(new AALabel("end"), "end");

        // populate hashmap: instrToCFG
        for (int i = 0; i < size; i++){
            AAInstruction instr = asm.get(i);
            if (instr instanceof AALabelInstr){
                labels.put(((AALabelInstr) instr).getName(), (AALabelInstr) instr);
                if (((AALabelInstr) instr).getName().length()>4 &&
                        ((AALabelInstr) instr).getName().substring(0,5).equals("done")){
                    instrToCFG.put(instr, end);
                }
            } else {
                instrToCFG.put(instr, new CFGNode<>(instr));
            }
        }

        //populate firstStmts
        for (int i = 0; i < size-1; i++){
            AAInstruction instr = asm.get(i);
            if (instr instanceof AALabelInstr){
                int nextNonLabelInstr = i+1;
                //get the first non-label stmt following the label
                while(nextNonLabelInstr < size && asm.get(nextNonLabelInstr) instanceof AALabelInstr) {
                    nextNonLabelInstr++;
                }
                firstIntrs.put((AALabelInstr) instr, asm.get(nextNonLabelInstr));
            }
        }

        AAInstruction lstInstr = asm.get(size-1);
        if (lstInstr instanceof AALabelInstr  && ((AALabelInstr)lstInstr).getName().length()>5 &&
                ((AALabelInstr)lstInstr).getName().substring(0,5).equals("done")){
            firstIntrs.put((AALabelInstr) lstInstr, lstInstr);
        }

        for (int i = 0; i < size-1; i++){
            AAInstruction curAsm = asm.get(i);
            CFGNode<AAInstruction> curNode = instrToCFG.get(curAsm);

            if (curAsm instanceof AALabelInstr || curAsm instanceof AAJmp){
                continue;
            } else if (curAsm instanceof AARet){
                connectAAInstr(curNode, end);
            } else if (curAsm instanceof AAJa || curAsm instanceof AAJae || curAsm instanceof AAJb
                    || curAsm instanceof AAJbe || curAsm instanceof AAJe || curAsm instanceof AAJg || curAsm instanceof AAJge
                    || curAsm instanceof AAJl || curAsm instanceof AAJle || curAsm instanceof AAJne) {
                String targetLabel = (curAsm.operand1.get()).toString();
                AALabelInstr targetLabelInstr = labels.get(targetLabel);
                AAInstruction nextInstr = firstIntrs.get(targetLabelInstr);
                connectAAInstr(curNode, instrToCFG.get(nextInstr));

                // add fall through
                if (i != size-1){
                    nextInstr = asm.get(i+1);
                    if (nextInstr instanceof AALabelInstr){
                        nextInstr = firstIntrs.get(nextInstr);
                    }
                    connectAAInstr(curNode, instrToCFG.get(nextInstr));
                }
            } else {
                if (i < size - 1){
                    AAInstruction nextAsm = asm.get(i + 1);

                    // if cur is not the last instruction, connect with the next aa instruction
                    if (curAsm instanceof AALabelInstr){
                        nextAsm = firstIntrs.get(nextAsm);
                    } else if (curAsm instanceof AAJmp){
                        String targetLabel = (curAsm.operand1.get()).toString();
                        AALabelInstr targetLabelInstr = labels.get(targetLabel);
                        nextAsm = firstIntrs.get(targetLabelInstr);
                    }

                    connectAAInstr(curNode, instrToCFG.get(nextAsm));
                }
            }
        }

        //connect last instruction with end, connect first instruction to start
        AAInstruction lastInstr = asm.get(size-1);
        if (!(lastInstr instanceof AALabelInstr)){
            connectAAInstr(instrToCFG.get(lastInstr), end);
        }

        connectAAInstr(start, instrToCFG.get(asm.get(0)));

        return new AsmCFG(start);
    }

    /**
     * build an IRCFG from an IRFuncDecl node
     * @param funcDecl IR node
     * @param funcName used for generate IRLabel as start node
     * @return CFG graph for given IRFuncDecl
     */
    public IRCFG toIRCFG (IRFuncDecl funcDecl, String funcName){
        IRStmt body = funcDecl.body();
        CFGNode<IRStmt> start = new CFGNode(new IRLabel(funcName), "start");
        CFGNode<IRStmt> end = new CFGNode(new IRLabel("emd"), "end");
        IRCFG cfg;

        if (body instanceof IRSeq){
            List<IRStmt> stmts = ((IRSeq) body).stmts();

            // a map storing all IRStmt to CFGNode
            HashMap<IRStmt, CFGNode<IRStmt>> irToCFG = new HashMap<>();
            //maps from label name to IRLabel
            HashMap<String, IRLabel> labels = new HashMap<>();
            //maps from label to the starting stmt following the label
            HashMap<IRLabel, IRStmt> firstStmts = new HashMap<>();

            // populate hashmap: irToCFG
            int size = stmts.size();
            for (int i = 0; i < size; i++){
                IRStmt stmt = stmts.get(i);
                if (stmt instanceof IRLabel){
                    labels.put(((IRLabel) stmt).name(), (IRLabel) stmt);
                    if (((IRLabel)stmt).name().length()>4 && ((IRLabel)stmt).name().substring(0,5).equals("done")){
                        irToCFG.put(stmt, end);
                    }
                } else {
                    irToCFG.put(stmt, new CFGNode<>(stmt));
                }
            }

            //populate firstStmts
            for (int i = 0; i < size-1; i++){
                IRStmt stmt = stmts.get(i);
                if (stmt instanceof IRLabel){
                    int nextNonLabelStmt = i+1;
                    //get the first non-label stmt following the label
                    while(nextNonLabelStmt < size-1 && stmts.get(nextNonLabelStmt) instanceof IRLabel) {
                        nextNonLabelStmt++;
                    }
                    firstStmts.put((IRLabel) stmt, stmts.get(nextNonLabelStmt));
                }
            }

            IRStmt lstStmt = stmts.get(size-1);
            if (lstStmt instanceof IRLabel  && ((IRLabel)lstStmt).name().length()>4 &&
            ((IRLabel)lstStmt).name().substring(0,5).equals("done")){
                firstStmts.put((IRLabel) lstStmt, lstStmt);
            }

            IRStmt nextStmt;
            for (int i = 0; i < size; i++) {
                IRStmt curStmt = stmts.get(i);
                CFGNode<IRStmt> curNode = irToCFG.get(curStmt);

                if (curStmt instanceof IRCJump){
                    String targetLabel = ((IRCJump) curStmt).trueLabel();
                    IRLabel nextLabel = labels.get(targetLabel);
                    nextStmt = firstStmts.get(nextLabel);
                    connectIR(curNode, irToCFG.get(nextStmt));

                    //add fall through node
                    if (i != size - 1){
                        nextStmt = stmts.get(i+1);
                        if (nextStmt instanceof IRLabel){
                            nextStmt = firstStmts.get(nextStmt);
                        }
                        connectIR(curNode, irToCFG.get(nextStmt));
                    }
                } else if (curStmt instanceof IRJump || curStmt instanceof IRLabel) {
                    continue;
                } else if (curStmt instanceof IRReturn){
                    connectIR(curNode, end);
                } else {
                    // if cur is not the last stmt, connect with the next ir stmt
                    if (i != size - 1){
                        nextStmt = stmts.get(i+1);
                        if (nextStmt instanceof IRLabel){
                            nextStmt = firstStmts.get(nextStmt);
                        } else if (nextStmt instanceof IRJump){
                            String targetLabel = ((IRName)((IRJump) nextStmt).target()).name();
                            IRStmt irLabel = labels.get(targetLabel);
                            nextStmt = firstStmts.get(irLabel);
                        }

                        connectIR(curNode, irToCFG.get(nextStmt));
                    }
                }
            }

            IRStmt lastStmt = stmts.get(size-1);
            if (!(lastStmt instanceof IRLabel)){
                connectIR(irToCFG.get(lastStmt), end);
            }
            connectIR(start, irToCFG.get(stmts.get(0)));
        } else {
            CFGNode<IRStmt> bodyNode = new CFGNode<>(body);
            connectIR(start, bodyNode);
            connectIR(bodyNode, end);
        }

        cfg = new IRCFG(start);
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
