package practice2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OddTimesArray {
	public static void main(String[] args) {

		int array[] = new int[] { 20, 40, 50, 40, 50, 20, 30, 30, 50, 20, 40, 20 };
		List<Integer> al = new ArrayList<>();

		Map<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < array.length; i++) {
			if (hm.get(array[i]) == null) {
				hm.put(array[i], 1);
			} else {
				hm.put(array[i], hm.get(array[i]) + 1);
			}
		}

		for (Map.Entry<Integer, Integer> obj : hm.entrySet()) {
			if (obj.getValue() % 2 != 0) {
				al.add(obj.getKey());
			}
		}

		System.out.println(al);

	}
}
