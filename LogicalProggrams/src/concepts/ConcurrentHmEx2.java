package concepts;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHmEx2 {

	public static void main(String[] args) {
		ConcurrentHashMap<Integer,String> hm = new ConcurrentHashMap();
		hm.put(1, "Apple");
		hm.put(2, "Orange");
		
		Iterator itr = hm.keySet().iterator();
		
		for(Map.Entry<Integer,String> obj : hm.entrySet()) {
			hm.put(3, "Modification");
			System.out.println(obj.getKey()+" "+obj.getValue());
		}
		
		
	}
}

/*

1 Apple
2 Orange
3 Modification


*/