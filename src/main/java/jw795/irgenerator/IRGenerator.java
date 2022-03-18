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
    int labelcounter;

    public IRGenerator(HashMap<String, String> funcNames, HashMap<String, Long> funcRetLengths){
        this.irFactory = new IRNodeFactory_c();
        this.funcNames = funcNames;
        this.funcRetLengths = funcRetLengths;
        this.globalVars = new HashMap<>();
        this.stringcounter = 1;
        this.labelcounter = 1;
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
        args.add(irFactory.IRConst(n * 8 + 8));
        l.add(irFactory.IRCallStmt(this.irFactory.IRName("_xi_alloc"), 1L, args)); //1L = new Long (1)
        IRTemp m = irFactory.IRTemp("_RV1");
        l.add(irFactory.IRMove(
                m,
                irFactory.IRConst(n))
        );
        for (int i = 0; i < n; i++) {
            Expr e = node.arrayElements.get(i);
            l.add(irFactory.IRMove(
                    irFactory.IRMem(
                            irFactory.IRBinOp(
                                    ADD,
                                    m,
                                    irFactory.IRConst((i + 1) * 8))),
                    e.ir));
        }
        IRSeq s = irFactory.IRSeq(l);
        IRBinOp a = irFactory.IRBinOp(ADD, m, irFactory.IRConst( 8));
        node.ir = irFactory.IRESeq(s, a);
    }

    @Override
    public void visitArrIndexExpr(ArrIndexExpr node) throws Exception {
        ArrayList<IRStmt> l = new ArrayList<>();
        IRTemp t_a = irFactory.IRTemp("t_a");
        l.add(irFactory.IRMove(t_a, node.array.ir));
        IRTemp t_i = irFactory.IRTemp("t_i");
        l.add(irFactory.IRMove(t_i, node.index.ir));
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
                "ok",
                "indexOutOfBound"
            )
        );
        l.add(irFactory.IRLabel("indexOutOfBound"));
        l.add(irFactory.IRCallStmt(this.irFactory.IRName("_xi_out_of_bound"), 0L, new ArrayList<>()));
        l.add(irFactory.IRLabel("ok"));
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
        if(node.value == true){
            node.ir = irFactory.IRConst(1);
        }else{
            node.ir = irFactory.IRConst(0);
        }
    }

    @Override
    public void visitStringLit(StringLit node) {
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
        lst.add(irFactory.IRCJump(node.condition.ir,"l"+labelcounter,"l"+(labelcounter+1)));
        lst.add(irFactory.IRLabel("l" +labelcounter));
        if(node.clause.ir instanceof IRStmt){
            //avoid the edge case where the stmt is a single valdeclare stmt and therefore just an irexpr
            lst.add((IRStmt) node.clause.ir);
        }
        lst.add(irFactory.IRLabel("l" +(labelcounter+1)));
        node.ir = irFactory.IRSeq(lst);

        labelcounter += 2;
    }

    @Override
    public void visitIfElseStmt(IfElseStmt node) throws Exception {
        // labelcounter for ifclause, labelcounter+1 for skip the elseclause, labelcounter+2 for the end
        LinkedList<IRStmt> lst = new LinkedList<>();
        //first put the branch
        lst.add(irFactory.IRCJump(node.condition.ir,"l"+labelcounter,"l"+(labelcounter+1)));
        lst.add(irFactory.IRLabel("l" +labelcounter));
        if(node.ifClause.ir instanceof IRStmt){
            //avoid the edge case where the stmt is a single valdeclare stmt and therefore just an irexpr
            lst.add((IRStmt) node.ifClause.ir);
        }
        lst.add(irFactory.IRJump(irFactory.IRName("l"+(labelcounter+2))));

        lst.add(irFactory.IRLabel("l" +(labelcounter+1)));
        if(node.elseClause.ir instanceof IRStmt){
            //avoid the edge case where the stmt is a single valdeclare stmt and therefore just an irexpr
            lst.add((IRStmt) node.ifClause.ir);
        }

        lst.add(irFactory.IRLabel("l" +(labelcounter+2)));
        node.ir = irFactory.IRSeq(lst);

        labelcounter += 3;
    }

    @Override
    public void visitWhileStmt(WhileStmt node) throws Exception {
        LinkedList<IRStmt> lst = new LinkedList<>();
        lst.add(irFactory.IRLabel("l"+labelcounter));
        lst.add(irFactory.IRCJump(node.condition.ir,"l"+(labelcounter+1),"l"+(labelcounter+2)));

        lst.add(irFactory.IRLabel("l"+(labelcounter+1)));
        if(node.loopBody.ir instanceof IRStmt){
            lst.add((IRStmt) node.loopBody.ir);
        }
        lst.add(irFactory.IRJump(irFactory.IRName("l"+labelcounter)));

        lst.add(irFactory.IRLabel("l"+(labelcounter+2)));

        node.ir = irFactory.IRSeq(lst);
        this.labelcounter +=3;
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
        if (node.leftVal instanceof LeftValueList) {
            //guarantee to be multiple return
            long length = this.funcRetLengths.get(node.expr);
            IRCall func = (IRCall) node.expr.ir;
            LinkedList<IRStmt> lst = new LinkedList<>();

            lst.add(irFactory.IRCallStmt(func.target(), length, func.args()));
            for (int i = 0; i < length; i++) {
                IRExpr e = ((LeftValueList) node.leftVal).declares.get(i).getir();
                lst.add(irFactory.IRMove(e, irFactory.IRTemp("_RV" + i)));
            }
            node.ir = irFactory.IRSeq(lst);
        } else if(node.leftVal instanceof WildCard) {
            node.ir = irFactory.IRMove(irFactory.IRTemp("_"), node.expr.ir);
        } else {
            node.ir = irFactory.IRMove(node.leftVal.getir(), node.expr.ir);
        }
    }

    @Override
    public void visitWildCard(WildCard node) {
        //no need to do anything and should not be called
    }

    @Override
    public void visitVarDecl(VarDeclareStmt node) throws Exception {
        //this ir should only be use when see as Lvalue
        node.ir = irFactory.IRTemp(node.identifier);
    }

    @Override
    public void visitFunDef(FunctionDefine node) throws Exception {
        //use abi convention to generate a name
        // also manually save args
        //TODO: use that helper function for name generating
        List<IRStmt> irBody = ((IRSeq)node.functionBody.ir).stmts();
        IRSeq bodyWithArgs = moveArgument(irBody, node.arguments);
        node.ir = irFactory.IRFuncDecl(node.name, bodyWithArgs);

    }

    @Override
    public void visitPrDef(ProcedureDefine node) throws Exception {
        List<IRStmt> irBody = ((IRSeq)node.procBody.ir).stmts();
        irBody.add(irFactory.IRReturn());
        IRSeq bodyWithArgs = moveArgument(irBody, node.arguments);
        node.ir = irFactory.IRFuncDecl(node.name, bodyWithArgs);
    }

    /** The helper function moveArgument returns irSeq including arg preparation moves and IRs in function body  */
    public IRSeq moveArgument(List<IRStmt> irBody, List<FunProcArgs> args){
        IRTemp tar;
        IRTemp val;
        for (int i = 0; i< args.size(); i++){
            tar = irFactory.IRTemp(args.get(i).identifier);
            val = irFactory.IRTemp("_ARG"+ (i+1));
            irBody.add(i, irFactory.IRMove(tar, val));
        }
        return irFactory.IRSeq(irBody);
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
            } else if (d instanceof ProcedureDefine){
                node.ir.appendFunc(((ProcedureDefine) d).ir);
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
