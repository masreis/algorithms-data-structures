package net.ads.arrays;

import java.util.Arrays;

public class CyclicRotation {
	public static void main(String[] args) {
		// int[] A = new int[] { 3, 8, 9, 7, 6 };
		// int[] A = new int[] { 1, 2 };
		// int[] A = new int[] { 0,0,0 };
		int[] A = new int[] {};
		int K = 3;
		int[] result = new CyclicRotation().solution(A, K);
		System.out.println(Arrays.toString(result));
	}

	public int[] solution(int[] A, int K) {
		if (A.length > 0 && K >= A.length) {
			K = K % A.length;
		}
		int[] result = new int[A.length];
		int position = A.length - K;
		boolean useFactor = true;
		for (int i = 0; i < A.length; i++) {
			if (position >= A.length && useFactor) {
				position = 0;
				useFactor = false;
			}
			result[i] = A[position];
			position++;
		}
		return result;

	}

}
