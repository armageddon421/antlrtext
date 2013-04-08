// Generated from Expr.g4 by ANTLR 4.0
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	T visitSum(ExprParser.SumContext ctx);

	T visitSatzbau(ExprParser.SatzbauContext ctx);

	T visitStart(ExprParser.StartContext ctx);

	T visitVariableDefinition(ExprParser.VariableDefinitionContext ctx);

	T visitNameList(ExprParser.NameListContext ctx);

	T visitVariableDefinitionMultiple(ExprParser.VariableDefinitionMultipleContext ctx);
}