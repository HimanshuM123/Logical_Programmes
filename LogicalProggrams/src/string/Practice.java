package string;

import java.util.Arrays;

public class Practice {
	 public static void main(String[] args) {
		 String str1="ACBD^";
			String str2= "^DCBL";
			System.out.println(isAnagram(str1,str2));
	}
	 
	 private static boolean isAnagram(String str1,String str2) {
		
		 StringBuffer bf = new StringBuffer(str2);
		 for(Character ch : str1.toCharArray()) {
			 
			 int index = bf.indexOf(ch+"");
			 
			 if(index !=-1) {
				 bf.deleteCharAt(index);
			 }
			 
			 
		 }
		 
		 System.out.println(bf.toString());
		 return bf.length()==0;
	 }

}
