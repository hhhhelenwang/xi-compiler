package jw795.typechecker;

import jw795.ast.*;
import util.SemanticErrorException;

import java.util.*;

public class TypeChecker extends Visitor{

    public SymbolTable env;
//    private HashMap<String, Interface> deps;

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
    public void visitVar(VarExpr node) throws SemanticErrorException {
        if (env.containsVar(node.identifier)) {
            node.type = ((Var) env.findTypeofVar(node.identifier)).varType;
        }
        else {
            String res = errorstart(node.getLine(), node.getCol());
            res += "Name " + node.identifier + " cannot be resolved";
            throw new SemanticErrorException(res);
        }
    }

    // UnOps =================================
    @Override
    public void visitIntNeg(IntNeg node) throws SemanticErrorException {
        if (node.expr.type instanceof Int) {
            node.type = new Int();
        } else {
            String res = errorstart(node.getLine(), node.getCol());
            res += "Expected int, but fount " + node.expr.type.toStr();
            throw new SemanticErrorException(res);
        }
    }

    @Override
    public void visitNot(Not node) throws SemanticErrorException {
        if(node.expr.type instanceof Bool){
            node.type = new Bool();
        } else {
            String res = errorstart(node.getLine(), node.getCol());
            res += "Expected bool, but fount " + node.expr.type.toStr();
            throw new SemanticErrorException(res);
        }
    }

    // BinOps =================================
    /** helper to check the type of the subexpressions of algebraic and int comparison binop */
    private void setBinOpIntType(BinOpExpr node, Tau type) throws SemanticErrorException{
        if ((node.expr1.type instanceof Int) && (node.expr2.type instanceof Int)) {
            node.type = type;
        } else if (!(node.expr1.type instanceof Int)) {
            String pos = errorstart(node.expr1.getLine(), node.expr1.getCol());
            throw new SemanticErrorException(pos + "Expected int, but found " + node.expr1.type.toStr());
        } else {
            String pos = errorstart(node.expr2.getLine(), node.expr2.getCol());
            throw new SemanticErrorException(pos + "Expected int, but found " + node.expr2.type.toStr());
        }
    }

    /** helper to check the type of the subexpressions of logical binop */
    private void setBinOpBoolType(BinOpExpr node) throws SemanticErrorException {
        if ((node.expr1.type instanceof Bool) && (node.expr2.type instanceof Bool)) {
            node.type = new Bool();
        } else if (!(node.expr1.type instanceof Bool)) {
            String pos = errorstart(node.expr1.getLine(), node.expr1.getCol());
            throw new SemanticErrorException(pos + "Expected bool, but found " + node.expr1.type.toStr());
        } else {
            String pos = errorstart(node.expr2.getLine(), node.expr2.getCol());
            throw new SemanticErrorException(pos + "Expected bool, but found " + node.expr2.type.toStr());
        }
    }

    /** Helper to check the type of two array expressions are equal when they are compared.
     * If true, set node to bool type. */
    private void setArrayCompareType(BinOpExpr node) throws SemanticErrorException {
        if (!(node.expr2.type instanceof Array)) {
            String pos = errorstart(node.expr2.getLine(), node.expr2.getCol());
            throw new SemanticErrorException(pos
                    + "Expected " + node.expr1.type.toStr()
                    + ", but found " + node.expr2.type.toStr());
        }
        if (((Array) node.expr1.type).compare((Array) node.expr2.type)
                || ((Array) node.expr2.type).compare((Array) node.expr1.type)) {
            // t1 <= t2 or t2 <= t1 so they can be compared
            node.type = new Bool();
        } else {
            // t1 != t2
            String pos = errorstart(node.expr2.getLine(), node.expr2.getCol());
            throw new SemanticErrorException(pos
                    + "Expected " + node.expr1.type.toStr()
                    + ", but found " + node.expr2.type.toStr());
        }
    }

