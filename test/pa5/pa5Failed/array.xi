use io
use conv

b : int[]

f(a : int[]) {
a[2] = 5
}

main(args : int[][]) {
b = {0,0,0}
f(b)
println(unparseInt(b[2])) // this is 5
}

