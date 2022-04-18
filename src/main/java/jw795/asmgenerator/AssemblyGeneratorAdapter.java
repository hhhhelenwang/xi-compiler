package jw795.asmgenerator;

import edu.cornell.cs.cs4120.xic.ir.IRCompUnit;
import edu.cornell.cs.cs4120.xic.ir.IRFuncDecl;
import edu.cornell.cs.cs4120.xic.ir.IRNode;
import edu.cornell.cs.cs4120.xic.ir.IRNodeFactory_c;
import jw795.assembly.AAAdd;
import jw795.assembly.AAInstruction;
import jw795.assembly.AAOperand;
import jw795.assembly.AATemp;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static jw795.util.FileUtil.generateTargetFile;

/**
 * An adapter class that takes in a single source file and generates the assembly code for that file.
 */
public class AssemblyGeneratorAdapter {
    String fileName; // already contains source dir + file name
    IRCompUnit sourceIR; // ir of the source file
    String destPathAsm;
    boolean optimize;
    FileWriter asmWriter;

    public AssemblyGeneratorAdapter(String file, IRCompUnit ir, String dest, boolean opt) {
        fileName = file;
        sourceIR = ir;
        destPathAsm = dest;
        optimize = opt;
        try {
            File targetAsmSol = generateTargetFile(fileName, destPathAsm, "s");
            asmWriter = new FileWriter(targetAsmSol);
        } catch (Exception e) {
            System.out.println("Compiler error: target file not found");
        }

    }

    /**
     * Generate assembly for file.
     */
    public void generateAssembly() {
        System.out.println("asm gen called!");
        Tiler asmvisit = new Tiler(new IRNodeFactory_c(),new TempSpiller());

        //after visiting, it should be still IRCompunit
        IRCompUnit visited = (IRCompUnit) asmvisit.visit(sourceIR);
        for(Map.Entry<String,IRFuncDecl> funde: visited.functions().entrySet()){
            List<AAInstruction> newins = new ArrayList<>();
            TempSpiller tmpsp = new TempSpiller();
            spillnode(funde.getValue(),tmpsp);
        }

        // we also need to deal with grow stack and stuff
        //tile and then spill temp
        try{
            printTile(visited.getTile());
            asmWriter.close();
        } catch (Exception e){
            System.out.println("got an error while printing the string for a tile");
        }
    }

    /**
     * print a given tile with Depth first recursion
     * @param node the given tile
     * @throws Exception
     */
    private void printTile(Tile node) throws Exception{
        if (node != null){
            asmWriter.write(node.toString());
        }
        for(IRNode e: node.getNeighborIRs()){
            printTile(e.getTile());
        }
    }

    /**
     * traverse the tile to get tmp number and replace tmp name with
     * @param node
     * @return the original node with modified tile
     */
    private void spillnode(IRNode node, TempSpiller tmpsp){
        Tile cur = node.getTile();
        for(AAInstruction a : cur.getAssembly()){
            AAOperand a1;
            AAOperand a2;
            if(a.operand1.isPresent()){
                a1 =  a.operand1.get();
                if(a1 instanceof AATemp) {
                    tmpsp.spillTemp((AATemp) a1);
                    a1 = tmpsp.getMemOfTemp((AATemp) a1);
                    a.reseta1(a1);
                }
            }
            if(a.operand2.isPresent()){
                a2 = a.operand1.get();
                if(a2 instanceof AATemp){
                    tmpsp.spillTemp((AATemp) a2);
                    a2 = tmpsp.getMemOfTemp((AATemp) a2);
                    a.reseta2(a2);
                }
            }
            for(IRNode irn: cur.getNeighborIRs()){
                spillnode(irn,tmpsp);
            }
        }
    }










}
