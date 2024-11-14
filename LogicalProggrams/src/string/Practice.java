package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class Practice {
	public static void main(String[] args) {
		 int result = palindromeIndex("abfcddcba");
		 System.out.println(result);

		
	}

	private static int palindromeIndex(String str) {
		int left =0;
		int right =str.length() - 1; 
		
		while(left < right) {
			if(str.charAt(left)!= str.charAt(right)) {
			boolean res =isPalimdrom(str.substring(left+1,right+1));
			if(res) {
				return left;
			}else {
				return right;
			}
			}
		
			
			left ++;
			right--;
		}
	

		return -1;

	}

	private static boolean isPalimdrom(String str) {

		int left = 0;
		int right = str.length() - 1;
		while (left < right) {

			if (str.charAt(right) != str.charAt(left)) {
				return false;
			}

			left++;
			right--;
		}

		return true;

	}
}
