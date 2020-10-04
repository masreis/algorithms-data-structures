package net.ads.arrays;

import java.io.IOException;

public class CoutingValleys {

	// Complete the countingValleys function below.
	static int countingValleys(int n, String s) {

		int level = 0;
		boolean inAValley = false;
		int valleys = 0;
		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == 'U') {
				level++;
			} else {
				level--;
			}

			if (level < 0 && !inAValley) {
				valleys++;
			}

			inAValley = level < 0;

		}
		return valleys;

	}

	public static void main(String[] args) throws IOException {
		String s = "UDDDUDUUDDUU";
		int result = countingValleys(s.length(), s);
		System.out.println(result);
	}
}
