package jw795.typechecker;

import jw795.ast.*;

import java.util.ArrayList;
import java.util.List;

public class TypeChecker extends Visitor{

    private SymbolTable env;

    @Override
    public void enterScope() {
        env.enterScope();
    }

    @Override
    public void leaveScope() {
        env.leaveScope();
    }

    TypeChecker(){
        this.env = new SymbolTable();
    }

    // ================================= Visit functions for Expressions =================================
    @Override
    // TODO: naming a bit confusing, can confuse with an int type keyword
    public void visitIntLiteral(IntLiteral node) {
        node.type = new Int();
    }

    @Override
    public void visitBoolLiteral(BoolLiteral node) {
        node.type = new Bool();
    }

    @Override
    public void visitStringLit(StringLit node) { node.type = new TypedArray(new Int()); }

    @Override
    public void visitCharLiteral(CharLiteral node) {
            node.type = new Int();
    }

    // there should not be any exception throw out from the upper 4 function, since they are basic type


    @Override
    public void visitFunCallExpr(FunCallExpr node) throws Exception {
        Sigma fnType = this.env.findType(node.name);
        if(!(fnType instanceof Fn)){
            String errmes = node.getLine() + ":" + node.getCol() +"error:" ;
            errmes = errmes + node.name + " is not a function";
            throw new Exception(errmes);
        }
        else if(!(((Fn) fnType).outputType instanceof Unit)){
            if (node.name.equals("length")) {
                checkLength(node);
            } else { //f(), f(e), f(e1, ..., en)
                List<Expr> nodeArgs = node.arguments;
                T declArgs = ((Fn) fnType).inputType;
                if (argsConform(nodeArgs, declArgs)){ //e1:tau, e2:tau ..
                    node.type = ((Fn) fnType).outputType;
                }
            }
        }
        if(node.type == null){
            //this is the case when argument type does not match
            String errmes = errorstart(node.getLine(), node.getCol()) + "Expected ";
            errmes += ((Fn) fnType).inputType.tostr();
            errmes += ", but got ";
            for(Expr e: node.arguments){
                e.type.tostr();
            }
            throw new Exception(errmes);
        }
    }


    /** Type check the function call of length(e) function */
    //this function'error will be handle by the more general function call
    private void checkLength(FunCallExpr node){
        if((node.arguments.size() == 1)) {
            Expr arg =node.arguments.get(0);
            if(arg instanceof VarExpr){
                if(this.env.findType(((VarExpr) arg).identifier) instanceof TypedArray){
                    node.type = new Int();
                }
            }
        }
    }

    @Override
    public void visitVar(VarExpr node) throws Exception {
        if (env.contains(node.identifier)) {
            node.type = (T) env.findType(node.identifier);
        }
        else {
            String res = errorstart(node.getLine(), node.getCol());
            res += "Name " + node.identifier + " cannot be resolved";
            throw new Exception(res);
        }
    }

    @Override
    public void visitIntNeg(IntNeg node) throws Exception {
        if (node.expr.type instanceof Int) {
            node.type = new Int();
        } else {
            String res = errorstart(node.getLine(), node.getCol());
            res += "Int negation cannot be apply to" + node.expr.type.tostr();
            throw new Exception(res);
        }
    }

    /** helper to check the type of the subexpressions of algebraic and comparison binop */
    private void setBinOpIntType(BinOpExpr node) {
        if ((node.expr1.type instanceof Int) && (node.expr2.type instanceof Int)) {
            node.type = new Int();
        }
    }

    /** helper to check the type of the subexpressions of logical binop */
    private void setBinOpBoolType(BinOpExpr node) {
        if ((node.expr1.type instanceof Bool) && (node.expr2.type instanceof Bool)) {
            node.type = new Bool();
        }
    }
    private void setArrayBoolType(BinOpExpr node){
        if(node.expr1.type instanceof  Tau){
            if(node.expr2.type instanceof  Tau) {
                if (((Tau) node.expr1.type).equals(node.expr2.type)) {
                    node.type = new Bool();
                }
            }
        }
    }

    @Override
    public void visitAdd(Add node) throws Exception {
        setBinOpIntType(node);
        setArrayBoolType(node);

        if(node.type == null) {
            String result = errorstart(node.getLine(), node.getCol());
            result += "Operand of + must be same type of tau";
            throw new Exception(result);
        }
    }

    @Override
    public void visitSub(Sub node) throws Exception {
        setBinOpIntType(node);
        errrorint("-", node);
    }

    @Override
    public void visitMult(Mult node) throws Exception {
        setBinOpIntType(node);
        errrorint("*", node);
    }

