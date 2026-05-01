package java8.interview;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibonacci {
	public static void main(String[] args) {
		int n = 10;

		List<Integer> fibonacci = Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
		                                .limit(n)
		                                .map(f -> f[0])
		                                .collect(Collectors.toList());

		System.out.println("Fibonacci sequence: " + fibonacci);  // Output: [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]

	}

}
