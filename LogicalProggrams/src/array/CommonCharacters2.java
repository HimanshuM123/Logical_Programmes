package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonCharacters2 {
	public static void main(String[] args) {

		// String [] arr = {"bella","label","roller"};
		String[] arr = { "BBBBbb", "Bbbb" };
		List<String> res = commonChars(arr);
		System.out.println(res);
	}

	private static List<String> commonChars(String[] arr) {
		List<String> list = new ArrayList<>();
		int[] countArray = new int[256];
		Arrays.fill(countArray, Integer.MAX_VALUE);
		//System.out.println(Arrays.toString(countArray));
		
		for(String obj : arr) {
			int[] freqArray = new int[256];
			for(Character ch : obj.toCharArray()) {
				freqArray[ch-'A']++;
			}
			//System.out.println(Arrays.toString(freqArray));
			
			for(int i=0; i<256 ;i++) {
				countArray[i] = Math.min(countArray[i],freqArray[i]);
				
			}
			
			//System.out.println(Arrays.toString(countArray));
			
		}
		
		for(int i=0; i< 256 ;i++) {
			while(countArray[i] > 0) {
				list.add(String.valueOf((char)(i+'A')));
				
				countArray[i]--;
			}
		}

		return list;

	}


}
