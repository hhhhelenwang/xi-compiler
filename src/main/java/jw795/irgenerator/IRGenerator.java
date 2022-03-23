package jw795.irgenerator;

import edu.cornell.cs.cs4120.xic.ir.*;
import jw795.Visitor;
import jw795.ast.*;
import jw795.typechecker.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static edu.cornell.cs.cs4120.xic.ir.IRBinOp.OpType.*;

public class IRGenerator extends Visitor {
    String filename;
    IRNodeFactory_c irFactory;
    //use for global data and string
    HashMap<String,IRData> globalData;
    //TODO: find out where to store definition of function, and also give a way to find it's return type
    //currently make it a hashmap, but should it?
    HashMap<String, String> funcNames;
    HashMap<String, Long> funcRetLengths;

    int stringCounter;
    int labelCounter;
    int tempCounter;

    public IRGenerator(String filename, HashMap<String, String> funcNames, HashMap<String, Long> funcRetLengths){
        this.filename = filename;
        this.irFactory = new IRNodeFactory_c();
        this.funcNames = funcNames;
        this.funcRetLengths = funcRetLengths;
        this.globalData = new HashMap<>();
        this.stringCounter = 1;
        this.labelCounter = 1;
        this.tempCounter = 1;
    }

    @Override
    public void enterScope() {

    }

    @Override
    public void leaveScope() {

    }

    @Override
    public void visitArrayExpr(ArrayExpr node) throws Exception {
        ArrayList<IRStmt> l = new ArrayList<>();
        long n = node.arrayElements.size();
        IRConst arg = irFactory.IRConst(n * 8 + 8);
        IRTemp arrayStart = irFactory.IRTemp(nextTemp());
        l.add(irFactory.IRMove(
                arrayStart,
                irFactory.IRCall(irFactory.IRName("_xi_alloc"), arg)
        ));
        l.add(irFactory.IRMove(
                irFactory.IRMem(arrayStart),
                irFactory.IRConst(n))
        );
        for (int i = 0; i < n; i++) {
            Expr e = node.arrayElements.get(i);
            l.add(irFactory.IRMove(
                    irFactory.IRMem(
                            irFactory.IRBinOp(
                                    ADD,
                                    arrayStart,
                                    irFactory.IRConst((i + 1) * 8L))),
                    e.ir));
        }
        IRSeq s = irFactory.IRSeq(l);
        IRBinOp a = irFactory.IRBinOp(ADD, arrayStart, irFactory.IRConst( 8));
        node.ir = irFactory.IRESeq(s, a);
    }

    @Override
    public void visitArrIndexExpr(ArrIndexExpr node) throws Exception {
        ArrayList<IRStmt> l = new ArrayList<>();
        IRTemp t_a = irFactory.IRTemp(nextTemp());
        l.add(irFactory.IRMove(t_a, node.array.ir));
        IRTemp t_i = irFactory.IRTemp(nextTemp());
        l.add(irFactory.IRMove(t_i, node.index.ir));
        String ok = nextLabel();
        String indexOutOfBound = nextLabel();
        l.add(irFactory.IRCJump(
                irFactory.IRBinOp(
                        ULT,
                        t_i,
                        irFactory.IRMem(
                                irFactory.IRBinOp(
                                        SUB,
                                        t_a,
                                        irFactory.IRConst(8)
                                )
                        )
                ),
                ok,
                indexOutOfBound
            )
        );
        l.add(irFactory.IRLabel(indexOutOfBound));
        l.add(irFactory.IRCallStmt(irFactory.IRName("_xi_out_of_bound"), 0L, new ArrayList<>()));
        l.add(irFactory.IRLabel(ok));
        IRSeq s = irFactory.IRSeq(l);
        IRMem a = irFactory.IRMem(
                irFactory.IRBinOp(
                        ADD,
                        t_a,
                        irFactory.IRBinOp(
                                MUL,
                                t_i,
                                irFactory.IRConst(8)
                        )
                )
        );
        node.ir = irFactory.IRESeq(s, a);
    }

    @Override
    public void visitIntLiteral(IntLiteral node) {
        node.ir = irFactory.IRConst(node.value.longValue());
    }

    @Override
    public void visitBoolLiteral(BoolLiteral node) {
        if(node.value){
            node.ir = irFactory.IRConst(1);
        }else{
            node.ir = irFactory.IRConst(0);
        }
    }