    @Override
    public void visitHighMult(HighMult node) throws Exception {
        setBinOpIntType(node);
        errrorint("*>>", node);
    }

    @Override
    public void visitDiv(Div node) throws Exception {
        setBinOpIntType(node);
        errrorint("//", node);
    }

    @Override
    public void visitMod(Mod node) throws Exception {
        setBinOpIntType(node);
        errrorint("%", node);
    }

    @Override
    public void visitAnd(And node) throws Exception {
        setBinOpBoolType(node);
        errrorbool("&", node);
    }

    @Override
    public void visitOr(Or node) throws Exception {
        setBinOpBoolType(node);
        errrorbool("|", node);
    }

    @Override
    public void visitEqual(Equal node) throws Exception {
        setBinOpIntType(node);
        setBinOpBoolType(node);
        setArrayBoolType(node);

        if(node.type == null) {
            String result = errorstart(node.getLine(), node.getCol());
            result += "Operands of = must be same type of tau";
            throw new Exception(result);
        }

    }

    @Override
    public void visitNotEqual(NotEqual node) throws Exception {
        setBinOpIntType(node);
        setBinOpBoolType(node);
        setArrayBoolType(node);

        if(node.type == null) {
            String result = errorstart(node.getLine(), node.getCol());
            result += "Operands of != must be same type of tau";
            throw new Exception(result);
        }
    }

    @Override
    public void visitLessThan(LessThan node) throws Exception {
        setBinOpIntType(node);
        errrorint("<", node);

    }

    @Override
    public void visitLessEq(LessEq node) throws Exception {
        setBinOpIntType(node);
        errrorint("<=", node);
    }

    @Override
    public void visitGreaterThan(GreaterThan node) throws Exception {
        setBinOpIntType(node);
        errrorint(">", node);
    }

    @Override
    public void visitGreaterEq(GreaterEq node) throws Exception {
        setBinOpIntType(node);
        errrorint(">=", node);
    }

    @Override
    public void visitArrayExpr(ArrayExpr node) throws Exception {
        if (node.arrayElements.isEmpty()) {
            node.type = new EmptyArray();
        } else {
            T t = node.arrayElements.get(0).type;
            boolean validArray = true;
            for (Expr e: node.arrayElements) {
                T et = e.type;
                if (!(et instanceof Tau)) {
                    validArray = false;
                    break;
                } else if (((Tau) et).equals((Tau) t)) {
                    if (et instanceof Array) {
                        if (((Array)t).compare((Array)et)) {
                            t = et;
                        }
                    }
                } else {
                    validArray = false;
                    break;
                }
            }
            if (validArray) {
                node.type = new TypedArray((Tau)t);
            }else{
                String res = errorstart(node.getLine(), node.getCol());
                throw new Exception(res + "The elements of this array have different types");
            }
        }
    }

    @Override
    public void visitArrIndexExpr(ArrIndexExpr node) throws Exception {
        if (node.array.type instanceof TypedArray && node.index.type instanceof Int) {
            node.type = ((TypedArray) node.array.type).elementType;
        } else if (node.array.type instanceof EmptyArray && node.index.type instanceof Int) {
            node.type = new Unit();
        }else if(! (node.index.type instanceof Int)){
            String res = errorstart(node.getLine(), node.getCol());
            throw new Exception(res + "Expected index as int but got"+ node.index.type.tostr());
        }else{
            String res = errorstart(node.getLine(), node.getCol());
            throw  new Exception(res + "Expected an array for indedxing but got "+ node.array.type);
        }
    }

    @Override
    public void visitNot(Not node) throws Exception {
        if(node.expr.type instanceof Bool){
            node.type = new Bool();
        }
        if(node.type == null) {
            String result = errorstart(node.getLine(), node.getCol());
            result += "bool negation cannot be applied " + node.expr.type.tostr();
            throw new Exception(result);
        }

    }

    // ================================= Visit functions for Statements =================================
    @Override
    public void visitPrCall(ProcCallStmt node) {
        // a procedure need to be fn T -> unit
        Sigma prType = this.env.findType(node.name);
        if(prType instanceof Fn && ((Fn) prType).outputType instanceof Unit){
            List<Expr> nodeArgs = node.arguments;
            T declArgs = ((Fn) prType).inputType;
            if (argsConform(nodeArgs, declArgs)){ //e1:tau, e2:tau ..
                node.type = new Unit();
            }
        }
    }

