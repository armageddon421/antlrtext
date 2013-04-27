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
getstatic java/lang/System/out Ljava/io/PrintStream;
fload 1
invokevirtual  java/io/PrintStream/println(F)V
fload 1
ldc 13.3
swap
fcmpl
iflt label1
fload 1
ldc 42.0
fadd
fstore 1
goto label2
label1:
fload 1
ldc -13
i2f
fsub
fstore 1
label2:
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Loop Test!"
invokevirtual  java/io/PrintStream/println(Ljava/lang/String;)V
label3:
iload 0
fload 1
swap
i2f
swap
swap
fcmpl
ifgt label4
iload 0
ldc 42
isub
istore 0
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 0
invokevirtual  java/io/PrintStream/println(I)V
goto label3
label4:
getstatic java/lang/System/out Ljava/io/PrintStream;
fload 1
invokevirtual  java/io/PrintStream/println(F)V
return
.end method
