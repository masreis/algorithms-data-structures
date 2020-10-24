package net.marcoreis.algorithms;

public class TapeEquilibrium {
	public static void main(String[] args) {
		int[] A = new int[] { 3, 1, 2, 4, 3 };
		// A = new int[] { 1, 2 };
		A = new int[] { -1000, 1000 };
		System.out.println(new TapeEquilibrium().solution(A));
	}

	public int solution(int[] A) {
		int[] B = new int[A.length];
		int[] arrResult = new int[A.length - 1];
		int tot = 0;
		int min = 2000;
		for (int i = 0; i < A.length; i++) {
			tot += A[i];
			B[i] += tot;
		}
		for (int i = 0; i < B.length - 1; i++) {
			int result = Math.abs(2 * B[i] - tot);
			if (result < min) {
				min = result;
			}
			arrResult[i] = result;
		}
		return min;
	}
}
