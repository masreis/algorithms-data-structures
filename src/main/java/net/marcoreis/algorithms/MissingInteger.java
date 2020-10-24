package net.marcoreis.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MissingInteger {
	public static void main(String[] args) {
		int[] A = { 1, 3, 6, 4, 1, 2 };
		 A = new int[] { 1, 2, 3 };
		 A = new int[] { -1, -2, -3 };
		 A = new int[] { -1, -2, -3, 65536, 1, 4, 2, 3 };
		// A = new int[100000];
		// Random r = new Random();
		// for (int i = 0; i < 100000; i++) {
		// A[i] = r.nextInt(1000000);
		// }
		long start = System.currentTimeMillis();
		System.out.println(new MissingInteger().solution(A));
		// System.out.println(System.currentTimeMillis() - start);
	}

	public int solution(int[] A) {
		Map<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] < 1) {
				continue;
			}
			map.put(A[i], true);
		}
		for (int i = 1; i <= map.keySet().size(); i++) {
			if (map.get(i) == null) {
				return i;
			}
		}
		return map.keySet().size() + 1;
	}

	public int solutionb(int[] A) {
		Arrays.sort(A);
		int min = 1;
		boolean allNegatives = true;
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] < 1) {
				continue;
			}
			allNegatives = false;
			if (A[i] == A[i + 1]) {
				continue;
			} else if (A[i] == A[i + 1] - 1) {
				min++;
			}
		}
		if (allNegatives) {
			return 1;
		}
		return min + 1;
	}

	public int solutionc(int[] A) {
		Set<Integer> numbers = new TreeSet<>();
		// List<Integer> numbers = new ArrayList<>();
		// List<Integer> match = new ArrayList<>();
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				numbers.add(A[i]);
			}
			if (A[i] > max) {
				max = A[i];
			}
		}
		//
		Iterator<Integer> ite = numbers.iterator();
		// Collections.sort(numbers);
		//
		for (int i = 1; i <= max; i++) {
			// if (!numbers.contains(i)) {
			// if (numbers.get(i - 1) != i) {
			if (ite.next() != i) {
				// match.add(i);
				return i;
			}
		}
		//
		if (numbers.isEmpty()) {
			return 1;
		}
		return max + 1;
	}
}
