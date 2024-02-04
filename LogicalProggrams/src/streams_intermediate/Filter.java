package streams_intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> oddList = list.stream().filter(o -> o % 2 != 0).collect(Collectors.toList());
		System.out.println(oddList);

		List<Order> orderList = Arrays.asList(new Order("Shirt", 300), new Order("Jeans", 700), new Order("Hat", 200),
				new Order("Jacket", 900));
		
		List<Order> result =  orderList.stream().filter(o -> o.price > 500).collect(Collectors.toList());
		System.out.println("Order greater than 500-->");
		result.forEach( obj -> System.out.println(obj.name+" "+obj.price));
				
	}

}

class Order {
	String name;
	int price;

	public Order(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
}
