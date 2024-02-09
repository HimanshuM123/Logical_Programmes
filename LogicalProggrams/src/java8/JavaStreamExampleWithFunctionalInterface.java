package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Product {
	int id;
	String name;
	float price;

	Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

}

public class JavaStreamExampleWithFunctionalInterface {

	public static void main(String[] args) {
		List<Product> productsList = new ArrayList<Product>();
		// Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));

		List<String> productList = productsList.stream()
				.filter(obj -> obj.price > 30000)
				.map(obj -> obj.name)
				.collect(Collectors.toList());
		
		
		Predicate<? super Product> pred = new Predicate<Product>() {
			@Override
			public boolean test(Product n) {
				return n.price > 30000;
			}
		};
		
		Function<Product, String> fun = new Function<Product, String>() {

			@Override
			public String apply(Product product) {
				return product.name;
			}

		};
		
		Consumer<String> consumer = new Consumer<String>() {
			@Override
			public void accept(String str) {
				System.out.print(str + " ");
			}
		};

		 productsList.stream()
//				.filter(pred)
				.filter(new Predicate<Product>() {
					@Override
					public boolean test(Product n) {
						return n.price > 30000;
					}
				})
//				.map(fun)
				.map(new Function<Product, String>() {
					@Override
					public String apply(Product product) {
						return product.name;
					}

				//}).forEach(consumer);
				}).forEach(new Consumer<String>() {
					@Override
					public void accept(String str) {
						System.out.print(str + " ");
					}
				});
		 
		
		
       System.out.println();
		System.out.println(productList);
		
	}
}
