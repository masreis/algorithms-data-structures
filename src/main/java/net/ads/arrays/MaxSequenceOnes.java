package net.ads.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSequenceOnes {
	public static void main(String[] args) {
		int[] A = { 1, 1, 0, 1, 0, 1, 1, 0, 1, 0 };
		System.out.println(new MaxSequenceOnes().solution(A));
	}

	public int solution(int[] A) {
		int max = 0;
		int ones = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 1) {
				ones++;
			} else if (A[i] == 0) {
				list.add(ones);
				ones = 0;
			}
			if (i == A.length - 1) {
				list.add(ones);
			}
		}
		System.out.println(Arrays.toString(list.toArray()));
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) + list.get(i + 1) + 1 > max) {
				max = list.get(i) + list.get(i + 1) + 1;
			}
		}
		return max;
	}
}
