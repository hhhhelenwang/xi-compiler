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

        options.addOption("sourcepath", "sourcepath", true,
                "specify where to find input source files");
        options.addOption("libpath", "libpath", true,
                "specify where to find library interface files");
        options.addOption("D", "destination", true,
                "set path for diagnostic files");
        options.addOption("d", "d", true,
                "Specify where to place generated assembly output files");


        options.addOption("O", "O", false,
                "Disable optimization for generating IR");

        options.addOption("target", "target", true,
                "Specify the operating system for which to generate code");

        CommandLineParser parser = new DefaultParser();
        cmd = parser.parse(options, args);

    }

    /**
     * Display the help page.
     */
    public void help(){
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
                if (file.endsWith("xi")) {
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
                    typeCheckFile(sourcePath + file);
                }
            }
        }
    }

    /**
     * Type check a single file
     * @param fileName input file
     */
    public void typeCheckFile(String fileName) {
        try {
            // Generate token file
            Reader reader = new FileReader(fileName);
            TypeCheckerAdapter typeAdapt = new TypeCheckerAdapter(reader, fileName, destPath, libPath, true);
            typeAdapt.generateTypeCheck();
        } catch (FileNotFoundException e) {
            System.out.println(fileName + ": " + " " + "File not found.");
        }
    }

    /**
     * Generate the intermediate representation for fileName
     * @param fileName the input xi file
     * @return an IRCompUnit which is the root node of generated IR
     */
    public IRCompUnit generateIRForFile(String fileName) {
        boolean generateFile = cmd.hasOption("irrun") || cmd.hasOption("irgen");
        boolean optimize = !cmd.hasOption("O");
        IRGeneratorAdapter irGeneratorAdapter = new IRGeneratorAdapter(
                fileName, this.destPath, this.libPath, optimize, generateFile);

        IRCompUnit sourceIR = irGeneratorAdapter.generateIR();
        funcArgLengths = irGeneratorAdapter.getFuncArgLengths();
        funcRetLengths = irGeneratorAdapter.getFuncRetLengths();
        return sourceIR; // nullable
    }

    /**
     * Generate IR for all input file.
     */
    public void generateIR() {
        if (cmd.hasOption("irgen")) {
            this.files = cmd.getArgList();
            for (String file : files) {
                generateIRForFile(file);
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
                IRCompUnit ir = generateIRForFile(file);
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
        IRCompUnit ir = generateIRForFile(filename);
        if (ir != null) {
            AssemblyGeneratorAdapter asmAdapter = new AssemblyGeneratorAdapter(
                    filename, ir, destPathAsm, !cmd.hasOption("O"), funcArgLengths, funcRetLengths);
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

    public static void main(String[] args) {
        Compiler compiler = new Compiler();
        try {
            compiler.init_cli(args);
        } catch (ParseException e){
            System.out.println(e.getMessage());
        }
        compiler.help();
        compiler.setPaths();
        compiler.lex();
        compiler.parse();
        compiler.typeCheck();
        compiler.generateIR();
        compiler.runIR();
        compiler.compile();
    }
}
