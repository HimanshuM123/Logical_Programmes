package java8.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice {
	public static void main(String[] args) {
		
		int number = 47932;
		
		String res =String.valueOf(number).chars().mapToObj(c->(char)c).sorted((a,b)->-1).map( v -> v+"").collect(Collectors.joining());
	System.out.println(res);
	}

}
