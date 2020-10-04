package net.ads.arrays;

public class Smallest {

	public int solution(int N) {
		String strN = String.valueOf(N);
		int[] digits = new int[strN.length()];
		int sum = 0;
		int smallest = 0;
		for (int i = 0; i < digits.length; i++) {
			digits[i] = Integer.valueOf(String.valueOf(strN.charAt(i)));
			sum += digits[i];
		}

		for (int i = N + 1;; i++) {
			if (sumOfDigits(i) == sum) {
				smallest = i;
				break;
			}
		}

		return smallest;
	}

	public int sumOfDigits(int N) {
		String strN = String.valueOf(N);
		int sum = 0;
		for (int i = 0; i < strN.length(); i++) {
			sum += Integer.valueOf(String.valueOf(strN.charAt(i)));
		}
		return sum;
	}

	public static void main(String[] args) {
		int N = 28;
		N = 734;
		N = 1990;
		N = 1;
		System.out.println(new Smallest().solution(N));
	}
}