    @Override
    public void visitStringLit(StringLit node) {
        String stringIndex = nextString();
        globalData.put(stringIndex, new IRData(stringIndex, exportVal(node)));

        List<IRStmt> stmts = new ArrayList<>();
        IRTemp strWithLen = irFactory.IRTemp(nextTemp());
        IRTemp strBegin = irFactory.IRTemp(nextTemp());

        stmts.add(irFactory.IRMove(strWithLen, irFactory.IRName(stringIndex)));
        stmts.add(irFactory.IRMove(strBegin, irFactory.IRBinOp(ADD, strWithLen, irFactory.IRConst(8))));

        IRSeq stmtSeq = irFactory.IRSeq(stmts);
        node.ir = irFactory.IRESeq(stmtSeq, strBegin);
    }

    @Override
    public void visitCharLiteral(CharLiteral node) {
        node.ir = irFactory.IRConst(node.value);
    }

    @Override
    public void visitVar(VarExpr node) throws Exception {
        //TODO: what is memtype for this ir mem
        if(globalData.containsKey(node.identifier)){
            node.ir = irFactory.IRMem(irFactory.IRName("_" + node.identifier));
        } else {
            node.ir = irFactory.IRTemp(node.identifier);
        }
    }

    @Override
    public void visitIntNeg(IntNeg node) throws Exception {
        IRExpr val = node.expr.ir;
        node.ir = irFactory.IRBinOp(SUB, irFactory.IRConst(0), val);
    }

    @Override
    //not equate to XOR True
    public void visitNot(Not node) throws Exception {
        IRExpr val = node.expr.ir;
        node.ir = irFactory.IRBinOp(XOR, val, irFactory.IRConst(1));
    }

    @Override
    public void visitAdd(Add node) throws Exception {
        if (node.type instanceof TypedArray || node.type instanceof EmptyArray) {
            node.ir = arrayConcat(node);
        } else {
            node.ir = irFactory.IRBinOp(ADD, node.expr1.ir, node.expr2.ir);
        }
    }

    private IRESeq arrayConcat (Add node) {
        IRExpr_c a1 = node.expr1.ir;
        IRExpr_c a2 = node.expr2.ir;
        IRMem a1L = irFactory.IRMem(irFactory.IRBinOp(SUB, a1, irFactory.IRConst(8L)));
        IRMem a2L = irFactory.IRMem(irFactory.IRBinOp(SUB, a2, irFactory.IRConst(8L)));
        IRBinOp totalL = irFactory.IRBinOp(ADD, a1L, a2L);
        IRBinOp space = irFactory.IRBinOp(ADD, irFactory.IRBinOp(MUL, totalL, irFactory.IRConst(8L)), irFactory.IRConst(8L));
        IRTemp arrayStart = irFactory.IRTemp(nextTemp());
        IRTemp i = irFactory.IRTemp(nextTemp());
        IRTemp j = irFactory.IRTemp(nextTemp());
        String lh1 = nextLabel();
        String l11 = nextLabel();
        String le1 = nextLabel();
        String lh2 = nextLabel();
        String l12 = nextLabel();
        String le2 = nextLabel();
        List<IRStmt> stmts = new ArrayList<>();
        stmts.add(irFactory.IRMove(
                arrayStart,
                irFactory.IRCall(irFactory.IRName("_xi_alloc"), space)
        ));
        stmts.add(irFactory.IRMove(
                irFactory.IRMem(arrayStart),
                totalL)
        );
        stmts.add(irFactory.IRMove(arrayStart, irFactory.IRBinOp(ADD, arrayStart, irFactory.IRConst(8L))));
        stmts.add(irFactory.IRMove(i, irFactory.IRConst(0L)));
        stmts.add(irFactory.IRMove(j, irFactory.IRConst(0L)));

        stmts.add(irFactory.IRLabel(lh1));
        stmts.add(C(irFactory.IRBinOp(LT, i, a1L), l11, le1));
        stmts.add(irFactory.IRLabel(l11));
        IRBinOp cur = irFactory.IRBinOp(ADD, arrayStart, irFactory.IRBinOp(MUL, i, irFactory.IRConst(8L)));
        IRBinOp cur1 = irFactory.IRBinOp(ADD, a1, irFactory.IRBinOp(MUL, i, irFactory.IRConst(8L)));
        stmts.add(irFactory.IRMove(irFactory.IRMem(cur), irFactory.IRMem(cur1)));
        stmts.add(irFactory.IRMove(i, irFactory.IRBinOp(ADD, i, irFactory.IRConst(1L))));
        stmts.add(irFactory.IRJump(irFactory.IRName(lh1)));
        stmts.add(irFactory.IRLabel(le1));

        stmts.add(irFactory.IRLabel(lh2));
        stmts.add(C(irFactory.IRBinOp(LT, j, a2L), l12, le2));
        stmts.add(irFactory.IRLabel(l12));
        cur = irFactory.IRBinOp(ADD, arrayStart, irFactory.IRBinOp(ADD, a2L, irFactory.IRBinOp(MUL, j, irFactory.IRConst(8L))));
        IRBinOp cur2 = irFactory.IRBinOp(ADD, a2, irFactory.IRBinOp(MUL, j, irFactory.IRConst(8L)));
        stmts.add(irFactory.IRMove(irFactory.IRMem(cur), irFactory.IRMem(cur2)));
        stmts.add(irFactory.IRMove(j, irFactory.IRBinOp(ADD, j, irFactory.IRConst(1L))));
        stmts.add(irFactory.IRJump(irFactory.IRName(lh2)));
        stmts.add(irFactory.IRLabel(le2));

        return irFactory.IRESeq(irFactory.IRSeq(stmts), arrayStart);
    }

