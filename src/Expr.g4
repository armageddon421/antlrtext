grammar Expr;
start:	satzbau;

satzbau: 	satz satzbau
		|	satz ;

satz: 		name=NAME ' ist z�hlbar' end=END #VariableDefinition
		|	names=nameList ' sind z�hlbar' end=END #VariableDefinitionMultiple
		
		|	name=NAME ' ist die Summe von ' nameList end=END #Sum ;



nameList: 	name1=NAME (', ' namen=NAME)* ' und ' name2 = NAME ;




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

