package array;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int uniqueIndex = 0; // This will track the position of unique elements.

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) { // Check for a new unique value.
                uniqueIndex++; // Move the unique index forward.
                nums[uniqueIndex] = nums[i]; // Assign the new unique value.
            }
        }

        return uniqueIndex + 1; // Length of the unique elements.
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2,2, 3, 4, 4, 5};
        int length = removeDuplicates(nums);

        System.out.println("Array after removing duplicates:");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
