package java8.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortArray {
	
	public static void main(String[] args) {
		int [] arr = {3,5,8,4,2,1,3,6,7};
		
	List<Integer> sortedList =Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
	System.out.println(sortedList);
	List<Integer> revList =Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	System.out.println(revList);
	}

}
