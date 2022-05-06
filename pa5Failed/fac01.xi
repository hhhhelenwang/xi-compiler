use io
use conv

main(args: int[][]) {
println(unparseInt(fac(7)))
}

fac(n: int): int {
if (n <= 1) { return 1 }
return n * fac(n-1)
}

