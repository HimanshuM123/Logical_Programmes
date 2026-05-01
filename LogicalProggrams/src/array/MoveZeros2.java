package array;

import java.util.Arrays;

public class MoveZeros2 {
public static void main(String[] args) {
	int [] arr= {1,2,0,3,0,0,0,4,5};
	int [] result = new int[arr.length];
	int j=0;
	for(int i=0;i<arr.length;i++) {
		if(arr[i]!=0) {
			result[j]=arr[i];
			j++;
		}
		
	}
	for(int i=0;i<arr.length;i++) {
		if(arr[i]==0) {
			result[j]=arr[i];
			j++;
		}
		
	}
	System.out.println(Arrays.toString(result));
	
}
}


//[1,2,0,3,0,0,0,4,5]=>[1,2,3,4,5,0,0,0,0]