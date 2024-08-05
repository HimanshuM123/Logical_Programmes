package string;

import java.util.Arrays;

public class Practice {
	public static void main(String[] args) {
		String str = "loveleetcode";
		int index = firstUniqChar(str);
		System.out.println(index);
	}

	private static int firstUniqChar(String str) {
		int[] arr = new int[256];
		Arrays.fill(arr, -1);
		
		for(int i=0; i< str.length();i++) {
			arr[str.charAt(i)]++;
		}
		
		for(int i=0; i< str.length();i++) {
			if(arr[str.charAt(i)]==0) {
				return i;
			}
		}
		
		
		

		return -1;

	}

}
