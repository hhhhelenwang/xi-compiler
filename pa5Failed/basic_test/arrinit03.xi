use io
use conv

main(args: int[][]) {
a: int[][] = {{1}, {2, 3}, {4, 5, 6}, {7, 8, 9, 10}}
{
i: int = 0
while (i < length(a)) {
j: int = 0
while (j < length(a[i])) {
println(unparseInt(a[i][j]))
j = j + 1
}
i = i + 1
}
}
}