    /** Helper to check the type of two array expressions are equal when they are concatenated.
     * If true, set node to the more restrictive array type between the two. */
    private void setArrayConcateType(BinOpExpr node) throws SemanticErrorException {
        // if the operand 2 is not an array then no
        if (!(node.expr2.type instanceof Array)) {
            String pos = errorstart(node.expr2.getLine(), node.expr2.getCol());
            throw new SemanticErrorException(pos
                    + "Expected " + node.expr1.type.toStr()
                    + ", but found " + node.expr2.type.toStr());
        }
        // now that they are both arrays
        if (((Array) node.expr1.type).compare((Array) node.expr2.type)) {
            // t1 <= t2 so assign t2
            node.type = node.expr2.type;
        } else if (((Array) node.expr2.type).compare((Array) node.expr1.type)) {
            // t2 <= t1
            node.type = node.expr1.type;
        } else {
            // t1 != t2
            String pos = errorstart(node.expr2.getLine(), node.expr2.getCol());
            throw new SemanticErrorException(pos
                    + "Expected " + node.expr1.type.toStr()
                    + ", but found " + node.expr2.type.toStr());
        }
    }

    @Override
    public void visitAdd(Add node) throws SemanticErrorException {
        // add allows both int and array as operands
        // if the first operand is an int, treat it as an integer add
        if (node.expr1.type instanceof Int) {
            setBinOpIntType(node, new Int());
        } else if (node.expr1.type instanceof Array){
            // if the first operand is an array, check for array concatenation
            setArrayConcateType(node);
        } else {
            // definitely cannot add on operand 1 now so report!
            String pos = errorstart(node.expr1.getLine(), node.expr1.getCol());
            String err = pos + "Operand of + must be int or array";
            throw new SemanticErrorException(err);
        }
    }

    @Override
    public void visitSub(Sub node) throws SemanticErrorException {
        setBinOpIntType(node, new Int());
    }

    @Override
    public void visitMult(Mult node) throws SemanticErrorException {
        setBinOpIntType(node, new Int());
    }

    @Override
    public void visitHighMult(HighMult node) throws SemanticErrorException {
        setBinOpIntType(node, new Int());
    }

    @Override
    public void visitDiv(Div node) throws SemanticErrorException {
        setBinOpIntType(node, new Int());
    }

    @Override
    public void visitMod(Mod node) throws SemanticErrorException {
        setBinOpIntType(node, new Int());
    }

    @Override
    public void visitAnd(And node) throws SemanticErrorException {
        setBinOpBoolType(node);
    }

    @Override
    public void visitOr(Or node) throws SemanticErrorException {
        setBinOpBoolType(node);
    }

    /** */
    private void checkEqCompareBinOp(BinOpExpr node) throws SemanticErrorException {
        // eq/neq allows int, bool, and array as operands
        // if the first operand is an int, treat it as an integer comparison
        if (node.expr1.type instanceof Int) {
            setBinOpIntType(node, new Bool());
        } else if (node.expr1.type instanceof Bool){
            // if the first operand is a bool, check for boolean comparison
            setBinOpBoolType(node);
        } else if (node.expr1.type instanceof Array){
            System.out.println("equal at line");
            // if the first operand is an array, check for array concatenation
            setArrayCompareType(node);
        } else {
            // definitely cannot add on operand 1 now so report!
            String pos = errorstart(node.expr1.getLine(), node.expr1.getCol());
            String err = pos + "Operand of == must be int, bool, or array";
            throw new SemanticErrorException(err);
        }
    }

    @Override
    public void visitEqual(Equal node) throws SemanticErrorException {
        checkEqCompareBinOp(node);
    }

    @Override
    public void visitNotEqual(NotEqual node) throws SemanticErrorException {
        checkEqCompareBinOp(node);
    }

    @Override
    public void visitLessThan(LessThan node) throws SemanticErrorException {
        setBinOpIntType(node, new Bool());
    }

    @Override
    public void visitLessEq(LessEq node) throws SemanticErrorException {
        setBinOpIntType(node, new Bool());
    }

    @Override
    public void visitGreaterThan(GreaterThan node) throws SemanticErrorException {
        setBinOpIntType(node, new Bool());
    }

    @Override
    public void visitGreaterEq(GreaterEq node) throws SemanticErrorException {
        setBinOpIntType(node, new Bool());
    }

