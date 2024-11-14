package java8.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountFreq {
	public static void main(String[] args) {
		String input = "hello world";

		Map<Character, Long> frequency = input.replace(" ", "").chars()
						.mapToObj(obj -> (char)obj)
						.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
						
		System.out.println(frequency);//{r=1, d=1, e=1, w=1, h=1, l=3, o=2}
		
		Map<Character, Long> frequency2 = input.replace(" ", "").chars()
						.mapToObj(obj -> (char)obj)
						.collect(Collectors.groupingBy(c -> c,()-> new LinkedHashMap<>(), Collectors.counting()));
				
				System.out.println(frequency2);//{h=1, e=1, l=3, o=2, w=1, r=1, d=1}
                  //maintains order

	}

}
