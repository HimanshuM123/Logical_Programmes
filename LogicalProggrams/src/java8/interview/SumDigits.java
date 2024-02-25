package java8.interview;

import java.util.stream.IntStream;

public class SumDigits {
	public static void main(String[] args) {
		int number = 12345;

		IntStream stream = String.valueOf(number).chars();
		int sum = stream.map(Character::getNumericValue).reduce(0, (a, b) -> a + b);
		System.out.println(sum);
		
		
		
	}

}
