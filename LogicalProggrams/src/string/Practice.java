package string;

import java.util.Arrays;

public class Practice {
	 public static void main(String[] args) {
		 String str1 = "braggg";
			String str2 = "gggrap";
			System.out.println(isAnagram(str1,str2));
	}
	 
	 private static boolean isAnagram(String str1,String str2) {
		StringBuffer buffer = new StringBuffer(str1);
		
		for(int i=0; i<str1.length();i++) {
			char ch = str1.charAt(i);
			if(buffer.indexOf(ch+"")!=-1) {
				int index = buffer.indexOf(ch+"");
				buffer.deleteCharAt(index);
			}
		}
		return buffer.length()==0;
	 }

}
