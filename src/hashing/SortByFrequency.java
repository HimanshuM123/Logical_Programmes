package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortByFrequency {

	private static void sortByFrequency(int[] arr) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (hm.get(arr[i]) == null) {
				hm.put(arr[i], 1);
			} else {
				hm.put(arr[i], hm.get(arr[i]) + 1);
			}
		}
		
		Set<Entry<Integer, Integer>> set = hm.entrySet();
		List<Entry<Integer, Integer>> list = new ArrayList<>(set);
		Collections.sort(list, (b,a)-> a.getValue().compareTo(b.getValue()));
		int count =0;
		for(Map.Entry<Integer, Integer> obj : list) {
			int freq = obj.getValue();
			while(freq>0) {
				arr[count]= obj.getKey();
				count++;
				freq--;
			}
			
		}
		
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {

		int[] arr = { 2, 5, 2, 8, 5, 6, 8, 8 };
		sortByFrequency(arr);

	}
}



/*
Input : arr[] = {2, 5, 2, 8, 5, 6, 8, 8}
Output : arr[] = {8, 8, 8, 2, 2, 5, 5, 6}
*/