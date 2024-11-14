package java8.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice {
	public static void main(String[] args) {
		String input = "hello world";
		
		Map<Character, Long> map=	input.chars()
		.mapToObj(obj -> (char)obj)
		.collect(Collectors.groupingBy((c -> c),()-> new LinkedHashMap<Character, Long>(), Collectors.counting()));
	
	System.out.println(map);
		
	}

}
