package net.ads.arrays;

public class JumpingOnTheClouds {
	static int jumpingOnClouds(int[] c) {
		int jumps = 0;
		for (int i = 0; i < c.length - 1; i += 2, jumps++) {
			if (c[i] == 1) {
				i--;
			}
		}
		return jumps;
	}

	public static void main(String[] args) {
		int[] c = new int[] { 0, 0, 1, 0, 0, 1, 0 }; // 4
		c = new int[] { 0, 0, 0, 0, 1, 0 };
		c = new int[] { 0, 0, 0, 1, 0, 0 };
		System.out.println(jumpingOnClouds(c));
	}
}
