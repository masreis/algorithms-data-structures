package net.marcoreis.algorithms;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {
	public static void main(String[] args) {
		int[] A = { 4, 1, 3, 2 };
		A = new int[] { 4, 5, 2 };
		// A = new int[] { 3, 2, 1 };
		// A = new int[] { 3, 2, 1, 1 };
		System.out.println(new PermCheck().solution(A));
	}

	public int solution(int[] A) {
		Set<Integer> set = new HashSet<>();
		int total = 0;
		int expectedTotal = 0;
		for (int i = 0; i < A.length; i++) {
			if (!set.add(A[i])) {
				return 0;
			}
			total += A[i];
			expectedTotal += i + 1;
		}
		// Iterator<Integer> ite = set.iterator();
		// int prev = ite.next();
		// if (prev != 1) {
		// return 0;
		// }
		// for (int i = 0; i < set.size(); i++) {
		// if (ite.next() != i + 1) {
		// return 0;
		// }
		// }
		if (A.length != set.size()) {
			return 0;
		}
		if (expectedTotal != total) {
			return 0;
		}
		return 1;
	}

	public static int solution_4_PermCheck(int[] A) {

		int sumOfElements = 0;
		int expectedSumOfElements = 0;
		int[] countArray = new int[A.length + 1];

		for (int i = 0; i < A.length; i++) {

			if (A[i] >= countArray.length)
				return 0;

			if (countArray[A[i]] != 0)
				return 0;

			countArray[A[i]]++;

			sumOfElements += A[i];
			expectedSumOfElements += i + 1;

		}

		if (sumOfElements == expectedSumOfElements)
			return 1;
		else
			return 0;
	}
}
