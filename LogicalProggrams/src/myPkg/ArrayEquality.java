package myPkg;

import java.util.HashMap;
import java.util.Map;

public class ArrayEquality {
	public static void main(String[] args) {
		int arr1[] = { 1, 2, 5, 4, 0,1};
		int arr2[] = { 2, 4, 5, 0, 1,1 };

		boolean flag = false;
		Map<Integer, Integer> hm = new HashMap<>();

		for (Integer obj : arr1) {
			if (hm.get(obj) == null) {
				hm.put(obj, 1);
			} else {
				hm.put(obj, hm.get(obj) + 1);
			}

		}

		for (Integer obj : arr2) {
			if (hm.get(obj) != null && hm.get(obj) >= 1) {
				hm.put(obj, hm.get(obj) - 1);
			}

		}

		for (Map.Entry<Integer, Integer> o : hm.entrySet()) {
			if (o.getValue() != 0) {
				flag = true;

			}
		}

		if (flag) {
			System.out.println("The arrays are NOT equals");
		} else {
			System.out.println("The arrays are  equals");
		}

	}
}

//Input: arr1[] = {1, 2, 5, 4, 0}, arr2[] = {2, 4, 5, 0, 1}

//YES