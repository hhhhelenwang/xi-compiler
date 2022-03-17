package jw795.irgenerator;

import edu.cornell.cs.cs4120.xic.ir.*;
import jw795.Visitor;
import jw795.ast.*;
import jw795.typechecker.Int;

import javax.naming.ldap.HasControls;
import java.util.*;

import static edu.cornell.cs.cs4120.xic.ir.IRBinOp.OpType.*;

public class IRGenerator extends Visitor {
    IRNodeFactory_c irFactory;
    HashMap<String,String> globalvar;
    LinkedList<IRData> memory;
    //TODO: find out where to store definition of function, and also give a way to find it's return type
    //currently make it a hashmap, but should it?
    HashMap<String, String> funcname;
    HashMap<String, Long> funcretlength;

    public IRGenerator(){
        this.irFactory = new IRNodeFactory_c();
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
        l.add(this.irFactory.IRMove(this.irFactory.IRMem()))
        for (Expr e : node.arrayElements) {
            l.add()
        }
        IRSeq s = this.irFactory.IRSeq();
        IRBinOp a = this.irFactory.IRBinOp();
        node.ir = this.irFactory.IRESeq(s, a);
    }

    @Override
    public void visitArrIndexExpr(ArrIndexExpr node) throws Exception {

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

    }

    @Override
    public void visitCharLiteral(CharLiteral node) {

    }

    @Override
    public void visitVar(VarExpr node) throws Exception {
        //TODO: what is memtype for this ir mem
        if(globalvar.containsKey("_" + node.identifier)){
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
            String ret = this.funcname.get(node.name);
            IRName name = irFactory.IRName(ret);
            node.ir = irFactory.IRCall(name,node.arguments.get(0).ir);
        }else{
            String ret = this.funcname.get(node.name);
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

    }

    @Override
    public void visitAssign(AssignStmt node) throws Exception {

        if (node.leftVal instanceof LeftValueList) {//_ = e;
//            long length = this.funcretlength.get(node.expr.);
//            IRCallStmt firstst = node.expr.ir;
//            node.ir = irFactory.IRCallStmt(funaddr, );
        } else if(node.leftVal instanceof WildCard) {
            node.ir = irFactory.IRMove(irFactory.IRTemp("_"), node.expr.ir);
        } else {

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

    }

    @Override
    public void visitUse(Use node) throws Exception {

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

    }

    @Override
    public void visitGlobDecl(GlobDeclare node) throws Exception {
        this.globalvar.put(node.identifier, "_" + node.identifier);
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
        this.memory.add(node.ir);
    }
}
