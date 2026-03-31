package myPkg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SortMapByKey {
	public static void main(String[] args) {
		Map<Integer, String> hm = new HashMap<>();

		hm.put(4, "Java");
		hm.put(2, "Hibernate");
		hm.put(1, "Spring");
		hm.put(3, "C");

		Set<Map.Entry<Integer, String>> entry = hm.entrySet();
		List<Map.Entry<Integer, String>> list = new ArrayList<>(entry);

		Collections.sort(list, (a, b) -> a.getKey().compareTo(b.getKey()));

		for (Map.Entry<Integer, String> obj : list) {
			System.out.println(obj.getKey() + " " + obj.getValue());
		}
	}
}
