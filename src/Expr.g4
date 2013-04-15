grammar Expr;
start:	satzbau;

satzbau: 	satz satzbau
		|	satz ;

satz: 		name=NAME ' ist zaehlbar' end=END #VariableDefinition
		|	names=nameList ' sind zaehlbar' end=END #VariableDefinitionMultiple
		|	name=NAME ' ist die Summe von ' nameList end=END #Sum 
		|   name=NAME ' ist das Produkt von ' nameList end=END #Mult
		|   name=NAME ' ist die Differenz von ' nameList end=END #Diff
		|	name=NAME ' ist der Quotient aus ' nameList end=END #Quot
		|   name=NAME ' ist die Division von ' nameModu end=END #Divi
		|   name=NAME ' ist die Summe des Quotienten aus ' nameList ' der Multiplikation von ' nameList end=END #QuoMul
		|   name=NAME ' ist der Rest der Division von ' nameModu end=END #Modulo
		; 


nameList: 	name1=NAME (', ' namen=NAME)* ' und ' name2 = NAME ;
nameModu:   name1=NAME ' durch ' name2=NAME;



//ausdruck:	
//	links=ausdruck (minus='minus' | plus='plus') rechts=ausdruck  #Subtraktion
//|	klammerAuf='(' inKlammer=ausdruck klammerZu=')' #Klammer
//|	zahl=ZAHL #Zahl;



NAME: [A-Za-z]+[0-9]* ;
END: ['.''!''?'][\r\n]+;
SPACE: [' '] ;

NUMBER: [0-9]+ ;


SKIP: [\t]+ -> skip ;
COMMENT: '//'+.*?[\r\n]+ -> skip ;

