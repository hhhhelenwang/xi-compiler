use io

hello(){
}

str:int[]
fun():bool{
_ = fun()
return true;
}

pro() {
//first pass should add hello() and pro() into context
hello()
pro()

// io functions should be in context without .ixi file supplied
str = "hello world"
_ = getchar()
print(str)
println(str)
_ = readln()
_ = eof()

return
}

ifloop(){
x:int
b:bool
if(b){

}
}