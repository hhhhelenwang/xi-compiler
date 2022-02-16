// a syntactically valid function definition
rightfunction(a: int, b : bool) : int{
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
