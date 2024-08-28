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
		Map<Character,Integer> hm = new LinkedHashMap<>();
		
		int longestLength=0;
		String longestString ="";
		int result=0;
		for(int i=0; i< str.length();i++) {
			if(hm.get(str.charAt(i))==null) {
				hm.put(str.charAt(i), i);
			}else {
				i= hm.get(str.charAt(i));
				hm.clear();
				
			}
			result = hm.size();
			if(result > longestLength) {
				longestLength = result;
				longestString = hm.keySet().toString();
			}
			
			
		}
		System.out.println(longestString);
		
	}

}

/*

j=0
a=1
v=2
a=3



 * 
 * */
