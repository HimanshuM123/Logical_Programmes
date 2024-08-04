package myPkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Practice {

	public static void main(String[] args) {

		String str = "javaconceptoftheday";

		Map<Character, Integer> hm = new LinkedHashMap<>();
		int longestLength =0;
		String longestString ="";
		
		
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			if (hm.get(ch) == null) {
				
				hm.put(ch, i);
			} else {
				i = hm.get(ch);
				hm.clear();
				
			}
			
			if(hm.size()>longestLength) {
				longestLength = Math.max(longestLength, hm.size());
				longestString = hm.keySet().toString();
			}
		}
		
		System.out.println(longestString);
	}

}
