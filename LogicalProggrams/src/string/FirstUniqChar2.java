package string;

import java.util.Arrays;

public class FirstUniqChar2 {
	 public static String  firstUniqChar(String s) {
	       String result ="";
	       int [] arr = new int[26];
	       for(int i=0; i<s.length();i++) {
	    	   arr[s.charAt(i)-'a']++;
	       }
	       
	       
	       for(int i=0; i<s.length();i++) {
	    	  if(arr[s.charAt(i)-'a']==1) {
	    		 result = s.charAt(i)+"";
	    		 break;
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