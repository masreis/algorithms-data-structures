package net.ads.arrays;

import java.util.Arrays;

public class MiniMaxSum {
	public static void main(String[] args) {

	}

	static void miniMaxSum(int[] arr) {
		Arrays.sort(arr);
		long min = 0;
		long max = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			min += arr[i];
		}
		for (int i = 1; i < arr.length; i++) {
			max += arr[i];
		}
		System.out.println(min + " " + max);
	}

}