    @Override
    public void visitSub(Sub node) throws Exception {
        node.ir = irFactory.IRBinOp(SUB, node.expr1.ir, node.expr2.ir);
    }

    @Override
    public void visitMult(Mult node) throws Exception {
        node.ir = irFactory.IRBinOp(MUL, node.expr1.ir, node.expr2.ir);
    }

    @Override
    public void visitHighMult(HighMult node) throws Exception {
        node.ir = irFactory.IRBinOp(HMUL, node.expr1.ir, node.expr2.ir);
    }

    @Override
    public void visitDiv(Div node) throws Exception {
        node.ir = irFactory.IRBinOp(DIV, node.expr1.ir, node.expr2.ir);
    }

    @Override
    public void visitMod(Mod node) throws Exception {
        node.ir = irFactory.IRBinOp(MOD, node.expr1.ir, node.expr2.ir);
    }

    @Override
    public void visitAnd(And node) throws Exception {
        node.ir = irFactory.IRBinOp(AND, node.expr1.ir, node.expr2.ir);
    }

    @Override
    public void visitOr(Or node) throws Exception {
        node.ir = irFactory.IRBinOp(OR, node.expr1.ir, node.expr2.ir);
    }

    @Override
    public void visitEqual(Equal node) throws Exception {
        node.ir = irFactory.IRBinOp(EQ, node.expr1.ir, node.expr2.ir);
    }

    @Override
    public void visitNotEqual(NotEqual node) throws Exception {
        node.ir = irFactory.IRBinOp(NEQ, node.expr1.ir, node.expr2.ir);

    }

    @Override
    public void visitLessThan(LessThan node) throws Exception {
        node.ir = irFactory.IRBinOp(LT, node.expr1.ir, node.expr2.ir);
    }

    @Override
    public void visitLessEq(LessEq node) throws Exception {
        node.ir = irFactory.IRBinOp(LEQ, node.expr1.ir, node.expr2.ir);
    }

    @Override
    public void visitGreaterThan(GreaterThan node) throws Exception {
        node.ir = irFactory.IRBinOp(GT, node.expr1.ir, node.expr2.ir);
    }

    @Override
    public void visitGreaterEq(GreaterEq node) throws Exception {
        node.ir = irFactory.IRBinOp(GEQ, node.expr1.ir, node.expr2.ir);
    }

    @Override
    public void visitPrCall(ProcCallStmt node) throws Exception {
        String procName = funcNames.get(node.name);
        ArrayList<IRExpr> argsIR = new ArrayList<>();
        for (Expr arg: node.arguments){
            argsIR.add(arg.ir);
        }
        node.ir = irFactory.IRCallStmt(irFactory.IRName(procName), 0L, argsIR);
    }

