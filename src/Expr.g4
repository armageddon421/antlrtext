grammar Expr;
prog:	ausdruck;
ausdruck:	links=ausdruck minus='-' rechts=ausdruck  #Subtraktion
|	klammerAuf='(' inKlammer=ausdruck klammerZu=')' #Klammer
|	zahl=ZAHL #Zahl;

ZAHL: [0-9]+ ;
WHITE: [\r\n\t]+ -> skip ;