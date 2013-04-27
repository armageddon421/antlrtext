//Copyright 2013 Robet Tagscherer, Alfred Becker
//
//This file is part of antlrtext.
//
//antlrtext is free software: you can redistribute it and/or modify it
//under the terms of the GNU General Public License as published by
//the Free Software Foundation, either version 3 of the License, or
//(at your option) any later version.
//
//antlrtext is distributed in the hope that it will be useful, but 
//WITHOUT ANY WARRANTY; without even the implied warranty of 
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
//General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with antlrtext. If not, see http://www.gnu.org/licenses/.



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
		'Solange' leftC=expression ' ' rel=compType ' ' rightC=expression END
		sentences
		'Schleifenende'						#Lp
	;
		
conditional:
		'Wenn ' leftC=expression ' ' rel=compType ' ' rightC=expression END
		then=sentences
		'Ende'								#CondT
		
	|	'Wenn ' leftC=expression ' ' rel=compType ' ' rightC=expression END
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

