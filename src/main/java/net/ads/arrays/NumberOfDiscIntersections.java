package net.ads.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://massivealgorithms.blogspot.com/2015/07/codility-lesson-4-number-of-disc.html
public class NumberOfDiscIntersections {
	public static void main(String[] args) {
		int[] A = new int[] { 1, 5, 2, 1, 4, 0 };
		// A = new int[] { 1, 10, 100, 1 };
		// A = new int[] { 1, 2147483647, 0 };
		System.out.println(new NumberOfDiscIntersections().solution(A));
	}

	public int solution(int[] A) {
		// Map<Integer, MinMax> map = new HashMap<>();
		int intersects = 0;

		List<MinMax> list = new ArrayList<>();

		for (int i = 0; i < A.length; i++) {
			MinMax minmax = new MinMax();
			minmax.max = Long.valueOf(A[i]) + i;
			minmax.min = i - A[i];
			// map.put(i, minmax);
			list.add(minmax);
		}

		Collections.sort(list, new Comparator<MinMax>() {

			@Override
			public int compare(MinMax o1, MinMax o2) {
				if (o1.min < o2.min)
					return -1;
				if (o2.min < o1.min)
					return 1;
				if (o1.max < o2.max)
					return 1;
				if (o2.max < o1.max)
					return -1;
				return 0;
			}
		});

		// TODO melhorar para o(n) ou o(nlogn)
		for (int i = 0; i < A.length; i++) {
			MinMax minmax1 = list.get(i);
			System.out.println(minmax1);
			for (int j = i + 1; j < A.length; j++) {
				MinMax minmax2 = list.get(j);
				// if ((minmax2.min <= minmax1.min
				// && minmax2.max >= minmax1.max)
				// || (minmax1.min <= minmax2.min
				// && minmax1.max >= minmax2.max)
				// || (minmax1.max >= minmax2.min
				// && minmax1.max <= minmax2.min)
				// || (minmax2.min >= minmax1.min
				// && minmax2.min <= minmax1.max)) {
				if (minmax1.max >= minmax2.min) {
					intersects++;
					if (intersects > 10000000) {
						return -1;
					}
				} else {
					break;
				}
				// } else {
				// System.out.println(minmax1 + "/" + minmax2);
				// }
			}

		}
		if (intersects > 10000000) {
			intersects = -1;
		}
		return intersects;
	}

	static class MinMax {
		long min;
		long max;

		@Override
		public String toString() {
			return min + "," + max;
		}
	}
}
