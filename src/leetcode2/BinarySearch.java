package leetcode2;

public class BinarySearch {
	public static void main(String[] args) {
	int arr[]= {-2,0,2,5,34,46,54,67,345,2345};
	int target=67;
	
	int result = binarySearch(arr,target);
	System.out.println(result);
	
	}
	
	private static int binarySearch(int [] nums, int tg) {
		int left =0;
		int right=nums.length-1;
		while(left < right) {
			int mid = left+(right-left)/2;
			if(nums[mid]==tg) {
				return mid;
			}else if(nums[mid]<tg) {
				left = mid+1;
			}else {
				right =mid-1;
			}
		}
		return -1;
	}
}
