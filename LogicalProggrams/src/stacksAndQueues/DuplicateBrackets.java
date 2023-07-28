package stacksAndQueues;

import java.util.Stack;

public class DuplicateBrackets {
public static void main(String[] args) {
	
	Stack<String> st= new Stack<String>();
	boolean flag=false;
	String inputStr= "(((a+b))+(c+d))";
	for(int i=0;i<inputStr.length();i++) {
		if(inputStr.charAt(i)==')') {
			if(st.peek().equalsIgnoreCase("(")) {
				flag=true;
			}
			while(!(st.peek().equalsIgnoreCase("("))) {
				st.pop();
			}
			st.pop();
		}else {
			st.push(String.valueOf(inputStr.charAt(i)));
		}
	}
	if(flag) {
		System.out.println("True");
	}else {
		System.out.println("False");
	}
	
}
}


//((a+b)+(c+d)) -> False
//(a+b)+((c+d)) -> True