package string;

import java.util.Arrays;

public class Practice {
	public static void main(String[] args) {
		String s = "abc";
		String t = "ahbgdc";
		boolean result = isSubstring(s,t);
		System.out.println(result);
	}

	
	private static boolean  isSubstring(String s,String t) {
		int i=0;
		int j=0;
		
		int len1 =s.length();
		int len2=t.length();
		
		while(i < len1 && j < len2) {
			if(s.charAt(i)==t.charAt(j)) {
				i++;
				j++;
			}
			else {
				j++;
			}		
		}
		return i==s.length();
	}
	

}
