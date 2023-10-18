package hackerRank.strings;

import java.util.HashMap;
import java.util.Map;

public class Anagram3 {
	public static void main(String[] args) {
		String str = "abccde";
		
		String str1 = str.substring(0,str.length()/2);
		String str2 = str.substring(str.length()/2);
		int count = 0;

		Map<Character, Integer> hm = new HashMap<Character, Integer>();

		for (Character ch : str1.toCharArray()) {
			if (hm.get(ch) == null) {
				hm.put(ch, 1);
			} else {
				hm.put(ch, hm.get(ch) + 1);
			}
		}
		
		
		for (Character ch : str2.toCharArray()) {
			if(hm.get(ch)!= null && hm.get(ch)>0) {
				hm.put(ch, hm.get(ch) - 1);
			}
			
		}
		
		for(Map.Entry<Character, Integer> obj : hm.entrySet()) {
			if(obj.getValue()>0) {
				count++;
			}
		}
		
		System.out.println("The character changes required are "+count);

	}
}