    @Override
    public void visitArrayExpr(ArrayExpr node) throws SemanticErrorException {
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
                } else if ((et).equals(t)) {
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
                throw new SemanticErrorException(res + "The elements of this array have different types");
            }
        }
    }

    @Override
    public void visitArrIndexExpr(ArrIndexExpr node) throws SemanticErrorException {
        if (node.array.type instanceof TypedArray && node.index.type instanceof Int) {
            node.type = ((TypedArray) node.array.type).elementType;
        } else if (node.array.type instanceof EmptyArray && node.index.type instanceof Int) {
            node.type = new Unit();
        }else if(! (node.index.type instanceof Int)){
            String res = errorstart(node.getLine(), node.getCol());
            throw new SemanticErrorException(res + "Expected index as int but got"+ node.index.type.toStr());
        }else{
            String res = errorstart(node.getLine(), node.getCol());
            throw  new SemanticErrorException(res + "Expected an array for indedxing but got "+ node.array.type);
        }
    }


    // ================================= Visit functions for Statements =================================
    @Override
    public void visitPrCall(ProcCallStmt node) throws SemanticErrorException {
        // a procedure need to be fn T -> unit
        Sigma prType = this.env.findTypeofFun(node.name);
        if(prType == null){
            String errorMsg = errorstart(node.getLine(), node.getCol());
            errorMsg += "Name " + node.name + " cannot be resolved";
            throw new SemanticErrorException(errorMsg);
        }
        try {
            proFunCall(false, prType, node.name);
        } catch (Exception e) {
            String errorMsg = errorstart(node.getLine(), node.getCol()) + e.getMessage();
            throw new SemanticErrorException(errorMsg);
        }
        List<Expr> nodeArgs = node.arguments;
        T declArgs = ((Fn) prType).inputType;
        // argsConform throws SemanticErrorException if there is a mismatch
        if (argsConform(nodeArgs, declArgs)) {
            node.type = new Unit();
        }

    }

    @Override
    public void visitFunCallExpr(FunCallExpr node) throws SemanticErrorException {
        // special case for length
        if (node.name.equals("length"))  {
            checkLength(node);
        } else {
            Sigma fnType = this.env.findTypeofFun(node.name);
            // check function types
            if(fnType == null){
                String errorMsg = errorstart(node.getLine(), node.getCol());
                errorMsg += "Name " + node.name + " cannot be resolved";
                throw new SemanticErrorException(errorMsg);
            }
            try {
                proFunCall(true, fnType, node.name);
            } catch (Exception e) {
                String errorMsg = errorstart(node.getLine(), node.getCol()) + e.getMessage();
                throw new SemanticErrorException(errorMsg);
            }
            List<Expr> nodeArgs = node.arguments;
            T declArgs = ((Fn) fnType).inputType;
            // check for argument types, argsConform throws SemanticErrorException if premise fails
            if (argsConform(nodeArgs, declArgs)) {
                node.type = ((Fn) fnType).outputType;
            }
        }
    }

    /** Type check the function call of length(e) function */
    private void checkLength(FunCallExpr node) throws SemanticErrorException {
        if (node.arguments.size() != 1) {
            String pos = errorstart(node.getLine(), node.getCol());
            throw new SemanticErrorException(pos + "Mismatched number of arguments");
        }
        Expr arg = node.arguments.get(0);
        if (arg.type instanceof Array) { // type checks as long as
            node.type = new Int();
        } else {
            String pos = errorstart(node.getLine(), node.getCol());
            throw new SemanticErrorException(pos + "Expected an array, but found " + arg.type.toStr());
        }
    }

    /** Checks if the types of arg passed in match the signature of declaration correspondingly*/
    private boolean argsConform(List<Expr> nodeArgs, T declArgs) throws SemanticErrorException {
        if (declArgs instanceof Unit && nodeArgs.size() == 0) {
            return true;
        } else if (declArgs instanceof Tau && nodeArgs.size() == 1){
            if ((declArgs).equals(nodeArgs.get(0).type)) {
                return true;
            } else {
                String pos = errorstart(nodeArgs.get(0).getLine(), nodeArgs.get(0).getCol());
                String errMsg = pos + "Expected "+ declArgs.toStr() + ", but found " +
                        nodeArgs.get(0).type.toStr();
                throw new SemanticErrorException(errMsg);
            }
        } else if (declArgs instanceof Prod && nodeArgs.size() == ((Prod) declArgs).elementTypes.size()){
            for (int i = 0; i < nodeArgs.size(); i++){
                Tau declArg = ((Prod) declArgs).elementTypes.get(i);
                Expr nodeArg = nodeArgs.get(i);
                if (nodeArg.type instanceof Tau) {
                    if (!declArg.equals(nodeArg.type)){ // NOTE: checked that nodeArg is a Tau type
                        String pos = errorstart(nodeArg.getLine(), nodeArg.getCol());
                        String errMsg = pos + "Expected "+ declArg.toStr() + ", but found " +
                                nodeArg.type.toStr();
                        throw new SemanticErrorException(errMsg);
                    }
                } else {
                    String pos = errorstart(nodeArg.getLine(), nodeArg.getCol());
                    String errMsg = pos + "Expected "+ declArg.toStr() + ", but found " +
                            nodeArg.type.toStr();
                    throw new SemanticErrorException(errMsg);
                }
            }
            return true;
        }
        // number mismatch
        String errMsg = "Mismatched number of arguments";
        String pos = errorstart(nodeArgs.get(0).getLine(), nodeArgs.get(0).getCol());
        throw new SemanticErrorException(pos + errMsg);
    }

    /** Helper for visitProCall and visitFunCall. It checks 1) f is type fn 2) outputType is correct */
    private void proFunCall(boolean isFun, Sigma prFnType, String fnPrName) throws Exception{
        if(!(prFnType instanceof Fn)){
            String errorMsg = "Expected a function or procedure call, but found " + prFnType.toStr();
            throw new Exception(errorMsg);
        } else if(!isFun && !(((Fn) prFnType).outputType instanceof Unit)) {
            String errorMsg = fnPrName + " is not a procedure";
            throw new Exception(errorMsg);
        } else if (isFun && ((Fn) prFnType).outputType instanceof Unit){
            String errorMsg = fnPrName + " is not a function";
            throw new Exception(errorMsg);
        }
    }

    @Override
    public void visitBlockStmt(BlockStmt node) throws SemanticErrorException {
        int numArgs = node.statements.size();
        for (int i = 0; i < numArgs - 1; i++){
            Statement stmt = node.statements.get(i);
            if (!(stmt.type instanceof Unit)){
                String errorMsg =  errorstart(stmt.getLine(), stmt.getCol()) +
                        "Expected unit, but found void.";
                throw new SemanticErrorException(errorMsg);
            }
        }
        if(numArgs == 0){
            node.type = new Unit();
        }else{
            Statement lastStmt = node.statements.get(numArgs - 1);
            node.type = lastStmt.type;
        }
    }

    @Override
    public void visitIfStmt(IfStmt node) throws SemanticErrorException {
        if (!(node.condition.type instanceof Bool)) {
            String errorMsg = errorstart(node.getLine(), node.getCol()) + "Expected condition is type Bool, but got" +
                    node.condition.type.toStr();
            throw new SemanticErrorException(errorMsg);
        } else {
            node.type = new Unit();
        }
    }

    @Override
    public void visitIfElseStmt(IfElseStmt node) throws SemanticErrorException {
        if (!(node.condition.type instanceof Bool)){
            String errorMsg = errorstart(node.getLine(), node.getCol()) + "Expected condition is type Bool, but got" +
                    node.condition.type.toStr();
            throw new SemanticErrorException(errorMsg);
        } else {
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
    public void visitWhileStmt(WhileStmt node) throws SemanticErrorException {
        if (!(node.condition.type instanceof Bool)){
            String errorMsg = errorstart(node.getLine(), node.getCol()) + "Expected condition is type Bool, but got" +
                    node.condition.type.toStr();
            throw new SemanticErrorException(errorMsg);
        } else {
            node.type = new Unit();
        }
    }


    @Override
    public void visitRet(ReturnStmt node) throws SemanticErrorException {
        boolean isvalid =false;
        T retarg = ((Ret)this.env.findTypeofVar("return")).retType; // variable with id return can only be type Ret

        if(retarg instanceof Prod){
            isvalid = true;
            if (((Prod) retarg).elementTypes.size() == node.returnVals.size() ){
                for (int i =0; i < node.returnVals.size(); i++){
                    if(! ((Prod) retarg).elementTypes.get(i).equals(node.returnVals.get(i).type)){
                        isvalid = false;
                    }
                }
            }
        }else if(retarg instanceof Unit){
            if(node.returnVals.size() == 0){
                isvalid = true;
            }
        }else if(retarg instanceof Tau){
            if (node.returnVals.size() == 1 && (retarg).equals(node.returnVals.get(0).type)){
                isvalid = true;
            }
        }
        if(isvalid){
            node.type = new Void();
        }else{
            String res= errorstart(node.getLine(), node.getCol());
            res += "invalid return";
            throw new SemanticErrorException(res);
        }
    }

    @Override
    public void visitAssign(AssignStmt node) throws SemanticErrorException {
        // TODO:
        //  x = e,
        //  e1[e2] = e2,
        //  x:tau = e,
        //  _ = e -> done
        //  d1...dn = e
        if (node.leftVal instanceof WildCard) {//_ = e
            checkExprStmt(node);
        } else if (node.leftVal instanceof LeftValueList) {// d1..dn = e
            checkMultiAssign(node);
        } else if (node.leftVal instanceof VarExpr) {//x = e
            Sigma t = this.env.findTypeofVar(((VarExpr) node.leftVal).identifier);
            if (t instanceof Var) {
                if (node.expr.type instanceof Tau) {
                    if (((Var) t).varType.equals(node.expr.type)) {
                        node.type = new Unit();
                    }
                }
            }
            if(node.type == null){
                String res = errorstart(node.getLine(), node.getCol());
                res += "Cannot assign " +node.expr.type.toStr() +" to "+  ((VarExpr) node.leftVal).type.toStr();
                throw new SemanticErrorException( res);
            }
        } else if (node.leftVal instanceof ArrIndexExpr) {//e1[e2] = e
            if (node.expr.type instanceof Tau) {
                if ((((ArrIndexExpr) node.leftVal).type).equals(node.expr.type)) {
                    node.type = new Unit();
                }
            }
            if(node.type == null){
                String res = errorstart(node.getLine(), node.getCol());
                res += "Cannot assign " +node.expr.type.toStr() +" to "+ ((ArrIndexExpr) node.leftVal).type.toStr();
                throw new SemanticErrorException( res);
            }
        }else if(node.leftVal instanceof VarDeclareStmt){ //x:tau = e
            Tau lefttype = typeToTau(((VarDeclareStmt) node.leftVal).varType);
            if((node.expr.type).equals(lefttype)){
                node.type = new Unit();
            }else{
                String res = errorstart(node.getLine(), node.getCol());
                res += "Cannot assign " +node.expr.type.toStr() +" to "+ lefttype.toStr();
                throw new SemanticErrorException( res);
            }
        }
        else{
            String res = errorstart(node.getLine(), node.getCol());
            throw new SemanticErrorException(res + "invalid object to assign to");
        }
    }

    @Override
    public void visitWildCard(WildCard node) {
        node.type = new Unit();
    }

    /** Type check _ = e */
    private void checkExprStmt(AssignStmt node) throws SemanticErrorException{
        if (!(node.expr instanceof FunCallExpr)) {
            String pos = errorstart(node.expr.getLine(), node.expr.getCol());
            throw new SemanticErrorException(pos + "Expected function call");
        }
        if (node.expr.type instanceof Tau) {
            node.type = new Unit();
        } else {
            String pos = errorstart(node.expr.getLine(), node.expr.getCol());
            throw new SemanticErrorException(pos + "Expected int, bool, or array, got " + node.expr.type.toStr());
        }
    }

    /** Type check multiple assignment statement d1, d2, ..., dn = e
     * Requires:
     * - node is a multiple assign statement (check in visitAssign) so must contain a LeftValueList
     * - contains a list of declarations or wildcards on the left, checked in parsing
     * - a function call on the right, checked in parsing
     */
    private void checkMultiAssign(AssignStmt node) throws SemanticErrorException {
        List<LValue> declares = ((LeftValueList) node.leftVal).declares;
        List<Tau> returnTypes = ((Prod) node.expr.type).elementTypes;
        if (declares.size() != returnTypes.size()) {
            String pos = errorstart(node.getLine(), node.getCol());
            throw new SemanticErrorException(pos + "Mismatched number of values");
        }

        // check tau(i) <= typesOf(d(i))
        for (int i = 0; i < declares.size(); i++) {
            Tau tau = returnTypes.get(i);
            LValue d = declares.get(i);
            if (tau instanceof Array && typesOf(d) instanceof Array) {
                if (!((Array) tau).compare((Array) typesOf(d))) {
                    String pos = errorstart(d.getLine(), d.getCol());
                    // as function signature as expected value, rather than LValues
                    throw new SemanticErrorException(pos + "Expected " + tau.toStr() + " but got " + typesOf(d).toStr());
                }
            } else {
                if (!tau.isSubOf(typesOf(d))) {
                    String pos = errorstart(d.getLine(), d.getCol());
                    throw new SemanticErrorException(pos + "Expected " + tau.toStr() + " but got " + typesOf(d).toStr());
                }
            }
        }
        // all premises satisfied
        // type this statement
        node.type = new Unit();
        // update context
        for (LValue decl : declares) {
            Set<String> var = varsOf(decl);
            if (!var.isEmpty()) {
                String id = var.iterator().next();
                env.addVar(id, new Var((Tau) typesOf(decl)));
            }
        }

    }

    /** The set of variable in a declaration d. */
    private Set<String> varsOf(LValue d) {
        Set<String> vars = new TreeSet<>();
        if (d instanceof VarDeclareStmt) {
            String id = ((VarDeclareStmt) d).identifier;
            vars.add(id);
        }
        return vars;
    }

    /** The set of types in a declaration d. */
    private T typesOf(LValue d) {
        if (d instanceof VarDeclareStmt) {
            Tau type = typeToTau(((VarDeclareStmt) d).varType);
            return type;
        } else {
            return new Unit();
        }
    }

    @Override
    public void visitVarDecl(VarDeclareStmt node) throws SemanticErrorException{
        if(this.env.containsVar(node.identifier)){
            String res = errorstart(node.getLine(), node.getCol());
            throw new SemanticErrorException(res+"variable already declared");
        }
        else if (node.varType instanceof ArrayType) { // check array declaration
            Tau vat = checkArrayDecl((ArrayType) node.varType);
            node.type = new Unit();
            this.env.addVar(node.identifier,new Var(vat));
        } else { // is it safe to use else here? Yes, it's var type already
            node.type = new Unit();
            env.addVar(node.identifier, new Var(typeToTau(node.varType)));
        }
    }

    /** Type check array declaration x:tau[e1][e2]...[en][]...[], allow n = 0.
     *  Requires:
     *  - node is an array declaration (check when calling this method in visitVarDecl),
     *  - all dimensions are specified to the left-most (checked at parsing),
     */
    public Tau checkArrayDecl(ArrayType arrType) throws SemanticErrorException{
        Type next = arrType;
        // check type
        while (next instanceof ArrayType) {
            // if dim is defined for this level
            boolean hasDim = ((ArrayType) next).length.isPresent();
            if (hasDim) {
                Expr length = ((ArrayType) next).length.get();
                T dimType = length.type;
                if (!(dimType instanceof Int)) {
                    String pos = errorstart(length.getLine(), length.getLine());
                    throw new SemanticErrorException(pos + "Expected int, but found " + dimType.toStr());
                }
            }
            next = ((ArrayType) next).elemType;
        }
        // if typeChecks, build an array type with m + n levels and primitive type = next
        return typeToTau(arrType);

    }

    @Override
    public void visitFunDef(FunctionDefine node) throws SemanticErrorException{
        if (!(node.functionBody.type instanceof Void)) {
            String pos = errorstart(node.functionBody.getLine(), node.functionBody.getCol());
            throw new SemanticErrorException(pos + "Missing return statement");
        }
    }

    @Override
    public void visitPrDef(ProcedureDefine node) {
        // nothing to check here
    }

    @Override
    public void visitFunDecl(FunctionDeclare node) throws SemanticErrorException {
            T input;
            T output;
            if (node.arguments.size() == 0) {
                input = new Unit();
            } else if (node.arguments.size() == 1) {
                input = typeToTau(node.arguments.get(0).argType);
            } else {
                List<Tau> eletype = new ArrayList<>();
                for (FunProcArgs fp : node.arguments) {
                    eletype.add(typeToTau(fp.argType));
                }
                input = new Prod(eletype);
            }

            if (node.returnTypes.size() == 1) {
                output = typeToTau(node.returnTypes.get(0));
            } else {
                List<Tau> rettype = new ArrayList<>();
                for (Type e : node.returnTypes) {
                    rettype.add(typeToTau(e));
                }
                output = new Prod(rettype);
            }

            Fn result = new Fn(input, output);
            // check if function id already exist, check for type equivalence
            if (env.containsFun(node.name) && !result.functionEquals((Fn) env.findTypeofFun(node.name))) {
                String pos = errorstart(node.getLine(), node.getCol());
                throw new SemanticErrorException(pos + "Function " + node.name + " already exists");
            }
            env.addFun(node.name, result);

    }

    @Override
    public void visitPrDecl(ProcedureDeclare node) throws SemanticErrorException {
        T input;
        if (node.arguments.size() == 0) {
            input = new Unit();
        } else if (node.arguments.size() == 1) {
            input = typeToTau(node.arguments.get(0).argType);
        } else {
            List<Tau> eletype = new ArrayList<>();
            for (FunProcArgs fp : node.arguments) {
                eletype.add(typeToTau(fp.argType));
            }
            input = new Prod(eletype);
        }
        Fn result = new Fn(input, new Unit());
        // if procedure id already exist, check for type equivalence
        if (env.containsFun(node.name) && !result.equals(env.findTypeofFun(node.name))) {
            String pos = errorstart(node.getLine(), node.getCol());
            throw new SemanticErrorException(pos + "Function " + node.name + " already exists");
        }
        env.addFun(node.name, result);
    }

    @Override
    public void visitGlobDecl(GlobDeclare node) throws SemanticErrorException {
        if (node.value != null) {
            if (node.value.type instanceof Tau) {
                if ((node.value.type).equals(typeToTau(node.varType))) {
                    env.addVar(node.identifier, new Var((Tau) node.value.type));
                } else {
                    String pos = errorstart(node.getLine(), node.getCol());
                    throw new SemanticErrorException(pos + "Cannot assign "
                            + node.value.type.toStr() + " to " +  typeToTau(node.varType).toStr());
                }
            }
        }
    }

    @Override
    public void visitFunProcArgs(FunProcArgs node) throws SemanticErrorException {
        if (this.env.containsVar(node.identifier)){
            String errorMsg = errorstart(node.getLine(), node.getCol()) + node.identifier + "is already defined.";
            throw new SemanticErrorException(errorMsg);
        } else {
            env.addVar(node.identifier, new Var(typeToTau(node.argType)));
        }
    }

    @Override
    public void visitUse(Use node) {
        // nothing to do here
    }

    @Override
    public void visitProgram(Program node) {
        // nothing to do here
    }


    @Override
    public void visitInterface(Interface node) {
        // nothing to do here
    }

    // Helper functions ======================================================================================
    /** Build a Tau type from a Type AST node. */
    public Tau typeToTau(Type t) {
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

    public String errorstart(int line, int colmn){
        return ((line+1) + ":" + (colmn+1) +" error:" );
    }
}
