//only last stmt can be void

foo(){
    proceed:bool
    if (proceed){
    return
    } else {
    return
    }
    should_not_reach:bool = true
    return
}