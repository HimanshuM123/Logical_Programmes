package java8Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class A_Practice {
	public static void main(String[] args) {
		
		boolean result = isPrime(15);
		System.out.println(result);
	
	}
	
	private static boolean isPrime(int number) {
		
		
		return IntStream.rangeClosed(2, (int)Math.sqrt(number)).allMatch(n -> number %n !=0);
		
	}
}
