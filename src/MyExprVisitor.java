public class MyExprVisitor<T> extends ExprBaseVisitor<T> {
	
	@Override
	public T visitVariableDefinition(final ExprParser.VariableDefinitionContext ctx) {
		
		String varName = ctx.name.getText();
		System.out.println(varName);
	
		
		return null;
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
