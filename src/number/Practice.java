package number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {

	public static void main(String[] args) {

	int num =54123;
	
	
	
	List<String> list = Arrays.asList("5","4","1","2","3");
	
	List<String> result  =list.stream().sorted((a,b)-> a.compareTo(b)).collect(Collectors.toList());
	System.out.println(result);
	
	List<Integer> list2 = Arrays.asList(5,4,1,2,3);
	
	List<Integer> result2  =list2.stream().sorted((a,b)-> a-b).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	System.out.println(result2);
		
	}
	
}

// 1 1 2 3 5 8 13 21 34 55