package jw795.cfg;

import jw795.assembly.*;

import java.util.HashMap;
import java.util.List;

public class AsmCFG extends CFG<AAInstruction> {

    public AsmCFG(CFGNode<AAInstruction> start) {
        super(start);
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
                connect(curNode, nextNode);
            } else {
                if (i < size - 1){
                    AAInstruction nextAsm = asm.get(i + 1);
                    CFGNode<AAInstruction> nextNode = map.get(nextAsm);
                    if(nextNode == null || curNode == null){
                        System.out.println("ASM CFG: regular CFG node == null");
                    }
                    connect(curNode, nextNode);
                }
            }
        }

        return new AsmCFG(map.get(asm.get(0)));
    }
}
