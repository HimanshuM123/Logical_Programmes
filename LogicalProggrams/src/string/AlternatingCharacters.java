package string;

public class AlternatingCharacters {
	public static void main(String[] args) {
		String str = "AABAAB"; // ABAB 2 deletions
		
		int res = getDeletions(str);
		System.out.println(res);

	}

	private static int getDeletions(String str) {
		int deletions = 0;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i - 1) == str.charAt(i)) {
				deletions++;
			}
		}
		return deletions;

	}

}

/*
 * 
 * 
 * You are given a string containing characters A and B only. Your task is to
 * change it into a string such that there are no matching adjacent characters.
 * To do this, you are allowed to delete zero or more characters in the string.
 * 
 * Your task is to find the minimum number of required deletions.
 * 
 * 
 */