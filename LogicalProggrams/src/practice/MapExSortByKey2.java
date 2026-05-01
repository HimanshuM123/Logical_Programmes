package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapExSortByKey2 {
public static void main(String[] args) {
	Map<Integer, String> hm = new HashMap<>();
	Map<Integer, String> sortedMap = new LinkedHashMap<>();
	hm.put(4, "C++");
	hm.put(1, "Python");
	hm.put(3, "Java");
	hm.put(2, "JavaScript");
	
	Set<Map.Entry<Integer, String>> set = hm.entrySet();
	List<Map.Entry<Integer,String>> al = new ArrayList<>(set);
	 Collections.sort(al, (x,y)-> x.getKey().compareTo(y.getKey()));
	 
	 for(Map.Entry<Integer, String> o : al) {
		 sortedMap.put(o.getKey(),o.getValue() );
	 }
	 
	 for(Map.Entry<Integer, String> o : al) {
		 System.out.println(o.getKey()+" "+o.getValue());
	 }
}
}
