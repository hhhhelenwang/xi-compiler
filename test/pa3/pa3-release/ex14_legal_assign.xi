//  x = e,
//  e1[e2] = e2,
//  x:tau = e,
//  _ = e -> done
//  d1...dn = e
a:int = 2
b:bool = false
c:int[]
d:bool[]
arr:int[][][]

multi_return(): int, int, bool, bool{
    return 1, a, b, true
}

single_int_return():int{
    return 100;
}

single_bool_return():bool{
    return true;
}

foo(){
e:int[1][2]
f:bool[5][]
s: int[] = "Hello";
q:int = -single_int_return()
p:bool = single_bool_return()

a = 1;
a = single_int_return();
b = true;
b = false;
c = {1, 2, 3}
d = {}
d[0] = b
d = {true}
o:bool = d[0]
e = {{1,2}}
f = {{},{},{},{},{}}
f = {{b,o},{true,false},{false,true},{true,false},{true,false}}

s[1] = a
d[0] = false
f[0] = {true,false}
f[0][1] = false

_ = single_int_return()
_, x:int, y:bool, _ = multi_return()
_, _, _, _ = multi_return()

m: int[][]
n: int[3][4]
m = n
k: int[3][]
k[0] = n[0]; k[1] = n[1]; k[2] = n[2]
}