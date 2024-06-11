package practice2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Practice3 {
	public static void main(String[] args) {
		
	Map<Integer,String> hm = new HashMap<>();
	hm.put(1, "Mango");
	hm.put(2, "Orange");
	hm.put(3, "Apple");
	
	Set<Map.Entry<Integer,String>> set = hm.entrySet();
	List<Map.Entry<Integer,String>> list = new ArrayList<>(set);
	
	list.sort((a,b)-> a.getValue().compareTo(b.getValue()));
	
	for(Map.Entry<Integer,String> obj : list) {
		System.out.println(obj.getKey() +" "+obj.getValue());
	}
	
		
	}
}
