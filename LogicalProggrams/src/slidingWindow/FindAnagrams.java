package slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
	
	public static void main(String[] args) {
		String txt = "forxxorfxdofr";
		String pat = "for";

		 List res = search(pat, txt);
		System.out.println("The result is "+res);
	}

	static boolean allZeros(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				return false;
			}
		}

		return true;
	}

	static List search(String pat, String txt) {

		int n = txt.length();
		int[] arr = new int[26];
		for (int i = 0; i < pat.length(); i++) {
			char ch = pat.charAt(i);
			arr[ch - 'a']++;
		}

		int i = 0;
		int j = 0;
		List result  = new ArrayList<>();

		int k = pat.length();
		while (j < n) {
			arr[txt.charAt(j) - 'a']--;
			if (j - i + 1 == k) {
				if (allZeros(arr)) {
					result.add(i);
				}
				arr[txt.charAt(j) - 'a']++;
				i++;
			}
			j++;
		}
		return result;
	}


}
//The result is [0, 4, 10]
