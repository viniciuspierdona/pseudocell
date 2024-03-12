package org.pseudocell.core.utils;

/*
 * Adapted by ViníciusPierdoná from the Towel project, developed by:
 * @author Marcos A. Vasconcelos Junior
 * @author Marco Biscaro
 * Available in: https://github.com/MarkyVasconcelos/Towel/wiki/Expression
*/

public class StringUtil {

	public static String removeCharacters(String x, char...cs) {
		for(char c : cs)
			x = x.replaceAll("["+String.valueOf(c)+"]", "");
		return x;
	}
}
