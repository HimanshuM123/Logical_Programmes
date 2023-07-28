package leetCode;

import java.util.Stack;

/*
 Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false 
 
 * */
public class ValidParentheses {
public static void main(String[] args) {
	//String str="([])";
	String str="))";
	//((){}[])
	//{[]}
	//{[}]
	System.out.println(isValid(str));
}

public static boolean isValid(String s) {
   Stack<String> st = new Stack<>();
  
   for(int i=0;i<s.length();i++) {
	   if(s.length()%2!=0) {
		   return false;
	   }
	   
	   if(("{[(").contains(String.valueOf(s.charAt(i)))) {
		   st.push(String.valueOf(s.charAt(i)));
	   }
	   if(String.valueOf(s.charAt(i)).equals("}")  )
	   {
		   if( !st.empty() && "{".equals(st.lastElement())) {
		   st.pop();
	   }else if(!st.contains("{")) {
		   return false;
	   }
		  
	   }
	   if(String.valueOf(s.charAt(i)).equals(")")  )
	   {
		   if( !st.empty() && "(".equals(st.lastElement())) {
		   st.pop();
	   }else if(!st.contains("(")) {
		   return false;
	   }
		  
	   }
	   if(String.valueOf(s.charAt(i)).equals("]")  )
	   {
		   if( !st.empty() && "[".equals(st.lastElement())) {
		   st.pop();
	   }else if(!st.contains("[")) {
		   return false;
	   }
		  
	   }
	  
	  
   }
   
   
   return st.empty();
  
}

   }















