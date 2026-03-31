package java8.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListOfStringsByLength {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");

		Map<Integer, List<String>> wordsByLength = words.stream()
		                                                .collect(Collectors.groupingBy(String::length));

		System.out.println("Words grouped by length: " + wordsByLength);
		// Output: {3=[fig], 4=[date], 5=[apple, grape], 6=[banana, cherry]}

	}

}
