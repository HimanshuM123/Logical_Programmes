package java8Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Distinct {
public static void main(String[] args) {
	 List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
	    List<Integer> distinctIntList = intList.stream()
	    		.distinct().collect(Collectors.toList());
	    System.out.println(distinctIntList);
	    
	    
	    Optional<Integer> min = intList.stream().min((a,b)-> a.compareTo(b));
	    System.out.println("minimum number is "+min.get());
	    
}
}
