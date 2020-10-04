package net.ads.arrays;

import java.util.HashMap;
import java.util.Map;

public class StringsConstruction {
	int stringsConstruction(String a, String b) {
//		char[] arrA = a.toCharArray();
//		char[] arrB = b.toCharArray();

		// Arrays.sort(arrA);
		// Arrays.sort(arrB);

		int result = 0;
		// int pos = 0;
		int matchB = 0;

		Map<Character, Integer> mapA = new HashMap<>();
		Map<Character, Integer> mapB = new HashMap<>();
		for (int i = 0; i < a.length(); i++) {
			if (mapA.get(a.charAt(i)) == null) {
				mapA.put(a.charAt(i), 1);
			} else {
				mapA.put(a.charAt(i), mapA.get(a.charAt(i)));
			}
		}

		for (int i = 0; i < b.length(); i++) {
			if (mapA.get(b.charAt(i)) == null) {
				continue;
			}
			matchB++;
			if (mapB.get(b.charAt(i)) == null) {
				mapB.put(b.charAt(i), 1);
			} else {
				mapB.put(b.charAt(i), mapB.get(b.charAt(i)) + 1);
			}
		}
		System.out.println(mapA);
		System.out.println(mapB);

		int maxPossibilities = matchB / a.length();

		for (int i = 0; i < maxPossibilities; i++) {
			System.out.println("B: " + b.charAt(i));
			boolean notMatch = false;
			for (int j = 0; j < a.length(); j++) {
				System.out.println("A: " + a.charAt(j));
				if (mapB.get(a.charAt(j)) == null || mapB.get(a.charAt(j)) == 0) {
					System.out.println("Break");
					notMatch = true;
					break;
				}
			}
			if (notMatch) {
				continue;
			}
			// Remove the itens from B
			for (int j = 0; j < a.length(); j++) {
				System.out.println("A: " + a.charAt(j));
				mapB.put(a.charAt(j), mapB.get(a.charAt(j)) - 1);
			}
			result++;
		}

		return result;

	}

	int stringsConstruction2(String a, String b) {
//		char[] arrA = a.toCharArray();
//		char[] arrB = b.toCharArray();

		// Arrays.sort(arrA);
		// Arrays.sort(arrB);

		int result = 0;
		// int pos = 0;
		int matchB = 0;

		Map<Character, Integer> mapA = new HashMap<>();
		Map<Character, Integer> mapB = new HashMap<>();
		for (int i = 0; i < a.length(); i++) {
			if (mapA.get(a.charAt(i)) == null) {
				mapA.put(a.charAt(i), 1);
			} else {
				mapA.put(a.charAt(i), mapA.get(a.charAt(i)));
			}
		}

		for (int i = 0; i < b.length(); i++) {
			if (mapA.get(b.charAt(i)) == null) {
				continue;
			}
			matchB++;
			if (mapB.get(b.charAt(i)) == null) {
				mapB.put(b.charAt(i), 1);
			} else {
				mapB.put(b.charAt(i), mapB.get(b.charAt(i)) + 1);
			}
		}
		System.out.println(mapA);
		System.out.println(mapB);

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < a.length(); i++) {
			int minLocal;
			if (mapB.get(a.charAt(i)) == null || mapA.get(a.charAt(i)) == null) {
				minLocal = 0;
			} else {
				minLocal = mapB.get(a.charAt(i)) / mapA.get(a.charAt(i));
			}
			if (minLocal < min) {
				min = minLocal;
			}
		}

		return min;

	}

	public static void main(String[] args) {
		String a = "abc";
		String b = "abccbabbaddcba"; // 2

		a = "ab";
		b = "abcbcb"; // 1

//		a = "zbc";
//		b = "ydlblksdjccdddb"; // 0
////
//		a = "b";
//		b = "a";
		System.out.println(new StringsConstruction().stringsConstruction2(a, b));
	}
}
