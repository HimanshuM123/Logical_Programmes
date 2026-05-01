package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapExSortByKey {
	public static void main(String[] args) {
		Map<Integer, String> hm = new HashMap<>();
		Map<Integer, String> sortedMap = new HashMap<>();
		hm.put(4, "C++");
		hm.put(1,"Python");
		hm.put(3, "Java");
		hm.put(2, "JavaScript");
		
	
		
		Set<Integer> keySet = hm.keySet();
		List<Integer> list=  new ArrayList<Integer>(keySet);
		Collections.sort(list);
		for(Integer obj :list) {
			sortedMap.put(obj, hm.get(obj));
		}
		
		for(Map.Entry o : sortedMap.entrySet()) {
			System.out.println(o.getKey() +" "+o.getValue());
		}
		
	}
}
