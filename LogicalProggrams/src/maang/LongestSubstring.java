package maang;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubstring {
	
	public static void main(String[] args) {
		String s = "javaconceptoftheday";
	String result =	longestString(s);
	System.out.println(result);
	}
	
	
	private static String longestString(String str) {
		
		String longestString ="";
		int length =0;
		
		Map<String,Integer> hm = new LinkedHashMap<>();
		for(int i=0; i<str.length();i++) {
			String obj = str.charAt(i)+"";
			if(hm.get(obj)==null) {
				hm.put(obj, i);
			}else {
				i= hm.get(obj);
				hm.clear();
				
			}
			
			if(hm.size()>length) {
				length = hm.size();
				longestString= hm.keySet().toString();
			}
			
			
			
		}
		
		return longestString;
		
		
	}

}
