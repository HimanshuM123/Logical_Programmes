package string;

import java.util.HashMap;
import java.util.Map;

public class Anagram3 {
	public static void main(String[] args) {
		String str1 = "braggg";
		String str2 = "gggrab";
		boolean isAnagram = true;

		Map<Character, Integer> hm = new HashMap<Character, Integer>();

		for (Character ch : str1.toCharArray()) {
			if (hm.get(ch) == null) {
				hm.put(ch, 1);
			} else {
				hm.put(ch, hm.get(ch) + 1);
			}
		}
		
		
		for (Character ch : str2.toCharArray()) {
			if(hm.get(ch)!= 0 && hm.get(ch)>0) {
				hm.put(ch, hm.get(ch) - 1);
			}
			
		}
		
		for(Map.Entry<Character, Integer> obj : hm.entrySet()) {
			if(obj.getValue()>0) {
				 isAnagram = false;
			}
		}
		
		if(isAnagram) {
			System.out.println("The strings are anagram");
		}else {
			System.out.println("The strings are NOT anagram");
		}

	}
}
