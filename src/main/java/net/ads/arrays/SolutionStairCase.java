package net.ads.arrays;

public class SolutionStairCase {
	static void staircase(int n) {
		int left = n - 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < left; j++) {
				System.out.print(" ");
			}
			for (int k = left; k < n; k++) {
				System.out.print("#");
			}
			System.out.println();
			left--;
		}
	}

	public static void main(String[] args) {
		staircase(6);
	}

}
