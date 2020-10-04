package net.ads.arrays;

import java.util.Scanner;

public class SolutionSimpleTextEditor {
	private static final int APPEND = 1;
	private static final int DELETE = 2;
	private static final int PRINT = 3;
	private static final int UNDO = 4;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		StringBuilder result = new StringBuilder();
		int q = scanner.nextInt();
		int[] command = new int[q];
		String[] value = new String[q];
		scanner.nextLine();
		for (int i = 0; i < q; i++) {
			String line = scanner.nextLine();
			String[] values = line.split(" ");
			command[i] = Integer.parseInt(values[0]);
			if (values.length == 2)
				value[i] = values[1];
		}

		for (int i = 0; i < q; i++) {
			if (command[i] == APPEND) {
				append(result, value, i);
			} else if (command[i] == DELETE) {
				delete(result, value, i);
			} else if (command[i] == PRINT) {
				int pos = Integer.parseInt(value[i]);
				System.out.println(result.charAt(pos - 1));
			} else if (command[i] == UNDO) {
				undo(result, command, value, i);
			}

		}
		scanner.close();
	}

	private static void undo(StringBuilder result, int[] command, String[] value, int i) {
		for (int j = i; j >= 0; j--) {
			if (command[j] == APPEND) {
				append(result, value, i);
			} else if (command[j] == DELETE) {
				delete(result, value, i);
			}
		}
	}

	private static void delete(StringBuilder result, String[] value, int i) {
		int pos = Integer.parseInt(value[i]);
		result.delete(result.length() - pos, result.length());
	}

	private static void append(StringBuilder result, String[] value, int i) {
		result.append(value[i]);
	}
}
