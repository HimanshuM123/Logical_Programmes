package java8Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Practice {
	public static void main(String[] args) {
		Map<Integer, String> hm = new HashMap<>();
		hm.put(4, "Apple");
		hm.put(2, "Grapes");
		hm.put(3, "Orange");
		hm.put(1, "Banana");
		
		
//		Set<Map.Entry<Integer, String>> set  = hm.entrySet();
//		List<Map.Entry<Integer, String>>  list = new ArrayList<>(set);
//		list.sort((a,b)->a.getValue().compareTo(b.getValue()));
//		
//		for(Map.Entry<Integer, String> obj : list) {
//			System.out.println(obj.getKey()+" "+obj.getValue());
//		}
		
		Map<Integer, String> map3  =	hm.entrySet().stream().sorted((a,b)-> a.getValue().compareTo(b.getValue())).collect(Collectors.toMap(p ->p.getKey(), s->s.getValue()));
		System.out.println(map3);
		
		
		List<String> list  =	hm.entrySet().stream().sorted((a,b)-> a.getValue().compareTo(b.getValue())).map(s-> s.getValue()).collect(Collectors.toList());
		System.out.println(list);

	}

}