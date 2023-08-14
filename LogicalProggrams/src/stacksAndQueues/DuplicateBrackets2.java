package stacksAndQueues;

import java.util.Stack;

public class DuplicateBrackets2 {
	public static void main(String[] args) {
		Stack<String> st = new Stack<>();
		
		String inputStr= "(((a+b))+(c+d)))";
		
		for(int i=0;i<inputStr.length();i++) {
			if(inputStr.charAt(i)==')') {
				while(!st.peek().equalsIgnoreCase("(")) {
					st.pop();
				}
				st.pop();
			}else {
				st.push(""+inputStr.charAt(i));
			}
		}
		
		if(st.size()==0) {
			System.out.println(false);
		}else {
			System.out.println(true);
		}
	}
}
