package leetCodePepcoding;

import java.util.Arrays;

//Rearrange array by size
public class RearrangeArray {
public static void main(String[] args) {
	
	int [] arr= {3,1,-2,-5,2,-4};
	int [] result =new int [arr.length];
	int positivePointer=0;
	int negativePointer=1;
	
	for(int i=0;i<arr.length;i++) {
		if(arr[i]>0) {
			result[positivePointer]=arr[i];
			positivePointer=positivePointer+2;
		}else if(arr[i]<0) {
			result[negativePointer]=arr[i];
			negativePointer=negativePointer+2;
		}
	}
	
	
	System.out.println(Arrays.toString(result));
	
	
}
}

//[3,1,-2,-5,2,-4]=>[3,-2,1,-5,2,-4]