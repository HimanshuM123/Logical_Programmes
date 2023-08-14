package stacksAndQueues;

import java.util.Stack;

public class DuplicateBrackets {
public static void main(String[] args) {
	
	Stack<String> st= new Stack<String>();
	
	String inputStr= "(((a+b))+(c+d))";
	for(int i=0;i<inputStr.length();i++) {
		if(inputStr.charAt(i)==')') {
			if(st.peek().equalsIgnoreCase("(")) {
				System.out.println(true);
				return;
			}
			while(!(st.peek().equalsIgnoreCase("("))) {
				st.pop();
			}
			st.pop();
		}else {
			st.push(""+inputStr.charAt(i));
		}
	}
	System.out.println(false);
}
}


//((a+b)+(c+d)) -> False
//(a+b)+((c+d)) -> True