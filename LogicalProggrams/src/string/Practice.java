package string;

import java.util.Arrays;

public class Practice {
	 public static void main(String[] args) {
		 String str ="loveleetcode";
			int index = firstUniqChar(str);
			System.out.println(index);
	}
	 
	 private static int firstUniqChar(String str) {
		 int index =0;
		 
		 int [] freq = new int[26];
		 Arrays.fill(freq, -1);
		 
		 for(Character ch : str.toCharArray()) {
			 freq[ch-'a']++;
		 }
		 
		 for(int i=0; i<str.length(); i++){
	            if(freq[str.charAt(i)-'a']==0){
	                return i;
	            }
	        }
		 
		 
		 
		 return -1;
	 }

}
