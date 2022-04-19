use io
g:int = 5

main (a : int[][]) {
    g = 7;
    str1:int[] = "str1 value"
    str2:int[] = "str2 value"

    str3:int[] = str1 + str2
    println(str3)
    str4:int[] = str1 + str1 + str1
    println(str4)


    str5:int[10]
    str5 = str1
    str5[3] = 72
    println(str5)


}
