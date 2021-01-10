package net.ads.arrays;

import java.util.HashMap;
import java.util.Map;

public class MostPopularNumber {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 1, 1, 3, 3 };
		int tamanho = array.length;
		int retorno = new MostPopularNumber()
				.numMaisPopular(array, tamanho);
		System.out.println("Tamanho: " + retorno);
	}

	public int numMaisPopular(int[] array, int tamanho) {
		Map<Integer, Integer> mapa = new HashMap<>();
		for (int i = 0; i < tamanho; i++) {
			Integer quantidade = mapa.get(array[i]);
			if (quantidade != null) {
				quantidade++;
			} else {
				quantidade = 1;
			}
			mapa.put(array[i], quantidade);
		}
		int maiorQuantidade = 0;
		for (int key : mapa.keySet()) {
			if (mapa.get(key) > maiorQuantidade) {
				maiorQuantidade = mapa.get(key);
			}
		}
		int menorNumero = -1;
		for (int key : mapa.keySet()) {
			if (mapa.get(key) == maiorQuantidade) {
				if (menorNumero < key) {
					menorNumero = key;
				}
			}
		}
		return menorNumero;
	}
}
