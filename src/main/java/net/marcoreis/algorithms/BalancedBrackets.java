package net.marcoreis.algorithms;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

public class BalancedBrackets {

	public static void main(String[] args) {
		String line = "{[()]}";
		// line = "{[(])}";
		// line = "{{[[(())]]}}";
		System.out.println(isBalanced(line));
	}

	static String isBalanced(String s) {

		if (s.length() == 0) {
			return "YES";
		}

		System.out.println(s.length());

		if (s.length() % 2 != 0) {
			return "NO";
		}

		Queue<Character> opening =
				Collections.asLifoQueue(new ArrayDeque<>());
		boolean balanced = true;
		for (int i = 0; i < s.length(); i++) {
			char charAt = s.charAt(i);
			switch (charAt) {
			case '{':
			case '[':
			case '(':
				opening.add(charAt);
				break;
			case '}':
				Character charPolled = opening.peek();
				if (opening.isEmpty() || charPolled != '{') {
					balanced = false;
				}
				opening.poll();
				break;
			case ']':
				charPolled = opening.peek();
				if (opening.isEmpty() || charPolled != '[') {
					balanced = false;
				}
				opening.poll();
				break;
			case ')':
				charPolled = opening.peek();
				if (opening.isEmpty() || charPolled != '(') {
					balanced = false;
				}
				opening.poll();
				break;
			}
		}
		if (opening.isEmpty() && balanced) {
			return "YES";
		} else {
			return "NO";
		}

	}
}
