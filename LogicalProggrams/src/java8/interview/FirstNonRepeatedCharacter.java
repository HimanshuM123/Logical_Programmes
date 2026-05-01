package java8.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {
	
	public static void main(String[] args) {
		String input = "swiss";
		Character firstNonRepeated = input.chars()
		                                   .mapToObj(c -> (char) c)
		                                   .collect(Collectors.groupingBy(c -> c, () -> new LinkedHashMap<>(), Collectors.counting()))
		                                   .entrySet().stream()
		                                   .filter(entry -> entry.getValue() == 1)
		                                   .map(Map.Entry::getKey)
		                                   .findFirst()
		                                   .orElse(null);
		System.out.println("First non-repeated character: " + firstNonRepeated);  // Output: w

	}

}
