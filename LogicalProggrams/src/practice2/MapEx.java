package practice2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapEx {
	public static void main(String[] args) {
		
		Map<Integer,String> hm  = new HashMap<>();
		hm.put(1, "Mumbai");
		hm.put(2, "Delhi");
		hm.put(3, "London");
		hm.put(4, "New York");
		
		
//		for(Map.Entry<Integer, String> o : hm.entrySet()) {
//			System.out.println(o.getKey()+"  "+o.getValue());
//		}
		
		Iterator<Map.Entry<Integer, String>> itr = hm.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<Integer, String> b=	itr.next();
			System.out.println(b.getKey() +"   "+b.getValue());
		}
		
	}
}
