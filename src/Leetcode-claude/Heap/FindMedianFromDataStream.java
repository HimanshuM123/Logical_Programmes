/*
 * LeetCode 295: Find Median from Data Stream
 *
 * Problem: The median is the middle value in an ordered integer list.
 * Implement MedianFinder class supporting:
 * 1. addNum(int num): adds integer to the data structure
 * 2. findMedian(): returns median of all elements
 *
 * Example: addNum(1), addNum(2), findMedian() = 1.5
 *
 * Approach: Two Heaps (Max Heap + Min Heap)
 * - maxHeap: stores smaller half of numbers
 * - minHeap: stores larger half of numbers
 * - maxHeap always has either same size or 1 more element than minHeap
 * - Median: if even count, average of heaps' tops; if odd, maxHeap's top
 *
 * Time Complexity: O(log n) for addNum, O(1) for findMedian
 * Space Complexity: O(n)
 */

import java.util.PriorityQueue;
import java.util.Collections;

public class FindMedianFromDataStream {

    private PriorityQueue<Integer> maxHeap;  // Max heap for smaller half
    private PriorityQueue<Integer> minHeap;  // Min heap for larger half

    public FindMedianFromDataStream() {
        // Max heap (default is min heap, so use Collections.reverseOrder())
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // Min heap (default)
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Add to maxHeap first
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Balance heaps
        // maxHeap should have equal or 1 more element than minHeap
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // Even count
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            // Odd count (maxHeap has one more)
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        FindMedianFromDataStream mf = new FindMedianFromDataStream();

        mf.addNum(1);
        System.out.println(mf.findMedian());  // 1.0

        mf.addNum(2);
        System.out.println(mf.findMedian());  // 1.5

        mf.addNum(3);
        System.out.println(mf.findMedian());  // 2.0

        mf.addNum(4);
        System.out.println(mf.findMedian());  // 2.5

        mf.addNum(5);
        System.out.println(mf.findMedian());  // 3.0
    }
}
