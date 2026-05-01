/*
 * LeetCode 215: Kth Largest Element in an Array
 *
 * Problem: Given an integer array nums and an integer k, return the kth largest element.
 * Note: The kth largest element is the kth distinct element (duplicates don't affect it).
 * Actually, it means the kth element after sorting in descending order (can have duplicates).
 *
 * Example: Input: nums = [3,2,1,5,6,7], k = 3 -> Output: 5
 *
 * Approach 1: Min Heap of size k
 * - Keep min heap of k largest elements
 * - Top of heap is kth largest
 * - Time: O(n log k), Space: O(k)
 *
 * Approach 2: Quick Select (optimal)
 * - Partition like quicksort
 * - Average O(n), Worst O(n^2)
 *
 * Using PriorityQueue (Min Heap) here
 */

import java.util.PriorityQueue;

public class KthLargestElement {

    // Approach 1: Using Min Heap
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;

        // Min heap - maintains k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);

            // Keep only k elements in heap
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    // Approach 2: Using QuickSelect
    public int findKthLargestQuickSelect(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;

        // Convert kth largest to index (kth largest = n-k index in ascending order)
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int targetIndex) {
        if (left == right) {
            return nums[left];
        }

        // Partition
        int pivotIndex = partition(nums, left, right);

        if (targetIndex == pivotIndex) {
            return nums[pivotIndex];
        } else if (targetIndex < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, targetIndex);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, targetIndex);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                // Swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

        // Swap pivot
        int temp = nums[i];
        nums[i] = nums[right];
        nums[right] = temp;

        return i;
    }

    public static void main(String[] args) {
        KthLargestElement sol = new KthLargestElement();

        System.out.println(sol.findKthLargest(new int[]{3, 2, 1, 5, 6, 7}, 3));      // 5
        System.out.println(sol.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // 4
        System.out.println(sol.findKthLargest(new int[]{1}, 1));                    // 1
    }
}
