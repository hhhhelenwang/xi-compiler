foo3() : int, int, int {
    return 1, 2, 3
}

foo2(): int[], bool[] {
    return {1, 2}, {true, false}
}

foo() {
    a:int, b:int, c:int = foo3()
    arr1:int[], arr2:bool[] = foo2()
}