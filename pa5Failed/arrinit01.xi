use io
use conv

main(args: int[][]) {
a: int[] = {1, 2, 3, 4, 5}
i: int = 0
while (i < length(a)) {
println(unparseInt(a[i]))
i = i + 1
}
}

