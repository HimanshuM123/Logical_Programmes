package collection;

import java.util.HashMap;
import java.util.Map;

public class CommonElement {
	public static void main(String[] args) {
		int arr1[] = { 1, 1, 2, 2, 2, 3, 5 };
		int arr2[] = { 1, 1, 1, 2, 2, 4, 5 };

		Map<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < arr1.length; i++) {
			if (hm.get(arr1[i]) == null) {
				hm.put(arr1[i], 1);
			} else {
				hm.put(arr1[i], hm.get(arr1[i]) + 1);
			}
		}

		for (int i = 0; i < arr2.length; i++) {
			if (hm.get(arr2[i]) != null && hm.get(arr2[i]) > 0) {
				System.out.print(arr2[i]+" ");
				hm.put(arr2[i], hm.get(arr2[i]) - 1);
			}
		}
	}
}

//output -> 1 1 2 2 5