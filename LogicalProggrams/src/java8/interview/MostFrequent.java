package java8.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MostFrequent {
	
	public static void main(String[] args) {
		List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

		String mostFrequent = items.stream()
		                           .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
		                           .entrySet().stream()
		                           .max(Map.Entry.comparingByValue())
		                           .map(Map.Entry::getKey)
		                           .orElse(null);

		System.out.println("Most frequent item: " + mostFrequent);  // Output: apple

	}

}
