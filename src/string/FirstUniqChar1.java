package string;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqChar1 {

	public static int firstUniqChar(String s) {
		Map<Character, Integer> hm = new LinkedHashMap<>();
		for (Character obj : s.toCharArray()) {
			if (hm.get(obj) == null) {
				hm.put(obj, 1);
			} else {
				hm.put(obj, hm.get(obj) + 1);
			}
		}

		for (Map.Entry<Character, Integer> obj : hm.entrySet()) {
			if (obj.getValue() == 1) {
				Character key = obj.getKey();
				int index = s.indexOf(key + "");

				return index;
			}
		}
		return -1;

	}
	
	public static void main(String[] args) {
		String str ="loveleetcode";
		int index = firstUniqChar(str);
		System.out.println(index);
		
	}

}
