package net.ads.arrays;

import java.util.Arrays;

public class MaxCounters {
	public static void main(String[] args) {
		int N = 5;
		int[] A = new int[] { 3, 4, 4, 6, 1, 4, 4 };
		//
		// N = 1;
		// A = new int[] { 1 };
		int[] result = new MaxCounters().solution(N, A);
		System.out.println(Arrays.toString(result));
	}

	// FIXME Estudar
	public int[] solution(int N, int[] A) {
		int result[] = new int[N];
		int max = 0;
		int lastMax = 0;
		for (int i = 0; i < A.length; i++) {
			int command = A[i];
			int index = A[i] - 1;
			if (command > N) {
				lastMax = max;
			} else {
				if (result[index] < lastMax) {
					result[index] = lastMax + 1;
				} else {
					result[index] += 1;
				}

				if (result[index] > max) {
					max = result[index];
				}

			}
			System.out.println(command + " Max(" + max + ") "
					+ "LastMax(" + lastMax + ")"
					+ Arrays.toString(result));
		}
		for (int i = 0; i < N; i++) {
			if (result[i] < lastMax) {
				result[i] = lastMax;
			}
		}
		return result;
	}
}
