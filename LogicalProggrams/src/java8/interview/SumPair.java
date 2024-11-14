package java8.interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumPair {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		int targetSum = 7;

		List<int[]> pairs = numbers.stream()
		                           .flatMap(a -> numbers.stream()
		                                                .filter(b -> a + b == targetSum)
		                                                .map(b -> new int[]{a, b}))
		                           .collect(Collectors.toList());

		pairs.forEach(pair -> System.out.println(Arrays.toString(pair)));
		// Output: [1, 6], [2, 5], [3, 4]

	}

}
