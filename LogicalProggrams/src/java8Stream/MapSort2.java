package java8Stream;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSort2 {
	public static void main(String[] args) {
		Map<Integer, String> hm =  new HashMap<>();
		hm.put(4,"r");
		hm.put(6,"a");
		hm.put(8,"h");
		hm.put(45,"c");
		hm.put(2,"z");
		
		
	List<Map.Entry<Integer, String>> list =	hm.entrySet()
		.stream()
		.sorted((a,b)-> a.getValue().compareTo(b.getValue()))
		.collect(Collectors.toList());
	
	
	list.forEach(obj -> System.out.println(obj.getKey()+" "+obj.getValue()));

		
	}
}
