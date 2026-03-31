package java8.interview;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllSubstrings {
	public static void main(String[] args) {
		String str = "abc";

		Set<String> substrings = IntStream.range(0, str.length())
		                                  .boxed()
		                                  .flatMap(i -> IntStream.range(i + 1, str.length() + 1)
		                                                         .mapToObj(j -> str.substring(i, j)))
		                                  .collect(Collectors.toSet());

		System.out.println("Substrings: " + substrings);  // Output: [a, ab, abc, b, bc, c]

	}

}
