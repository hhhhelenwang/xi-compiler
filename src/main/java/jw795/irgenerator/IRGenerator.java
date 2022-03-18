package jw795.irgenerator;

import edu.cornell.cs.cs4120.xic.ir.*;
import jw795.Visitor;
import jw795.ast.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static edu.cornell.cs.cs4120.xic.ir.IRBinOp.OpType.*;

public class IRGenerator extends Visitor {
    IRNodeFactory_c irFactory;
    //use for global data and string
    HashMap<String,IRData> globalVars;
    //TODO: find out where to store definition of function, and also give a way to find it's return type
    //currently make it a hashmap, but should it?
    HashMap<String, String> funcNames;
    HashMap<String, Long> funcRetLengths;

    int stringcounter;

    public IRGenerator(){
        this.irFactory = new IRNodeFactory_c();
        this.globalVars = new HashMap<>();
        this.stringcounter = 1;
        this.funcNames = new HashMap<>();
        this.funcRetLengths = new HashMap<>();
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
        ArrayList<IRExpr> args = new ArrayList<>();
        long n = node.arrayElements.size();
        args.add(this.irFactory.IRConst(n * 8 + 8));
        l.add(this.irFactory.IRCallStmt(this.irFactory.IRName("_xi_alloc"), 1L, args));
        IRTemp m = this.irFactory.IRTemp("_RV1");
        l.add(this.irFactory.IRMove(
                m,
                this.irFactory.IRConst(n))
        );
        for (int i = 0; i < n; i++) {
            Expr e = node.arrayElements.get(i);
            l.add(this.irFactory.IRMove(
                    this.irFactory.IRMem(
                            this.irFactory.IRBinOp(
                                    ADD,
                                    m,
                                    this.irFactory.IRConst((i + 1) * 8))),
                    e.ir));
        }
        IRSeq s = this.irFactory.IRSeq(l);
        IRBinOp a = this.irFactory.IRBinOp(ADD, m, this.irFactory.IRConst( 8));
        node.ir = this.irFactory.IRESeq(s, a);
    }

    @Override
    public void visitArrIndexExpr(ArrIndexExpr node) throws Exception {
        ArrayList<IRStmt> l = new ArrayList<>();
        IRTemp t_a = this.irFactory.IRTemp("t_a");
        l.add(this.irFactory.IRMove(t_a, node.array.ir));
        IRTemp t_i = this.irFactory.IRTemp("t_i");
        l.add(this.irFactory.IRMove(t_i, node.index.ir));
        l.add(this.irFactory.IRCJump(
                this.irFactory.IRBinOp(
                        ULT,
                        t_i,
                        this.irFactory.IRMem(
                                this.irFactory.IRBinOp(
                                        SUB,
                                        t_a,
                                        this.irFactory.IRConst(8)
                                )
                        )
                ),
                "ok",
                "indexOutOfBound"
            )
        );
        l.add(this.irFactory.IRLabel("indexOutOfBound"));
        l.add(this.irFactory.IRCallStmt(this.irFactory.IRName("_xi_out_of_bound"), 0L, new ArrayList<>()));
        l.add(this.irFactory.IRLabel("ok"));
        IRSeq s = this.irFactory.IRSeq(l);
        IRMem a = this.irFactory.IRMem(
                this.irFactory.IRBinOp(
                        ADD,
                        t_a,
                        this.irFactory.IRBinOp(
                                MUL,
                                t_i,
                                this.irFactory.IRConst(8)
                        )
                )
        );
        node.ir = this.irFactory.IRESeq(s, a);
    }

    @Override
    public void visitIntLiteral(IntLiteral node) {
        node.ir = irFactory.IRConst(node.value.longValue());
    }

    @Override
    //1 for true and 0 for false
    public void visitBoolLiteral(BoolLiteral node) {
        if(node.value == true){
            node.ir = irFactory.IRConst(1);
        }else{
            node.ir = irFactory.IRConst(0);
        }
    }

    @Override
    public void visitStringLit(StringLit node) {
        //TODO: we also need to store it memory

        globalVars.put("string_const"+ this.stringcounter, new IRData("string_const"+this.stringcounter, exprtoval(node)));
        node.ir = irFactory.IRName("string_const"+ this.stringcounter);
        stringcounter +=1;
    }

    @Override
    public void visitCharLiteral(CharLiteral node) {
        node.ir = irFactory.IRConst(node.value);
    }

