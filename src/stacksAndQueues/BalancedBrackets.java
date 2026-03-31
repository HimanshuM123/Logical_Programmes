package stacksAndQueues;

import java.util.Stack;

public class BalancedBrackets {
public static void main(String[] args) {
	
	Stack <Character> st = new Stack <>();
	//String str = "[(a+b)+{(c+d)*(e/f)}]";
	//String str = "[(a+b)+{(c+d)*(e/f)]}";
	String str ="}}";
	boolean flag = true;
	for(int i=0; i< str.length();i++) {
		if(str.charAt(i)=='[' || str.charAt(i)=='(' || str.charAt(i)=='{') {
			st.push(str.charAt(i));
		} else if (str.charAt(i)==']' ) {
		flag=	handleClosing( str.charAt(i),'[', str,  i, st,  flag) ;
		}else if (str.charAt(i)==')' ) {
		flag=	handleClosing( str.charAt(i),'(', str,  i, st,  flag) ;
		}else if (str.charAt(i)=='}' ) {
		flag=	handleClosing( str.charAt(i),'{', str,  i, st,  flag) ;
		}
	}
	if(flag) {
		System.out.println("BalancedBrackets found");
	}else {
		System.out.println("BalancedBrackets not found");
	}
}

private static boolean handleClosing( Character ch,Character opening,String str, int i, Stack <Character> st, boolean flag) {
	 if(str.charAt(i)==ch ) {
			if(st.empty()) {
				flag =false;
			}
			if(!st.empty() && st.peek() == opening) {
				 st.pop();
			}
		}
		
	 return flag;
}
}


// [(a+b)+{(c+d)*(e/f)}] --> true
//[(a+b)+{(c+d)*(e/f)]} -->false