package net.marcoreis.algorithms;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {

	public static void main(String[] args) {
		int[] A = new int[] { 9, 3, 9, 3, 9, 7, 9 };
		System.out.println(
				new OddOccurrencesInArray().solution(A));
	}

	public int solution(int[] A) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (map.get(A[i]) == null) {
				map.put(A[i], i);
			} else {
				map.remove(A[i]);
			}
		}
		return map.keySet().iterator().next();

	}
}