    @Override
    public void visitBlockStmt(BlockStmt node) {
        int numArgs = node.statements.size();
        boolean stmtTypeChecked = true;
        for (int i = 0; i < numArgs - 1; i++){
            if (!(node.statements.get(i).type instanceof Unit)){
                stmtTypeChecked = false;
            }
        }
        Statement lastStmt = node.statements.get(numArgs - 1);
        if (stmtTypeChecked && lastStmt.type instanceof R){
            node.type = lastStmt.type;
        }
    }


    @Override
    public void visitIfStmt(IfStmt node) {
        if (node.condition.type instanceof Bool && node.clause.type instanceof R) {
            node.type = new Unit();
        } else if (!(node.condition.type instanceof Bool)){

        }
    }

    @Override
    public void visitIfElseStmt(IfElseStmt node) {
        if (node.condition.type instanceof Bool && node.ifClause.type instanceof R && node.elseClause.type instanceof R)
        {
            node.type = lub(node.ifClause.type, node.elseClause.type);
        }
    }

    /** Function lub is defined as spec: lub(R, R) = R, lub(unit, R) = lub(R, unit) = unit */
    private R lub(R r1, R r2) {
        if (r1 instanceof Unit || r2 instanceof Unit){
            return new Unit();
        } else {
            return r1;
        }
    }

    @Override
    public void visitWhileStmt(WhileStmt node) {
        if (node.condition.type instanceof Bool && node.loopBody.type instanceof R){
            node.type = new Unit();
        }
    }

    /** helper to check the types of arg passed in match the signature of declaration correspondingly */
    private boolean argsConform(List<Expr> nodeArgs, T declArgs){
        boolean valid = false;
        if (declArgs instanceof Unit && nodeArgs.size() == 0) {
            valid = true;
        } else if (declArgs instanceof Tau && nodeArgs.size() == 1){
            valid = declArgs.equals(nodeArgs.get(0).type);
        } else if (declArgs instanceof Prod && nodeArgs.size() == ((Prod) declArgs).elementTypes.size()){
            valid = true;
            for (int i = 0; i < nodeArgs.size(); i++){
                Tau declArg = ((Prod) declArgs).elementTypes.get(i);
                Expr nodeArg = nodeArgs.get(i);
                if (!declArg.equals(nodeArg)){
                    valid = false;
                }
            }
        }
        return valid;
    }



    @Override
    public void visitRet(ReturnStmt node) {
        boolean isvalid =true;
        Sigma retarg = this.env.findType("return");
        if(retarg instanceof  Prod){
            if (((Prod) retarg).elementTypes.size() == node.returnVals.size() ){
                for (int i =0; i < node.returnVals.size(); i++){
                    if(! ((Prod) retarg).elementTypes.get(i).equals(node.returnVals.get(i))){
                        isvalid = false;
                    }
                }
            }
        }
        if(isvalid){
            node.type = new Void();
        }
    }

    @Override
    public void visitAssign(AssignStmt node) {
        // TODO:
        //  x = e,
        //  e1[e2] = e2,
        //  x:tau = e,
        //  _ = e -> done
        //  d1...dn = e
        if (node.leftVal instanceof WildCard) {
            checkExprStmt(node);
        } else if (node.leftVal instanceof LeftValueList) {
            checkMultiAssign(node);
        } else if (node.leftVal instanceof VarExpr) {
            Sigma t = this.env.findType(((VarExpr) node.leftVal).identifier);
            if (t instanceof Var) {
                if (node.expr.type instanceof Tau) {
                    if (((Var) t).varType.equals((Tau)(node.expr.type))) {
                        node.type = new Unit();
                    }
                }
            }
        } else if (node.leftVal instanceof ArrIndexExpr) {
            if (node.expr.type instanceof Tau) {
                if (((ArrIndexExpr) node.leftVal).type.equals(node.expr.type)) {
                    node.type = new Unit();
                }
            }

        }
        // TODO: leave scope here?
    }

    @Override
    public void visitWildCard(WildCard node) {
        node.type = new Unit();
    }

    /** Type check _ = e */
    private void checkExprStmt(AssignStmt node) {
        if (node.expr.type instanceof Tau) {
            node.type = new Unit();
        }
    }

    /** Type check multiple assignment statement d1, d2, ..., dn = e
     * Requires:
     * - node is a multiple assign statement (check in visitAssign) so must contain a LeftValueList
     * - contains a list of declarations or wildcards on the left, checked in parsing
     * - a function call on the right, checked in parsing
     */
    private void checkMultiAssign(AssignStmt node) {
        boolean typeChecks = true;
        List<LValue> declares = ((LeftValueList) node.leftVal).declares;
        List<Tau> returnTypes = ((Prod) node.expr.type).elementTypes;
        if (declares.size() != returnTypes.size()) {
            typeChecks = false;
            // TODO: error, assignment mismatch
        } else {
            for (int i = 0; i < declares.size(); i ++) {

            }
        }



    }


