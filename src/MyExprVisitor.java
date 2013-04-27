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
	
	Scope			scope;
	UniqueGenerator	lblGen;
	
	public MyExprVisitor() {
		
		scope = new Scope();
		lblGen = new UniqueGenerator("label");
		
	}
	
	
	@Override
	public Variable.TypeEnum visitArgFloat(final ExprParser.ArgFloatContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public Variable.TypeEnum visitArgInt(final ExprParser.ArgIntContext ctx) {
		return visitChildren(ctx);
	}
	
	
	@Override
	public Variable.TypeEnum visitCondT(final ExprParser.CondTContext ctx) {
		
		
	}
	
	@Override
	public Variable.TypeEnum visitCondTE(final ExprParser.CondTEContext ctx) {
		return visitChildren(ctx);
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
		return visitChildren(ctx);
	}
	
	@Override
	public Variable.TypeEnum visitFuncCall(final ExprParser.FuncCallContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public Variable.TypeEnum visitInp(final ExprParser.InpContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public Variable.TypeEnum visitLp(final ExprParser.LpContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public Variable.TypeEnum visitModulo(final ExprParser.ModuloContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public Variable.TypeEnum visitMoreArgs(final ExprParser.MoreArgsContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public Variable.TypeEnum visitMorePars(final ExprParser.MoreParsContext ctx) {
		return visitChildren(ctx);
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
		return visitChildren(ctx);
	}
	
	@Override
	public Variable.TypeEnum visitOnePar(final ExprParser.OneParContext ctx) {
		return visitChildren(ctx);
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
	public Variable.TypeEnum visitSentences(final ExprParser.SentencesContext ctx) {
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
		return visitChildren(ctx);
	}
	
	@Override
	public Variable.TypeEnum visitValueI(final ExprParser.ValueIContext ctx) {
		return visitChildren(ctx);
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
