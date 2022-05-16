package jw795.irgenerator;

import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import edu.cornell.cs.cs4120.util.SExpPrinter;
import edu.cornell.cs.cs4120.xic.ir.IRCompUnit;
import edu.cornell.cs.cs4120.xic.ir.IRFuncDecl;
import edu.cornell.cs.cs4120.xic.ir.IRStmt;
import jw795.OptSettings;
import jw795.Visitor;
import jw795.ast.Program;
import jw795.cfg.CFG;
import jw795.cfg.CFGGenerator;
import jw795.optimizer.IROptimizationRunner;
import jw795.typechecker.*;

import java.io.*;
import java.util.*;

import static jw795.util.FileUtil.generateTargetFile;
import static jw795.util.FileUtil.generateTargetFileWithFuncName;

/**
 * Take in an input source file and produce an IR for it.
 */
public class IRGeneratorAdapter {
    TypeCheckerAdapter typeCheckerAdapter;
    String destPath; // the path to put the typed file in
    String libPath; // path to find the interface files in
    String fileName; // already contains source dir + file name
    HashMap<String, String> funcNames = new HashMap<>();
    HashMap<String, Long> funcRetLengths = new HashMap<>();
    HashMap<String, Long> funcArgLengths = new HashMap<>();
    HashMap<String, ArrayList<String>> recordfields;
    boolean genIRFile;
    OptSettings optSettings;

    public IRGeneratorAdapter(String fileName, String dest, String lib,
                              boolean generateIRFile, OptSettings optSettings) {
        this.destPath = dest;
        this.libPath = lib;
        this.fileName = fileName;
        this.optSettings = optSettings;
        String ends = fileName.endsWith("rh")? ".ri": ".ixi";
        try {
            FileReader fr = new FileReader(fileName);
            typeCheckerAdapter = new TypeCheckerAdapter(fr, fileName, dest, lib, false,ends );
        } catch (FileNotFoundException e) {
            System.out.println(fileName + ": " + " " + "File not found.");
        }
        this.genIRFile = generateIRFile;
    }


    /**
     * Generate IR code for the file specified for adaptor, and write generated IR code to target file
     * @return a root node for the lowered IR ast
     */
    public IRCompUnit generateIR() {
        // typeCheckAdapter.gentypecheck() will print Lexical, Syntax, or Semantic errors if those errors exist
        Program checkedProgram = (Program) typeCheckerAdapter.generateTypeCheck();
        if (checkedProgram != null) {
            if(optSettings.cf()){
                ConstantFoldingAst confold = new ConstantFoldingAst(checkedProgram);
                checkedProgram = confold.fold();
            }
            funProcess();
            this.recordfields = this.getRecordFieldNames();
            // create irVisitor
            String[] name = fileName.split("/");
            String dotXiName = name[name.length - 1];
            String finalName = dotXiName.split("\\.")[0];
            Visitor irVisitor = new IRGenerator(finalName, funcNames, funcRetLengths, recordfields);
            IRCompUnit lowerIR = null;
            IRCompUnit reorderedIR = null;
            IRCompUnit optimizedIR = null;
            // generate the target .ir file
            FileWriter targetWriter = null;

            try{
                if (genIRFile) {
                    File targetIrsol = generateTargetFile(fileName, destPath, "ir");
                    targetWriter = new FileWriter(targetIrsol);
                }
                // Generating IR
                checkedProgram.accept(irVisitor);
                IRCompUnit root = checkedProgram.ir;
                IRLower lirTranslator = new IRLower();
                lowerIR = lirTranslator.lower(root);
                if(optSettings.cf()){
                    ConstantFolding confold = new ConstantFolding(lowerIR);
                    lowerIR = confold.foldComp();
                }
                JumpReorder jumpReorder = new JumpReorder();
                reorderedIR = jumpReorder.reorder(lowerIR);

                // optimization!!
                System.out.println("start running optimization");
                IROptimizationRunner irOptimizationRunner = new IROptimizationRunner(reorderedIR, optSettings);
                optimizedIR = irOptimizationRunner.runOptimizations();
                // here optimizedIR will be the same as unoptimizedIR if no optimization is done

                if (genIRFile) {
                    // Writing to target file
                    assert targetWriter != null;
                    targetWriter.write(prettyPrint(optimizedIR));
                    targetWriter.close();
                }
            } catch (Exception e) {
                System.out.println("unknown error while generating IR: "+ e.getMessage());
                System.out.println(Arrays.toString(e.getStackTrace()));
            }

            // output cfg files at different stages of optimization
            try {
                if (optSettings.optCFGInit() || optSettings.optCFGFinal()){
                    Map<String, IRFuncDecl> funcs;
                    if (optSettings.optCFGInit()) {
                        assert reorderedIR != null;
                        funcs = reorderedIR.functions();
                        CFGGenerator ircfg = new CFGGenerator();
                        for (IRFuncDecl func : funcs.values()){
                            CFG<IRStmt> cfg = ircfg.toIRCFG(func);
                            cfg.toDotFormat(fileName, destPath, func.name(), "initial");
                        }
                    }
                    if (optSettings.optCFGFinal()) {
                        assert optimizedIR != null;
                        funcs = optimizedIR.functions();
                        CFGGenerator ircfg = new CFGGenerator();
                        for (IRFuncDecl func : funcs.values()){
                            CFG<IRStmt> cfg = ircfg.toIRCFG(func);
                            cfg.toDotFormat(fileName, destPath, func.name(), "final");
                        }
                    }

                }
            } catch (Exception e) {
                System.out.println("unknown error while generating IRCFG : "+ e.getMessage());
            }

            // output IR or CFG files at different phases of optimization
            try{
                if (optSettings.optIRInit() || optSettings.optIRFinal()) {

                    if (optSettings.optIRInit()) {
                        File targetIrsol = generateTargetFileWithFuncName(fileName, destPath, "ir",
                                Optional.empty(), Optional.of("initial"));
                        targetWriter = new FileWriter(targetIrsol);
                        assert reorderedIR != null;
                        targetWriter.write(prettyPrint(reorderedIR));
                        targetWriter.close();
                    }

                    if (optSettings.optIRFinal()) {
                        File targetIrsol = generateTargetFileWithFuncName(fileName, destPath, "ir",
                            Optional.empty(), Optional.of("initial"));
                        targetWriter = new FileWriter(targetIrsol);
                        assert optimizedIR != null;
                        targetWriter.write(prettyPrint(optimizedIR));
                        targetWriter.close();

                    }
                }
            }catch (Exception e) {
                System.out.println("unknown error while generating OptIRFile : "+ e.getMessage());
                System.out.println(e.getStackTrace());
            }

            return optimizedIR;

        } else {
            return null;
        }
    }

