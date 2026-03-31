package string;

import java.util.Stack;

public class ReverseVowels {
	
	public static void main(String[] args) {
		String str = "aA";
		Stack<Character> stk = new Stack();
		String result="";
		for(char ch : str.toCharArray()) {
			if(isVowel(ch)) {
				stk.push(ch);
			}
		}
		
		for(char ch : str.toCharArray()) {
			if(isVowel(ch)) {
				result = result + stk.pop();
			}else {
				result = result + ch;
			}
		}
		
		System.out.println(result);
		
		
	}
	
	private static boolean isVowel(char ch) {
		return "aeiouAEIOU".contains(ch+"");
	}

}


/*

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"
 


*/