package net.marcoreis.algorithms;

public class AlmostPalindrome {
	public static void main(String[] args) {
		boolean retorno = new AlmostPalindrome().quasePalindromo("abcddccx");
		System.out.println("Palindromo: " + retorno);
		retorno = new AlmostPalindrome().quasePalindromo("abcddbbb");
		System.out.println("Palindromo: " + retorno);
	}

	public boolean quasePalindromo(String palavra) {
		int wrong = 0;
		int half = palavra.length() / 2 - 1;
		int j = half + 1;
		for (int i = half; i >= 0; i--) {
			if (palavra.charAt(i) != palavra.charAt(j)) {
				wrong++;
			}
			j++;
		}
		return wrong <= 1;
	}
}
