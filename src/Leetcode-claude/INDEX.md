# LeetCode Interview Prep - 53 MAANG Problems

Comprehensive collection of **53 curated problems** organized by category, with Java solutions, time complexity, and space complexity.

---

## 📊 Quick Stats
- **Total Problems**: 53
- **Categories**: 6 (String, Array, LinkedList, Stack, Heap, Backtrack)
- **All Solutions**: Java with detailed comments
- **Time/Space Complexity**: Included in every solution

---

## 🔤 STRING (8 Problems)

| # | Problem | LeetCode # | Time | Space |
|---|---------|----------|------|-------|
| 1 | Longest Substring Without Repeating Characters | 3 | O(n) | O(min(m,n)) |
| 2 | Longest Palindromic Substring | 5 | O(n²) | O(1) |
| 3 | Group Anagrams | 49 | O(n·k log k) | O(n·k) |
| 4 | Valid Parentheses | 20 | O(n) | O(n) |
| 5 | Palindrome Number | 9 | O(log n) | O(1) |
| 6 | First Unique Character in String | 387 | O(n) | O(1) |
| 7 | Valid Anagram | 242 | O(n) | O(1) |
| 8 | Roman to Integer | 13 | O(n) | O(1) |

**Key Topics**: Sliding Window, Hashing, Stack, String Manipulation

---

## 📈 ARRAY (18 Problems)

| # | Problem | LeetCode # | Time | Space |
|---|---------|----------|------|-------|
| 1 | Two Sum | 1 | O(n) | O(n) |
| 2 | Best Time to Buy and Sell Stock | 121 | O(n) | O(1) |
| 3 | Contains Duplicate | 217 | O(n) | O(n) |
| 4 | Product of Array Except Self | 238 | O(n) | O(1)* |
| 5 | Maximum Subarray | 53 | O(n) | O(1) |
| 6 | Search in Rotated Sorted Array | 33 | O(log n) | O(1) |
| 7 | 3Sum | 15 | O(n²) | O(1)* |
| 8 | Container With Most Water | 11 | O(n) | O(1) |
| 9 | Rotate Array | 189 | O(n) | O(1) |
| 10 | Trapping Rain Water | 42 | O(n) | O(1) |
| 11 | Majority Element | 169 | O(n) | O(1) |
| 12 | Merge Sorted Array | 88 | O(m+n) | O(1) |
| 13 | Remove Duplicates from Sorted Array | 26 | O(n) | O(1) |
| 14 | Missing Number | 268 | O(n) | O(1) |
| 15 | Set Matrix Zeroes | 73 | O(m·n) | O(1) |
| 16 | Next Permutation | 31 | O(n) | O(1) |
| 17 | Intersection of Two Arrays II | 350 | O(m+n) | O(min(m,n)) |
| 18 | (Bonus) Kth Largest Element | - | - | - |

**Key Topics**: Two Pointers, Binary Search, Hashing, Sorting, Kadane's Algorithm, Prefix/Suffix

---

## 🔗 LINKEDLIST (8 Problems)

| # | Problem | LeetCode # | Time | Space |
|---|---------|----------|------|-------|
| 1 | Reverse Linked List | 206 | O(n) | O(1) iterative, O(n) recursive |
| 2 | Linked List Cycle | 141 | O(n) | O(1) |
| 3 | Merge Two Sorted Lists | 21 | O(m+n) | O(1) |
| 4 | Remove Nth Node From End of List | 19 | O(n) | O(1) |
| 5 | Intersection of Two Linked Lists | 160 | O(m+n) | O(1) |
| 6 | Odd Even Linked List | 328 | O(n) | O(1) |
| 7 | Merge K Sorted Lists | 23 | O(n·k·log k) | O(k) |
| 8 | Palindrome Linked List | 234 | O(n) | O(1) |

**Key Topics**: Two Pointers, Fast/Slow Pointers, Reversal, Heap

---

## 📚 STACK (6 Problems)

| # | Problem | LeetCode # | Time | Space |
|---|---------|----------|------|-------|
| 1 | Min Stack | 155 | O(1) | O(n) |
| 2 | Daily Temperatures | 739 | O(n) | O(n) |
| 3 | Evaluate Reverse Polish Notation | 150 | O(n) | O(n) |
| 4 | Next Greater Element | 496 | O(n+m) | O(n) |
| 5 | Largest Rectangle in Histogram | 84 | O(n) | O(n) |
| 6 | Decode String | 394 | O(n) | O(n) |

**Key Topics**: Monotonic Stack, Stack-based Evaluation, Pattern Matching

---

## 💎 HEAP (4 Problems)

| # | Problem | LeetCode # | Time | Space |
|---|---------|----------|------|-------|
| 1 | Kth Largest Element in Array | 215 | O(n log k) | O(k) |
| 2 | Top K Frequent Elements | 347 | O(n log k) | O(n) |
| 3 | Find Median from Data Stream | 295 | O(log n) add, O(1) find | O(n) |
| 4 | Reorganize String | 767 | O(n log n) | O(1) |

**Key Topics**: Min/Max Heap, Priority Queue, Frequency Counting, Dual Heap

