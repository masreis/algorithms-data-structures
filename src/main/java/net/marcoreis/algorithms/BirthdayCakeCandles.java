package net.marcoreis.algorithms;

import java.util.HashMap;
import java.util.Map;

public class BirthdayCakeCandles {
	public static void main(String[] args) {
		System.out.println(
				birthdayCakeCandles(new int[] { 3, 2, 1, 3 }));
	}

	static int birthdayCakeCandles(int[] ar) {
		Map<Integer, Integer> map =
				new HashMap<Integer, Integer>();

		// new TreeMap<>(new Comparator<Integer>() {
		// @Override
		// public int compare(Integer o1, Integer o2) {
		// return o2 .compareTo(o1;
		// }
		// });

		for (int i = 0; i < ar.length; i++) {
			if (map.get(ar[i]) == null) {
				map.put(ar[i], 1);
			} else {
				map.put(ar[i], map.get(ar[i]) + 1);
			}
		}
		int max = 0;
		for (int value : map.keySet()) {
			if (value > max)
				max = value;
		}
		return map.get(max);

	}
}
