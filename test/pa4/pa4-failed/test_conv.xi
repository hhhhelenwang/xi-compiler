use io
use conv

main(args: int[][]) {
x1: int, b1: bool = parseInt("47")
if (b1) {
print("Valid int: ")
println(unparseInt(x1))
}
else println ("Invalid int")

x2: int, b2: bool = parseInt("hex")
if (b2) {
print("Valid int: ")
println(unparseInt(x2))
}
else println ("Invalid int")
}
