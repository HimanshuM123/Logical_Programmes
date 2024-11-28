package java8.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice {
	public static void main(String[] args) {
		
		String str = "abcdacd";
		
		List<String> res=
		str.chars()
		.mapToObj(c->(char)c)
		.collect(Collectors.groupingBy(a -> a, Collectors.counting()))
		.entrySet()
		.stream()
		.filter(obj -> obj.getValue()==1)
		.map(k -> k.getKey()+"")
		.collect(Collectors.toList());
		
		
		System.out.println(res);
		
		
	}

}
