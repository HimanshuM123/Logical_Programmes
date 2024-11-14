package java8.interview;

import java.util.Arrays;
import java.util.List;

public class PalindromicWords {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("madam", "apple", "civic", "banana", "radar");

		long palindromeCount = words.stream()
		                            .filter(word -> word.equals(new StringBuilder(word).reverse().toString()))
		                            .count();

		System.out.println("Number of palindromic words: " + palindromeCount);  // Output: 3

	}

}
