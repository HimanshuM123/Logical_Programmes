package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapEx extends Thread{
	
	@Override
	public void run() {
		Map<Integer,String> hm  = new HashMap<>();
	//	Map<Integer,String> hm  = new ConcurrentHashMap<>();
		hm.put(1, "London");
		hm.put(2, "New York");
		hm.put(3, "Mumbai");
		
		for(Map.Entry<Integer, String> obj : hm.entrySet()) {
			hm.put(4, "France");
			System.out.println(obj.getKey()+"   "+obj.getValue());
		}
	}
	
	public static void main(String[] args) {
		ConcurrentHashMapEx t1 = new ConcurrentHashMapEx();
		ConcurrentHashMapEx t2 = new ConcurrentHashMapEx();
		t1.start();
		t2.start();
	}
	

}
