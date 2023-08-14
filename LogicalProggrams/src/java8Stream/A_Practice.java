package java8Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class A_Practice {
	public static void main(String[] args) {
		List<Integer> al = Arrays.asList(2,7,7,2,6,6);
		
	List<Integer> result =	al.stream().distinct()
			.collect(Collectors.toList());
	//result.forEach(o -> System.out.println(o));
	
	Optional<Integer> res= al.stream().min((a,b)-> a.compareTo(b));
	//System.out.println(res.get());
	
	Integer sum = al.stream().reduce(0,(a,b)-> a+b);
	System.out.println(sum);
	
	
	}
}
