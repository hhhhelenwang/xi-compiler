.intel_syntax noprefix
.data
.text
.global _Imain_paai
_Imain_paai:
subq rsp, 8
push rbp
mov rbp, rsp
addq rbp, 8
push rbx
push r12
push r13
push r14
push r15
mov [rbp-56], rdi
sub rsp, 392
mov rsi, [rbp-56]
mov [rbp-64], rsi
movq [rbp-72], 3
movq [rbp-80], 1
movq [rbp-88], 2
movq [rbp-96], 3
movq [rbp-104], 4
movq [rbp-112], 5
movq [rbp-120], 6
movq [rbp-128], 7
movq [rbp-136], 8
movq [rbp-144], 9
movq [rbp-152], 10
mov [rbp-160], rax
mov [rbp-168], rcx
mov [rbp-176], rdx
mov [rbp-184], rsp
mov [rbp-192], rsi
mov [rbp-200], rdi
mov [rbp-208], r8
mov [rbp-216], r9
mov [rbp-224], r10
mov [rbp-232], r11
mov rdi, [rbp-80]
mov rsi, [rbp-88]
mov rdx, [rbp-96]
mov rcx, [rbp-104]
mov r8, [rbp-112]
mov r9, [rbp-120]
push [rbp-152]
push [rbp-144]
push [rbp-136]
push [rbp-128]
call _If_i
addq rsp, 32
mov [rbp-240], rax // return
mov rax, [rbp-160]
mov rcx, [rbp-168]
mov rdx, [rbp-176]
mov rsp, [rbp-184]
mov rsi, [rbp-192]
mov rdi, [rbp-200]
mov r8, [rbp-208]
mov r9, [rbp-216]
mov r10, [rbp-224]
mov r11, [rbp-232]

mov rsi, [rbp-240] // 240 = return (rax) from f
mov [rbp-248], rsi //
mov rsi, [rbp-248]
mov [rbp-256], rsi // 256 = y
mov rsi, [rbp-256]
mov [rbp-264], rsi
mov [rbp-272], rax
mov [rbp-280], rcx
mov [rbp-288], rdx
mov [rbp-296], rsp
mov [rbp-304], rsi
mov [rbp-312], rdi
mov [rbp-320], r8
mov [rbp-328], r9
mov [rbp-336], r10
mov [rbp-344], r11
mov rdi, [rbp-264]
call _IunparseInt_aii
mov [rbp-240], rax
mov rax, [rbp-272]
mov rcx, [rbp-280]
mov rdx, [rbp-288]
mov rsp, [rbp-296]
mov rsi, [rbp-304]
mov rdi, [rbp-312]
mov r8, [rbp-320]
mov r9, [rbp-328]
mov r10, [rbp-336]
mov r11, [rbp-344]
mov rsi, [rbp-240]
mov [rbp-352], rsi
mov rsi, [rbp-352]
mov [rbp-360], rsi
mov [rbp-368], rax
mov [rbp-376], rcx
mov [rbp-384], rdx
mov [rbp-392], rsp
mov [rbp-400], rsi
mov [rbp-408], rdi
mov [rbp-416], r8
mov [rbp-424], r9
mov [rbp-432], r10
mov [rbp-440], r11
mov rdi, [rbp-360]
call _Iprintln_pai
mov rax, [rbp-368]
mov rcx, [rbp-376]
mov rdx, [rbp-384]
mov rsp, [rbp-392]
mov rsi, [rbp-400]
mov rdi, [rbp-408]
mov r8, [rbp-416]
mov r9, [rbp-424]
mov r10, [rbp-432]
mov r11, [rbp-440]
add rsp, 392
pop r15
pop r14
pop r13
pop r12
pop rbx
pop rbp
addq rsp, 8
ret
.text
.global _If_i
_If_i:
subq rsp, 8
push rbp
mov rbp, rsp
addq rbp, 8
push rbx
push r12
push r13
push r14
push r15
mov [rbp-56], rdi
mov [rbp-64], rsi
mov [rbp-72], rdx
mov [rbp-80], rcx
mov [rbp-88], r8
mov [rbp-96], r9
sub rsp, 168
mov rsi, [rbp-56] //a
mov [rbp-104], rsi
mov rsi, [rbp-64] //b
mov [rbp-112], rsi
mov rsi, [rbp-72] //c
mov [rbp-120], rsi
mov rsi, [rbp-80] //d
mov [rbp-128], rsi
mov rsi, [rbp-88] //e
mov [rbp-136], rsi
mov rsi, [rbp-96] //f
mov [rbp-144], rsi
mov rsi, [rbp-152] //g
mov [rbp-160], rsi
mov rsi, [rbp-168] //h
mov [rbp-176], rsi
mov rsi, [rbp-184] //i
mov [rbp-192], rsi
mov rsi, [rbp-200] //j
mov [rbp-208], rsi
mov rsi, [rbp-208] // j to t14
mov [rbp-216], rsi
mov rax, [rbp-208]
add rsp, 168
pop r15
pop r14
pop r13
pop r12
pop rbx
pop rbp
addq rsp, 8
ret
