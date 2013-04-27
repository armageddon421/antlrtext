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
ldc "Ergebnisse"
invokevirtual  java/io/PrintStream/println(Ljava/lang/String;)V
ldc 0.0
fstore 2
iload 0
fload 1
swap
i2f
swap
fdiv
fstore 2
getstatic java/lang/System/out Ljava/io/PrintStream;
fload 2
invokevirtual  java/io/PrintStream/println(F)V
return
.end method
