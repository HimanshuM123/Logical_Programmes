package codingInterview;

public class IndexOfSubArraySum {
	public static void main(String[] args) {
		int [] arr = {1,2,3,7,5};
		int target =12;
		
		int left =0;
		int currentSum =0;
		
		for(int right=0; right < arr.length; right++) {
			currentSum = currentSum+arr[right];
			
			while(currentSum>target && left <=right) {
				currentSum =currentSum-arr[left];
				left++;
			}
			
			if(currentSum == target) {
				System.out.println("left "+left +" right "+right);
			}
			/*
			 left 1 right 3 (2,3,7)
			 left 3 right 4 (7,5)

			 */
		}
	}

}
