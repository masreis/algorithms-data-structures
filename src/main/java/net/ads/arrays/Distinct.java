package net.ads.arrays;

import java.util.HashSet;
import java.util.Set;

public class Distinct {
	public static void main(String[] args) {
		int[] A = { 2, 1, 1, 2, 3, 1 };
		System.out.println(new Distinct().solution(A));
	}

	public int solution(int[] A) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < A.length; i++) {
			set.add(A[i]);
		}
		return set.size();
	}
}
