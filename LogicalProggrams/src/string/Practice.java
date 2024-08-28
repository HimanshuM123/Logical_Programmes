package string;

import java.util.Arrays;

public class Practice {
	public static void main(String[] args) {
		
		String[] input = { "geeksforgeeks", "geeks", "geek", "geezer" };
		System.out.println("The longest Common Prefix is : " + longestCommonPrefix1(input));
	}

	private static String longestCommonPrefix1(String[] arr) {
		String res = arr[0];
		
		for(int i =1; i<arr.length;i++) {
			while(arr[i].indexOf(res)!=0) {
				
				res = res.substring(0, res.length()-1);
				
				
			}
		}
		
		return res;

	}

}