    @Override
    public void visitVarDecl(VarDeclareStmt node) {
        // TODO: x:tau, x:tau[]
        if (node.varType instanceof ArrayType) { // check array declaration
            checkArrayDecl(node);
        } else { // TODO: is it safe to use else here
            if (!env.contains(node.identifier)) {
                node.type = new Unit();
                env.add(node.identifier, new Var(typeToTau(node.varType)));
            }
            // TODO: else
        }
    }

    /** Type check array declaration x:tau[e1][e2]...[en][]...[], allow n = 0.
     *  Requires:
     *  - node is an array declaration (check when calling this method in visitVarDecl),
     *  - all dimensions are specified to the left-most (checked at parsing),
     */
    public void checkArrayDecl(VarDeclareStmt node) {
        String id = node.identifier;
        ArrayType arrType = (ArrayType) node.varType;
        boolean typeChecks = true;
        if (env.contains(id)) {
            // TODO: error: id is already declared
            typeChecks = false;
        } else {
            Type next = arrType;
            // check type
            while (next instanceof ArrayType) {
                // if dim is defined for this level
                boolean hasDim = ((ArrayType) next).length.isPresent();
                if (hasDim) {
                    XiType dimType = ((ArrayType) next).length.get().type;
                    if (!(dimType instanceof Int)) {
                        // TODO: error: expected Int, got <dimType>
                        typeChecks = false;
                        break;
                    }
                    next = ((ArrayType) next).elemType;
                }
            }
        }
        // if typeChecks, build an array type with m + n levels and primitive type = next
        if (typeChecks) {
            Tau type = typeToTau(arrType);
            env.add(id, new Var(type));
        }
    }

    @Override
    public void visitFundef(FunctionDefine node){
        T input;
        T output;
        if(node.arguments.size() == 0){
            input = new Unit();
        }else if(node.arguments.size() == 1){
            input =  node.arguments.get(0).type;
        }else{
            List<Tau> eletype= new ArrayList<>();
            for(FunProcArgs fp: node.arguments){
                eletype.add(fp.type);
            }
            input = new Prod(eletype);
        }

        if(node.returnTypes.size() == 0){
            output =new Unit();
        }else if(node.returnTypes.size() == 1){
            output = typeToTau(node.returnTypes.get(0)) ;
        }else{
            List<Tau> rettype= new ArrayList<>();
            for(Type e: node.returnTypes){
                rettype.add(typeToTau(e));
            }
            output = new Prod(rettype);
        }

        Fn thetype = new Fn(input, output);
        this.env.add(node.name, thetype);

        this.env.leaveScope();
    }

    @Override
    public void visitPrdef(ProcedureDefine node){
        T input;
        T output;
        if(node.arguments.size() == 0){
            input = new Unit();
        }else if(node.arguments.size() == 1){
            input =  node.arguments.get(0).type;
        }else{
            List<Tau> eletype= new ArrayList<>();
            for(FunProcArgs fp: node.arguments){
                eletype.add(fp.type);
            }
            input = new Prod(eletype);
        }

        Fn thetype = new Fn(input, new Unit());
        this.env.add(node.name, thetype);

        this.env.leaveScope();
    }


    /** Build a Tau type from a Type AST node. */
    private Tau typeToTau(Type t){
        if (t instanceof IntType){
            return new Int();
        }
        else if (t instanceof BoolType){
            return new Bool();
        }
        else if (t instanceof ArrayType){
            if (((ArrayType) t).elemType == null){
                return new EmptyArray();
            }else{
                return new TypedArray(typeToTau(((ArrayType) t).elemType));
            }
        }
        return null;
    }

    private String errorstart(int line, int colmn){
        return (line + ":" + colmn +"error:" );
    }
    private void errrorint (String operands, BinOpExpr node) throws Exception {
        if(node.type == null) {
            String result = errorstart(node.getLine(), node.getCol());
            result += "Operands of " + operands+ " must be int";
            throw new Exception(result);
        }

    }
    private void errrorbool (String operands, BinOpExpr node) throws Exception {
        if(node.type == null) {
            String result = errorstart(node.getLine(), node.getCol());
            result += "Operands of " + operands+ " must be bool";
            throw new Exception(result);
        }
    }

}
