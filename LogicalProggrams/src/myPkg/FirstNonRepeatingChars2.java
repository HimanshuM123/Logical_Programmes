package myPkg;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class FirstNonRepeatingChars2 {
	public static void main(String[] args) {
		String str = "geeksforgeeks";

		Map<Character, Integer> hm = new LinkedHashMap<>();
		
	
		for (Character ch : str.toCharArray()) {
			if (hm.get(ch) == null) {
				hm.put(ch, 1);
			} else {
				hm.put(ch, hm.get(ch) + 1);
			}
		}

		hm.forEach((k, v) -> {
			if (hm.get(k) == 1) {
				System.out.println("First non-repeating number is " + k);
				
			}
			
		});

	}
}

//geeksforgeeks -> f