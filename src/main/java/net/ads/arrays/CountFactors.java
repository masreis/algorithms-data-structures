package net.ads.arrays;

public class CountFactors {
	public static void main(String[] args) {
		int N = 24;
//		 N = 10;
		// N = 9;
		N = 16;
//		 N = 1;
		// N = Integer.MAX_VALUE;
		System.out.println(new CountFactors().solution(N));
	}

	public int solution2(int N) {
		int i = 1;
		int result = 0;
		while (i * i < N) {
			System.out.println(i);
			if (N % i == 0) {
				result += 2;
			}
			i++;
		}
		if (i * i == N) {
			result++;
		}

		return result;
	}

	public int solution(int N) {
		int result = 0;
		int squareRoot = (int) Math.sqrt(N);
		if ((Math.sqrt(N) - Math.floor(squareRoot)) == 0) {
			result++;
		} else {
			squareRoot++;
		}
		//
		for (int i = 1; i < squareRoot; i++) {
			if (N % i == 0) {
				result += 2;
			}
		}

		return result;
	}

	public int solution1(int N) {
		int factors = 0;
		int squareRootN = (int) Math.sqrt(N);
		if (Math.pow(squareRootN, 2) != N) {
			squareRootN++; // round up for any non-perfect squares
		} else { // perfect squares have an additional factor
			factors++;
		}

		for (int i = 1; i < squareRootN; i++) {
			if (N % i == 0) {
				factors += 2;
			}
		}

		return factors;
	}
}
