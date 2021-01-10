package net.ads.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinPerimeterRectangle {
	public static void main(String[] args) {
		int n = 30;
		n = 101; // 204
//		 n = 1;
//		n = 1234; // 1238
		System.out.println(
				new MinPerimeterRectangle().solution(n));
	}

	public int solution(int N) {
		List<Integer> result = new ArrayList<>();
		int squareRoot = (int) Math.sqrt(N);

		for (int i = 1; i <= squareRoot; i++) {
			int a = N / i;
			int b = i;
			if ((a * b) != N) {
				continue;
			}
			int p = 2 * (a + b);
			result.add(p);
		}
		Collections.sort(result);
		System.out.println(Arrays.toString(result.toArray()));
		return result.get(0);
	}
}
