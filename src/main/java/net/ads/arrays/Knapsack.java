package net.ads.arrays;

public class Knapsack {

	static int knapSack(int W, int wt[], int val[], int n) {
		int i, w;
		int K[][] = new int[n + 1][W + 1];

		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		return K[n][W];
	}

	public static void main(String[] args) {
		int[] costs = new int[] { 1, 2, 3 };
		int[] quantities = new int[] { 10, 15, 40 };
		int n = 6;

		n = 50;
		quantities = new int[] { 60, 100, 120 };
		costs = new int[] { 10, 20, 30 };

		n = 50;
		quantities = new int[] { 20, 19 };
		costs = new int[] { 24, 20 };

		System.out.println(knapSack(n, costs, quantities, quantities.length));
	}
}
