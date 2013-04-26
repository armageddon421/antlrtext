public class MyExprVisitor<T> extends ExprBaseVisitor<T> {
	
	Scope	scope;
	
	public MyExprVisitor() {
		
		scope = new Scope();
		
	}
	
	/*
	 * @Override public T visitVariableDefinition(final
	 * ExprParser.VariableDefinitionContext ctx) {
	 * 
	 * String varName = ctx.name.getText(); System.out.println(varName);
	 * 
	 * 
	 * return null; }
	 */
	
	@Override
	public T visitArgFloat(final ExprParser.ArgFloatContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitArgInt(final ExprParser.ArgIntContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitCompE(final ExprParser.CompEContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitCompG(final ExprParser.CompGContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitCompGE(final ExprParser.CompGEContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitCompL(final ExprParser.CompLContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitCompLE(final ExprParser.CompLEContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitCompU(final ExprParser.CompUContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitCondT(final ExprParser.CondTContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitCondTE(final ExprParser.CondTEContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitDifference(final ExprParser.DifferenceContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitDivison(final ExprParser.DivisonContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitFDef(final ExprParser.FDefContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitFuncCall(final ExprParser.FuncCallContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitLp(final ExprParser.LpContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitModulo(final ExprParser.ModuloContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitMoreArgs(final ExprParser.MoreArgsContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitMorePars(final ExprParser.MoreParsContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitMultiplication(final ExprParser.MultiplicationContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitOneArg(final ExprParser.OneArgContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitOnePar(final ExprParser.OneParContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitSCond(final ExprParser.SCondContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitSentences(final ExprParser.SentencesContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitSFuncDef(final ExprParser.SFuncDefContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitSLoop(final ExprParser.SLoopContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitStart(final ExprParser.StartContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitSum(final ExprParser.SumContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitSVarAssign(final ExprParser.SVarAssignContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitValueF(final ExprParser.ValueFContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitValueI(final ExprParser.ValueIContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitVardefFloat(final ExprParser.VardefFloatContext ctx) {
		
		String varname = ctx.varname.getText();
		float value = Float.parseFloat(ctx.valueD.getText().replace(',', '.'));
		
		scope.addVariable(Variable.TypeEnum.FLOAT, varname);
		
		
		return null;
	}
	
	@Override
	public T visitVardefInt(final ExprParser.VardefIntContext ctx) {
		
		String varname = ctx.varname.getText();
		int value = Integer.parseInt(ctx.valueN.getText());
		
		scope.addVariable(Variable.TypeEnum.INT, varname);
		
		return null;
	}
	
	@Override
	public T visitVarValue(final ExprParser.VarValueContext ctx) {
		return visitChildren(ctx);
	}
	
	/*
	 * @Override public T visitSubtraktion(final ExprParser.SubtraktionContext
	 * ctx) {
	 * 
	 * visit(ctx.links); visit(ctx.rechts);
	 * 
	 * System.out.println("Sub");
	 * 
	 * return null; }
	 * 
	 * @Override public T visitZahl(final ExprParser.ZahlContext ctx) {
	 * System.out.printf("Zahl: %s\n", ctx.getText()); return
	 * super.visitZahl(ctx); }
	 * 
	 * @Override public T visitKlammer(final ExprParser.KlammerContext ctx) {
	 * visit(ctx.inKlammer); return null; }
	 */
	
}
