/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package jw795;

import jw795.asmgenerator.AssemblyGeneratorAdapter;
import edu.cornell.cs.cs4120.xic.ir.IRCompUnit;
import edu.cornell.cs.cs4120.xic.ir.interpret.IRSimulator;
import jw795.irgenerator.IRGeneratorAdapter;
import jw795.lexer.LexerAdapter;
import jw795.parser.ParserAdapter;
import jw795.typechecker.TypeCheckerAdapter;
import org.apache.commons.cli.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;

/**
 * Main class of xi-compiler.
 */
public class Compiler {
    CommandLine cmd;
    String destPath = "./";
    String sourcePath = "./";
    String libPath = "./";
    String destPathAsm = "./";
    Target targetOS = Target.LINUX;
    List<String> files = new ArrayList<>();
    Options options;

    OptSettings optSettings = new OptSettings(); // default is all opts are OFF



    HashMap<String, String> funcNames;
    HashMap<String, Long> funcRetLengths;
    HashMap<String, Long> funcArgLengths;

    public enum Target {
        LINUX, // supported
        WINDOWS,
        MACOS
    }

    /**
     * Initialize the CommandLine Interface
     * @param args the arguments passed in with CLI command.
     * @throws ParseException if
     */
    public void init_cli(String[] args) throws ParseException {
        options = new Options();

        options.addOption("h", "help", false,
                "display the help page");

        // compiler stages
        options.addOption("lex", "lex", false,
                "perform lexical analysis on the input file");
        options.addOption("parse", "parse", false,
                "generate output from syntactic analysis");
        options.addOption("typechecck", "typecheck", false,
                "generate output from semantic analysis");
        options.addOption("irgen", "irgen", false,
                "generate intermediate code on the input file");
        options.addOption("irrun", "irrun", false,
                "generate and interpret intermediate code");

        // path settings
        options.addOption("sourcepath", "sourcepath", true,
                "specify where to find input source files");
        options.addOption("libpath", "libpath", true,
                "specify where to find library interface files");
        options.addOption("D", "destination", true,
                "set path for diagnostic files");
        options.addOption("d", "d", true,
                "Specify where to place generated assembly output files");

        // optimization - progress files
        options.addOption("optir", "optir", true,
                "Report the intermediate code at the specified phase of optimization");
        options.addOption("optcfg", "optcfg", true,
                "Report the control-flow graph at the specified phase of optimization");
        options.addOption("reportopts", "report-opts", false,
                "Output the optimizations supported by this compiler");

        // optimization flags
        options.addOption("O", "O", false,
                "Disable all optimization");
        options.addOption("Oreg", "Oregalloc", false,
                "Turn on register allocation optimization");
        options.addOption("Ocopy", "Ocopyprop", false,
                "Turn on copy propagation optimization");
        options.addOption("Ocf", "Oconstfold", false,
                "Turn on constant folding optimization");
        options.addOption("Ocse", "Ocommomsubexpr", false,
                "Turn on common subexpression elimination.");

        // target OS
        options.addOption("target", "target", true,
                "Specify the operating system for which to generate code");

        CommandLineParser parser = new DefaultParser();
        cmd = parser.parse(options, args);

    }

    /**
     * Display the help page.
     */
    public void help(){
        System.out.println(cmd);
        if (cmd.hasOption("h")){
            String syntax = "./xic [options] <source-files> ";
            String header = "Available options to use the compiler with:";
            String footer = "Have fun!";
            HelpFormatter helpFormatter = new HelpFormatter();
            helpFormatter.printHelp(syntax, header, options, footer);
        }
    }

    /**
     * Set the path to place the diagnostic files
     */
    public void setPaths() {
        if (cmd.hasOption("D")) {
            this.destPath = cmd.getOptionValue("D")+"/";
        }
        if (cmd.hasOption("sourcepath")) {
            this.sourcePath = cmd.getOptionValue("sourcepath")+"/";
        }
        if (cmd.hasOption("libpath")) {
            this.libPath = cmd.getOptionValue("libpath")+ "/";
        }
    }

