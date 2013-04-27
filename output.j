.source output.j
.class public Output
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
.limit stack 2000
.limit locals 1000
ldc 1022
istore 0
ldc 42
istore 1
ldc 0
istore 2
goto label1
Test:
astore 3
istore 4
ldc 0
istore 5
iload 4
ldc 22
isub
istore 5
iload 5
ret 3
label1:
goto label2
Step:
astore 6
istore 7
istore 8
ldc 0
istore 9
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 7
invokevirtual  java/io/PrintStream/println(I)V
ldc 0
istore 10
iload 7
iload 8
isub
istore 10
iload 7
ldc 0
swap
if_icmpgt label3
iload 10
jsr Test
istore 10
label3:
iload 10
istore 9
iload 9
ret 6
label2:
iload 1
iload 0
jsr Step
istore 2
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 2
invokevirtual  java/io/PrintStream/println(I)V
return
.end method
