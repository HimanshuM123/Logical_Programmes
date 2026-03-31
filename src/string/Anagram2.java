package string;

import java.util.Arrays;

public class Anagram2 {
	
	public static void main(String[] args) {
		String str1="ACBD^";
		String str2= "^DCBA";
		
		if(isAnagram(str1,str2)) {
			System.out.println("The string is Anagram");
		}else {
			System.out.println("The string is Not Anagram");
		}
	}
	
	private static boolean isAnagram(String str1, String str2) {
		int count [] = new int[256];
		
		for(int i=0;i<str1.length();i++) {
			count[str1.charAt(i)]++;
			count[str2.charAt(i)]--;
		}
		
		System.out.println(count.length);
		
		for(int i=0;i<count.length;i++) {
			if(count[i]!=0) {
				return false;
			}
		}
		return true;
	}
}
