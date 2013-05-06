.source output.j
.class public Output
.super java/lang/Object

.method static Mod(II)F
.limit stack 200
.limit locals 100
ldc 0
istore 2
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 1
invokevirtual  java/io/PrintStream/println(I)V
iload 1
iload 0
isub
istore 2
ldc 0
istore 3
iload 2
iload 3
swap
if_icmpgt label1
iload 0
iload 2
invokestatic Output/Mod(II)F
f2i
istore 2
goto label2
label1:
iload 1
istore 2
label2:
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 2
invokevirtual  java/io/PrintStream/println(I)V
iload 2
i2f
freturn
.end method
.method public static main([Ljava/lang/String;)V
.limit stack 200
.limit locals 100
ldc 1022
istore 0
ldc 22
istore 1
ldc 0
istore 2
iload 1
iload 0
invokestatic Output/Mod(II)F
f2i
istore 2
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 2
invokevirtual  java/io/PrintStream/println(I)V
return
.end method
