package java8.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ElementFrequency {
	public static void main(String[] args) {
		List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

		Map<String, Long> frequencyMap = items.stream()
		                                      .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

		System.out.println("Frequency map: " + frequencyMap);  // Output: {orange=1, banana=2, apple=3}

	}

}
