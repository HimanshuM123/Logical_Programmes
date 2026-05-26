package maang;

public class ValidPalindrome {

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";

		boolean result = isValidPalimdrom(s);
		System.out.println(result);

	}

	private static boolean isValidPalimdrom(String str) {

		int left = 0;
		int right = str.length() - 1;

		while (left < right) {

			while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
				left++;
			}
			while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
				right--;

			}

			if (!(str.charAt(left) + "").equalsIgnoreCase((str.charAt(right) + ""))) {
				return false;
			}

			left++;
			right--;

		}
		return true;
	}

}
