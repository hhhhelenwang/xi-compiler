use io;

f(arr : int[]) : int {
    arr[0] = 2;
    return 2;
}

main (a : int[][]) {
    b : int[] = {1};
    if (1 < f(b)) {
        println("Hello, World!")
    }
}