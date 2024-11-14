package java8.interview;

import java.util.List;
import java.util.stream.Collectors;

public class DistinctCharacters {
	public static void main(String[] args) {
		String input = "banana";

		List<Character> distinctChars = input.chars()
		                                     .mapToObj(c -> (char) c)
		                                     .distinct()
		                                     .collect(Collectors.toList());

		System.out.println("Distinct characters: " + distinctChars);  // Output: [b, a, n]

	}

}
