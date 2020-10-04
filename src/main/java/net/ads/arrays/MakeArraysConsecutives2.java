package net.ads.arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MakeArraysConsecutives2 {
	int makeArrayConsecutive2(int[] statues) {
		int result = 0;
		Arrays.sort(statues);
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < statues.length; i++) {
			map.put(statues[i], 1);
		}
		for (int i = statues[0]; i < statues[statues.length - 1]; i++) {
			if (map.get(i) == null) {
				result++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] statues = new int[] { 6, 2, 3, 8 };
		System.out.println(new MakeArraysConsecutives2().makeArrayConsecutive2(statues));
	}
}
