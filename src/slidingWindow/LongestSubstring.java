package slidingWindow;

import java.util.HashSet;
import java.util.Set;

//Longest substring without  repeating chars
public class LongestSubstring {
	private static  int lenghtOfLongestSubStr(String str) {
		
		Set<Character> set = new HashSet<>();
		int j =0;
		int result =0;
		for(int i=0; i< str.length();i++) {
			while(set.contains(str.charAt(i))) {
				set.remove(str.charAt(j));
				j++;
			}
			set.add(str.charAt(i));
			result = Math.max(result, i-j+1);
		}
		
		return result;
	}

	public static void main(String[] args) {
		String str ="abcabcd";
		int result = lenghtOfLongestSubStr(str);
		System.out.println(result);
		
		
	}
}

/*
abcabcbb  

-> 4   abcd

*/