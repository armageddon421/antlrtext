import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


public class Main {
	
	public static void main(final String[] args) throws Exception {
		
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		
		ExprLexer lexer = new ExprLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		ExprParser parser = new ExprParser(tokens);
		
		ParseTree tree = parser.prog();
		
		new MyExprVisitor().visit(tree);
		
	}
	
	
}
