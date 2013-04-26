grammar Expr;
start:	sentence;

sentence:

	//Variablendeklarationen
	
		'Der Integer ' 	varname=NAME ' ist ' value=NUMBER	END	#VardefInt
	|	'Die Float ' 	varname=NAME ' ist ' value=DECIMAL	END	#VardefFloat
	
	|	varname=NAME ' ist' value=expression END	#VarAssign
	;
	

expression:

		varname=NAME		#VarValue
	|	value=NUMBER		#ValueI
	|	value=DECIMAL		#ValueF
	
	|	' ' left=expression		op=' plus'		right=expression		#Sum
	|	' ' left=expression		op=' minus'		right=expression		#Difference
	|	' ' left=expression		op=' mal'		right=expression		#Multiplication
	|	' ' left=expression		op=' durch'		right=expression		#Divison
	|	' ' left=expression		op=' modulo'	right=expression		#Modulo
	;


//ausdruck:	
//	links=ausdruck (minus='minus' | plus='plus') rechts=ausdruck  #Subtraktion
//|	klammerAuf='(' inKlammer=ausdruck klammerZu=')' #Klammer
//|	zahl=ZAHL #Zahl;



NAME: [A-Za-z]+[0-9]* ;
END: ['.''!''?'][\r\n]+;
SPACE: [' '] ;

NUMBER: 	[0-9]+ ;
DECIMAL: 	[0-9]+','+[0-9]+;


SKIP: [\t]+ -> skip ;
COMMENT: '//'+.*?[\r\n]+ -> skip ;

