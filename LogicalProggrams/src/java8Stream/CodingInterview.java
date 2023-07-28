package java8Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CodingInterview {
	public static void main(String[] args) {
		// Even numbers
		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
		List<Integer> evenNumbers = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println("Even numbers ->");
		evenNumbers.forEach(o -> System.out.print(o +" "));
		System.out.println();
		
		//Numbers starts with 1
		List<Integer> list2= Arrays.asList(2,11,14,67,4,3,18,100);
		System.out.println("Numbers starts with 1 ->");
		List<String> result =list2.stream().map( a -> a+"").filter(b -> b.startsWith("1")).collect(Collectors.toList());
		result.forEach(x -> System.out.print(x+" "));
		System.out.println();
		
		//Duplicate Elements
		List<Integer> list3 = Arrays.asList(3,6,6,7,3,8,9,8);
		System.out.println("Duplicate Elements ->");
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> result2 =list3.stream().filter(o -> !set.add(o)).collect(Collectors.toList());
		result2.forEach(o -> System.out.print(o+" "));
		
		//Maximum number
		System.out.println("Maximum number");
		List<Integer> list4 = Arrays.asList(4,8,89,34,67);
		Integer max= list4.stream().max((a,b)-> a.compareTo(b)).get();
		System.out.println(max);
		
		//sort reverse order
		System.out.println("Sorting elements in reverse order-->");
		List<Integer> list5 =  Arrays.asList(4,7,2,9,82,12,45,55,122);
		List<Integer> result5 = list5.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(result5);
		
		//count occurrence
		System.out.println("Count the Occurrence-->");
		List<String> list6=  Arrays.asList("A","B","C","A","B","B");
		Map<String, Long> nameCount = list6.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(nameCount);
		
		//Minimum Number
		System.out.println("Minimum number");
		List<Integer> list7 = Arrays.asList(4,8,89,34,67);
		Integer min =list7.stream().min((a,b)-> a.compareTo(b)).get();
		System.out.println(min);
		
		//first 2 number
		System.out.println("Print first 2 numbers");
		List<Integer> list8 =  Arrays.asList(4,6,2,5,89,3,22);
		List<Integer> result8= list8.stream().limit(2).collect(Collectors.toList());
		System.out.println(result8);
		
		
	}

}
