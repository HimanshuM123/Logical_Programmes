package java8.interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumOfDigits {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(123, 45, 6);

		int sumOfDigits = numbers.stream()
		                         .mapToInt(num -> String.valueOf(num)
		                                                .chars()
		                                                .map(Character::getNumericValue)
		                                                .sum())
		                         .sum();

		System.out.println("Sum of all digits: " + sumOfDigits);  // Output: 21  <- 1 +2 +3+4+5+6
		
		
		
		//sum of numbers
		List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);

		int sum = numbers2.stream()
		                 .mapToInt(Integer::intValue)
		                 .sum();

		System.out.println("Sum: " + sum);  // Output: 15

		

	}

}
