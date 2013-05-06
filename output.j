.source output.j
.class public Output
.super java/lang/Object

.method static Funk(I)F
.limit stack 200
.limit locals 100
ldc 0
istore 2
iload 1
invokestatic Output/Test(I)F
f2i
istore 2
iload 2
i2f
freturn
.end method
.method static Test(I)F
.limit stack 200
.limit locals 100
ldc 0
istore 5
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 4
invokevirtual  java/io/PrintStream/println(I)V
iload 4
ldc 22
isub
istore 5
ldc 0
istore 6
iload 5
iload 6
swap
if_icmpgt label1
ldc 0
istore 7
iload 4
istore 7
iload 7
invokestatic Output/Funk(I)F
f2i
istore 5
label1:
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 5
invokevirtual  java/io/PrintStream/println(I)V
iload 5
i2f
freturn
.end method
.method public static main([Ljava/lang/String;)V
.limit stack 200
.limit locals 100
ldc 1022
istore 8
return
.end method
