package net.marcoreis.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicArray {
	public static void main(String[] args) {
		int n = 2;
		List<List<Integer>> queries =
				new ArrayList<List<Integer>>();
		Integer[] a1 = { 1, 0, 5 };
		Integer[] a2 = { 1, 1, 7 };
		Integer[] a3 = { 1, 0, 3 };
		Integer[] a4 = { 2, 1, 0 };
		Integer[] a5 = { 2, 1, 1 };
		queries.add(Arrays.asList(a1));
		queries.add(Arrays.asList(a2));
		queries.add(Arrays.asList(a3));
		queries.add(Arrays.asList(a4));
		queries.add(Arrays.asList(a5));
		List<Integer> list = dynamicArray(n, queries);
		System.out.println(Arrays.toString(list.toArray()));
	}

	public static List<Integer> dynamicArray(int n,
			List<List<Integer>> queries) {
		List<List<Integer>> seqList =
				new ArrayList<List<Integer>>(n);
		for (int i = 0; i < n; i++) {
			seqList.add(new ArrayList<Integer>());
		}
		List<Integer> result = new ArrayList<>();
		int lastAnswer = 0;
		for (List<Integer> q : queries) {
			int x = q.get(1);
			int y = q.get(2);
			int seq = ((x ^ lastAnswer) % n);
			if (q.get(0) == 1) {
				seqList.get(seq).add(y);
			} else if (q.get(0) == 2) {
				int index = seqList.get(seq).size();
				Integer value = seqList.get(seq).get(y % index);
				lastAnswer = value;
				result.add(value);
				System.out.println(lastAnswer);
			}
		}
		return result;
	}
}
