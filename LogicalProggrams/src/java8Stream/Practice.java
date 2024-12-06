package java8Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {
	public static void main(String[] args) {
		 Map<Integer, String> hm = new HashMap<>();
			hm.put(4, "Apple");
			hm.put(2, "Grapes");
			hm.put(3, "Orange");
			hm.put(1, "Banana");
			
			
			List<Map.Entry<Integer, String>> entry=	hm.entrySet().stream().sorted((a,b)-> a.getValue().compareTo(b.getValue())).collect(Collectors.toList());
			
			entry.forEach(obj -> System.out.println(obj.getKey()+" "+obj.getValue()));
			
	}

}