package java8.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ReverseString {
	public static void main(String[] args) {
		
		String str ="ReverseMe";
		
		String result =str.chars().mapToObj(c -> (char)c).sorted((a,b)-> -1).map(s -> s+"").collect(Collectors.joining());
		System.out.println(result);
	}

}
//wuysusga
