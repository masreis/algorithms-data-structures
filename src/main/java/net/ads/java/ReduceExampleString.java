package net.ads.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ReduceExampleString {
	public static void main(String[] args) {

		// Country with more characters
		List<String> countries = Arrays.asList("Germany", "England", "China", "Denmark", "Brazil", "France",
				"Australia");

		Optional<String> countryName = countries

				.stream()

				.reduce((c1, c2) -> c1.length() > c2.length() ? c1 : c2);

		countryName.ifPresent(System.out::println);

		Optional<String> minLen = countries.stream().min(Comparator.comparing((a) -> a.length()));

		minLen.ifPresent(System.out::println);

		Optional<String> maxLen = countries.stream().max(Comparator.comparing(String::length));

		maxLen.ifPresent(System.out::println);
		
	}
}
