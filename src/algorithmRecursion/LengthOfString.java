package algorithmRecursion;

public class LengthOfString {

	public static void main(String[] args) {

		int result = findLength("sample", 0);
		System.out.println(result);
	}

	private static int findLength(String str, int index) {
		if (index == str.length() ) {
			return 0;
		}

		return (1 + findLength(str, index + 1));

	}

}
