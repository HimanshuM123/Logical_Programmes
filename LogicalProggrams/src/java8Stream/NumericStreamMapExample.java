package java8Stream;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamMapExample {
	
	public static List<Integer> mapToObject() {
		return IntStream.rangeClosed(1,5)
		.mapToObj(i->{
			return new Integer(i);
		})
		.collect(Collectors.toList());
		
	}
	
	public static long mapToLong() {
		return IntStream.rangeClosed(1,5)
				.mapToLong((i)->i)//convert instream to longstream
				.sum();
		
	}
	
	public static double mapToDouble() {
		return IntStream.rangeClosed(1,5)
				.mapToDouble((i)->i)//convert instream to doublestream
				.sum();
		
	}
	
	
	public static void main(String[] args) {
			System.out.println("Map to obj "+mapToObject());
			System.out.println("Map to long "+mapToLong());
			System.out.println("Map to double "+mapToDouble());
	}
}
