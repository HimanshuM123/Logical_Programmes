package java8.interview;

import java.util.stream.IntStream;

public class Factorial {
	public static void main(String[] args) {
		int number = 5;

		int factorial = IntStream.rangeClosed(1, number)
		                         .reduce(1, (a, b) -> a * b);

		System.out.println("Factorial of 5: " + factorial);  // Output: 120

	}

}
