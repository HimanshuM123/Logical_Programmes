package array;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueOccurrences {
	public static void main(String[] args) {
		int arr [] = {1,2,2,1,3};
		boolean result =uniqueOccurrences(arr);
		System.out.println(result);
	}

	public static boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> hm = new HashMap<>();

		for (Integer obj : arr) {
			if (hm.get(obj) == null) {
				hm.put(obj, 1);
			} else {
				hm.put(obj, hm.get(obj) + 1);
			}
		}
		
		System.out.println(hm.size());
		Set<Integer> set = new HashSet<>();
	for(Map.Entry<Integer, Integer> obj : hm.entrySet()) {
		set.add(obj.getValue());
	}

		return set.size()==hm.size();

	}
}

/*
 * 
 * Input: arr = [1,2,2,1,1,3] Output: true Explanation: The value 1 has 3
 * occurrences, 2 has 2 and 3 has 1. No two values have the same number of
 * occurrences.
 */