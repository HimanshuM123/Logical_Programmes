package parallel_Stream;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStramExample {

	public static long checkPerformanceResult(Supplier<Integer> supplier, int numOfTimes) {

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < numOfTimes; i++) {

			supplier.get();
		}
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

	public static int sumSequentialStream() {

		return IntStream.rangeClosed(1, 100000).sum();
	}

	public static int sumParallelStream() {

		return IntStream.rangeClosed(1, 100000).parallel().sum();
	}

	public static void main(String[] args) {
		
		System.out.println("Sequential stream result: "+checkPerformanceResult(ParallelStramExample::sumSequentialStream,20));
		System.out.println("Parallel stream result: "+checkPerformanceResult(ParallelStramExample::sumParallelStream,20));

	}

}
