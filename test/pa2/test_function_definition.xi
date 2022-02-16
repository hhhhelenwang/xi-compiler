// a syntactically valid function definition
rightfunction(a: int, b : bool) : int{
    if (b) {
        return a;
    } else {
        return a+1;
    }
}

// no argument type
noType (a, b) : int {
    return a;
}

// no return type, should parse
noReturnType(a: int) {
    return a;
}

// procedure
proc(a: int) {
    print("hello");
}
