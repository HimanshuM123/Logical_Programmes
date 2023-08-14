package string;

public class PermuteString2 {
	public static void main(String[] args) {

		String str = "ABC";
		generatePermute(str, "");

	}

	private static void generatePermute(String str, String asf) {
		if (str.length() == 0) {
			System.out.println(asf);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String left = str.substring(0, i);
			String right = str.substring(i + 1);
			String result = left + right;
			generatePermute(result, asf + ch);

		}
	}
}
