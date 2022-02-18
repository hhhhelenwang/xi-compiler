foo() {
    a: int = 15
    b: bool
    c: int[]
    d: int = -15
    e:int, _ = foo2()
    f: int, g: int, _, _ = foo4()
}

foo2():int, int {
    //valid function

    return 3,5,7,9,10
}

foo4():int, int, int, int, int{
    //valid function

    return 3,5,7,9,10
}