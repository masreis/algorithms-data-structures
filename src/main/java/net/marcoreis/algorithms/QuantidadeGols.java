package net.marcoreis.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class QuantidadeGols {
	static int[] teamA;

	public static String processInput(String inputLine) {
		int goals = Integer.parseInt(inputLine);
		int total = teamA.length;
		for (int i = teamA.length - 1; i >= 0; i--) {
			if (teamA[i] <= goals) {
				break;
			}
			total--;
		}

		return String.valueOf(total);
	}

	// Este e um exemplo de processamento de entradas (inputs), sinta-se a
	// vontade para altera-lo conforme necessidade da questao.
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int qtd = Integer.parseInt(scanner.nextLine());
		teamA = new int[qtd];
		for (int i = 0; i < qtd; i++) {
			String inputLine = scanner.nextLine();
			teamA[i] = Integer.parseInt(inputLine);
		}

		Arrays.sort(teamA);

		qtd = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < qtd; i++) {
			String inputLine = scanner.nextLine();
			System.out.println(processInput(inputLine));
		}
		scanner.close();
	}
}
