package algorithmsBasics;

import java.util.HashMap;
import java.util.Map;

public class ArrayDuplicates {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 3, 5, 7, 3, 6, 7, 2 };
		Map<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			if (hm.containsKey(arr[i])) {
				hm.put(arr[i], hm.get(arr[i]) + 1);
			} else {
				hm.put(arr[i], 1);
			}
		}
		System.out.println(hm);

	}

}
