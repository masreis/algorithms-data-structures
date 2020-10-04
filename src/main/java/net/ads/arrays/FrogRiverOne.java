package net.ads.arrays;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {
	public static void main(String[] args) {
		int X = 5;
		int[] A = new int[] { 1, 3, 1, 4, 2, 3, 5, 4 };
//		A = new int[] { 2, 2, 2, 2, 2, 2, 2, 2 };
		// X = 3;
		// A = new int[] { 4 };
		System.out.println(new FrogRiverOne().solution(X, A));
	}

	public int solution(int X, int[] A) {
		Set<Integer> set = new HashSet<>();
		int result = -1;
		int repeat = 0;
		for (int i = 0; i < A.length; i++) {
			if (!set.add(A[i])) {
				repeat++;
			}
			if (set.size() == X) {
				return X + repeat - 1;
			}
		}
		return result;
	}
}
