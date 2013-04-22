// Generated from Expr.g4 by ANTLR 4.0
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	T visitSum(ExprParser.SumContext ctx);

	T visitMult(ExprParser.MultContext ctx);

	T visitDivi(ExprParser.DiviContext ctx);

	T visitSatzbau(ExprParser.SatzbauContext ctx);

	T visitNameModu(ExprParser.NameModuContext ctx);

	T visitStart(ExprParser.StartContext ctx);

	T visitModulo(ExprParser.ModuloContext ctx);

	T visitVariableDefinition(ExprParser.VariableDefinitionContext ctx);

	T visitDiff(ExprParser.DiffContext ctx);

	T visitNameList(ExprParser.NameListContext ctx);

	T visitQuot(ExprParser.QuotContext ctx);

	T visitVariableDefinitionMultiple(ExprParser.VariableDefinitionMultipleContext ctx);
}