    /**
     * Helper function prettyPrint is adapted from given code
     * @param compUnit The root IR node of the program
     * @return a string representation of all IR code in compUnit
     */
    private static String prettyPrint(IRCompUnit compUnit) {
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw);
             SExpPrinter sp = new CodeWriterSExpPrinter(pw)) {
            compUnit.printSExp(sp);
        }
        return sw.toString();
    }

    /**
     * fill up funcNames and funcRetLengths after typechecking
     */
    private void funProcess() {
        HashMap<String, Sigma> funs = typeCheckerAdapter.getFunctions();
        for (Map.Entry<String, Sigma> entry : funs.entrySet()) {
            if (entry.getValue() instanceof Fn) {
                funcNames.put(entry.getKey(), funNameBuild(entry.getKey(), (Fn) entry.getValue()));
                funcRetLengths.put(entry.getKey(), TLength(((Fn) entry.getValue()).outputType));
                funcArgLengths.put(entry.getKey(), TLength(((Fn) entry.getValue()).inputType));
            }
        }
    }

    /**
     * build the name of a function following the abi naming convention for a function
     * @param funcName the original name of the function
     * @param type the type of the function
     * @return the name of the function following the abi naming convention
     */
    private String funNameBuild(String funcName, Fn type) {
        String newName = funcName.replaceAll("_", "__");
        return "_I" + newName + "_" + outputNameBuild(type.outputType) + inputNameBuild(type.inputType);
    }

    /**
     * generate the input part of the function name building
     * @param inputType the input type of the function
     * @return the input part of the function name building
     */
    private String inputNameBuild(T inputType) {
        if (inputType instanceof Int) {
            return "i";
        } else if (inputType instanceof Bool) {
            return "b";
        } else if (inputType instanceof TypedArray) {
            return "a" + inputNameBuild(((TypedArray) inputType).elementType);
        }else if(inputType instanceof Record){
            return "r"+((Record) inputType).name.length() + ((Record) inputType).name;
        }else if (inputType instanceof Unit) {
            return "";
        } else if (inputType instanceof Prod){
            String result = "";
            for (Tau t : ((Prod) inputType).elementTypes) {
                result.concat(inputNameBuild(t));
            }
            return result;
        }
        return null;
    }

    /**
     * generate the output part of the function name building
     * @param outputType the output type of the function
     * @return the output part of the function name building
     */
    private String outputNameBuild(T outputType) {
        if (outputType instanceof Int) {
            return "i";
        } else if (outputType instanceof Bool) {
            return "b";
        } else if (outputType instanceof TypedArray) {
            return "a" + inputNameBuild(((TypedArray) outputType).elementType);
        } else if (outputType instanceof Unit) {
            return "p";
        }else if(outputType instanceof Record){
            return "r"+((Record) outputType).name.length() + ((Record) outputType).name;
        }
        else if (outputType instanceof Prod){
            String result = "t".concat(String.valueOf(((Prod) outputType).elementTypes.size()));
            for (Tau t : ((Prod) outputType).elementTypes) {
                result = result.concat(outputNameBuild(t));
            }
            return result;
        }
        return null;
    }

    /**
     * generate number of primitive types in a T type
     * @param type the T type
     * @return number of primitive types in a T type
     */
    private Long TLength(T type) {
        if (type instanceof Int) {
            return 1L;
        } else if (type instanceof Bool) {
            return 1L;
        } else if (type instanceof TypedArray) {
            return 1L;
        }else if (type instanceof Record) {
            return 1L;
        } else if (type instanceof Unit) {
            return 0L;
        } else if (type instanceof Prod){
            return (long) ((Prod) type).elementTypes.size();
        }
        return null;
    }

    /**
     * Getter for the map of function names to their number of arguments
     */
    public HashMap<String, Long> getFuncArgLengths() {
        return funcArgLengths;
    }

    /**
     * Getter for the map of function names to their number of returns
     */
    public HashMap<String, Long> getFuncRetLengths() {
        return funcRetLengths;
    }

    public HashMap<String, String> getFuncNames() {
        return funcNames;
    }

    public HashMap<String, ArrayList<String>> getRecordFieldNames(){
        HashMap<String,Record> ori = typeCheckerAdapter.getRecords();
        HashMap<String, ArrayList<String>> result = new HashMap<>();
        for(Map.Entry<String,Record> mpe: ori.entrySet()){
            ArrayList<String> temp = new ArrayList<String>(mpe.getValue().fields.keySet());
            result.put(mpe.getKey(),temp );
        }
        return result;
    }
}
