import java.util.HashMap;

//Copyright 2013 Robet Tagscherer, Alfred Becker
//
//This file is part of antlrtext.
//
//antlrtext is free software: you can redistribute it and/or modify it
//under the terms of the GNU General Public License as published by
//the Free Software Foundation, either version 3 of the License, or
//(at your option) any later version.
//
//antlrtext is distributed in the hope that it will be useful, but 
//WITHOUT ANY WARRANTY; without even the implied warranty of 
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
//General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with antlrtext. If not, see http://www.gnu.org/licenses/.


public class MyExprVisitor<TypeEnum> extends ExprBaseVisitor<Variable.TypeEnum> {
	
	private static HashMap<String, String>	compTypes	= new HashMap<String, String>();
	static {
		compTypes.put("kleiner", "lt");
		compTypes.put("kleiner oder gleich", "le");
		compTypes.put("gleich", "eq");
		compTypes.put("groesser oder gleich", "ge");
		compTypes.put("groesser", "gt");
		compTypes.put("ungleich", "ne");
	}
	
	private String							returnhelper;
	
	
	private final Scope						scope;
	private final UniqueGenerator			lblGen;
	
	public MyExprVisitor() {
		
		scope = new Scope();
		lblGen = new UniqueGenerator("label");
		
	}
	
	
	@Override
	public Variable.TypeEnum visitArgFloat(final ExprParser.ArgFloatContext ctx) {
		
		String vname = ctx.retname.getText();
		scope.addVariable(Variable.TypeEnum.FLOAT, vname).store();
		return null;
	}
	
	@Override
	public Variable.TypeEnum visitArgInt(final ExprParser.ArgIntContext ctx) {
		
		String vname = ctx.retname.getText();
		scope.addVariable(Variable.TypeEnum.INT, vname).store();
		
		return null;
	}
	
	@Override
	public Variable.TypeEnum visitRetFloat(final ExprParser.RetFloatContext ctx) {
		String vname = ctx.retname.getText();
		System.out.printf("ldc 0.0\n");
		scope.addVariable(Variable.TypeEnum.FLOAT, vname).store();
		returnhelper = vname;
		return null;
	}
	
	@Override
	public Variable.TypeEnum visitRetInt(final ExprParser.RetIntContext ctx) {
		String vname = ctx.retname.getText();
		System.out.printf("ldc 0\n");
		scope.addVariable(Variable.TypeEnum.INT, vname).store();
		returnhelper = vname;
		return null;
	}
	
	@Override
	public Variable.TypeEnum visitCondT(final ExprParser.CondTContext ctx) {
		String rel = ctx.rel.getText();
		String compSuffix = compTypes.get(rel);
		
		Variable.TypeEnum ltype = visit(ctx.leftC);
		Variable.TypeEnum rtype = visit(ctx.rightC);
		
		
		if (ltype == Variable.TypeEnum.INT && rtype == Variable.TypeEnum.FLOAT) {
			System.out.println("swap");
			System.out.println("i2f");
			System.out.println("swap");
			ltype = Variable.TypeEnum.FLOAT;
			
		} else if (ltype == Variable.TypeEnum.FLOAT && rtype == Variable.TypeEnum.INT) {
			System.out.println("i2f");
			rtype = Variable.TypeEnum.FLOAT;
		}
		
		String lblOut = lblGen.pullNumber();
		
		System.out.println("swap"); // logik invertieren
		
		if (ltype == Variable.TypeEnum.INT) {
			System.out.printf("if_icmp%s %s\n", compSuffix, lblOut);
		} else if (ltype == Variable.TypeEnum.FLOAT) {
			System.out.printf("fcmpl\n");
			System.out.printf("if%s %s\n", compSuffix, lblOut);
		}
		scope.ascend();
		visit(ctx.then);
		scope.descend();
		
		System.out.printf("%s:\n", lblOut);
		
		
		return null;
	}
	
	@Override
	public Variable.TypeEnum visitCondTE(final ExprParser.CondTEContext ctx) {
		String rel = ctx.rel.getText();
		String compSuffix = compTypes.get(rel);
		
		Variable.TypeEnum ltype = visit(ctx.leftC);
		Variable.TypeEnum rtype = visit(ctx.rightC);
		
		if (ltype == Variable.TypeEnum.INT && rtype == Variable.TypeEnum.FLOAT) {
			System.out.println("swap");
			System.out.println("i2f");
			System.out.println("swap");
			ltype = Variable.TypeEnum.FLOAT;
			
		} else if (ltype == Variable.TypeEnum.FLOAT && rtype == Variable.TypeEnum.INT) {
			System.out.println("i2f");
			rtype = Variable.TypeEnum.FLOAT;
		}
		
		String lblElse = lblGen.pullNumber();
		String lblOut = lblGen.pullNumber();
		
		System.out.println("swap"); // logik invertieren
		
		if (ltype == Variable.TypeEnum.INT) {
			System.out.printf("if_icmp%s %s\n", compSuffix, lblElse);
		} else if (ltype == Variable.TypeEnum.FLOAT) {
			System.out.printf("fcmpl\n");
			System.out.printf("if%s %s\n", compSuffix, lblElse);
		}
		
		scope.ascend();
		visit(ctx.thenBranch);
		scope.descend();
		System.out.printf("goto %s\n", lblOut);
		
		System.out.printf("%s:\n", lblElse);
		
		scope.ascend();
		visit(ctx.elseBranch);
		scope.descend();
		
		System.out.printf("%s:\n", lblOut);
		
		
		return null;
	}
	
