package practice;

import java.util.HashMap;
import java.util.Map;

public class MapEx {
	public static void main(String[] args) {

		Map<Integer,String> hm = new HashMap<>();
		hm.put(1, "Java");
		hm.put(2, "C++");
		hm.put(3, "Go");
		hm.put(4, "Python");
		
		for(Map.Entry obj : hm.entrySet()) {
			System.out.println(obj.getKey() +"  "+obj.getValue());
		}
	}
}
