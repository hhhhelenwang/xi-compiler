foo() {
    _, arr : int[3] = foo2();
}

foo2(): int[], int {
    return {1, 2}, 3;
}