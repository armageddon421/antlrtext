grammar Expr;
start:	STARTLINES sentences | sentences;


sentences:
		sentence
	| 	sentence sentences
	;

sentence:
	
		'Der Integer ' 	varname=NAME ' ist ' valueN=NUMBER	END	#VardefInt
	|	'Die Float ' 	varname=NAME ' ist ' valueD=DECIMAL	END	#VardefFloat
	
	|	varname=NAME ' gleich' valueE=expression 	END		#SVarAssign
	|	funcdef									END		#SFuncDef
	|	loop									END		#SLoop
	|	conditional								END		#SCond
	|	input									END		#Read
	|	output									END		#Write
	;
	

expression:
		' ' varname=NAME		#VarValue
	|	' ' valueN=NUMBER		#ValueI
	|	' ' valueD=DECIMAL		#ValueF
	
	|	left=expression		op=' plus'		right=expression		#Sum
	|	left=expression		op=' minus'		right=expression		#Difference
	|	left=expression		op=' mal'		right=expression		#Multiplication
	|	left=expression		op=' durch'		right=expression		#Divison
	|	left=expression		op=' modulo'	right=expression		#Modulo
	
	|	' ' funcname=NAME ' mit ' parList								#FuncCall
	;

parList:
		par=NAME							#OnePar
	|	par=NAME ', ' parList				#MorePars
	;

	
funcdef:
		funcname=NAME ' braucht Integer ' argList END
		sentences
		'Das Ergebnis ist ' argType				#FDef
	;
	
argList:
		arg=argType							#OneArg
	|	arg=argType ', ' nextArgs=argList	#MoreArgs
	;
	
	
argType:
		'Integer ' 	retname=NAME		#ArgInt
	|	'Float '	retname=NAME		#ArgFloat
	;

loop:
		'Solange' valueE=expression ' ' rel=compType END
		sentences
		'Schleifenende'						#Lp
	;
		
conditional:
		'Wenn ' valueE=expression ' ' rel=compType END
		then=sentences
		'Ende'								#CondT
		
	|	'Wenn ' valueE=expression ' ' rel=compType END
		thenBranch=sentences
		'Sonst' END
		elseBranch=sentences
		'Ende'								#CondTE
	;
		
		
compType:
		'kleiner'				#CompL
	|	'kleiner oder gleich'	#CompLE
	|	'gleich'				#CompE
	|	'groesser oder gleich'	#CompGE
	|	'groesser'				#CompG
	|	'ungleich'				#CompU
	;

input:
		'Lese ' varname=NAME		#Inp
	;
	
output:
		'Zeige ' varname=NAME		#Outp
	|	'Zeige ' text=TEXT 			#OutpText
	;


//ausdruck:	
//	links=ausdruck (minus='minus' | plus='plus') rechts=ausdruck  #Subtraktion
//|	klammerAuf='(' inKlammer=ausdruck klammerZu=')' #Klammer
//|	zahl=ZAHL #Zahl;



NAME: [A-Za-z]+[0-9]* ;
END: ['.''!''?'][\r\n]+;

NUMBER: 	[0-9]+;
DECIMAL: 	[0-9]+','+[0-9]+;
TEXT:		'"'[A-Za-z0-9' ''.''!''?']+'"';

STARTLINES:	[\r\n]+;

SKIP: [\t]+ -> skip ;
COMMENT: '//'+.*?[\r\n]+ -> skip ;

