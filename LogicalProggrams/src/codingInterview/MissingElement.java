package codingInterview;

public class MissingElement {
	
	public static void main(String[] args) {
		int [] arr = {2,3,3,1,4};
		int result = missingElement(arr);
		System.out.println(result);
				
	}
	
	
	private static int missingElement(int [] arr) {
		int missing=0;
		
		for(int i=0; i<arr.length;i++) {
			int idx = Math.abs(arr[i])-1;
			if(arr[i]>0) {
				arr[idx]= -arr[idx];
			}
		}
		
		for(int i=0; i<arr.length;i++) {
			
			if(arr[i]>0) {
				missing=i+1;
				
			}
		}
		
		return missing;
	}

}


/*

2,3,3,1,4
2,-3,3,1,4
2,-3,3,1,4
2,-3,-3,1,4
-2, -3, -3, 1, 4
-2, -3, -3, -1, 4


*/