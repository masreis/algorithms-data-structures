package net.ads.java;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByExample {
	public static void main(String[] args) {

		List<ProductExample> products = Arrays.asList(new ProductExample("A", 12.0), new ProductExample("B", 20.0),
				new ProductExample("C", 12.0), new ProductExample("D", 5.0), new ProductExample("E", 90.0),
				new ProductExample("F", 91.0), new ProductExample("G", 92.0));

		Map<Boolean, List<ProductExample>> moreThan20 = products.stream()
				.collect(Collectors.partitioningBy(product -> product.getPrice() > 20));

		System.out.println("=> moreThan20");
		moreThan20.get(true).stream().map(ProductExample::getName).forEach(System.out::println);

		Map<Double, List<ProductExample>> byPrice = products.stream()
				.collect(Collectors.groupingBy(ProductExample::getPrice));

		System.out.println("=> byPrice");
		byPrice.forEach(
				(k, list) -> list.forEach(product -> System.out.println("Key: " + k + ":" + product.getName())));

	}

}