    /**
     * Produce lexical analysis for one file
     * @param fileName the name of the file
     */
    public void lexFile(String fileName) {
        try {
            // Generate token file
            Reader reader = new FileReader(fileName);
            LexerAdapter lexerAdapt = new LexerAdapter(reader, fileName, destPath);
            lexerAdapt.generateTokens();
        } catch (FileNotFoundException e) {
            System.out.println(fileName + ": " + " " + "File not found.");
        }
    }


    /**
     * Produce lexical analysis on all input source files.
     */
    public void lex(){
        if (cmd.hasOption("lex")) {
            files = cmd.getArgList();
            for (String file : files) {
                if (file.endsWith("xi") || file.endsWith("rh")) {
                    lexFile(file);
                }
            }
        }
    }

    /**
     * Produce syntactic analysis on all input source files.
     */
    public void parse(){
        if (cmd.hasOption("parse")) {
            files = cmd.getArgList();
            for (String file : files) {
                if (file.endsWith("xi")) {
                    parseFile(file);
                }
                if(file.endsWith("rh")){
                    parseFile(file);
                }
            }
        }
    }

    /**
     * Parse a single file
     * @param fileName input file
     */
    public void parseFile(String fileName) {
        try {
            // Generate token file
            Reader reader = new FileReader(fileName);
            ParserAdapter parserAdapt = new ParserAdapter(reader, fileName, destPath);
            parserAdapt.generateAST();
        } catch (FileNotFoundException e) {
            System.out.println(fileName + ": " + " " + "File not found.");
        }
    }

    /**
     * Perform type check on all input files
     */
    public void typeCheck(){
        if (cmd.hasOption("typecheck")) {
            files = cmd.getArgList();
            for (String file : files) {
                if (file.endsWith(".xi")) {
                    typeCheckFile(sourcePath + file, false);
                }
                if (file.endsWith(".rh")) {
                    typeCheckFile(sourcePath + file, true);
                }
            }
        }
    }

    /**
     * Type check a single file
     * @param fileName input file
     */
    public void typeCheckFile(String fileName, Boolean rh) {
        try {
            // Generate token file
            Reader reader = new FileReader(fileName);
            TypeCheckerAdapter typeAdapt;
            if(rh){
                typeAdapt = new TypeCheckerAdapter(reader, fileName, destPath, libPath, true,".ri");
            }else{
                typeAdapt = new TypeCheckerAdapter(reader, fileName, destPath, libPath, true, ".ixi");
            }
            typeAdapt.generateTypeCheck();
        } catch (FileNotFoundException e) {
            System.out.println(fileName + ": " + " " + "File not found.");
        }
    }

    /**
     * Generate the intermediate representation or CFG for fileName
     * @param fileName the input xi file
     * @return an IRCompUnit which is the root node of generated IR
     */
    public IRCompUnit generateIRorCFGForFile(String fileName) {
        boolean generateIRFile = cmd.hasOption("irrun") || cmd.hasOption("irgen");
        boolean generateOptIRFile = cmd.hasOption("optir");
        boolean generateCFGFile = cmd.hasOption("optcfg");

        IRGeneratorAdapter irGeneratorAdapter = new IRGeneratorAdapter(
                fileName, this.destPath, this.libPath, generateIRFile, optSettings);

        IRCompUnit sourceIR = irGeneratorAdapter.generateIR();
        funcNames = irGeneratorAdapter.getFuncNames();
        funcArgLengths = irGeneratorAdapter.getFuncArgLengths();
        funcRetLengths = irGeneratorAdapter.getFuncRetLengths();
        return sourceIR; // nullable
    }

    /**
     * Generate IR for all input file.
     */
    public void generateIR() {
        if (cmd.hasOption("irgen") || cmd.hasOption("optcfg")) {
            this.files = cmd.getArgList();
            for (String file : files) {
                generateIRorCFGForFile(file);
            }
        }
    }


