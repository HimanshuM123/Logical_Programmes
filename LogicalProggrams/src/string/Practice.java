package string;

import java.util.Arrays;

public class Practice {
	public static void main(String[] args) {
		String str1= "ABCJ";
		String str2= "ADBC";
		boolean res = anagram(str1,str2);
		if(res) {
			System.out.println("This is anagram");
		}else {
			System.out.println("This is NOT anagram ");
		}	
	}

	private static boolean  anagram(String str1, String str2) {
		
		int count[] = new int[256];
		for(int i=0; i<str1.length();i++) {
			count[str1.charAt(i)-'0']++;
			count[str2.charAt(i)-'0']--;
		}
		
		for(int j =0; j <count.length;j++) {
			if(count[j]!=0) {
				return false;
			}
		}
		return true;
		
		}
		
		

	

}
