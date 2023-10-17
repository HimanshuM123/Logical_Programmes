package hackerRank.strings;

public class AlternatingCharacters {
	public static void main(String[] args) {
		int delete = 0;
		String s = "ABABABAB";
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i - 1) == s.charAt(i)) {
				delete++;
			}
		}
		System.out.println("The number of deletions required "+delete);
	}
}

/*
 * You are given a string containing characters A and B only. Your task is to
 * change it into a string such that there are no matching adjacent characters.
 * To do this, you are allowed to delete zero or more characters in the string.
 * 
 * Your task is to find the minimum number of required deletions.
 * 
 * s =AABAAB Remove an A at positions 0 and 3 to make ABAB in 2 deletions.
 * 



AAAA -3
BBBBB -4
ABABABAB-0
BABABA-0
AAABBB -4

 */