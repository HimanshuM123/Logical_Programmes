package practice2;

import java.util.HashMap;
import java.util.Map;

public class Practice {
	
	public static void main(String[] args) {
		Map<Integer,String> hm = new HashMap<>();
		hm.put(1, "abc");
		hm.put(2, "xyz");
		hm.put(1, "some other value");
		
		for(Map.Entry<Integer,String> obj : hm.entrySet()) {
			System.out.println(obj.getKey()+" "+obj.getValue());
		}
			
	}
}
