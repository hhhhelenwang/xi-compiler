package jw795.ast;

import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import jw795.Visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordDeclare extends ASTNode implements ProcFuncDecl, Definition{
    public String name;
    public Map<String, Type> fieldtypelst;
//    public List<HashMap<Integer,Integer>> s;
    public RecordDeclare(String n, int li, int co) {
        super(li, co);
        name = n;
        fieldtypelst = new HashMap<>();
    }
    public RecordDeclare(String n, ArrayList<HashMap<String, Type>> lst, int li, int co) {
        super(li, co);
        name = n;
        fieldtypelst = new HashMap<>();
        for(Map<String, Type> m: lst) {
            fieldtypelst.putAll(m);
        }

    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom("record");
        printer.printAtom(name);
        printer.startList();
        for (Map.Entry<String,Type> entry : fieldtypelst.entrySet()) {
            printer.printAtom( entry.getKey());
            printer.printAtom(":");
            entry.getValue().prettyPrint(printer);
        }
        printer.endList();
        printer.startList();
        printer.endList();
        printer.endList();

    }

    @Override
    public void accept(Visitor visitor) throws Exception {

    }
}
