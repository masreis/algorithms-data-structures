package net.ads.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FairIndexes {
	public int solution2(int[] A, int[] B) {
		List<Integer> indexes = new ArrayList<Integer>();
//		int result = 0;
		int sumA = 0;
		int sumB = 0;
		int arrSumA[] = new int[A.length];
		int arrSumB[] = new int[B.length];

		for (int i = 0; i < A.length; i++) {
			sumA += A[i];
			sumB += B[i];
			arrSumA[i] = sumA;
			arrSumB[i] = sumB;
		}

		for (int i = 0; i < arrSumA.length; i++) {
			if (arrSumA[i] == arrSumB[i]) {
//				result = i + 1;
				indexes.add(i);
			}
		}

		// We need one more comparison here
		List<Integer> fairIndexes = new ArrayList<>();
		for (int i = 0; i < indexes.size(); i++) {
			if (arrSumA[indexes.get(i)] == arrSumA[indexes.get(i + 1)] - arrSumA[indexes.get(i)]
					&& arrSumB[indexes.get(i)] == arrSumB[indexes.get(i + 1)] - arrSumB[indexes.get(i)]) {
				fairIndexes.add(indexes.get(i));
			}
		}

		return fairIndexes.size();
	}

	public int solution(int[] A, int[] B) {
		boolean arr[] = new boolean[A.length];
		List<Integer> list = new ArrayList<>();
		int aux = 0;
		int sumA = 0;
		int sumB = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			sumA += A[i];
			sumB += B[i];
			if (sumA == sumB) {
//				list.add(aux);
				arr[i] = true;
//				aux = 0;
//				continue;

				sumA = 0;
				sumB = 0;
			} else {
//				aux++;
				arr[i] = false;
			}
		}

		for (int i = 1; i < arr.length; i++) {
			if (!arr[i]) { // arr[i]&& arr[i-1] || i == arr.length - 1) {
				continue;
			} else if ((arr[i] && !arr[i - 1]) || i == arr.length - 1) {
				list.add(i);
			}
		}

		int arrSum[] = new int[list.size()];
		int j = 0;
		int result = 0;
		sumA = 0;
		for (int i = 0; i < A.length; i++) {
			sumA += A[i];
			if (i == list.get(j)) {
				arrSum[j] = sumA;
				if (map.get(sumA) == null) {
					map.put(sumA, 1);
				} else {
					map.put(sumA, map.get(sumA) + 1);
				}

				sumA = 0;
				j++;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		// T F T T T
		int[] A = new int[] { 0, 4, -1, 0, 3 };
		int[] B = new int[] { 0, -2, 5, 0, 3 }; // 2

		// F T F T
		// Nâo entendi esse caso
		A = new int[] { 2, -2, -3, 3 };
		B = new int[] { 0, 0, 4, -4 }; // 1
////
////		// F F F F
//		A = new int[] { 4, -1, 0, 3 };
//		B = new int[] { -2, 6, 0, 4 }; // 0
////
////		// F T T
//		A = new int[] { 3, 2, 6 };
//		B = new int[] { 4, 1, 6, }; // 0

		A = new int[] { 1, 4, 2, -2, 5 };
		B = new int[] { 7, -2, 2, 2, 5 }; // 2

		System.out.println(new FairIndexes().solution(A, B));
	}

}
