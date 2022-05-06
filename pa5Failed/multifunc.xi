use io
use conv

f1(x:int) : int {
println("f1")
return x*2
}

g1(x:int) : int {
return x-5
}

f2(x:int, y:int) : int, int {
return x+y, x*y
}

f3(x:int, y:int, z:int) : int, int, int {
return g1(x), g1(y), f1(z)
}

f4(x:int, y:int, z:int, w:int) : int, int, int, int {
return g1(x), g1(y), f1(z), f1(w)
}

f5(x:int, y:int, z:int, w:int, u:int) : int, int, int, int, int {
return g1(x), g1(y), f1(z), f1(w), g1(u)
}

f6(x:int, y:int, z:int, w:int, u:int, v:int) : int, int, int, int, int, int {
return g1(x), g1(y), f1(z), f1(w), g1(u), f1(v)
}

f7(x:int, y:int, z:int, w:int, u:int, v:int, o:int) : int, int, int, int, int, int, int {
return g1(x), g1(y), f1(z), f1(w), g1(u), f1(v), g1(o)
}

f8(x:int, y:int, z:int, w:int, u:int, v:int, o:int, i:int) : int, int, int, int, int, int, int, int {
return g1(x), g1(y), f1(z), f1(w), g1(u), f1(v), g1(o), f1(i)
}

f9(x:int, y:int, z:int, w:int, u:int, v:int, o:int, i:int, a:int) : int, int, int, int, int, int, int, int, int {
return g1(x), g1(y), f1(z), f1(w), g1(u), f1(v), g1(o), f1(i), f1(a)
}

f10(x:int, y:int, z:int, w:int, u:int, v:int, o:int, i:int, a:int, b:int) : int, int, int, int, int, int, int, int, int, int {
return g1(x), g1(y), f1(z), f1(w), g1(u), f1(v), g1(o), f1(i), f1(a), g1(b)
}

f11(x:int, y:int, z:int, w:int, u:int, v:int, o:int, i:int, a:int, b:int, c:int) : int, int, int, int, int, int, int, int, int, int, int {
return g1(x), g1(y), f1(z), f1(w), g1(u), f1(v), g1(o), f1(i), f1(a), g1(b), g1(c)
}


main (args : int[][]) {
v1:int = f1(1)
v2:int, v3:int = f2(2, 3)
v4:int, v5:int, v6:int = f3(4, 5, 6)
v7:int, v8:int, v9:int, v10:int = f4(7,8,9,10)
v11:int, v12:int, v13:int, v14:int, v15:int = f5(11,12,13,14,15)
v16:int, v17:int, v18:int, v19:int, v20:int, v21:int = f6(16,17,18,19,20,21)
v22:int, v23:int, v24:int, v25:int, v26:int, v27:int, v28:int = f7(22,23,24,25,26,27,28)
v29:int, v30:int, v31:int, v32:int, v33:int, v34:int, v35:int, v36:int = f8(29,30,31,32,33,34,35,36)
v37:int, v38:int, v39:int, v40:int, v41:int, v42:int, v43:int, v44:int, v45:int = f9(37,38,39,40,41,42,43,44,45)
v46:int, v47:int, v48:int, v49:int, v50:int, v51:int, v52:int, v53:int, v54:int, v55:int = f10(46,47,48,49,50,51,52,53,54,55)
v56:int, v57:int, v58:int, v59:int, v60:int, v61:int, v62:int, v63:int, v64:int, v65:int, v66:int = f11(56,57,58,59,60,61,62,63,64,65,66)

a:int[] = {
v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20,
v21, v22, v23, v24, v25, v26, v27, v28, v29, v30, v31, v32, v33, v34, v35, v36, v37, v38,
v39, v40, v41, v42, v43, v44, v45, v46, v47, v48, v49, v50, v51, v52, v53, v54, v55, v56,
v57, v58, v59, v60, v61, v62, v63, v64, v65, v66
}
i:int = 0
while (i < length(a)) {
println(unparseInt(a[i]))
i = i + 1
}
}

