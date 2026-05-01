package twoPointer;

import java.util.Arrays;

public class FourSum {
	
	public static void main(String[] args) {
	
		int arr [] = { 1, 2, 3, 4, 5, 9, 7, 8 };
		int X = 16;
		Arrays.sort(arr);
		for (int i=0; i< arr.length-3;i++) {
			for(int j=i+1; j < arr.length-2; j++) {
				int left = j+1;
				int right = arr.length-1;
				
				while(left < right) {
					
					if(arr[i]+arr[j]+arr[left]+arr[right]==X) {
						System.out.println(arr[i]+" "+arr[j]+" "+arr[left]+" "+arr[right]);
						left ++;
						right--;
					}else if(arr[i]+arr[j]+arr[left]+arr[right]<X) {
						left++;
						
					}else {
						right--;
					}
				}
			}
			
		}
		
		
	}

}


/*


 { 1, 2, 3, 4, 5, 9, 7, 8 };

=>
1 2 4 9
1 2 5 8
1 3 4 8
1 3 5 7
2 3 4 7


*/