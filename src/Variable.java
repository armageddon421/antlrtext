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

public class Variable {
	
	private final String	name;
	
	public enum TypeEnum {
		INT, FLOAT
	}
	
	private final TypeEnum	type;
	
	private final int		varID;
	
	
	private static int		varCounter;
	
	public Variable(final TypeEnum t, final String n) {
		name = n;
		type = t;
		varID = varCounter;
		varCounter += 1;
	}
	
	public final String getName() {
		return name;
	}
	
	public final TypeEnum getType() {
		return type;
	}
	
	public final int getID() {
		return varID;
	}
	
	public final void store() {
		
		switch (type) {
			case INT:
				System.out.printf("istore %d\n", varID);
				break;
			case FLOAT:
				System.out.printf("fstore %d\n", varID);
				break;
		}
		
	}
	
	public final void load() {
		
		switch (type) {
			case INT:
				System.out.printf("iload %d\n", varID);
				break;
			case FLOAT:
				System.out.printf("fload %d\n", varID);
				break;
		}
		
	}
	
}
