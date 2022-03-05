//testing lub in if Else && evaluate ifElse, BlockStmt, funDef
foo():bool{
    b:bool

    //will complain because if else will evaluate to void
    if(b){
        return
    } else {
        return
    }

    return b;
}