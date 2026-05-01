package streams_intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sorted {
	public static void main(String[] args) {
		// Stream<T> sorted(Comparator<? super T> comparator);
		List<Integer> intList = Arrays.asList(4, 1, 8, 2, 0, 1, 6, 7);
		List<Integer> result = intList.stream().sorted((a, b) -> a.compareTo(b)).collect(Collectors.toList());
		System.out.println(result);
		
		List<Order> orderList = Arrays.asList(new Order("Shirt", 300), new Order("Jeans", 700), new Order("Hat", 200),
				new Order("Jacket", 900));
		
		List<Order> orderListSorted = orderList.stream().sorted((a,b)-> a.price- b.price).collect(Collectors.toList());
		
		orderListSorted.forEach(o -> System.out.print( o.name+" "+o.price+" "));
		
	}
}


