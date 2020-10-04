package net.ads.arrays;

public class BinaryGap {
	public static void main(String[] args) {

		int input = 1041;
		input = 20;
		// input = 15;
		int result = 0;
		String bits = Integer.toBinaryString(input);

		bits = "00010011";
		System.out.println(bits);
		StringBuilder value = new StringBuilder();
		for (int i = 0; i < bits.length(); i++) {
			if (i > 0 && bits.charAt(i) == '0') {
				value.append(bits.charAt(i));
			} else if (bits.charAt(i) == '1') {
				if (value.length() > result) {
					result = value.length();
				}
				value.setLength(0);
			}
		}

		System.out.println(result);

	}
}
