package java8Stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamBoxUnBoxExample {
	
	public static List<Integer> boxing(){
		return IntStream.rangeClosed(1, 10)
		//int
		.boxed()
		//integer
		.collect(Collectors.toList());
	}
	
	
	public static int unboxing(List<Integer> integerList){
		return integerList.stream()
		.mapToInt(Integer::intValue)
		.sum();
	}
	
	public static void main(String[] args) {
		System.out.println("Boxing... "+boxing());
		System.out.println("UnBoxing... "+unboxing(boxing()));
	}
}
