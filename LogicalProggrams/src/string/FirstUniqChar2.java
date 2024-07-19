package string;

import java.util.Arrays;

public class FirstUniqChar2 {
	 public static int  firstUniqChar(String s) {
	        char[] ch = s.toCharArray();
	        int[] freq = new int[26];
	        Arrays.fill(freq,-1);
	        for(int i=0; i<ch.length; i++){
	           freq[ch[i]-'a']++;
	        }
	        for(int i=0; i<ch.length; i++){
	            if(freq[ch[i]-'a']==0){
	                return i;
	            }
	        }
	        return -1;
	    }
	 
	 public static void main(String[] args) {
		 String str ="loveleetcode";
			int index = firstUniqChar(str);
			System.out.println(index);
	}
}

// 2  "v"