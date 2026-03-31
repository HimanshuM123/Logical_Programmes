package java8.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestWord {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("apple", "banana", "cherry", "date");

		String longestWord = words.stream()
		                          .max(Comparator.comparingInt(String::length))
		                          .orElse(null);

		System.out.println("Longest word: " + longestWord);  // Output: banana

	}

}
