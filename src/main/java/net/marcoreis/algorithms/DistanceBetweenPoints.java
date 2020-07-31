package net.marcoreis.algorithms;

public class DistanceBetweenPoints {
	public static void main(String[] args) {

		int x1 = 1;
		int y1 = 2;
		int x2 = 3;
		int y2 = 5;
		int x3 = 6;
		int y3 = 9;

		double intermediate1 =
				(y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1);
		double intermediate2 =
				(y3 - y1) * (y3 - y1) + (x3 - x1) * (x3 - x1);
		double intermediate3 =
				(y2 - y3) * (y2 - y3) + (x2 - x3) * (x2 - x3);

		System.out.println("The distance is: " + (intermediate1
				+ intermediate2 + intermediate3) / 3);

	}

}
