package codingInterview;

public class KthLargestQuickSelect {
	public static void main(String[] args) {
	//	int[] arr = { 3, 2, 1, 5, 6, 4 };
		int[] arr = { 5, 1, 4, 2, 3};
		int k = 3;
		int result = findKthLargest(arr, k);
		System.out.println(result);

	}

	    public static int findKthLargest(int[] nums, int k) {
	        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
	    }

	    private static int quickSelect(int[] nums, int left, int right, int kSmallest) {
	        int pivotIndex = partition(nums, left, right);

	        if (pivotIndex == kSmallest) return nums[pivotIndex];
	        else if (pivotIndex < kSmallest)
	            return quickSelect(nums, pivotIndex + 1, right, kSmallest);
	        else
	            return quickSelect(nums, left, pivotIndex - 1, kSmallest);
	    }

	    private static int partition(int[] nums, int left, int right) {
	        int pivot = nums[right];
	        int i = left;

	        for (int j = left; j < right; j++) {
	            if (nums[j] <= pivot) {
	                swap(nums, i, j);
	                i++;
	            }
	        }

	        swap(nums, i, right);
	        return i;
	    }

	    private static void swap(int[] nums, int i, int j) {
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
	
}
