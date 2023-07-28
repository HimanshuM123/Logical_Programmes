package myPkg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapSortByValue2 {
public static void main(String[] args) {
	HashMap<String, Integer> hm = new HashMap<String, Integer>();
	HashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();

	hm.put("Math", 98);
	hm.put("Data Structure", 85);
	hm.put("Database", 91);
	hm.put("Java", 95);
	hm.put("Operating System", 79);
	hm.put("Networking", 80);
	
	List<Integer> al= new ArrayList<Integer>();
	
	for(Map.Entry<String, Integer>  obj:hm.entrySet()) {
		al.add(obj.getValue());
	}
	Collections.sort(al);
	System.out.println(al);
	for(Integer obj:al) {
		for(Map.Entry<String, Integer>  obj2:hm.entrySet()) {
			if(obj==obj2.getValue()) {
				sortedMap.put(obj2.getKey(), obj);
			}
		}
	}
	System.out.println(sortedMap);
}
}
