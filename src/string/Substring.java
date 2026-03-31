package string;

//Find if a given string can be represented from a substring by iterating the substring “n” times
public class Substring {

	public static void main(String[] args) {
		String str = "ABCABCFABC";
		//String str = "AABCAAABCA";
		if (findPeriod(str) == -1)
			System.out.println("false");
		else
			System.out.println("True");
	}

	public static int findPeriod(String A) {
		int length = A.length();

		int period = -1;
		int i = 0;
		for (int j = 1; j < length; j++) {
			int currChar = A.charAt(j);
			int comparator = A.charAt(i);

			if (currChar == comparator) {
				period = (j - i);
				i++;
			}

			else {
				if (currChar == A.charAt(0)) {
					i = 1;
					period = j;
				} else {
					i = 0;
					period = -1;
				}
			}
		}

		period = (length % period != 0) ? -1 : period;
		return period;
	}
}
