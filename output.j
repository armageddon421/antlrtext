.source output.j
.class public Output
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
.limit stack 200
.limit locals 100
ldc 10
istore 0
label1:
iload 0
ldc 20
swap
if_icmpge label2
ldc 30
istore 1
label3:
iload 1
ldc 28
swap
if_icmple label4
iload 1
ldc 1
isub
istore 1
iload 0
ldc 18
swap
if_icmpne label5
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 1
invokevirtual  java/io/PrintStream/println(I)V
label5:
goto label3
label4:
iload 0
ldc 15
swap
if_icmpne label6
ldc 99
istore 2
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 2
invokevirtual  java/io/PrintStream/println(I)V
label6:
iload 0
ldc 15
swap
if_icmpge label7
iload 0
ldc 15
swap
if_icmpne label8
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "rong1"
invokevirtual  java/io/PrintStream/println(Ljava/lang/String;)V
label8:
label7:
iload 0
ldc 15
swap
if_icmple label9
iload 0
ldc 15
swap
if_icmpne label10
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "rong2"
invokevirtual  java/io/PrintStream/println(Ljava/lang/String;)V
label10:
label9:
iload 0
ldc 1
iadd
istore 0
goto label1
label2:
return
.end method
