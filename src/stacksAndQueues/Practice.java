package stacksAndQueues;

import java.util.Stack;

public class Practice {
	public static void main(String[] args) {
		String inputStr= "(a+b)+((c+d))";
		
		boolean result = duplicates(inputStr);
		System.out.println(result);
		
	}
	
	private static boolean duplicates(String str) {
		Stack<Character> stk = new Stack<>();
		
		for(Character ch : str.toCharArray()) {
			if(ch ==')') {
				if(stk.peek()=='(') {
					return true;
				}
				while( stk.peek()!='(') {
					stk.pop();
				}
				
				stk.pop();
				
				
				
			}else {
				stk.push(ch);
			}
			
			
		}
		
		return false;
		
		
	}
	
}

