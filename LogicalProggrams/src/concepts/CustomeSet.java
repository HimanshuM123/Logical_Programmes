package concepts;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CustomeSet {

	Map<Integer, Integer> hm = new LinkedHashMap<>();
	Integer PRESENT = 0;

	private boolean add(int num) {
		return hm.put(num, PRESENT) == null;
	}
	
	private void print() {
		for(Map.Entry<Integer, Integer> obj : hm.entrySet()) {
			System.out.print(obj.getKey()+" ");
		}
	}

	public static void main(String[] args) {
		CustomeSet set = new CustomeSet();
		set.add(10);
		set.add(20);
		set.add(20);
		set.add(30);
		
		set.print();
	}

}
