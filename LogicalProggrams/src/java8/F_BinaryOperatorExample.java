package java8;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class F_BinaryOperatorExample {

	static Comparator<Integer> comparator = (a, b) -> a.compareTo(b);

	public static void main(String[] args) {
		// use this when input & output has same type like Integer in this case
		BinaryOperator<Integer> binary = (a, b) -> a * b;
		System.out.println("Result is " + binary.apply(4, 5));

		BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
		System.out.println("The result of maxby is " + maxBy.apply(4, 5));
		
		BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
		System.out.println("The result of minBy is " + minBy.apply(4, 5));
	}
}
