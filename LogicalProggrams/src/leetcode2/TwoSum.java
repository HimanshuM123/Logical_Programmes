package leetcode2;

public class TwoSum {
	public static void main(String[] args) {
		int[] arr = { 2, 7, 11, 15 };
		int target = 9;
		
		int left_ptr =0;
		int right_ptr= arr.length-1;
		
		while(left_ptr < right_ptr) {
			int sum= arr[left_ptr]+arr[right_ptr];
			if(sum > target) {
				right_ptr--;
			}else if (sum <target) {
				left_ptr++;
			}else {
				System.out.println(" The indexes are "+left_ptr+" "+right_ptr);
				break;
			}
			
		}
		

	}
}

//[2,7,11,15] target =9
//
//output -> [0,1]