package practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class A_test {
	
	public static void main(String[] args) {
		Map<Integer, String> hm = new HashMap<>();
		hm.put(1, "Mango");
		hm.put(2, "Banana");
		hm.put(3, "Orange");
		hm.put(4, "Apple");
		
	List<Map.Entry<Integer, String>>	set =hm.entrySet().stream().sorted((a,b)-> a.getValue().compareTo(b.getValue())).collect(Collectors.toList());
	
	for(Map.Entry<Integer, String> obj : set) {
		System.out.println(obj.getKey()+" "+obj.getValue());
	}
	
	}

}
