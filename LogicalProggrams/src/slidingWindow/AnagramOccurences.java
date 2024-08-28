package slidingWindow;

public class AnagramOccurences {

	public static void main(String[] args) {
		String txt = "forxxorfxdofr";
		String pat = "for";

		int res = search(pat, txt);
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

	static int search(String pat, String txt) {
//forxxorfxdofr
		//for
		int n = txt.length();
		int[] arr = new int[26];
		for (int i = 0; i < pat.length(); i++) {
			char ch = pat.charAt(i);
			arr[ch - 'a']++;
		}
//[0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0]
		int i = 0;
		int j = 0;
		int result = 0;

		int k = pat.length();
		while (j < n) {
			arr[txt.charAt(j) - 'a']--;
			if (j - i + 1 == k) {
				if (allZeros(arr)) {
					result++;
				}
				arr[txt.charAt(j) - 'a']++;
				i++;
			}
			j++;
		}
		return result;
	}

}

/*
 * txt = forxxorfxdofr pat =for
 * 
 * output =3
 * 
 * for, orf & ofr appears 3 times
 * 
 */