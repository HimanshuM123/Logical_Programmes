package java8.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice {
	public static void main(String[] args) {
		
		List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
		
		String res=
		items.stream().collect(Collectors.groupingBy(c -> c, Collectors.counting())).entrySet()
		.stream()
		.max((x,y)-> Long.compare(x.getValue(), y.getValue()))
		.map(obj -> obj+"")
		.get();
		
		System.out.println(res);
		
		
	}

}
