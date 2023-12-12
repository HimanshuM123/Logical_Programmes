package leetcode2;

public class RestoreString {
	public static void main(String[] args) {

		String s = "codeleet";
		int[] indices = { 4, 5, 6, 7, 0, 2, 1, 3 };
		String result = restoreString(s, indices);
		System.out.println(result);
	}

	public static String restoreString(String s, int[] indices) {

		String[] arr = new String[indices.length];
		for (int i = 0; i < indices.length; i++) {
			
			
			int j = indices[i];
			arr[j]=String.valueOf(s.charAt(i));
					
		}

		String result = "";
		for (int i = 0; i < arr.length; i++) {
			result = result + arr[i];
		}
		return result;
	}

}

//leetcode



/*
Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
Output: "leetcode"
Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
*/