import java.io.FileReader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


public class Main {
	
	public static void main(final String[] args) throws Exception {
		
		
		// String inputString =
		// "Der Integer Alf ist 5.\nDie Float Aiko ist 2,3.\n";
		
		// ANTLRInputStream input = new ANTLRInputStream(System.in);
		// ANTLRInputStream input = new ANTLRInputStream(new
		// StringReader(inputString));
		
		if (args.length != 1) {
			System.err.println("Please specify input file!!!");
			return;
		}
		
		ANTLRInputStream input = new ANTLRInputStream(new FileReader(args[0]));
		
		
		ExprLexer lexer = new ExprLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		ExprParser parser = new ExprParser(tokens);
		
		ParseTree tree = parser.start();
		
		new MyExprVisitor().visit(tree);
		// new ExprBaseVisitor<Object>().visit(tree);
		
	}
}
