package hashing;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentEle {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 1, 4, 1 };
		Map<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int ele = arr[i];
			if (hm.get(ele) == null) {
				hm.put(ele, 1);
			} else {
				hm.put(ele, hm.get(ele) + 1);
			}
		}
		
		int max_count=0;
		int ele =0;
		for(Map.Entry<Integer, Integer> obj : hm.entrySet()) {
			if(obj.getValue() > max_count) {
				max_count = obj.getValue();
				ele = obj.getKey();
			}
			
		}
		System.out.println(ele);

	}
}
