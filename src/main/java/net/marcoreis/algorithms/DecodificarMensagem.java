package net.marcoreis.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DecodificarMensagem {
	public static String processInput(String inputLine) {
		String values[] = inputLine.split(" ");
		int len = Integer.parseInt(values[0]);
		String message = values[1];
		int qtdPass = message.length() / len;
		Map<String, Integer> map = new HashMap<>();
		int max = 0;
		int pos = 0;
		for (int i = 0; i <= message.length() - len; i++) {
			String pwd = message.substring(i, len + i);
			if (map.get(pwd) != null) {
				map.put(pwd, map.get(pwd) + 1);
			} else {
				map.put(pwd, 1);
			}
		}

		for (String pwd : map.keySet()) {
			if (map.get(pwd) > max) {
				max = map.get(pwd);
			}
		}
		for (String pwd : map.keySet()) {
			if (map.get(pwd) == max) {
				return pwd;
			}
		}
		return "";
	}

	// Este e um exemplo de processamento de entradas (inputs), sinta-se a
	// vontade para altera-lo conforme necessidade da questao.
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int qtd = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < qtd; i++) {
			String inputLine = scanner.nextLine();
			System.out.println(processInput(inputLine));
		}
		scanner.close();
	}

	// final class MapValueComparator<K, V extends Comparable<V>>
	// implements Comparator<K> {
	//
	// private Map<K, V> map;
	//
	// private MapValueComparator() {
	// super();
	// }
	//
	// public MapValueComparator(Map<K, V> map) {
	// this();
	// this.map = map;
	// }
	//
	// public int compare(K o1, K o2) {
	// return map.get(o1).compareTo(map.get(o2));
	// }
	// }
}