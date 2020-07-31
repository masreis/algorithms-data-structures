package net.marcoreis.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SparseArrays {
	public static void main(String[] args) {
		String[] strings = { "ab", "ab", "abc" };
		String[] queries = { "ab", "abc", "abd" };
		int[] result = matchingStrings(strings, queries);
		System.out.println(Arrays.toString(result));
	}

	static int[] matchingStrings(String[] strings,
			String[] queries) {
		Map<String, Integer> map = new HashMap<>();
		int[] result = new int[queries.length];
		for (String string : strings) {
			Integer value = map.get(string);
			if (value == null) {
				map.put(string, 1);
			} else {
				map.put(string, value + 1);
			}
		}
		for (int i = 0; i < queries.length; i++) {
			Integer value = map.get(queries[i]);
			if (value != null) {
				result[i] = value;
			}
		}
		return result;
	}
}