	@Override
	public Variable.TypeEnum visitDifference(final ExprParser.DifferenceContext ctx) {
		Variable.TypeEnum ltype = visit(ctx.left);
		Variable.TypeEnum rtype = visit(ctx.right);
		
		if (ltype == Variable.TypeEnum.INT && rtype == Variable.TypeEnum.FLOAT) {
			System.out.println("swap");
			System.out.println("i2f");
			System.out.println("swap");
			ltype = Variable.TypeEnum.FLOAT;
			
		} else if (ltype == Variable.TypeEnum.FLOAT && rtype == Variable.TypeEnum.INT) {
			System.out.println("i2f");
			rtype = Variable.TypeEnum.FLOAT;
		}
		
		if (ltype == Variable.TypeEnum.INT) {
			System.out.println("isub");
		} else if (ltype == Variable.TypeEnum.FLOAT) {
			System.out.println("fsub");
		}
		
		return ltype; // same as rtype anyways
	}
	
	@Override
	public Variable.TypeEnum visitDivison(final ExprParser.DivisonContext ctx) {
		Variable.TypeEnum ltype = visit(ctx.left);
		Variable.TypeEnum rtype = visit(ctx.right);
		
		if (ltype == Variable.TypeEnum.INT && rtype == Variable.TypeEnum.FLOAT) {
			System.out.println("swap");
			System.out.println("i2f");
			System.out.println("swap");
			ltype = Variable.TypeEnum.FLOAT;
			
		} else if (ltype == Variable.TypeEnum.FLOAT && rtype == Variable.TypeEnum.INT) {
			System.out.println("i2f");
			rtype = Variable.TypeEnum.FLOAT;
		}
		
		if (ltype == Variable.TypeEnum.INT) {
			System.out.println("idiv");
		} else if (ltype == Variable.TypeEnum.FLOAT) {
			System.out.println("fdiv");
		}
		
		return ltype; // same as rtype anyways
	}
	
	@Override
	public Variable.TypeEnum visitFDef(final ExprParser.FDefContext ctx) {
		
		String funcname = ctx.funcname.getText();
		
		scope.ascend();
		
		
		// skip func if accidentially reached
		String lblSkip = lblGen.pullNumber();
		System.out.printf("goto %s\n", lblSkip);
		
		
		System.out.printf("%s:\n", funcname);
		Variable retRef = scope.addVariable(Variable.TypeEnum.REF, funcname + "_REF");
		retRef.store(); // Rücksprungadresse Speichern.
		
		visit(ctx.args); // Argumente von Stack in Variablen verfrachten.
		
		visit(ctx.atype); // Create Variable for return value and init with 0.
		String retVarName = returnhelper;
		Variable retVar = scope.getVariable(retVarName); // And store it here.
		
		
		visit(ctx.action); // Execute function code.
		
		
		retVar.load(); // Throw return value on stack.
		
		System.out.printf("ret %d\n", retRef.getID());
		
		
		scope.descend();
		
		System.out.printf("%s:\n", lblSkip);
		return null;
	}
	
	@Override
	public Variable.TypeEnum visitFuncCall(final ExprParser.FuncCallContext ctx) {
		String funcname = ctx.funcname.getText();
		// scope.ascend();
		
		// scope.push();
		
		visit(ctx.pars);
		
		System.out.printf("jsr %s\n", funcname); // funktion aufrufen
		// scope.descend();
		
		// scope.pop();
		
		return null;
	}
	
