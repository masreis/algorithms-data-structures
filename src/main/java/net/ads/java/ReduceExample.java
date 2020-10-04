package net.ads.java;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 30, 4, 5, 10);

		Optional<Integer> result = list.stream().reduce((a, b) -> a > b ? a : b);
		System.out.println(result.get());

	}

	class Person {

	}
}