    @Override
    public void visitVar(VarExpr node) throws Exception {
        //TODO: what is memtype for this ir mem
        //I guess default type is fine
        if(globalVars.containsKey(node.identifier)){
            node.ir = irFactory.IRMem(irFactory.IRName("_" + node.identifier));
        }else{
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
        node.ir = irFactory.IRBinOp(ADD,node.expr1.ir,node.expr2.ir);

    }

    @Override
    public void visitSub(Sub node) throws Exception {
        node.ir = irFactory.IRBinOp(SUB,node.expr1.ir,node.expr2.ir);

    }

    @Override
    public void visitMult(Mult node) throws Exception {
        node.ir = irFactory.IRBinOp(MUL,node.expr1.ir,node.expr2.ir);

    }

    @Override
    public void visitHighMult(HighMult node) throws Exception {
        node.ir = irFactory.IRBinOp(HMUL,node.expr1.ir,node.expr2.ir);

    }

    @Override
    public void visitDiv(Div node) throws Exception {
        node.ir = irFactory.IRBinOp(DIV,node.expr1.ir,node.expr2.ir);

    }

    @Override
    public void visitMod(Mod node) throws Exception {
        node.ir = irFactory.IRBinOp(MOD,node.expr1.ir,node.expr2.ir);

    }

    @Override
    public void visitAnd(And node) throws Exception {
        node.ir = irFactory.IRBinOp(AND,node.expr1.ir,node.expr2.ir);

    }

    @Override
    public void visitOr(Or node) throws Exception {
        node.ir = irFactory.IRBinOp(OR,node.expr1.ir,node.expr2.ir);

    }

    @Override
    public void visitEqual(Equal node) throws Exception {
        node.ir = irFactory.IRBinOp(EQ,node.expr1.ir,node.expr2.ir);

    }

    @Override
    public void visitNotEqual(NotEqual node) throws Exception {
        node.ir = irFactory.IRBinOp(NEQ,node.expr1.ir,node.expr2.ir);

    }

    @Override
    public void visitLessThan(LessThan node) throws Exception {
        node.ir = irFactory.IRBinOp(LT,node.expr1.ir,node.expr2.ir);

    }

    @Override
    public void visitLessEq(LessEq node) throws Exception {
        node.ir = irFactory.IRBinOp(LEQ,node.expr1.ir,node.expr2.ir);

    }

    @Override
    public void visitGreaterThan(GreaterThan node) throws Exception {
        node.ir = irFactory.IRBinOp(GT,node.expr1.ir,node.expr2.ir);

    }

    @Override
    public void visitGreaterEq(GreaterEq node) throws Exception {
        node.ir = irFactory.IRBinOp(GEQ,node.expr1.ir,node.expr2.ir);

    }

    @Override
    public void visitPrCall(ProcCallStmt node) throws Exception {

    }

    @Override
    public void visitFunCallExpr(FunCallExpr node) throws Exception {
        if(node.arguments.size() == 1){
            String ret = this.funcNames.get(node.name);
            IRName name = irFactory.IRName(ret);
            node.ir = irFactory.IRCall(name,node.arguments.get(0).ir);
        }else{
            String ret = this.funcNames.get(node.name);
            IRName name = irFactory.IRName(ret);
            LinkedList<IRExpr> args = new LinkedList<>();
            long length = (long)node.arguments.size();
            for(Expr e: node.arguments){
                args.add(e.ir);
            }
            node.ir = irFactory.IRCall(name,args);
        }
    }

    @Override
    public void visitBlockStmt(BlockStmt node) throws Exception {
        //Require: when an AST node translate to multiple IRStmts, make its ir an IRSeq
        LinkedList<IRStmt> seq = new LinkedList<>();
        for (Statement s: node.statements) {
            if (s.ir instanceof IRSeq) {
                seq.addAll(((IRSeq) s.ir).stmts());
            } else {
                seq.add(s.ir);
            }
        }
        node.ir = irFactory.IRSeq(seq);
    }

    @Override
    public void visitIfStmt(IfStmt node) throws Exception {

    }

    @Override
    public void visitIfElseStmt(IfElseStmt node) throws Exception {

    }

    @Override
    public void visitWhileStmt(WhileStmt node) throws Exception {

    }

    @Override
    public void visitRet(ReturnStmt node) throws Exception {
        ArrayList<IRExpr> l = new ArrayList<>();
        for (Expr e : node.returnVals) {
            l.add(e.ir);
        }
        node.ir = this.irFactory.IRReturn(l);
    }

    @Override
    public void visitAssign(AssignStmt node) throws Exception {
        //TODO: implement array index related assign
        if(node.leftVal instanceof LeftValueList){
            //guarantee to be multiple return
            long length = this.funcRetLengths.get(node.expr);
            IRCall func = (IRCall) node.expr.ir;
            LinkedList<IRStmt> lst = new LinkedList<>();

            lst.add(irFactory.IRCallStmt(func.target(),length, func.args()));
            for(int i = 0; i< length;i++){
                IRExpr e = ((LeftValueList) node.leftVal).declares.get(i).getir();
                lst.add(irFactory.IRMove(e, irFactory.IRTemp("_RV" + i)));
            }
            node.ir = irFactory.IRSeq(lst);

        }
        else if(node.leftVal instanceof WildCard) {
            node.ir = irFactory.IRMove(irFactory.IRTemp("_"), node.expr.ir);
        } else {
            node.ir = irFactory.IRMove(node.leftVal.getir(), node.expr.ir);
        }
    }

    @Override
    public void visitWildCard(WildCard node) {

    }

    @Override
    public void visitVarDecl(VarDeclareStmt node) throws Exception {

    }

    @Override
    public void visitFunDef(FunctionDefine node) throws Exception {
        //use abi convention to generate a name
        // also manually save args
        //TODO: use that helper function for name generating
        List<IRStmt> irBody = ((IRSeq)node.functionBody.ir).stmts();
        IRSeq bodyWithArgs = moveArgument(irBody, node.arguments);
        node.ir = irFactory.IRFuncDecl(node.name,bodyWithArgs);

    }

    @Override
    public void visitPrDef(ProcedureDefine node) throws Exception {
        List<IRStmt> irBody = ((IRSeq)node.procBody.ir).stmts();
        IRSeq bodyWithArgs = moveArgument(irBody, node.arguments);
        node.ir = irFactory.IRFuncDecl(node.name,bodyWithArgs);
    }

    public IRSeq moveArgument(List<IRStmt> origin, List<FunProcArgs> args){
        IRTemp tar;
        IRTemp val;
        for (int i = 0; i< args.size();i++){
            tar = irFactory.IRTemp(args.get(i).identifier);
            val = irFactory.IRTemp("_ARG"+i);
            origin.add(i, irFactory.IRMove(tar,val));
        }
        return irFactory.IRSeq(origin);
    }

    @Override
    public void visitFunDecl(FunctionDeclare node) throws Exception {

    }

    @Override
    public void visitPrDecl(ProcedureDeclare node) throws Exception {

    }

    @Override
    public void visitFunProcArgs(FunProcArgs funProcArgs) throws Exception {
        // see example, we only print funcname, but not args
    }

    @Override
    public void visitUse(Use node) throws Exception {
        //do nothing
    }

    @Override
    public void visitProgram(Program node) throws Exception {
        //TODO: loop over memory to add static data
        node.ir = irFactory.IRCompUnit("example");
        for (Definition d: node.definitions) {
            if (d instanceof GlobDeclare) {
                node.ir.appendData(((GlobDeclare) d).ir);
            } else if (d instanceof FunctionDefine) {
                node.ir.appendFunc(((FunctionDefine) d).ir);
            }
        }
    }

    @Override
    public void visitInterface(Interface node) throws Exception {
        //do nothing, since we don't print stuff in ixi file
    }

    @Override
    public void visitGlobDecl(GlobDeclare node) throws Exception {
        this.globalVars.put(node.identifier, new IRData("_" + node.identifier, exprtoval(node.value)));
        if (node.value != null) {
            if (node.value instanceof IntLiteral) {
                long[] singleval = {((IntLiteral) node.value).value.longValue()};
                node.ir = new IRData("_" + node.identifier, singleval);
            } else if (node.value instanceof BoolLiteral) {
                if (((BoolLiteral) node.value).value) {
                    node.ir = new IRData("_" + node.identifier, new long[]{1});
                } else {
                    node.ir = new IRData("_" + node.identifier, new long[]{0});
                }
            }
        } else{
            node.ir = new IRData("_" + node.identifier, new long[]{});
        }
    }

    //TODO:implement this helper to make constant
    // int -> long
    // bool -> long
    // string -> long[]
    private long[] exprtoval(Expr e){
        return null;
    }
}
