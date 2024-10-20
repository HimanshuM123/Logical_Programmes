package string;

import java.util.Arrays;
import java.util.Stack;

public class Practice {
	public static void main(String[] args) {
		String str = "ab-C-dEf-ghIj";
		
		Stack<Character> stk = new Stack();
		String result ="";
		
		for(int i=0 ;i <str.length();i++) {
			Character ch = str.charAt(i);
			
			if(Character.isLetter(ch)) {
				stk.push(ch);
			}
		}
		
		for(int i=0 ;i <str.length();i++) {
			Character ch = str.charAt(i);
			
			if(Character.isLetter(ch)) {
				result = result+stk.pop();
			}else {
				result = result+ ch;
			}
		}
		
		System.out.println(result);

	}

}
