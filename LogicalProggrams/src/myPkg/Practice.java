package myPkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Practice {

	public static void main(String[] args) {
		Map<Integer, String> hm = new HashMap<>();
		hm.put(1, "Mango");
		hm.put(2, "Banana");
		hm.put(3, "Orange");
		hm.put(4, "Apple");
		
	List<Map.Entry<Integer, String>> list =	hm.entrySet().stream().sorted((a,b)-> a.getValue().compareTo(b.getValue())).collect(Collectors.toList());
	
	list.stream().forEach((obj)-> System.out.println(obj.getKey()+" "+obj.getValue()));
	}

}

/*
 * 
 * j=0 a=1 v=2 a=3
 * 
 * 
 * 
 * 
 */
