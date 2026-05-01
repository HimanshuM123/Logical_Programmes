/*
 * LeetCode 268: Missing Number
 *
 * Problem: Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 *
 * Example: Input: nums = [3,0,1] -> Output: 2
 *
 * Approach: Math (XOR or Sum)
 * - Option 1: Sum approach - calculate expected sum and subtract actual sum
 * - Option 2: XOR approach - XOR all numbers with range 0 to n (missing number will remain)
 * - XOR is better to avoid integer overflow
 *
 * Time Complexity: O(n) - single pass
 * Space Complexity: O(1) - only variables
 */

public class MissingNumber {

    // Approach 1: Using XOR
    // XOR properties: a ^ a = 0, a ^ 0 = a, XOR is commutative
    public int missingNumberXOR(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int xor = 0;

        // XOR all array elements
        for (int num : nums) {
            xor ^= num;
        }

        // XOR with all numbers from 0 to n
        for (int i = 0; i <= nums.length; i++) {
            xor ^= i;
        }

        return xor;
    }

    // Approach 2: Using Sum
    // Expected sum of 0 to n = n * (n + 1) / 2
    public int missingNumberSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        long expectedSum = (long) n * (n + 1) / 2;
        long actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return (int) (expectedSum - actualSum);
    }

    public static void main(String[] args) {
        MissingNumber sol = new MissingNumber();

        System.out.println(sol.missingNumberXOR(new int[]{3, 0, 1}));        // 2
        System.out.println(sol.missingNumberXOR(new int[]{0, 1}));           // 2
        System.out.println(sol.missingNumberXOR(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1})); // 8

        System.out.println("\nUsing Sum approach:");
        System.out.println(sol.missingNumberSum(new int[]{3, 0, 1}));        // 2
        System.out.println(sol.missingNumberSum(new int[]{0, 1}));           // 2
    }
}
