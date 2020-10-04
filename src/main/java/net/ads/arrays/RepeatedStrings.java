package net.ads.arrays;

public class RepeatedStrings {
	static long repeatedString(String s, long n) {
		long div = n / s.length();
		long mod = n % s.length();
		long count = 0;
		long countAfterRest = 0;
		for (int i = 0; i < s.length(); i++) {
			char charAt = s.charAt(i);
			if (charAt == 'a') {
				count++;
				if (i < mod) {
					countAfterRest++;
				}
			}

		}
		count *= div;
		count += countAfterRest;
		return count;
	}

	public static void main(String[] args) {
		String s = "aba";
		long n = 10;
		//
//		s = "a";
//		n = 1000000000000;
		System.out.println(repeatedString(s, n));
	}
}
