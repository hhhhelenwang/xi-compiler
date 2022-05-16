package jw795.ast;

import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import jw795.Visitor;

import java.util.ArrayList;

public class VarDeclareMulStmt extends Statement{
    public ArrayList<String> names;
    public String typename;

    public VarDeclareMulStmt(String s, ArrayList<String> names,String typename, int li, int co) {
        super(li, co);
        names.add(0,s);
        this.names = names;
        this.typename = typename;
    }


    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        for(String s: names) {
            printer.printAtom(s);
        }
        printer.printAtom(":");
        printer.printAtom(typename);
        printer.endList();
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        visitor.visitVarDeclMul(this);
    }
}
