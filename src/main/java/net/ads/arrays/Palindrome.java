package net.ads.arrays;

public class Palindrome {

	public static String palindrome(String str) {
		str = str.replaceAll("\\W+", "");
		int half = str.length() / 2 - 1;
		int j = half + 1;
		if (str.length() % 2 == 1) {
			j++;
		}
		for (int i = half; i >= 0; i--) {
			if (str.charAt(i) != str.charAt(j)) {
				return "false";
			}
			j++;
		}
		return "true";
	}

	public static void main(String[] args) {
		String word = "eye";
		word = "abcddcba";
		System.out.print(palindrome(word));
	}

}
