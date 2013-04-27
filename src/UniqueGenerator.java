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

public class UniqueGenerator {
	
	private final String	prefix;
	
	private int				counter;
	
	public UniqueGenerator(final String pre) {
		counter = 0;
		prefix = pre;
	}
	
	
	public String pullNumber() {
		counter += 1;
		return String.format("%s%s", prefix, counter);
	}
	
}
