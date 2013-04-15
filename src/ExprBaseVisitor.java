// Generated from Expr.g4 by ANTLR 4.0
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;

public class ExprBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements ExprVisitor<T> {
	@Override public T visitMult(ExprParser.MultContext ctx) { return visitChildren(ctx); }

	@Override public T visitNameModu(ExprParser.NameModuContext ctx) { return visitChildren(ctx); }

	@Override public T visitVariableDefinition(ExprParser.VariableDefinitionContext ctx) { return visitChildren(ctx); }

	@Override public T visitDiff(ExprParser.DiffContext ctx) { return visitChildren(ctx); }

	@Override public T visitVariableDefinitionMultiple(ExprParser.VariableDefinitionMultipleContext ctx) { return visitChildren(ctx); }

	@Override public T visitSum(ExprParser.SumContext ctx) { return visitChildren(ctx); }

	@Override public T visitSatzbau(ExprParser.SatzbauContext ctx) { return visitChildren(ctx); }

	@Override public T visitDivi(ExprParser.DiviContext ctx) { return visitChildren(ctx); }

	@Override public T visitQuoMul(ExprParser.QuoMulContext ctx) { return visitChildren(ctx); }

	@Override public T visitStart(ExprParser.StartContext ctx) { return visitChildren(ctx); }

	@Override public T visitModulo(ExprParser.ModuloContext ctx) { return visitChildren(ctx); }

	@Override public T visitQuot(ExprParser.QuotContext ctx) { return visitChildren(ctx); }

	@Override public T visitNameList(ExprParser.NameListContext ctx) { return visitChildren(ctx); }
}