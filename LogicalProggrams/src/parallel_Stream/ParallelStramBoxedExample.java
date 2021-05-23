package parallel_Stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStramBoxedExample {
	
	public static int sequentialSum(List<Integer> integerList) {
		long start=System.currentTimeMillis();
		int sum=integerList.stream()
		.reduce(0,(a,b)->a+b);
		long end=System.currentTimeMillis();
		System.out.println("Duration in sequential stream "+(end-start));
		return sum;
	}
	
	public static int parallelSum(List<Integer> integerList) {
		long start=System.currentTimeMillis();
		int sum=integerList.stream().parallel()
		.reduce(0,(a,b)->a+b);//unboxing takes longer time
		long end=System.currentTimeMillis();
		System.out.println("Duration in parallel stream "+(end-start));
		return sum;
	}
	
	
	
	public static void main(String[] args) {
		List<Integer> integerList = IntStream.rangeClosed(1, 10000).boxed()
				.collect(Collectors.toList());
		sequentialSum(integerList);
		parallelSum(integerList);
	}
}
