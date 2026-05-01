package java8.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Top3 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(5, 12, 7, 20, 18, 30, 25);

		List<Integer> top3Highest = numbers.stream()
		                                   .sorted(Comparator.reverseOrder())
		                                   .limit(3)
		                                   .collect(Collectors.toList());

		System.out.println("Top 3 highest numbers: " + top3Highest);  // Output: [30, 25, 20]

	}

}
