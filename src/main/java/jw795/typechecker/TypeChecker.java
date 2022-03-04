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
            node.type = (T) env.findTypeofVar(node.identifier);
        }
        else {
            String res = errorstart(node.getLine(), node.getCol());
            res += "Name " + node.identifier + " cannot be resolved";
            throw new SemanticErrorException(res);
        }
    }

    @Override
    public void visitIntNeg(IntNeg node) throws SemanticErrorException {
        if (node.expr.type instanceof Int) {
            node.type = new Int();
        } else {
            String res = errorstart(node.getLine(), node.getCol());
            res += "Expected int, but fount " + node.expr.type.tostr();
            throw new SemanticErrorException(res);
        }
    }

    /** helper to check the type of the subexpressions of algebraic and int comparison binop */
    private void setBinOpIntType(BinOpExpr node) throws SemanticErrorException{
        if ((node.expr1.type instanceof Int) && (node.expr2.type instanceof Int)) {
            node.type = new Int();
        } else if (!(node.expr1.type instanceof Int)) {
            String pos = errorstart(node.expr1.getLine(), node.expr1.getCol());
            throw new SemanticErrorException(pos + "Expected int, but found " + node.expr1.type.tostr());
        } else {
            String pos = errorstart(node.expr2.getLine(), node.expr2.getCol());
            throw new SemanticErrorException(pos + "Expected int, but found " + node.expr1.type.tostr());
        }
    }

    /** helper to check the type of the subexpressions of logical binop */
    private void setBinOpBoolType(BinOpExpr node) throws SemanticErrorException {
        if ((node.expr1.type instanceof Bool) && (node.expr2.type instanceof Bool)) {
            node.type = new Bool();
        } else if (!(node.expr1.type instanceof Bool)) {
            String pos = errorstart(node.expr1.getLine(), node.expr1.getCol());
            throw new SemanticErrorException(pos + "Expected bool, but found " + node.expr1.type.tostr());
        } else {
            String pos = errorstart(node.expr2.getLine(), node.expr2.getCol());
            throw new SemanticErrorException(pos + "Expected bool, but found " + node.expr1.type.tostr());
        }
    }

    /** Helper to check if both expressions have the same type when being compared. */
    private void setArrayBoolType(BinOpExpr node){
        if(node.expr1.type instanceof Tau){
            if(node.expr2.type instanceof Tau) {
                if (((Tau) node.expr1.type).equals((Tau) node.expr2.type)) {
                    node.type = new Bool();
                }
            }
        }
    }

    /** Helper to check the type of two array expressions are equal when they are compared.
     * If true, set node to bool type. */
    private void setArrayCompareType(BinOpExpr node) {

    }

    /** Helper to check the type of two array expressions are equal when they are concatenated.
     * If true, set node to the more restrictive array type between the two. */
    private void setArrayConcateType(BinOpExpr node) throws SemanticErrorException {
        // if the operand 2 is not an array then no
        if (!(node.expr2.type instanceof Array)) {
            String pos = errorstart(node.expr2.getLine(), node.expr2.getCol());
            throw new SemanticErrorException(pos
                    + "Expected " + node.expr1.type.tostr()
                    + ", but found " + node.expr2.type.tostr());
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
                    + "Expected " + node.expr1.type.tostr()
                    + ", but found " + node.expr2.type.tostr());
        }
    }

    @Override
    public void visitAdd(Add node) throws SemanticErrorException {
        // add allows both int and array as operands
        // if the first operand is an int, treat it as an integer add
        if (node.expr1.type instanceof Int) {
            setBinOpIntType(node);
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
    public void visitPrCall(ProcCallStmt node) throws Exception {
        // a procedure need to be fn T -> unit
        Sigma prType = this.env.findTypeofFun(node.name);
        try {
            proFunCall(false, prType, node.name);
        } catch (Exception e) {
            String errorMsg = errorstart(node.getLine(), node.getCol()) + e.getMessage();
            throw new SemanticErrorException(errorMsg);
        }
            List<Expr> nodeArgs = node.arguments;
            T declArgs = ((Fn) prType).inputType;
            // argsConform throws SemanticErrorException if there is a mismatch
            if (argsConform(nodeArgs, declArgs)){
                node.type = new Unit();
            }

    }

    @Override
    public void visitFunCallExpr(FunCallExpr node) throws Exception {
        // special case for length
        if (node.name.equals("length"))  {
            checkLength(node);
        } else {
            Sigma fnType = this.env.findTypeofFun(node.name);
            // check function types
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
    private void checkLength(FunCallExpr node) throws Exception {
        if (node.arguments.size() != 1) {
            String pos = errorstart(node.getLine(), node.getCol());
            throw new SemanticErrorException(pos + "Mismatched number of arguments");
        }
        Expr arg = node.arguments.get(0);
        if (arg.type instanceof Array) { // type checks as long as
            node.type = new Int();
        } else {
            String pos = errorstart(node.getLine(), node.getCol());
            throw new SemanticErrorException(pos + "Expected an array, but found " + arg.type.tostr());
        }
    }

    /** Checks if the types of arg passed in match the signature of declaration correspondingly*/
    private boolean argsConform(List<Expr> nodeArgs, T declArgs) throws Exception {
        if (declArgs instanceof Unit && nodeArgs.size() == 0) {
            return true;
        } else if (declArgs instanceof Tau && nodeArgs.size() == 1){
            if (((Tau)declArgs).equals((Tau)nodeArgs.get(0).type)) {
                return true;
            } else {
                String pos = errorstart(nodeArgs.get(0).getLine(), nodeArgs.get(0).getCol());
                String errMsg = pos + "Expected "+ declArgs.tostr() + ", but found " +
                        nodeArgs.get(0).type.tostr();
                throw new SemanticErrorException(errMsg);
            }
        } else if (declArgs instanceof Prod && nodeArgs.size() == ((Prod) declArgs).elementTypes.size()){
            for (int i = 0; i < nodeArgs.size(); i++){
                Tau declArg = ((Prod) declArgs).elementTypes.get(i);
                Expr nodeArg = nodeArgs.get(i);
                if (nodeArg.type instanceof Tau) {
                    if (!declArg.equals((Tau) nodeArg.type)){ // NOTE: checked that nodeArg is a Tau type
                        String pos = errorstart(nodeArg.getLine(), nodeArg.getCol());
                        String errMsg = pos + "Expected "+ declArg.tostr() + ", but found " +
                                nodeArg.type.toString();
                        throw new SemanticErrorException(errMsg);
                    }
                } else {
                    String pos = errorstart(nodeArg.getLine(), nodeArg.getCol());
                    String errMsg = pos + "Expected "+ declArg.tostr() + ", but found " +
                            nodeArg.type.toString();
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
            String errorMsg = "Expected a function or procedure call, but found " + prFnType.toString();
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
    public void visitBlockStmt(BlockStmt node) throws Exception {
        int numArgs = node.statements.size();
        for (int i = 0; i < numArgs - 1; i++){
            if (!(node.statements.get(i).type instanceof Unit)){
                String errorMsg =  errorstart(node.getLine(), node.getCol()) +
                        "Unexpected statement evaluation outcome void. Expected unit.";
                throw new Exception(errorMsg);
            }
        }
        Statement lastStmt = node.statements.get(numArgs - 1);
        node.type = lastStmt.type;
    }


    @Override
    public void visitIfStmt(IfStmt node) throws Exception {
        if (!(node.condition.type instanceof Bool)) {
            String errorMsg = errorstart(node.getLine(), node.getCol()) + "Expected condition is type Bool, but got" +
                    node.condition.type.tostr();
            throw new Exception(errorMsg);
        } else {
            node.type = new Unit();
        }
    }

    @Override
    public void visitIfElseStmt(IfElseStmt node) throws Exception {
        if (!(node.condition.type instanceof Bool)){
            String errorMsg = errorstart(node.getLine(), node.getCol()) + "Expected condition is type Bool, but got" +
                    node.condition.type.tostr();
            throw new Exception(errorMsg);
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
    public void visitWhileStmt(WhileStmt node) throws Exception {
        if (!(node.condition.type instanceof Bool)){
            String errorMsg = errorstart(node.getLine(), node.getCol()) + "Expected condition is type Bool, but got" +
                    node.condition.type.tostr();
            throw new Exception(errorMsg);
        } else {
            node.type = new Unit();
        }
    }


    @Override
    public void visitRet(ReturnStmt node) throws Exception {
        boolean isvalid =false;
        Sigma retarg = this.env.findTypeofVar("return");
        if(retarg instanceof  Prod){
            isvalid = true;
            if (((Prod) retarg).elementTypes.size() == node.returnVals.size() ){
                for (int i =0; i < node.returnVals.size(); i++){
                    if(! ((Prod) retarg).elementTypes.get(i).equals(node.returnVals.get(i))){
                        isvalid = false;
                    }
                }
            }
        }else if(retarg instanceof Unit){
            if(node.returnVals.size() == 0){
                isvalid = true;
            }
        }else if(retarg instanceof Tau){
            if (node.returnVals.size() ==1 & ((Tau) retarg).equals(node.returnVals.get(0))){
                isvalid = true;
            }
        }
        if(isvalid){
            node.type = new Void();
        }else{
            String res= errorstart(node.getLine(), node.getCol());
            res += "invalid return";
            throw new Exception(res);
        }
    }

    @Override
    public void visitAssign(AssignStmt node) throws Exception {
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
            Sigma t = this.env.findTypeofVar(((VarExpr) node.leftVal).identifier);

            if (t instanceof Var) {
                if (node.expr.type instanceof Tau) {
                    if (((Var) t).varType.equals((Tau)(node.expr.type))) {
                        node.type = new Unit();
                    }
                }
            }
            if(node.type == null){
                String res = errorstart(node.getLine(), node.getCol());
                res += "Cannot assign " +node.expr.type.tostr() +" to "+  ((ArrIndexExpr) node.leftVal).type.tostr();
                throw new Exception( res);
            }
        } else if (node.leftVal instanceof ArrIndexExpr) {
            if (node.expr.type instanceof Tau) {
                if (((ArrIndexExpr) node.leftVal).type.equals(node.expr.type)) {
                    node.type = new Unit();
                }
            }
            if(node.type == null){
                String res = errorstart(node.getLine(), node.getCol());
                res += "Cannot assign " +node.expr.type.tostr() +" to "+ ((ArrIndexExpr) node.leftVal).type.tostr();
                throw new Exception( res);
            }
        }
        else{
            String res = errorstart(node.getLine(), node.getCol());
            throw new Exception(res + "invalid oject to assign to");
        }
        // TODO: leave scope here?
    }

    @Override
    public void visitWildCard(WildCard node) {
        node.type = new Unit();
    }

    /** Type check _ = e */
    //Todo: we only allow wild car to be assign by a function
    //yet currently it is unchecked
    private void checkExprStmt(AssignStmt node) throws Exception{
        if (!(node.expr instanceof FunCallExpr)) {
            String pos = errorstart(node.expr.getLine(), node.expr.getCol());
            throw new Exception(pos + "Expected function call");
        }
        if (node.expr.type instanceof Tau) {
            node.type = new Unit();
        } else {
            String pos = errorstart(node.expr.getLine(), node.expr.getCol());
            throw new Exception(pos + "Expected int, bool, or array, got " + node.expr.type.tostr());
        }
    }

    /** Type check multiple assignment statement d1, d2, ..., dn = e
     * Requires:
     * - node is a multiple assign statement (check in visitAssign) so must contain a LeftValueList
     * - contains a list of declarations or wildcards on the left, checked in parsing
     * - a function call on the right, checked in parsing
     */
    private void checkMultiAssign(AssignStmt node) throws Exception {
        List<LValue> declares = ((LeftValueList) node.leftVal).declares;
        List<Tau> returnTypes = ((Prod) node.expr.type).elementTypes;
        if (declares.size() != returnTypes.size()) {
            String pos = errorstart(node.getLine(), node.getCol());
            throw new Exception(pos + "Mismatched number of values");
        }
        // check dom(gamma) does not contains varsOf(d)
        for (LValue decl: declares) {
            // dom contains varsOf(decl)
            if (env.domVar().removeAll(varsOf(decl))) {
                String pos = errorstart(decl.getLine(), decl.getCol());
                throw new Exception(pos + "Variable " + ((VarDeclareStmt) decl).identifier + " already declared");
            }
        }
        // check no two declarations have same var
        for (LValue d1 : declares) {
            for (LValue d2: declares) {
                Set<String> intersect = varsOf(d1);
                intersect.retainAll(varsOf(d2));
                if (!d1.equals(d2) && !intersect.isEmpty()) {
                    String pos = errorstart(d1.getLine(), d1.getCol());
                    throw new Exception(pos + "Repeated declarations of variables");
                }
            }
        }
        // check tau(i) <= typesOf(d(i))
        for (int i = 0; i < declares.size(); i++) {
            Tau tau = returnTypes.get(i);
            LValue d = declares.get(i);
            if (tau instanceof Array && typesOf(d) instanceof Array) {
                if (!((Array) tau).compare((Array) typesOf(d))) {
                    String pos = errorstart(d.getLine(), d.getCol());
                    throw new Exception(pos + "Expected " + typesOf(d).tostr() + " got" + tau.tostr());
                }
            } else {
                if (!tau.isSubOf(typesOf(d))) {
                    String pos = errorstart(d.getLine(), d.getCol());
                    throw new Exception(pos + "Expected " + typesOf(d).tostr() + " got" + tau.tostr());
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
    public void visitVarDecl(VarDeclareStmt node) throws Exception{
        if(this.env.containsVar(node.identifier)){
            String res = errorstart(node.getLine(), node.getCol());
            throw new Exception(res+"variable already declared");
        }
        else if (node.varType instanceof ArrayType) { // check array declaration
            Tau vat = checkArrayDecl((ArrayType) node.varType);
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
    public Tau checkArrayDecl(ArrayType arrType) throws Exception{
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
                    throw new Exception(pos + "Expected int, but found " + dimType.tostr());
                }
                next = ((ArrayType) next).elemType;
            }
        }
        // if typeChecks, build an array type with m + n levels and primitive type = next
        Tau type = typeToTau(arrType);
        return type;
    }

    @Override
    public void visitFunDef(FunctionDefine node) throws Exception{
        if (!(node.functionBody.type instanceof Void)) {
            String pos = errorstart(node.functionBody.getLine(), node.functionBody.getCol());
            throw new Exception(pos + "Expected void, but found " + node.functionBody.type.tostr());
        }
    }

    @Override
    public void visitPrDef(ProcedureDefine node) {
        // nothing to check here
    }

    @Override
    public void visitFunDecl(FunctionDeclare node) throws Exception {
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
            if (env.containsFun(node.name) && !result.equals(env.findTypeofFun(node.name))) {
                String pos = errorstart(node.getLine(), node.getCol());
                throw new Exception(pos + "Function " + node.name + " already exists");
            }
            env.addFun(node.name, result);

    }

    @Override
    public void visitPrDecl(ProcedureDeclare node) throws Exception {
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
            throw new Exception(pos + "Function " + node.name + " already exists");
        }
        env.addFun(node.name, result);
    }

    @Override
    public void visitGlobDecl(GlobDeclare node) throws Exception {
        if (node.varType instanceof ArrayType) { // check array declaration
            Tau vart = checkArrayDecl((ArrayType) node.varType);
            if(node.value.type.equals(vart)){
                this.env.addVar(node.identifier, new Var(checkArrayDecl((ArrayType) node.varType)));
            }
            else {
                String res = errorstart(node.getLine(), node.getCol());
                res+= "Cannot assign "+ node.value.type.tostr() + " to " + vart.tostr();
                throw new Exception(res);
            }
        } else if (node.varType instanceof  IntType ||node.varType instanceof  BoolType ){
            // is it safe to use else here? Yes, it's var type already
            Tau vart = typeToTau(node.varType);
            if(node.value.type.equals(vart)){
                env.addVar(node.identifier, new Var(vart));
            }else{
                String res = errorstart(node.getLine(), node.getCol());
                res+= "Cannot assign "+ node.value.type.tostr() + " to " + vart.tostr();
                throw new Exception(res);
            }
        }else{
            String res = errorstart(node.getLine(), node.getCol());
            res+= "Invalid type";
            throw new Exception(res);
        }
    }

    @Override
    public void visitFunProcArgs(FunProcArgs node) throws Exception {
        if (this.env.containsVar(node.identifier)){
            String errorMsg = errorstart(node.getLine(), node.getCol()) + node.identifier + "is already defined.";
            throw new Exception(errorMsg);
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
        return (line + ":" + colmn +" error: " );
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
