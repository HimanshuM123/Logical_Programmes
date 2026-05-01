package hackerRank.strings;

public class Anagrams {
	public static void main(String[] args) {

		String str = "abccde";
		char words[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };

		int c = 0;
		int count1[] = new int[26];
		int count2[] = new int[26];

		if (str.length() % 2 != 0) {
			System.out.println(-1);
		} else {
			String s1 = str.substring(0, str.length() / 2);
			String s2 = str.substring(str.length() / 2);

			for (int j = 0; j < 26; j++) {
				for (int i = 0; i < s1.length(); i++) {
					if (words[j] == s1.charAt(i)) {
						count1[j]++;
					}
				}
			}

			for (int j = 0; j < 26; j++) {
				for (int i = 0; i < s2.length(); i++) {
					if (words[j] == s2.charAt(i)) {
						count2[j]++;
					}
				}
			}
			
			for(int k=0; k<26;k++) {
				c =c + Math.abs(count1[k]-count2[k]);
			}
			
			System.out.println(c/2);

		}
		
		
		
	}
}

/*

Two words are anagrams of one another if their letters can be rearranged to form the other word.

Given a string, split it into two contiguous substrings of equal length. Determine the minimum number of characters to change to make the two substrings into anagrams of one another

s=abccde

Break s into two parts: 'abc' and 'cde'. Note that all letters have been used, the substrings are contiguous and their lengths are equal. 
Now you can change 'a' and 'b' in the first substring to 'd' and 'e' to have 'dec' and 'cde' which are anagrams. Two changes were necessary.

*/