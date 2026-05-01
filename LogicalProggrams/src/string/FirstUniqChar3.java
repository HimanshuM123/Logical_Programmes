package string;

import java.util.Arrays;

public class FirstUniqChar3 {
	 public static String  firstUniqChar(String s) {
	       String result ="";
	     
	       for(int i=0; i<s.length();i++) {
	    	   if(s.indexOf(s.charAt(i))!=s.lastIndexOf(s.charAt(i))) {
	    		   return s.charAt(i)+"";
	    	   }
	       }
	       return result;
	    }
	 
	 public static void main(String[] args) {
		 String str ="loveleetcode";
			String result = firstUniqChar(str);
			System.out.println(result);
	}
}

// 2  "v"