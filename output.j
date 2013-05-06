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
Funk:
swap
istore 3
ldc 0
istore 4
iload 3
;;;Tion loaded.
iload 4
;;;Keiner loaded.
iload 3
jsr Test
istore 4
;;;Keiner stored.
istore 3
;;;Tion stored.
istore 4
iload 4
swap
astore 5
ret 5
label1:
goto label2
Test:
swap
istore 6
ldc 0
istore 7
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 6
invokevirtual  java/io/PrintStream/println(I)V
iload 6
ldc 22
isub
istore 7
ldc 0
istore 8
iload 7
iload 8
swap
if_icmpgt label3
ldc 0
istore 9
iload 6
istore 9
iload 6
;;;Input loaded.
iload 7
;;;Ret loaded.
iload 8
;;;Limit loaded.
iload 9
;;;Temp2 loaded.
iload 9
jsr Funk
istore 9
;;;Temp2 stored.
istore 8
;;;Limit stored.
istore 7
;;;Ret stored.
istore 6
;;;Input stored.
istore 7
label3:
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 7
invokevirtual  java/io/PrintStream/println(I)V
iload 7
swap
astore 10
ret 10
label2:
iload 0
jsr Test
istore 2
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 2
invokevirtual  java/io/PrintStream/println(I)V
return
.end method
