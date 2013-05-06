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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;


public class Scope {
	
	LinkedList<ArrayList<Variable>>	levels;
	
	int								level;
	
	public Scope() {
		levels = new LinkedList<ArrayList<Variable>>();
		levels.add(new ArrayList<Variable>());
		level = 0; // 0 is root level.
	}
	
	public int ascend() {
		level += 1;
		levels.add(new ArrayList<Variable>());
		
		return level;
	}
	
	public int descend() {
		level -= 1;
		levels.removeLast();
		return level;
	}
	
	public Variable addVariable(final Variable.TypeEnum type, final String name) {
		Variable var = new Variable(type, name);
		levels.get(level).add(var);
		return var;
	}
	
	public Variable getVariable(final String name) {
		
		
		Variable result = null;
		int lv = level;
		
		while (result == null && lv >= 0) {
			// System.out.printf(";level: %d, searching:%s\r\n", lv, name);
			result = getVariableInLevel(lv, name);
			lv -= 1;
		}
		
		return result;
	}
	
	private Variable getVariableInLevel(final int lv, final String name) {
		ListIterator<Variable> it = levels.get(lv).listIterator(0);
		
		while (it.hasNext()) {
			Variable v = it.next();
			// System.out.printf(";level: %d, searching: %s, current: %s\r\n",
			// lv, name, v.getName());
			if (v.getName().equals(name)) {
				return v;
			}
			
		}
		
		return null;
	}
	
	public boolean isVariableInCurrentScope(final String name) {
		return getVariableInLevel(level, name) != null;
	}
	
	public void push() {
		// skip level 0 because it can never be run recursively
		ListIterator<ArrayList<Variable>> levelIter = levels.listIterator(1);
		
		while (levelIter.hasNext()) {
			ArrayList<Variable> vlist = levelIter.next();
			ListIterator<Variable> varIter = vlist.listIterator(0);
			while (varIter.hasNext()) {
				Variable var = varIter.next();
				var.load();
				System.out.printf(";;;%s loaded.\r\n", var.getName());
			}
		}
		
		
	}
	
	public void pop() {
		// skip level 0 because it can never be run recursively
		ListIterator<ArrayList<Variable>> levelIter = levels.listIterator(levels.size());
		
		while (levelIter.hasPrevious() && levelIter.previousIndex() != 0) {
			ArrayList<Variable> vlist = levelIter.previous();
			ListIterator<Variable> varIter = vlist.listIterator(vlist.size());
			while (varIter.hasPrevious()) {
				Variable var = varIter.previous();
				var.store();
				System.out.printf(";;;%s stored.\r\n", var.getName());
			}
		}
		
	}
	
	
}
