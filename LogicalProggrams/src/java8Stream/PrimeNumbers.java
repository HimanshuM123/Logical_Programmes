package java8Stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumbers {
	private static boolean isPrime(int number) {
		return IntStream.rangeClosed(2, (int) (Math.sqrt(number))).allMatch(n -> number % n != 0);
	}

	public static List<Integer> primeNumbersTill(int n) {
		return IntStream.rangeClosed(2, n).boxed().filter(x -> isPrime(x)).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		List<Integer> result = primeNumbersTill(100);
		System.out.println(result);

	}

}
