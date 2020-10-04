package net.ads.arrays;

import java.util.ArrayList;
import java.util.List;

// https://app.codesignal.com/arcade/intro/level-2/2mxbGwLzvkTCKAJMG

// TODO
public class AlmostIncreasingSequence {
	boolean almostIncreasingSequence(int[] sequence) {
//		int[] seqTemp = Arrays.copyOf(sequence, sequence.length);
//		Arrays.sort(seqTemp);
//		int biggest = seqTemp[seqTemp.length - 1];
//		int secondBiggest = seqTemp[seqTemp.length - 2];
//		int smallest = seqTemp[0];
//		int[] result = new int[sequence.length - 1];
//		int lower = Integer.MAX_VALUE;
		boolean removed = false;
		int posRemoved = -1;
		int countInverse = 0;
		int index = 0;
		List<Integer> posDecreasing = new ArrayList<>();
//		List<Integer> list = new ArrayList<>();
//		int prev = Integer.MIN_VALUE;

		for (int i = 0; i < sequence.length - 1; i++) {
			if (sequence[i] < sequence[i + 1]) {
				posDecreasing.add(i);
			}
		}

		// 1. val < next - ok
		// 2. val > next - ok -> removed = true
		// 3. removed && val > next &&
		//
//		for (int i = 0; i < sequence.length; i++) {
//
//			if (removed && posRemoved == i - 1) {
//				if (sequence[i] <= sequence[i - 2]) {
//					return false;
//				}
//			} else if (removed) {
//				if (sequence[i] <= sequence[i - 1]) {
//					return false;
//				}
//
//			}
//
//			// last item
//			if (i == sequence.length - 1) {
//				if (sequence[i] < sequence[i - 1]) {
//					removed = true;
//				}
//				continue;
//			}
//
//			if (sequence[i] > sequence[i + 1]) {
//				removed = true;
//				posRemoved = i;
//				continue;
////				list.add(val);
////				prev = sequence[i];
//			}
//
//		}

//		list.add(sequence[sequence.length - 1]);
//		System.out.println(Arrays.toString(list.toArray()));
//		countInverse = 0;
//		for (int i = 0; i < list.size() - 1; i++) {
//			if (list.get(i) >= list.get(i + 1)) {
//				return false;
//			}
//		}

//		System.out.println(countInverse);
//		return list.size() + 2 == sequence.length;
		//
//		System.out.println(countBigger);
//		return countInverse == 1;
		return true;
	}

	public static void main(String[] args) {
		int[] sequence = new int[] { 1, 3, 2, 1 }; // F
		System.out.println(new AlmostIncreasingSequence().almostIncreasingSequence(sequence));
		sequence = new int[] { 1, 3, 2 }; // V
		System.out.println(new AlmostIncreasingSequence().almostIncreasingSequence(sequence));
		sequence = new int[] { 1, 2, 1, 2 }; // F
		System.out.println(new AlmostIncreasingSequence().almostIncreasingSequence(sequence));
		sequence = new int[] { 1, 1, 2, 3, 4, 4 }; // F
		System.out.println(new AlmostIncreasingSequence().almostIncreasingSequence(sequence));
		sequence = new int[] { 40, 50, 60, 10, 20, 30 }; // F
		System.out.println(new AlmostIncreasingSequence().almostIncreasingSequence(sequence));
		sequence = new int[] { 10, 1, 2, 3, 4, 5 }; // V
		System.out.println(new AlmostIncreasingSequence().almostIncreasingSequence(sequence));
		sequence = new int[] { 1, 10, 2, 3, 4, 5 }; // V
		System.out.println(new AlmostIncreasingSequence().almostIncreasingSequence(sequence));
		sequence = new int[] { 1, 2, 1, 4, 5 };// V
		System.out.println(new AlmostIncreasingSequence().almostIncreasingSequence(sequence));
		sequence = new int[] { 1, 2, 5, 3, 5 };
		System.out.println(new AlmostIncreasingSequence().almostIncreasingSequence(sequence));
	}
}
