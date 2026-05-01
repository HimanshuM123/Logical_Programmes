package streams_intermediate;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Distinct {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,1,2,2,3,3,4,4,5,5);
		List<Integer> result = list.stream().distinct().collect(Collectors.toList());
		System.out.println(result);
		
		Stream<String> list2 =  Stream.of("Java","Python","C++","C","Java");
		List<String> result2 =list2.distinct().collect(Collectors.toList());
		System.out.println(result2);
		
	}

}
