package net.marcoreis.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionNonDivisibleSubset {

	// https://www.hackerrank.com/challenges/non-divisible-subset/problem
	// https://challier.github.io/home/divisible-subset/
	public static void main(String[] args) {
		List<Integer> s = Arrays.asList(1, 7, 2, 4);
		System.out.println(nonDivisibleSubset(3, s));

		s = Arrays.asList(19, 10, 12, 10, 24, 25, 22);
		System.out.println(nonDivisibleSubset(4, s));

		s = Arrays.asList(278, 576, 496, 727, 410, 124, 338,
				149, 209, 702, 282, 718, 771, 575, 436);
		// System.out.println(nonDivisibleSubset(7, s));
	}

	public static int nonDivisibleSubset(int k,
			List<Integer> s) {
		int subsets = 0;
		int[] remainders = new int[k];

		for (int i = 0; i < s.size(); i++) {
			int remainder = s.get(i) % k;
			remainders[remainder]++;
		}
		System.out.println(Arrays.toString(remainders));
		if (k % 2 == 0) {
			remainders[k / 2] = Math.min(remainders[k / 2], 1);
		}
		subsets = Math.min(remainders[0], 1);

		for (int i = 1; i <= k / 2; i++) {
			subsets +=
					Math.max(remainders[i], remainders[k - i]);
		}

		return subsets;
	}

	public static int nonDivisibleSubset2(int k,
			List<Integer> s) {

		Set<Integer> nonDivisible = new HashSet<>();
		Set<Integer> divisible = new HashSet<>();

		for (int i = 0; i < s.size(); i++) {
			for (int j = 0; j < s.size(); j++) {
				if (i > j || i == j) {
					continue;
				}
				if ((s.get(i) + s.get(j)) % k != 0) {
					nonDivisible.add(s.get(i));
					nonDivisible.add(s.get(j));
				} else {
					divisible.add(s.get(i));
					divisible.add(s.get(j));
				}
				System.out.println(
						"i,j: " + s.get(i) + "," + s.get(j));
			}
		}

		System.out.println("Div: " + divisible);
		System.out.println(divisible.size());
		System.out.println("Non div: " + nonDivisible);
		System.out.println(nonDivisible.size());

		return nonDivisible.size();
	}
}
