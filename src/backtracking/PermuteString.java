package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermuteString {
	public static void main(String[] args) {
		String str = "abc";
		permuteString(str, "");

	}

	private static void permuteString(String str, String asf) {
		if (str.length() == 0) {
			System.out.print(asf + " ");
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String left = str.substring(0, i);
			String right = str.substring(i + 1);
			String result = left + right;
			permuteString(result, asf + ch);
		}

	}
}