    @Override
    public void visitFunCallExpr(FunCallExpr node) throws Exception {
        if (node.name == "length") {
            IRTemp len = irFactory.IRTemp(nextTemp());
            IRMove stmt = irFactory.IRMove(len, irFactory.IRBinOp(SUB, node.arguments.get(0).ir, irFactory.IRConst(8L)));
            node.ir = irFactory.IRESeq(stmt, irFactory.IRMem(len));
        } else {
            List<Expr> args = node.arguments;
            String funcName = funcNames.get(node.name);
            List<IRExpr> argsIR = new ArrayList<>();
            for(Expr e: args){
                argsIR.add(e.ir);
            }
            node.ir =  irFactory.IRCall(irFactory.IRName(funcName), argsIR);
        }
    }

    @Override
    public void visitBlockStmt(BlockStmt node) throws Exception {
        //Require: when an AST node translate to multiple IRStmts, make its ir an IRSeq
        LinkedList<IRStmt> seq = new LinkedList<>();
        for (Statement s: node.statements) {
            if (s.ir instanceof IRSeq) {
                seq.addAll(((IRSeq) s.ir).stmts());
            } else if(s.ir instanceof IRStmt) {
                seq.add((IRStmt) s.ir);
            }else{
                //the left out case is vardeclarstmt, and it should not be print
            }
        }
        node.ir = irFactory.IRSeq(seq);
    }

    @Override
    public void visitIfStmt(IfStmt node) throws Exception {
        // labelcounter for ifclause, labelcounter+1 for skip the ifclause
        //use a label counter to generate a freshlabel
        LinkedList<IRStmt> lst = new LinkedList<>();
        //first put the branch
        String trueL = nextLabel();
        String falseL = nextLabel();
        lst.add(C(node.condition.ir, trueL, falseL));
        lst.add(irFactory.IRLabel(trueL));

        if (node.clause.ir instanceof IRStmt) {
            //avoid the edge case where the stmt is a single valdeclare stmt and therefore just an irexpr
            lst.add((IRStmt) node.clause.ir);
        }
        lst.add(irFactory.IRLabel(falseL));
        node.ir = irFactory.IRSeq(lst);
    }

    @Override
    public void visitIfElseStmt(IfElseStmt node) throws Exception {
        // labelcounter for ifclause, labelcounter+1 for skip the elseclause, labelcounter+2 for the end
        LinkedList<IRStmt> lst = new LinkedList<>();
        //first put the branch
        String trueL = nextLabel();
        String falseL = nextLabel();
        String endL = nextLabel();
        lst.add(C(node.condition.ir, trueL, falseL));
        lst.add(irFactory.IRLabel(trueL));
        if(node.ifClause.ir instanceof IRStmt){
            //avoid the edge case where the stmt is a single valdeclare stmt and therefore just an irexpr
            lst.add((IRStmt) node.ifClause.ir);
        }
        lst.add(irFactory.IRJump(irFactory.IRName(endL)));
        lst.add(irFactory.IRLabel(falseL));
        if(node.elseClause.ir instanceof IRStmt){
            //avoid the edge case where the stmt is a single valdeclare stmt and therefore just an irexpr
            lst.add((IRStmt) node.ifClause.ir);
        }
        lst.add(irFactory.IRLabel(endL));
        node.ir = irFactory.IRSeq(lst);
    }

    @Override
    public void visitWhileStmt(WhileStmt node) throws Exception {
        LinkedList<IRStmt> lst = new LinkedList<>();
        String sL= nextLabel();
        String mL= nextLabel();
        String eL= nextLabel();
        lst.add(irFactory.IRLabel(sL));
        lst.add(C(node.condition.ir, mL, eL));
        lst.add(irFactory.IRLabel(mL));
        if(node.loopBody.ir instanceof IRStmt){
            lst.add((IRStmt) node.loopBody.ir);
        }
        lst.add(irFactory.IRJump(irFactory.IRName(sL)));
        lst.add(irFactory.IRLabel(eL));
        node.ir = irFactory.IRSeq(lst);
    }

    @Override
    public void visitRet(ReturnStmt node) throws Exception {
        ArrayList<IRExpr> l = new ArrayList<>();
        for (Expr e : node.returnVals) {
            l.add(e.ir);
        }
        node.ir = irFactory.IRReturn(l);
    }