---

## 🔄 BACKTRACK (9 Problems)

| # | Problem | LeetCode # | Time | Space |
|---|---------|----------|------|-------|
| 1 | Permutations | 46 | O(n!·n) | O(n) |
| 2 | Combinations | 77 | O(C(n,k)·k) | O(C(n,k)) |
| 3 | Subsets | 78 | O(n·2ⁿ) | O(n·2ⁿ) |
| 4 | Generate Parentheses | 22 | O(Catalan·n) | O(n) |
| 5 | Combination Sum | 39 | O(N^(T/M)) | O(T/M) |
| 6 | Word Search | 79 | O(m·n·4^L) | O(m·n) |
| 7 | Palindrome Partitioning | 131 | O(2ⁿ·n) | O(n) |
| 8 | Letter Combinations of Phone Number | 17 | O(4ⁿ) | O(n) |
| 9 | N-Queens | 51 | O(N!) | O(n) |

**Key Topics**: Exhaustive Search, Constraint Tracking, Early Pruning, Pattern Building

---

## 🎯 Study Strategy

### Difficulty Path (Recommended Order)
1. **Week 1**: Array + String (Easy to Medium)
   - TwoSum, Best Time to Buy/Sell, Valid Parentheses
   - Longest Substring, Palindrome Number

2. **Week 2**: LinkedList + Stack (Medium)
   - Reverse LinkedList, Merge Sorted Lists
   - Min Stack, Valid Parentheses with Stack

3. **Week 3**: Array Advanced (Medium to Hard)
   - Product of Array Except Self, 3Sum
   - Container With Most Water, Search Rotated Array

4. **Week 4**: Backtrack (Medium to Hard)
   - Combinations, Subsets, Permutations
   - Generate Parentheses

5. **Week 5**: Heap + Advanced Problems
   - Kth Largest, Top K Frequent
   - Merge K Sorted Lists, Trapping Rain Water

6. **Week 6**: Mixed Review + Hard Problems
   - N-Queens, Palindrome Partitioning
   - Decode String, Daily Temperatures

### By Frequency (MAANG Focus)
**Most Asked**:
- Two Sum
- Reverse LinkedList
- Merge Two Sorted Lists
- Valid Parentheses
- Best Time to Buy/Sell Stock
- Product of Array Except Self
- Kth Largest Element
- Permutations & Combinations
- Generate Parentheses

**Very Important**:
- 3Sum
- Search Rotated Sorted Array
- Merge K Sorted Lists
- Top K Frequent
- N-Queens
- Word Search

---

## 💡 Key Techniques by Category

### String
- ✅ Sliding Window (Longest Substring)
- ✅ Two Pointers (Palindrome)
- ✅ Hashing (Group Anagrams, Anagram)
- ✅ Stack (Valid Parentheses)

### Array
- ✅ Two Pointers (3Sum, Container)
- ✅ Hashing (Two Sum, Duplicates)
- ✅ Binary Search (Rotated Array)
- ✅ Prefix/Suffix (Product Except Self)
- ✅ Greedy (Best Time to Buy/Sell)
- ✅ DP (Max Subarray - Kadane's)

### LinkedList
- ✅ Fast/Slow Pointers (Cycle, Palindrome)
- ✅ Reversal (Reverse List)
- ✅ Merge/Split (Merge Lists, Odd-Even)
- ✅ Heap (Merge K Lists)

### Stack
- ✅ Monotonic Stack (Daily Temp, Histogram)
- ✅ Expression Evaluation (RPN)
- ✅ Pattern Matching (Decode String)
- ✅ Min/Max Tracking (Min Stack)

### Heap
- ✅ Priority Queue
- ✅ Min/Max Heap
- ✅ Frequency Counting
- ✅ Stream Processing

### Backtrack
- ✅ Exhaustive Search
- ✅ Constraint Tracking
- ✅ Early Pruning
- ✅ State Management

---

## 📝 How to Use This Repository

### For Each Problem:
1. **Read the problem statement** (in comments at top of file)
2. **Study the approach** (documented in comments)
3. **Understand the solution** (well-commented code)
4. **Note complexity** (Time & Space at top)
5. **Run the main()** to test
6. **Try variations** (mentioned in comments)

### Tips for Interview:
- ✅ Write clean, readable code
- ✅ Explain your approach first
- ✅ Discuss trade-offs
- ✅ Test with edge cases
- ✅ Optimize step-by-step
- ✅ State assumptions clearly

---

## 🔗 Related Resources

- **LeetCode**: leetcode.com
- **GeeksforGeeks**: geeksforgeeks.org
- **InterviewBit**: interviewbit.com
- **System Design**: lowleveldesign.com

---

## ✅ Completion Checklist

Track your progress:

- [ ] String - 8/8
- [ ] Array - 18/18
- [ ] LinkedList - 8/8
- [ ] Stack - 6/6
- [ ] Heap - 4/4
- [ ] Backtrack - 9/9
- [ ] **TOTAL: 53/53**

---

**Last Updated**: 2026-04-30

Happy Learning! 🚀
