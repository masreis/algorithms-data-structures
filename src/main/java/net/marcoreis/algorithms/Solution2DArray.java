package net.marcoreis.algorithms;

import java.util.Arrays;

public class Solution2DArray {
	public static void main(String[] args) {
		int[][] arr = { { 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 2, 4, 4, 0 }, { 0, 0, 0, 2, 0, 0 },
				{ 0, 0, 1, 2, 4, 0 } };
		System.out.println(hourglassSum(arr));
	}

	static int hourglassSum(int[][] arr) {
		int[] sum = new int[16];
		int f = 0;
		while (f < 16) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					// Line 1
					sum[f] += arr[i][j];
					sum[f] += arr[i][j + 1];
					sum[f] += arr[i][j + 2];
					// Line 2
					sum[f] += arr[i + 1][j + 1];
					// Line 3
					sum[f] += arr[i + 2][j];
					sum[f] += arr[i + 2][j + 1];
					sum[f] += arr[i + 2][j + 2];
					// System.out.println(arr[i][j]);
					// System.out.println(arr[i][j + 1]);
					// System.out.println(arr[i][j + 2]);
					// System.out.println(arr[i + 1][j + 1]);
					// System.out.println(arr[i + 2][j]);
					// System.out.println(arr[i + 2][j + 1]);
					// System.out.println(arr[i + 2][j + 2]);
					// System.out.println("===========");
					f++;
				}
			}
		}
		Arrays.sort(sum);
		return sum[sum.length - 1];
	}
}
