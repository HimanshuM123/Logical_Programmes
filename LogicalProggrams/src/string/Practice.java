package string;

import java.util.Arrays;

public class Practice {
	public static void main(String[] args) {
		String str = "ABC";
		generatePermute(str, "");
	}

	
	private static void generatePermute(String str , String asf) {
		
	//base case
		if(str.length()==0) {
			
			System.out.println(asf);
			return;
		}
		
		for(int i=0; i<str.length();i++) {
			Character ch = str.charAt(i);
			String left = str.substring(0,i);
			String right = str.substring(i+1);
			String result = left+right;
			System.out.println("result =>"+result);
			generatePermute(result,asf+ch);
			
			
		}
		
	}
	

}
