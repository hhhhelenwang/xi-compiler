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

        IRNode visited = asmvisit.visit(sourceIR);
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
    private IRNode spillnode(IRNode node, TempSpiller tmpsp){
        Tile cur = node.getTile();
        for(AAInstruction a : cur.getAssembly()){
            if(a.operand1.isPresent()){
                if(a.operand1.get() instanceof AATemp){
                    //spill the tmp if it is not default tmp
                    if(!checkname(((AATemp) a.operand1.get()).name()))
                    tmpsp.spillTemp((AATemp) a.operand1.get());
                    //let assume that we make every access to temp a Memaccess
                    //todo: seprate store and load

                }
                if(a.operand2.get() instanceof AATemp){
                    //spill the tmp if it is not default tmp
                    if(!checkname(((AATemp) a.operand2.get()).name()))
                        tmpsp.spillTemp((AATemp) a.operand2.get());

                }
            }
        }

        return node;
    }

    private boolean checkname(String s){
        boolean result = false;
        if(s =="rcx" | s == "rdi" | s == "rsi"){ result = true; }
        if(s == "r8" | s == "r9" | s == "rax"){ result = true; }
        if(s.charAt(0) == 'r' && s.length() == 3){
            result = true;
        }
        return result;
    }









}
