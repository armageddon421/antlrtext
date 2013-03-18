// Generated from Expr.g4 by ANTLR 4.0
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;

public class ExprBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements ExprVisitor<T> {
	@Override public T visitProg(ExprParser.ProgContext ctx) { return visitChildren(ctx); }

	@Override public T visitSubtraktion(ExprParser.SubtraktionContext ctx) { return visitChildren(ctx); }

	@Override public T visitKlammer(ExprParser.KlammerContext ctx) { return visitChildren(ctx); }

	@Override public T visitZahl(ExprParser.ZahlContext ctx) { return visitChildren(ctx); }
}