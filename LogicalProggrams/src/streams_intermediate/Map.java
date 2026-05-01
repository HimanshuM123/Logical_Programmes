package streams_intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Map {

	public static void main(String[] args) {
		
		//<R> Stream<R> map(Function<? super T, ? extends R> mapper);
		List<String> list= Arrays.asList("JavaScript","Java","Golang","Python","Rubby");
		List<String> listToUpper = list.stream().map(o -> o.toUpperCase()).collect(Collectors.toList());
		System.out.println(listToUpper);
		
		List<String> listToLower = list.stream().map(String::toLowerCase).collect(Collectors.toList());
		System.out.println(listToLower);
	
	}

}
