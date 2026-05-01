package java8Stream;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamRangesExample {
	public static void main(String[] args) {
			IntStream.range(1, 50).forEach(n->System.out.print(n+","));
			System.out.println();
			System.out.println("Range count "+IntStream.range(1, 50).count());
			System.out.println();
			IntStream.rangeClosed(1, 50).forEach(n->System.out.print(n+","));
			System.out.println();
			System.out.println("Range closed count "+IntStream.rangeClosed(1, 50).count());
			System.out.println();
			LongStream.range(1, 50).forEach(n->System.out.print(n+","));
			System.out.println();
			IntStream.range(1, 50).asDoubleStream().forEach(n->System.out.print(n+","));
			
	}
}
