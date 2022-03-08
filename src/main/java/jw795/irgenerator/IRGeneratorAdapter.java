package jw795.irgenerator;

import edu.cornell.cs.cs4120.xic.ir.IRCompUnit;
import jw795.ast.ASTNode;
import jw795.typechecker.TypeCheckerAdapter;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class IRGeneratorAdapter {
    TypeCheckerAdapter typeCheckerAdapter;

    public IRGeneratorAdapter(String fileName, String dest, String lib) {
        try {
            FileReader fr = new FileReader(fileName);
            typeCheckerAdapter = new TypeCheckerAdapter(fr, fileName, dest, lib, false);
        } catch (FileNotFoundException e) {
            System.out.println(fileName + ": " + " " + "File not found.");
        }

    }

    public IRCompUnit generateIR() {
        // first type check the input file,
        // this should report any lexical, syntactic, and semantic errors
        ASTNode checkedProgram = typeCheckerAdapter.gentypecheck();

        // generate IR for the AST node;

        return null;
    }

}
