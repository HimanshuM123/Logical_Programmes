package java8.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ReverseString {
	public static void main(String[] args) {
		
		int number = 12345;
		Integer sum =
		String.valueOf(number).chars().mapToObj(c ->(char)c).map(i -> Integer.parseInt(i+"")).reduce((a,b)-> a+b).get();
		
		System.out.println(sum);
	}

}
//wuysusga
