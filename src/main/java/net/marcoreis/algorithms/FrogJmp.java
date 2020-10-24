package net.marcoreis.algorithms;

public class FrogJmp {
	public static void main(String[] args) {
		int X = 10;
		int Y = 85;
		int D = 30;
		System.out.println(new FrogJmp().solution(X, Y, D));
	}

	public int solution(int X, int Y, int D) {
		double result = (Y - X) / (double) D;
		return (int) Math.ceil(result);
	}
}