    @Override
    public void visitAssign(AssignStmt node) throws Exception {
        if (node.leftVal instanceof LeftValueList) {
            //guarantee to be multiple return
            long length = funcRetLengths.get(node.expr);
            IRCall func = (IRCall) node.expr.ir;
            LinkedList<IRStmt> lst = new LinkedList<>();

            lst.add(irFactory.IRCallStmt(func.target(), length, func.args()));
            for (int i = 0; i < length; i++) {
                IRExpr e = ((LeftValueList) node.leftVal).declares.get(i).getir();
                if (e != null){
                    lst.add(irFactory.IRMove(e, irFactory.IRTemp("_RV" + i)));
                }
            }
            node.ir = irFactory.IRSeq(lst);
        } else if (node.leftVal instanceof WildCard) {
            node.ir = irFactory.IRExp(node.expr.ir);
        } else if(node.leftVal instanceof ArrIndexExpr) {
            List<IRStmt> lst = new ArrayList<>();
            IRTemp t_a = irFactory.IRTemp(nextTemp());
            IRTemp t_i = irFactory.IRTemp(nextTemp());
            lst.add(irFactory.IRMove(t_a, ((ArrIndexExpr) node.leftVal).array.ir));
            lst.add(irFactory.IRMove(t_i, ((ArrIndexExpr) node.leftVal).index.ir));
            String ok = nextLabel();
            String indexOutOfBound = nextLabel();
            lst.add(irFactory.IRCJump(
                irFactory.IRBinOp(
                    ULT,
                    t_i,
                    irFactory.IRMem(
                            irFactory.IRBinOp(
                                    SUB,
                                    t_a,
                                    irFactory.IRConst(8)
                            )
                    )
            ),
                    ok,
                    indexOutOfBound
            ));
            lst.add(irFactory.IRLabel(indexOutOfBound));
            lst.add(irFactory.IRCallStmt(irFactory.IRName("_xi_out_of_bound"), 0L, new ArrayList<>()));
            lst.add(irFactory.IRLabel(ok));
            IRMem a = irFactory.IRMem(irFactory.IRBinOp(ADD, t_a,
                    irFactory.IRBinOp(MUL, t_i, irFactory.IRConst(8))));
            lst.add(irFactory.IRMove(a, node.expr.ir));

            node.ir = irFactory.IRSeq(lst);
        } else {

            if(node.leftVal.getir() == null){
                System.out.println("left is null");
            }if(node.expr.ir == null ){
                System.out.println("expr is null");
                System.out.println(node.expr.toString());
            }

            node.ir = irFactory.IRMove(node.leftVal.getir(), node.expr.ir);
        }
    }

    @Override
    public void visitWildCard(WildCard node) {
        //no need to do anything
    }

    @Override
    public void visitVarDecl(VarDeclareStmt node) throws Exception {
        //this ir should only be use when see as Lvalue
        node.ir = irFactory.IRTemp(node.identifier);
    }

    @Override
    public void visitFunDef(FunctionDefine node) throws Exception {
        List<IRStmt> irBody = new ArrayList<>();
        List<IRStmt> saveArgs = moveArgument(node.arguments);
        irBody.addAll(saveArgs);
        irBody.add((IRStmt) node.functionBody.ir);
        String name = funcNames.get(node.name);
        node.ir = irFactory.IRFuncDecl(name, irFactory.IRSeq(irBody));
    }

    @Override
    public void visitPrDef(ProcedureDefine node) throws Exception {
        List<IRStmt> irBody = new ArrayList<>();
        List<IRStmt> saveArgs = moveArgument(node.arguments);
        irBody.addAll(saveArgs);
        irBody.add((IRStmt) node.procBody.ir);
        irBody.add(irFactory.IRReturn());

        String name = funcNames.get(node.name);
        node.ir = irFactory.IRFuncDecl(name, irFactory.IRSeq(irBody));
    }

    /** Helper function to return a irSeq object that includes arg preparation moves and IRs in function body. */
    public List<IRStmt> moveArgument(List<FunProcArgs> args){
        List<IRStmt> stmts = new ArrayList<>();
        IRTemp tar;
        IRTemp val;
        for (int i = 0; i< args.size(); i++){
            tar = irFactory.IRTemp(args.get(i).identifier);
            val = irFactory.IRTemp("_ARG" + (i + 1));
            stmts.add(i, irFactory.IRMove(tar, val));
        }
        return stmts;
    }

