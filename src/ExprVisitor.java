// Generated from Expr.g4 by ANTLR 4.0
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	T visitMoreArgs(ExprParser.MoreArgsContext ctx);

	T visitSCond(ExprParser.SCondContext ctx);

	T visitMainSent(ExprParser.MainSentContext ctx);

	T visitOutpText(ExprParser.OutpTextContext ctx);

	T visitSLoop(ExprParser.SLoopContext ctx);

	T visitSum(ExprParser.SumContext ctx);

	T visitCompU(ExprParser.CompUContext ctx);

	T visitFDef(ExprParser.FDefContext ctx);

	T visitCompLE(ExprParser.CompLEContext ctx);

	T visitFuncs(ExprParser.FuncsContext ctx);

	T visitOutp(ExprParser.OutpContext ctx);

	T visitWrite(ExprParser.WriteContext ctx);

	T visitModulo(ExprParser.ModuloContext ctx);

	T visitInp(ExprParser.InpContext ctx);

	T visitSVarAssign(ExprParser.SVarAssignContext ctx);

	T visitCondTE(ExprParser.CondTEContext ctx);

	T visitArgInt(ExprParser.ArgIntContext ctx);

	T visitMultiplication(ExprParser.MultiplicationContext ctx);

	T visitArgFloat(ExprParser.ArgFloatContext ctx);

	T visitRetInt(ExprParser.RetIntContext ctx);

	T visitFuncCall(ExprParser.FuncCallContext ctx);

	T visitVardefFloat(ExprParser.VardefFloatContext ctx);

	T visitCondT(ExprParser.CondTContext ctx);

	T visitRetFloat(ExprParser.RetFloatContext ctx);

	T visitLp(ExprParser.LpContext ctx);

	T visitDivison(ExprParser.DivisonContext ctx);

	T visitVardefInt(ExprParser.VardefIntContext ctx);

	T visitValueF(ExprParser.ValueFContext ctx);

	T visitCompG(ExprParser.CompGContext ctx);

	T visitDifference(ExprParser.DifferenceContext ctx);

	T visitOnePar(ExprParser.OneParContext ctx);

	T visitOneArg(ExprParser.OneArgContext ctx);

	T visitStart(ExprParser.StartContext ctx);

	T visitCompL(ExprParser.CompLContext ctx);

	T visitVarValue(ExprParser.VarValueContext ctx);

	T visitMorePars(ExprParser.MoreParsContext ctx);

	T visitSSingle(ExprParser.SSingleContext ctx);

	T visitRead(ExprParser.ReadContext ctx);

	T visitSMulti(ExprParser.SMultiContext ctx);

	T visitCompGE(ExprParser.CompGEContext ctx);

	T visitCompE(ExprParser.CompEContext ctx);

	T visitValueI(ExprParser.ValueIContext ctx);
}