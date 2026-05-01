/*
 * LeetCode 169: Majority Element
 *
 * Problem: Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume the majority element always exists in the array.
 *
 * Example: Input: nums = [3,2,3] -> Output: 3
 *
 * Approach: Boyer-Moore Voting Algorithm
 * - Keep track of candidate and its count
 * - When count is 0, set new candidate
 * - If current equals candidate, increment count
 * - Otherwise, decrement count
 * - Candidate with count > 0 at end is the majority element
 *
 * Time Complexity: O(n) - single pass
 * Space Complexity: O(1) - only two variables
 */

public class MajorityElement {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int candidate = nums[0];
        int count = 0;

        // Find potential candidate using Boyer-Moore voting
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    // Alternative: Using HashMap
    // Time: O(n), Space: O(n)
    public int majorityElementHashMap(int[] nums) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        int majority = nums.length / 2;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > majority) {
                return num;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MajorityElement sol = new MajorityElement();

        System.out.println(sol.majorityElement(new int[]{3, 2, 3}));           // 3
        System.out.println(sol.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2})); // 2
        System.out.println(sol.majorityElement(new int[]{1}));                 // 1
        System.out.println(sol.majorityElement(new int[]{3, 3, 4}));           // 3
    }
}
