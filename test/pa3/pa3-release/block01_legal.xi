do_something(){
}

// only last stmt can eval to void
pro(){
    {}
    {}
    {{{{{{}}}}}}
    b:bool

    // if and while evaluate to unit
    if(b){
        // empty blocks evaluate to unit
    }

    while(b){
    }

    if(b){
        do_something() //procedure evaluates to unit
    }

    while(b){
        do_something()
    }

    //if else, if one branch is unit, entire stmt evaluated to unit
    if(b){
    } else {
        return
    }

    return
}

fun():bool{
    {}
    {}
    b:bool

    // if and while evaluate to unit
    if(b){
        // empty blocks evaluate to unit
    }

    while(b){
    }

    if(b){
        do_something() //procedure evaluates to unit
    }

    while(b){
        do_something()
    }

    //if else, if one branch is unit, entire stmt evaluated to unit
    if(b){
    } else {
        return b;
    }

    return b
}