	@Override
	public Variable.TypeEnum visitInp(final ExprParser.InpContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public Variable.TypeEnum visitLp(final ExprParser.LpContext ctx) {
		String rel = ctx.rel.getText();
		String compSuffix = compTypes.get(rel);
		String lblLoop = lblGen.pullNumber();
		String lblOut = lblGen.pullNumber();
		
		System.out.printf("%s:\n", lblLoop);
		
		Variable.TypeEnum ltype = visit(ctx.leftC);
		Variable.TypeEnum rtype = visit(ctx.rightC);
		
		
		if (ltype == Variable.TypeEnum.INT && rtype == Variable.TypeEnum.FLOAT) {
			System.out.println("swap");
			System.out.println("i2f");
			System.out.println("swap");
			ltype = Variable.TypeEnum.FLOAT;
			
		} else if (ltype == Variable.TypeEnum.FLOAT && rtype == Variable.TypeEnum.INT) {
			System.out.println("i2f");
			rtype = Variable.TypeEnum.FLOAT;
		}
		
		
		System.out.println("swap"); // logik invertieren
		
		if (ltype == Variable.TypeEnum.INT) {
			System.out.printf("if_icmp%s %s\n", compSuffix, lblOut);
		} else if (ltype == Variable.TypeEnum.FLOAT) {
			System.out.printf("fcmpl\n");
			System.out.printf("if%s %s\n", compSuffix, lblOut);
		}
		
		visit(ctx.action);
		System.out.printf("goto %s\n", lblLoop);
		
		System.out.printf("%s:\n", lblOut);
		
		
		return null;
	}
	
	@Override
	public Variable.TypeEnum visitModulo(final ExprParser.ModuloContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public Variable.TypeEnum visitMoreArgs(final ExprParser.MoreArgsContext ctx) {
		
		visit(ctx.arg);
		visit(ctx.nextArgs);
		
		return null;
	}
	
	@Override
	public Variable.TypeEnum visitMorePars(final ExprParser.MoreParsContext ctx) {
		
		visit(ctx.npars);
		
		String par = ctx.par.getText();
		scope.getVariable(par).load();
		
		
		return null;
	}
	
	@Override
	public Variable.TypeEnum visitMultiplication(final ExprParser.MultiplicationContext ctx) {
		Variable.TypeEnum ltype = visit(ctx.left);
		Variable.TypeEnum rtype = visit(ctx.right);
		
		if (ltype == Variable.TypeEnum.INT && rtype == Variable.TypeEnum.FLOAT) {
			System.out.println("swap");
			System.out.println("i2f");
			System.out.println("swap");
			ltype = Variable.TypeEnum.FLOAT;
			
		} else if (ltype == Variable.TypeEnum.FLOAT && rtype == Variable.TypeEnum.INT) {
			System.out.println("i2f");
			rtype = Variable.TypeEnum.FLOAT;
		}
		
		if (ltype == Variable.TypeEnum.INT) {
			System.out.println("imul");
		} else if (ltype == Variable.TypeEnum.FLOAT) {
			System.out.println("fmul");
		}
		
		return ltype; // same as rtype anyways
	}
	
	@Override
	public Variable.TypeEnum visitOneArg(final ExprParser.OneArgContext ctx) {
		
		
		visit(ctx.arg);
		
		return null;
	}
	
	@Override
	public Variable.TypeEnum visitOnePar(final ExprParser.OneParContext ctx) {
		
		String par = ctx.par.getText();
		scope.getVariable(par).load();
		
		return null;
	}
	
	@Override
	public Variable.TypeEnum visitOutp(final ExprParser.OutpContext ctx) {
		
		String varname = ctx.varname.getText();
		Variable var = scope.getVariable(varname);
		
		if (var.getType() == Variable.TypeEnum.INT) {
			System.out.println("getstatic java/lang/System/out Ljava/io/PrintStream;");
			var.load();
			System.out.println("invokevirtual  java/io/PrintStream/println(I)V");
		} else if (var.getType() == Variable.TypeEnum.FLOAT) {
			System.out.println("getstatic java/lang/System/out Ljava/io/PrintStream;");
			var.load();
			System.out.println("invokevirtual  java/io/PrintStream/println(F)V");
		}
		
		return null;
	}
	
	
	@Override
	public Variable.TypeEnum visitOutpText(final ExprParser.OutpTextContext ctx) {
		
		String txt = ctx.text.getText();
		
		System.out.println("getstatic java/lang/System/out Ljava/io/PrintStream;");
		System.out.printf("ldc %s\n", txt);
		System.out.println("invokevirtual  java/io/PrintStream/println(Ljava/lang/String;)V");
		
		return null;
	}
	
	
	@Override
	public Variable.TypeEnum visitRead(final ExprParser.ReadContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public Variable.TypeEnum visitSFuncDef(final ExprParser.SFuncDefContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public Variable.TypeEnum visitSLoop(final ExprParser.SLoopContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public Variable.TypeEnum visitStart(final ExprParser.StartContext ctx) {
		
		System.out.println(".source output.j");
		System.out.println(".class public Output");
		System.out.println(".super java/lang/Object");
		System.out.println();
		System.out.println(".method public static main([Ljava/lang/String;)V");
		System.out.println(".limit stack 2000");
		System.out.println(".limit locals 1000");
		
		visitChildren(ctx);
		
		System.out.println("return");
		System.out.println(".end method");
		
		return null;
	}
	
	@Override
	public Variable.TypeEnum visitSum(final ExprParser.SumContext ctx) {
		
		Variable.TypeEnum ltype = visit(ctx.left);
		Variable.TypeEnum rtype = visit(ctx.right);
		
		if (ltype == Variable.TypeEnum.INT && rtype == Variable.TypeEnum.FLOAT) {
			System.out.println("swap");
			System.out.println("i2f");
			System.out.println("swap");
			ltype = Variable.TypeEnum.FLOAT;
			
		} else if (ltype == Variable.TypeEnum.FLOAT && rtype == Variable.TypeEnum.INT) {
			System.out.println("i2f");
			rtype = Variable.TypeEnum.FLOAT;
		}
		
		if (ltype == Variable.TypeEnum.INT) {
			System.out.println("iadd");
		} else if (ltype == Variable.TypeEnum.FLOAT) {
			System.out.println("fadd");
		}
		
		return ltype; // same as rtype anyways
	}
	
	@Override
	public Variable.TypeEnum visitSVarAssign(final ExprParser.SVarAssignContext ctx) {
		
		// Den Typ des sich auf dem Stack befindlichen Elements merken.
		Variable.TypeEnum stackType = visit(ctx.valueE);
		Variable var = scope.getVariable(ctx.varname.getText());
		Variable.TypeEnum varType = var.getType();
		
		if (varType == Variable.TypeEnum.INT && stackType == Variable.TypeEnum.FLOAT) {
			System.out.println("f2i");
		} else if (varType == Variable.TypeEnum.FLOAT && stackType == Variable.TypeEnum.INT) {
			System.out.println("i2f");
		}
		
		var.store();
		
		return null;
	}
	
	@Override
	public Variable.TypeEnum visitValueF(final ExprParser.ValueFContext ctx) {
		float val = Float.parseFloat(ctx.valueD.getText().replace(',', '.'));
		
		System.out.printf("ldc %s\n", Float.toString(val));
		
		return Variable.TypeEnum.FLOAT;
	}
	
	@Override
	public Variable.TypeEnum visitValueI(final ExprParser.ValueIContext ctx) {
		
		int val = Integer.parseInt(ctx.valueN.getText());
		
		System.out.printf("ldc %d\n", val);
		
		return Variable.TypeEnum.INT;
	}
	
	@Override
	public Variable.TypeEnum visitVardefFloat(final ExprParser.VardefFloatContext ctx) {
		
		String varname = ctx.varname.getText();
		float value = Float.parseFloat(ctx.valueD.getText().replace(',', '.'));
		
		if (scope.isVariableInCurrentScope(varname)) {
			System.err.printf("Variable %s already exists in this scope!", varname);
			System.exit(1);
		}
		
		System.out.printf("ldc %s\n", Float.toString(value));
		scope.addVariable(Variable.TypeEnum.FLOAT, varname).store();
		
		
		return null;
	}
	
	@Override
	public Variable.TypeEnum visitVardefInt(final ExprParser.VardefIntContext ctx) {
		
		String varname = ctx.varname.getText();
		int value = Integer.parseInt(ctx.valueN.getText());
		
		if (scope.isVariableInCurrentScope(varname)) {
			System.err.printf("Variable %s already exists in this scope!", varname);
			System.exit(1);
		}
		
		System.out.printf("ldc %d\n", value);
		scope.addVariable(Variable.TypeEnum.INT, varname).store();
		
		return null;
	}
	
	@Override
	public Variable.TypeEnum visitVarValue(final ExprParser.VarValueContext ctx) {
		
		Variable var = scope.getVariable(ctx.varname.getText());
		
		var.load();
		
		return var.getType();
	}
	
	@Override
	public Variable.TypeEnum visitWrite(final ExprParser.WriteContext ctx) {
		return visitChildren(ctx);
	}
	
	
	/*
	 * @Override public Variable.TypeEnum visitSubtraktion(final
	 * ExprParser.SubtraktionContext ctx) {
	 * 
	 * visit(ctx.links); visit(ctx.rechts);
	 * 
	 * System.out.println("Sub");
	 * 
	 * return null; }
	 * 
	 * @Override public Variable.TypeEnum visitZahl(final ExprParser.ZahlContext
	 * ctx) { System.out.printf("Zahl: %s\n", ctx.getText()); return
	 * super.visitZahl(ctx); }
	 * 
	 * @Override public Variable.TypeEnum visitKlammer(final
	 * ExprParser.KlammerContext ctx) { visit(ctx.inKlammer); return null; }
	 */
	
}
