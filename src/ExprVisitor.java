// Generated from Expr.g4 by ANTLR 4.0
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	T visitProg(ExprParser.ProgContext ctx);

	T visitSubtraktion(ExprParser.SubtraktionContext ctx);

	T visitKlammer(ExprParser.KlammerContext ctx);

	T visitZahl(ExprParser.ZahlContext ctx);
}