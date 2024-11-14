package java8.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringToMap {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("apple", "banana", "cherry");

		Map<String, Integer> wordLengths = words.stream()
		                                        .collect(Collectors.toMap(word -> word, String::length));

		System.out.println("Word lengths: " + wordLengths);  // Output: {apple=5, banana=6, cherry=6}

	}

}
