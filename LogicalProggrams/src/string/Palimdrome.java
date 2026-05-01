package string;

public class Palimdrome {

	public static void main(String[] args) {
		String str = "abcdedcbai";
		boolean result = isPalimdrome(str);
		if (result) {
			System.out.println("String is palimdrome");
		} else {
			System.out.println("String is NOT palimdrome");
		}

	}

	private static boolean isPalimdrome(String str) {
		int left = 0;
		int right = str.length() - 1;

		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}
}
