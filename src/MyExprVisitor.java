public class MyExprVisitor<T> extends ExprBaseVisitor<T> {
	
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
	public T visitSum(final ExprParser.SumContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitMult(final ExprParser.MultContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitDivi(final ExprParser.DiviContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitSatzbau(final ExprParser.SatzbauContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitNameModu(final ExprParser.NameModuContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitStart(final ExprParser.StartContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitModulo(final ExprParser.ModuloContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitVariableDefinition(final ExprParser.VariableDefinitionContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitDiff(final ExprParser.DiffContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitNameList(final ExprParser.NameListContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitQuot(final ExprParser.QuotContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public T visitVariableDefinitionMultiple(final ExprParser.VariableDefinitionMultipleContext ctx) {
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
