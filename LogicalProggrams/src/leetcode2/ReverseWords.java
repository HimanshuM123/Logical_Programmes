package leetcode2;

import java.util.Arrays;
import java.util.Stack;

public class ReverseWords {
	public static void main(String[] args) {
		String s = "a good   example";
		String result = reverseWords(s);
		System.out.println(result);
	}
	
	 public static String reverseWords(String s) {
	        
		String[] str=  s.split(" ");
		Stack<String> stk = new Stack<>();
		for(String obj : str) {
			if(!obj.equals("")) {
				stk.push(obj.replaceAll(" ", ""));
			}
		}
		String res ="";
		
		while(!stk.isEmpty()) {
			res = res +stk.pop()+" ";
		}
		res =res.substring(0, res.length()-1);
		 
		 return res;
		 
		 
	    }

}


//https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150