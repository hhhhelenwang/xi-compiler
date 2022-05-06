use io
use conv

main(args: int[][]) {
println(unparseInt(fac(7)))
}

fac(n: int): int {
return fac'(n, 1)
}

fac'(n: int, accum: int): int {
if (n <= 1) { return accum }
return fac'(n-1, n*accum)
}

