package myPkg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapSortEx1 {
	public static void main(String[] args) {
		Map<Integer, String> hm = new HashMap<>();
		hm.put(1, "Mango");
		hm.put(2, "Banana");
		hm.put(3, "Orange");
		hm.put(4, "Apple");

		Set<Map.Entry<Integer, String>> set = hm.entrySet();
		List<Map.Entry<Integer, String>> list = new ArrayList<>(set);

		Collections.sort(list, (a, b) -> a.getValue().compareTo(b.getValue()));

		for (Map.Entry<Integer, String> o : list) {
			System.out.println(o.getKey() + " " + o.getValue());
		}
	}

}
