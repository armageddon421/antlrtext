.source output.j
.class public Output
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
.limit stack 2000
.limit locals 1000
ldc 1022
istore 0
ldc 13.37
fstore 1
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 0
invokevirtual  java/io/PrintStream/println(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
fload 1
invokevirtual  java/io/PrintStream/println(F)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Hallo Alfred!!"
invokevirtual  java/io/PrintStream/println(Ljava/lang/String;)V
ldc 0
istore 2
fload 1
iload 0
i2f
fadd
f2i
istore 2
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 2
invokevirtual  java/io/PrintStream/println(I)V
ldc 0.0
fstore 3
fload 1
iload 0
i2f
fadd
iload 2
i2f
fadd
fstore 3
getstatic java/lang/System/out Ljava/io/PrintStream;
fload 3
invokevirtual  java/io/PrintStream/println(F)V
return
.end method
