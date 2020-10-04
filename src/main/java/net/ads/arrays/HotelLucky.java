package net.ads.arrays;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class HotelLucky {

	// Complete the getLuckyFloorNumber function below.
	static int getLuckyFloorNumber(int n) {
		int real = 0;
		Set<Integer> result = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			real++;
			while (contains(real)) {
				real++;
			}
			result.add(real);
		}
		return real;
	}

	private static boolean contains(int real) {
		String val = String.valueOf(real);
		return val.contains("4") || val.contains("13");
	}

	public static void main(String[] args) throws IOException {
		int n = 440;
		// n = 12;
		// n = 1;
		int res = getLuckyFloorNumber(n);

		System.out.println(res);
	}
}
