package slidingWindow;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
	public static void main(String[] args) {

		String str="ABAB"; int k=2;
		int res=characterReplacement(str,2);
		System.out.println(res);
	}
	
	
	 public static int characterReplacement(String s, int k) {
	        HashMap<Character, Integer> count = new HashMap<>();
	        int res = 0;
	        int l = 0;
	        int maxf = 0;
	        
	        for (int r = 0; r < s.length(); r++) {
	            char rightChar = s.charAt(r);
	            count.put(rightChar, count.getOrDefault(rightChar, 0) + 1);
	            maxf = Math.max(maxf, count.get(rightChar));
	            
	            while (r - l + 1 - maxf > k) {
	                char leftChar = s.charAt(l);
	                count.put(leftChar, count.get(leftChar) - 1);
	                l++;
	            }
	            
	            res = Math.max(res, r - l + 1);
	        }
	        
	        return res;
	    }
}


/*

You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.

*/