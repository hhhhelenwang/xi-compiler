foo() {
    arr : int[] = {1, 2, 3}
    arr1 : int[], _ = foo2();
}

foo2() : int[], int {
    return {1,3}, 3;
}