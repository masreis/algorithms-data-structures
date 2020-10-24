package net.marcoreis.algorithms;

import java.util.Arrays;

public class PermMissingElem {
	public static void main(String[] args) {
		int[] A = new int[] { 2, 3, 1, 5 };
		A = new int[] { 2, 1 };
		A = new int[] { 1 };
		A = new int[] {};
		A = new int[] { 1, 4, 3, 2, 5 };
		A = new int[] { 2, 3 };
		A = new int[] { 2, 3 ,1};
		System.out.println(new PermMissingElem().solution(A));
	}

	public int solution(int[] A) {
		if (A.length == 0) {
			return 1;
		}
		Arrays.sort(A);
		if (A[0] == 2) {
			return 1;
		}
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] + 1 != A[i + 1]) {
				return A[i] + 1;
			}
		}
		return A[A.length - 1] + 1;
	}
}
