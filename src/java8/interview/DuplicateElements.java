package java8.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateElements {
	public static void main(String[] args) {
		List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");
		Set<String> duplicates = items.stream()
		                              .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
		                              .entrySet().stream()
		                              .filter(entry -> entry.getValue() > 1)
		                              .map(obj -> obj.getKey())
		                              .collect(Collectors.toSet());
		System.out.println("Duplicate items: " + duplicates);  // Output: [apple, banana]
		
		
//		Map<Object, Long> map = items.stream()
//        .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

	}

}
