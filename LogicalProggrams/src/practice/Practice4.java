package practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice4 {
	public static void main(String[] args) {

		Map<Integer,String> hm = new HashMap<Integer,String>();
		hm.put(4, "Java");
		hm.put(2, "Hibernate");
		hm.put(1, "Spring");
		hm.put(3, "C");
		
	List<Map.Entry<Integer,String>> list=	hm.entrySet().stream().sorted((a,b)-> a.getValue().compareTo(b.getValue()))
		.collect(Collectors.toList());
	
	list.forEach(obj -> System.out.println(obj.getKey()+" "+obj.getValue()));
	}

}
