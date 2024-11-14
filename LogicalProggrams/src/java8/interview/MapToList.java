package java8.interview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapToList {
public static void main(String[] args) {
	Map<String, Integer> map = new HashMap<>();
	map.put("A", 1);
	map.put("B", 2);
	map.put("C", 3);

	List<String> keyValuePairs = map.entrySet().stream()
	                                .map(entry -> entry.getKey() + "=" + entry.getValue())
	                                .collect(Collectors.toList());

	System.out.println("Key-Value pairs: " + keyValuePairs);  // Output: [A=1, B=2, C=3]

}
}
