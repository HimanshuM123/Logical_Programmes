package java8Stream;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSort {
	public static void main(String[] args) {
		Map<Integer, String> hm =  new HashMap<>();
		hm.put(4,"r");
		hm.put(6,"a");
		hm.put(8,"h");
		hm.put(45,"c");
		hm.put(2,"z");
		
//		for(Map.Entry<Integer, String> obj : hm.entrySet()) {
//			System.out.println(obj.getKey()+" "+obj.getValue());
//		}
		
		Map<Integer,String> result = hm.entrySet().stream().sorted(Map.Entry.comparingByKey())
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue)-> oldValue, LinkedHashMap::new));
		
//		for(Map.Entry<Integer, String> obj : result.entrySet()) {
//			System.out.println(obj.getKey()+" "+obj.getValue());
//		}
		
		Map<Integer,String> result2 = hm.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue)-> oldValue, LinkedHashMap::new));
				
				for(Map.Entry<Integer, String> obj : result2.entrySet()) {
					System.out.println(obj.getKey()+" "+obj.getValue());
				}
		
	}
}
