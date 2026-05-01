package java8.interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CheckForSorted {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		boolean isSorted = IntStream.range(0, numbers.size() - 1)
		                            .allMatch(i -> numbers.get(i) <= numbers.get(i + 1));

		System.out.println("Is list sorted: " + isSorted);  // Output: true

	}

}
