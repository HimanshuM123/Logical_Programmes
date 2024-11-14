package java8.interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommonElements {
	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("apple", "banana", "cherry", "date");
		List<String> list2 = Arrays.asList("banana", "date", "fig", "grape");

		List<String> commonElements = list1.stream()
		                                   .filter(list2::contains)
		                                   .collect(Collectors.toList());

		System.out.println("Common elements: " + commonElements);  // Output: [banana, date]

	}

}
