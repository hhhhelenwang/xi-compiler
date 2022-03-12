package jw795.irgenerator;

import edu.cornell.cs.cs4120.xic.ir.*;
import jw795.Visitor;
import jw795.ast.*;
import jw795.typechecker.Int;

import javax.naming.ldap.HasControls;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class IRGenerator extends Visitor {
    IRNodeFactory_c irFactory;
    HashMap<String,String> globalvar;
    LinkedList<IRData> memory;

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

    }

    @Override
    public void visitArrIndexExpr(ArrIndexExpr node) throws Exception {

    }

    @Override
    public void visitIntLiteral(IntLiteral node) {

    }

    @Override
    public void visitBoolLiteral(BoolLiteral node) {

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
        if(globalvar.containsKey(node.identifier)){
            node.ir = irFactory.IRMem(irFactory.IRName(node.identifier));
        }

    }

    @Override
    public void visitIntNeg(IntNeg node) throws Exception {

    }

    @Override
    public void visitNot(Not node) throws Exception {

    }

    @Override
    public void visitAdd(Add node) throws Exception {

    }

    @Override
    public void visitSub(Sub node) throws Exception {

    }

    @Override
    public void visitMult(Mult node) throws Exception {

    }

    @Override
    public void visitHighMult(HighMult node) throws Exception {

    }

    @Override
    public void visitDiv(Div node) throws Exception {

    }

    @Override
    public void visitMod(Mod node) throws Exception {

    }

    @Override
    public void visitAnd(And node) throws Exception {

    }

    @Override
    public void visitOr(Or node) throws Exception {

    }

    @Override
    public void visitEqual(Equal node) throws Exception {

    }

    @Override
    public void visitNotEqual(NotEqual node) throws Exception {

    }

    @Override
    public void visitLessThan(LessThan node) throws Exception {

    }

    @Override
    public void visitLessEq(LessEq node) throws Exception {

    }

    @Override
    public void visitGreaterThan(GreaterThan node) throws Exception {

    }

    @Override
    public void visitGreaterEq(GreaterEq node) throws Exception {

    }

    @Override
    public void visitPrCall(ProcCallStmt node) throws Exception {

    }

    @Override
    public void visitFunCallExpr(FunCallExpr node) throws Exception {

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
