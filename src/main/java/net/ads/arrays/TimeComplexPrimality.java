package net.ads.arrays;

import java.io.IOException;

public class TimeComplexPrimality {
	static String primality(int n) {
		int square = (int) Math.sqrt(n);
		if (n == 1) {
			return "Not prime";
		} else if (n == 2) {
			return "Prime";
		}
		for (int i = 2; i <= square; i++) {
			if (n % i == 0) {
				return "Not prime";
			}
		}
		return "Prime";
	}

	public static void main(String[] args) throws IOException {
		// for (int pItr = 0; pItr < 3; pItr++) {
		int n = 3;
		n = 1000000006;
		String result = primality(n);
		System.out.println(result);

	}

}