    /**
     * Generate and run IR for all input files.
     */
    public void runIR() {
        if (cmd.hasOption("irrun")) {
            this.files = cmd.getArgList();
            for (String file : files) {
                IRCompUnit ir = generateIRorCFGForFile(file);
                if (ir != null) {
                    IRSimulator sim = new IRSimulator(ir);
                    long result = sim.call("_Imain_paai", 1);
                }
            }

        }
    }

    /**
     * Compile a single file into assembly.
     * @param filename source file
     */
    public void compileFile(String filename) {
        IRCompUnit ir = generateIRorCFGForFile(filename);
        if (ir != null) {
            AssemblyGeneratorAdapter asmAdapter = new AssemblyGeneratorAdapter(
                    filename, ir, destPathAsm, optSettings, funcArgLengths, funcRetLengths, funcNames);
            asmAdapter.generateAssembly();
        }

    }

    /**
     * Compile the input files into assembly code.
     */
    public void compile() {
        Option[] options = cmd.getOptions();
        if (options.length == 0 || cmd.hasOption("target")) {
            this.files = cmd.getArgList();
            for (String file : files) {
                compileFile(file);
            }
        }
    }

    /**
     * Output (only) a list of optimizations supported by the compiler
     */
    public void printAllOpt(){
        if (cmd.hasOption("report-opts")){
            System.out.println("List of optimizations supported are:");
            System.out.println("-cf: Constant Folding");
            System.out.println("-reg: Register Allocation");
            System.out.println("-copy: Copy Propagation");
            System.out.println("-dce: Dead Code Elimination");
            System.out.println("-cse: Common Subexpression Elimination");
        }
    }

    /**
     * Set the optimization settings.
     */
    public void setOptimizationSettings() {
        // if nothing is specified then everything is on
        if (cmd.hasOption("Oreg")) { optSettings.setReg(true); }
        if (cmd.hasOption("Ocopy")) { optSettings.setCopy(true); }
        if (cmd.hasOption("Odce")) { optSettings.setDce(true); }
        if (cmd.hasOption("Ocf")) { optSettings.setCf(true); }
        if (cmd.hasOption("Ocse")) { optSettings.setReg(true); }
        if (!cmd.hasOption("O") &&
                !cmd.hasOption("Oreg") &&
                !cmd.hasOption("Ocopy") &&
                !cmd.hasOption("Odce") &&
                !cmd.hasOption("Ocf") &&
                !cmd.hasOption("Ocse")) {
            optSettings.setReg(true);
            optSettings.setCopy(true);
            optSettings.setDce(true);
            optSettings.setCf(true);
            optSettings.setCse(true);
        }

        if (cmd.hasOption("optir")) {
            List<String> irPhases = Arrays.asList(cmd.getOptionValues("optir"));
            if (irPhases.contains("initial")) {
                optSettings.setOptIRInit(true);
            }
            if (irPhases.contains("final")) {
                optSettings.setOptIRFinal(true);
            }
        }

        if (cmd.hasOption("optcfg")) {
            List<String> cfgPhases = Arrays.asList(cmd.getOptionValues("optcfg"));
            if (cfgPhases.contains("initial")) {
                optSettings.setOptCFGInit(true);
            }
            if (cfgPhases.contains("final")) {
                optSettings.setOptCFGFinal(true);
            }
        }

    }


    public static void main(String[] args) {
        Compiler compiler = new Compiler();
        try {
            compiler.init_cli(args);
        } catch (ParseException e){
            System.out.println(e.getMessage());
        }

        compiler.help();
        compiler.printAllOpt();
        compiler.setPaths();
        compiler.setOptimizationSettings();
        compiler.lex();
        compiler.parse();
        compiler.typeCheck();
        compiler.generateIR();
        compiler.runIR();
        compiler.compile();
    }
}
