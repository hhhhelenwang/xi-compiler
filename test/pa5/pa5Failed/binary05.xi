use io
use conv

main(args: int[][]) {
println(b2s(true == true))
println(b2s(true == false))
println(b2s(false == true))
println(b2s(false == false))
println(b2s(true != true))
println(b2s(true != false))
println(b2s(false != true))
println(b2s(false != false))
println(b2s(true & true))
println(b2s(true & false))
println(b2s(false & true))
println(b2s(false & false))
println(b2s(true | true))
println(b2s(true | false))
println(b2s(false | true))
println(b2s(false | false))
}

b2s(b: bool): int[] {
if (b) { return unparseInt(1) } else { return unparseInt(0) }
}

