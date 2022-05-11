use io
use conv

main(args: int[][]) {
println(unparseInt(fib(7)))
}

fib(n: int): int {
i: int = 2
r: int = 1
r1: int = 0
if (n <= 0) { return r1 }
while (i <= n) {
newr: int = r + r1
r1 = r
r = newr
i = i + 1
}
return r
}

