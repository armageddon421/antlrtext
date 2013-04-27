// Generated from Expr.g4 by ANTLR 4.0
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;

public class ExprBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements ExprVisitor<T> {
	@Override public T visitSCond(ExprParser.SCondContext ctx) { return visitChildren(ctx); }

	@Override public T visitMoreArgs(ExprParser.MoreArgsContext ctx) { return visitChildren(ctx); }

	@Override public T visitOutpText(ExprParser.OutpTextContext ctx) { return visitChildren(ctx); }

	@Override public T visitSentences(ExprParser.SentencesContext ctx) { return visitChildren(ctx); }

	@Override public T visitSLoop(ExprParser.SLoopContext ctx) { return visitChildren(ctx); }

	@Override public T visitSum(ExprParser.SumContext ctx) { return visitChildren(ctx); }

	@Override public T visitCompU(ExprParser.CompUContext ctx) { return visitChildren(ctx); }

	@Override public T visitFDef(ExprParser.FDefContext ctx) { return visitChildren(ctx); }

	@Override public T visitCompLE(ExprParser.CompLEContext ctx) { return visitChildren(ctx); }

	@Override public T visitOutp(ExprParser.OutpContext ctx) { return visitChildren(ctx); }

	@Override public T visitWrite(ExprParser.WriteContext ctx) { return visitChildren(ctx); }

	@Override public T visitModulo(ExprParser.ModuloContext ctx) { return visitChildren(ctx); }

	@Override public T visitInp(ExprParser.InpContext ctx) { return visitChildren(ctx); }

	@Override public T visitSVarAssign(ExprParser.SVarAssignContext ctx) { return visitChildren(ctx); }

	@Override public T visitCondTE(ExprParser.CondTEContext ctx) { return visitChildren(ctx); }

	@Override public T visitMultiplication(ExprParser.MultiplicationContext ctx) { return visitChildren(ctx); }

	@Override public T visitArgInt(ExprParser.ArgIntContext ctx) { return visitChildren(ctx); }

	@Override public T visitSFuncDef(ExprParser.SFuncDefContext ctx) { return visitChildren(ctx); }

	@Override public T visitArgFloat(ExprParser.ArgFloatContext ctx) { return visitChildren(ctx); }

	@Override public T visitFuncCall(ExprParser.FuncCallContext ctx) { return visitChildren(ctx); }

	@Override public T visitVardefFloat(ExprParser.VardefFloatContext ctx) { return visitChildren(ctx); }

	@Override public T visitCondT(ExprParser.CondTContext ctx) { return visitChildren(ctx); }

	@Override public T visitLp(ExprParser.LpContext ctx) { return visitChildren(ctx); }

	@Override public T visitDivison(ExprParser.DivisonContext ctx) { return visitChildren(ctx); }

	@Override public T visitValueF(ExprParser.ValueFContext ctx) { return visitChildren(ctx); }

	@Override public T visitVardefInt(ExprParser.VardefIntContext ctx) { return visitChildren(ctx); }

	@Override public T visitCompG(ExprParser.CompGContext ctx) { return visitChildren(ctx); }

	@Override public T visitDifference(ExprParser.DifferenceContext ctx) { return visitChildren(ctx); }

	@Override public T visitOnePar(ExprParser.OneParContext ctx) { return visitChildren(ctx); }

	@Override public T visitOneArg(ExprParser.OneArgContext ctx) { return visitChildren(ctx); }

	@Override public T visitStart(ExprParser.StartContext ctx) { return visitChildren(ctx); }

	@Override public T visitCompL(ExprParser.CompLContext ctx) { return visitChildren(ctx); }

	@Override public T visitVarValue(ExprParser.VarValueContext ctx) { return visitChildren(ctx); }

	@Override public T visitMorePars(ExprParser.MoreParsContext ctx) { return visitChildren(ctx); }

	@Override public T visitRead(ExprParser.ReadContext ctx) { return visitChildren(ctx); }

	@Override public T visitCompGE(ExprParser.CompGEContext ctx) { return visitChildren(ctx); }

	@Override public T visitCompE(ExprParser.CompEContext ctx) { return visitChildren(ctx); }

	@Override public T visitValueI(ExprParser.ValueIContext ctx) { return visitChildren(ctx); }
}