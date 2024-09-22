package string;

public class PalindromeIndex2 {
	public static void main(String[] args) {
		//bcbc=0
		//cbcd =3
		//  abdcba =2
		int result = palindromeIndex("abdcba");
		System.out.println(result);
	}
	
	static int palindromeIndex(String s) {
		int palindromeIndex = -1;
		int left =0;
		int right = s.length()-1;
		
		while(left< right) {
			if(s.charAt(left)!= s.charAt(right)) {
				boolean isRightStringValidPalindrome = isValidPalindrome(s.substring(left+1,right+1));
				if (isRightStringValidPalindrome)
					return left;
				return right;
			}
			left++;
			right--;
		}
		return palindromeIndex;

	}
	
	public static boolean isValidPalindrome(String str) {
		int len = str.length();

		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) != str.charAt(len - i - 1)) {
				return false;
			}
		}

		return true;

	}
}


/*

Given a string of lowercase letters in the range ascii[a-z], determine the index of a character that can be removed to make the string a palindrome. There may be more than one solution, but any will do. If the word is already a palindrome or there is no solution, return -1. Otherwise, return the index of a character to remove.

Example
bcbc 

Either remove 'b' at index  or 'c' at index .




*/