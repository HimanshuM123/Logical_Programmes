package string;

import java.util.Arrays;

public class RepetativeString {

	public static void main(String[] args) {
		String str = "abcdaaaabc";
		int len = str.length();
		int count = 1;

		int arr[] = new int[len];
		char charArr[] = str.toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			for (int j = i + 1; j < charArr.length; j++) {
				if (charArr[i] == charArr[j] && charArr[i] != '*') {
					count++;
					arr[i] = count;
					charArr[j] = '*';
				} else {
					arr[i] = count;
				}

			}
			count = 1;

		}
		System.out.println(Arrays.toString((arr)));
		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] != '*') {
				System.out.print(charArr[i] + " ->" + arr[i] + "  ");
			}
		}

	}
}
