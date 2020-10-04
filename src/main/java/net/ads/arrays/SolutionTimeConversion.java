package net.ads.arrays;

public class SolutionTimeConversion {
	public static void main(String[] args) {
		System.out.println(timeConversion("12:05:45PM"));
		System.out.println(timeConversion("12:05:45AM"));
		System.out.println(timeConversion("04:59:59PM"));
	}

	static String timeConversion(String s) {
		// 07:05:45PM
		String result = null;
		String hour = s.substring(0, 2);
		Integer factor = 0;
		if ((s.endsWith("PM") && !hour.equals("12"))) {
			factor = 12;
		}
		if ((s.endsWith("AM") && hour.equals("12"))) {
			factor = 12;
		}
		Integer intHour = (Integer.valueOf(hour) + factor) % 24;
		String hourConverted = String.format("%02d", intHour);
		String rest = s.substring(2, 8);
		result = hourConverted + rest;
		return result;
	}
}
