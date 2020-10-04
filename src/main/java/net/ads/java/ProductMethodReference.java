package net.ads.java;

public class ProductMethodReference {
	public static void main(String[] args) {
		ProductFactory<ProductExample> factory = ProductExample::new;
		ProductExample product = factory.creating("ABC", 10.0);
		System.out.println(product.getName());
	}

}

@FunctionalInterface
interface ProductFactory<P extends ProductExample> {

	P creating(String name, Double price);

	default P delete() {
		return null;
	}

}
