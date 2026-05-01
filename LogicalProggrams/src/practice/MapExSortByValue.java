package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapExSortByValue {
	public static void main(String[] args) {
		Map<Integer, String> hm = new HashMap<>();
		Map<Integer, String> sortedMap = new LinkedHashMap<>();
		hm.put(4, "C++");
		hm.put(1, "Python");
		hm.put(3, "Java");
		hm.put(2, "JavaScript");
		
		Set<Map.Entry<Integer, String>> e = hm.entrySet();
		List<Map.Entry<Integer, String>> list = new ArrayList<>(e);
		
		
		//System.out.println(e);
		
		Collections.sort(list,(a,b)-> a.getValue().compareTo(b.getValue()));
		
		for(Map.Entry<Integer, String> o :list) {
			sortedMap.put(o.getKey(), o.getValue());
		}
		
		for(Map.Entry<Integer, String> o :sortedMap.entrySet()) {
			System.out.println(o.getKey()+"  "+o.getValue());
		}
		
		
	}
}
