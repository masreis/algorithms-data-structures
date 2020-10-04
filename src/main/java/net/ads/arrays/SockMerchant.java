package net.ads.arrays;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SockMerchant {

	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {
		Map<Integer, Integer> map = new HashMap<>();
		int total = 0;
		for (int i = 0; i < ar.length; i++) {
			if (map.get(ar[i]) == null) {
				map.put(ar[i], 1);
			} else if (map.get(ar[i]) == 1) {
				map.remove(ar[i]);
				total++;
			}
		}
		return total;
	}

	public static void main(String[] args) throws IOException {
		int[] ar = new int[] { 10, 20, 20, 10, 10, 30, 50, 10, 20 };
		int result = sockMerchant(ar.length, ar);
		System.out.println(result);
	}
}
