package codingInterview;

import java.util.Arrays;

public class RearrangeArrayBySign {
	
	public static void main(String[] args) {
		int [] arr = {3, 1, -2, -5, 2, -4};
		int [] result = rearrangeArray(arr);
		System.out.println(Arrays.toString(result));//[3, -2, 1, -5, 2, -4]
		
	}
	
	private static int[] rearrangeArray(int [] arr) {
		
		int [] res = new int[arr.length];
		int posIdx=0;
		int negIdx=1;
		
		
		for(int obj : arr) {
			if(obj >0) {
				res[posIdx]=obj;
				posIdx=posIdx+2;
			}
			
			if(obj <0) {
				res[negIdx]=obj;
				negIdx=negIdx+2;
			}
			
		}
		
		return res;
		
	}
	
	
	

}
