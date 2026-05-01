/*
 * LeetCode 350: Intersection of Two Arrays II
 *
 * Problem: Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays.
 * You may return the result in any order.
 *
 * Example: Input: nums1 = [1,2,2,1], nums2 = [2,2]
 *          Output: [2,2]
 *
 * Approach 1: HashMap - count elements in nums1, then check in nums2
 * Time: O(m + n), Space: O(min(m, n))
 *
 * Approach 2: Two Pointers - sort both arrays, then merge-like process
 * Time: O(m log m + n log n), Space: O(1) if not counting output
 *
 * Using HashMap here for better average performance
 */

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class IntersectionOfTwoArraysII {

    // Approach 1: HashMap
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];

        // Make sure nums1 is smaller
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();

        // Count elements in nums1
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        // Find intersection with nums2
        for (int num : nums2) {
            if (map.containsKey(num)) {
                result.add(num);
                map.put(num, map.get(num) - 1);

                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }

        int[] output = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }

        return output;
    }

    // Approach 2: Two Pointers with Sorting
    public int[] intersectTwoPointers(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int p1 = 0, p2 = 0, k = 0;

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                result[k++] = nums1[p1];
                p1++;
                p2++;
            }
        }

        return Arrays.copyOf(result, k);
    }

    public static void main(String[] args) {
        IntersectionOfTwoArraysII sol = new IntersectionOfTwoArraysII();

        System.out.println(Arrays.toString(sol.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        // [2,2]

        System.out.println(Arrays.toString(sol.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
        // [4,9] or [9,4]
    }
}