    @Override
    public void visitFunDecl(FunctionDeclare node) throws Exception {
        //do nothing
    }

    @Override
    public void visitPrDecl(ProcedureDeclare node) throws Exception {
        //do nothing
    }

    @Override
    public void visitFunProcArgs(FunProcArgs funProcArgs) throws Exception {
        //do nothing, see example, we only print funcname, but not args
    }

    @Override
    public void visitUse(Use node) throws Exception {
        //do nothing
    }

    @Override
    public void visitProgram(Program node) throws Exception {
        node.ir = irFactory.IRCompUnit("example");
        for (Definition d: node.definitions) {
            if (d instanceof FunctionDefine) {
                node.ir.appendFunc(((FunctionDefine) d).ir);
            } else if (d instanceof ProcedureDefine){
                node.ir.appendFunc(((ProcedureDefine) d).ir);
            }
        }
        for (IRData value : globalData.values()) {
            node.ir.appendData(value);
        }
    }

    @Override
    public void visitInterface(Interface node) throws Exception {
        //do nothing, since we don't print stuff in ixi file
    }

    @Override
    public void visitGlobDecl(GlobDeclare node) throws Exception {
        node.ir = new IRData("_" + node.identifier, exportVal(node.value));
        globalData.put(node.identifier, node.ir);
    }

    private IRStmt C(IRExpr e, String trueL, String falseL) {
        if (e instanceof IRConst) {
            if (((IRConst) e).value() == 1) {
                return irFactory.IRJump(irFactory.IRName(trueL));
            } else {
                return irFactory.IRJump(irFactory.IRName(falseL));
            }
        } else if (e instanceof IRBinOp) {
            if (((IRBinOp) e).opType() == XOR) {
                return C(((IRBinOp) e).left(), falseL, trueL);
            } else if (((IRBinOp) e).opType() == AND) {
                List<IRStmt> stmts = new ArrayList<>();
                String newTrueL = nextLabel();
                stmts.add(C(((IRBinOp) e).left(), newTrueL, falseL));
                stmts.add(irFactory.IRLabel(newTrueL));
                stmts.add(C(((IRBinOp) e).right(), trueL, falseL));
                return new IRSeq(stmts);
            } else if (((IRBinOp) e).opType() == OR) {
                List<IRStmt> stmts = new ArrayList<>();
                String newFalseL = nextLabel();
                stmts.add(C(((IRBinOp) e).left(), trueL, newFalseL));
                stmts.add(irFactory.IRLabel(newFalseL));
                stmts.add(C(((IRBinOp) e).right(), trueL, falseL));
                return new IRSeq(stmts);
            } else {
                return irFactory.IRCJump(e, trueL, falseL);
            }
        } else {
            return irFactory.IRCJump(e, trueL, falseL);
        }
    }

    /**
     * convert a IntLiteral, a BoolLiteral, or a StringLiteral to a long array, used for putting data into globalData
     * @param e the intput Expr that should be a IntLiteral, a BoolLiteral, or a StringLiteral
     * @return long array representation of e
     */
    private long[] exportVal(Expr e){
        if (e == null) {
            return new long[]{};
        } else {
            if (e instanceof IntLiteral) {
                return new long[] {((IntLiteral) e).value.longValue()};
            } else if (e instanceof BoolLiteral) {
                return new long[] {((BoolLiteral) e).value? 1L:0L};
            } else if (e instanceof StringLit) {
                String nstr = ((StringLit) e).str;
                nstr = replacespecial(nstr);
                int n = nstr.length();
//                System.out.println(nstr);
//                System.out.println(n);
                long[] result = new long[n+1];
                char[] ch= nstr.toCharArray();
                result[0] = n;
                for (int i = 0; i < n; i++) {
                    result[i+1] = ch[i];
                }
                return result;
            }
        }
        return null;
    }

    private String replacespecial(String nstr) {
        //looking at lex.jflex, there seems to be only one special case
        String result = nstr.replace("\\n", "\n");
//        result = result.replace("\\");
        return result;
    }

    private String nextLabel() {
        String result = "l"+ labelCounter;
        labelCounter++;
        return result;
    }

    private String nextTemp() {
        String result = "t"+ tempCounter;
        tempCounter++;
        return result;
    }

    private String nextString() {
        String result = "string_const" + stringCounter;
        stringCounter++;
        return result;
    }

}
