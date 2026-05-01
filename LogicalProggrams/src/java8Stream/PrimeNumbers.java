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
		
		
		IntStream.rangeClosed(2, (int) (Math.sqrt(100))).forEach(o -> System.out.println(o));

	}

}
//[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]
