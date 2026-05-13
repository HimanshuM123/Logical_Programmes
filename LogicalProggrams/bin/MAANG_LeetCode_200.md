# MAANG LeetCode 200 Questions (Easy-Medium) — Learning Order

---

## SECTION 1: ARRAYS (Q1–Q25)

---

### Q1. Two Sum
**Difficulty:** Easy | **Companies:** Google, Amazon, Meta, Apple

**Problem:** Given an array of integers and a target, return indices of two numbers that add up to target.

**Example:**
```
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
```

**Solution:**
```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) return new int[]{map.get(complement), i};
        map.put(nums[i], i);
    }
    return new int[]{};
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q2. Best Time to Buy and Sell Stock
**Difficulty:** Easy | **Companies:** Amazon, Google, Meta

**Problem:** Find the maximum profit from one buy and one sell transaction.

**Example:**
```
Input: prices = [7,1,5,3,6,4]
Output: 5
```

**Solution:**
```java
public int maxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE, maxProfit = 0;
    for (int price : prices) {
        minPrice = Math.min(minPrice, price);
        maxProfit = Math.max(maxProfit, price - minPrice);
    }
    return maxProfit;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q3. Contains Duplicate
**Difficulty:** Easy | **Companies:** Amazon, Apple

**Problem:** Return true if any value appears at least twice.

**Example:**
```
Input: nums = [1,2,3,1]
Output: true
```

**Solution:**
```java
public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums) {
        if (!set.add(n)) return true;
    }
    return false;
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q4. Maximum Subarray (Kadane's Algorithm)
**Difficulty:** Easy | **Companies:** Amazon, Google, Apple

**Problem:** Find the contiguous subarray with the largest sum.

**Example:**
```
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6  (subarray [4,-1,2,1])
```

**Solution:**
```java
public int maxSubArray(int[] nums) {
    int maxSum = nums[0], currentSum = nums[0];
    for (int i = 1; i < nums.length; i++) {
        currentSum = Math.max(nums[i], currentSum + nums[i]);
        maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q5. Move Zeroes
**Difficulty:** Easy | **Companies:** Meta, Amazon

**Problem:** Move all 0s to the end while maintaining relative order of non-zero elements.

**Example:**
```
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
```

**Solution:**
```java
public void moveZeroes(int[] nums) {
    int insertPos = 0;
    for (int num : nums) {
        if (num != 0) nums[insertPos++] = num;
    }
    while (insertPos < nums.length) nums[insertPos++] = 0;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q6. Plus One
**Difficulty:** Easy | **Companies:** Google, Amazon

**Problem:** Given a number as digit array, add one and return the result array.

**Example:**
```
Input: digits = [1,2,3]
Output: [1,2,4]
```

**Solution:**
```java
public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
        if (digits[i] < 9) { digits[i]++; return digits; }
        digits[i] = 0;
    }
    int[] result = new int[digits.length + 1];
    result[0] = 1;
    return result;
}
```
**Time:** O(n) | **Space:** O(1) amortized

---

### Q7. Merge Sorted Array
**Difficulty:** Easy | **Companies:** Meta, Amazon, Apple

**Problem:** Merge two sorted arrays nums1 and nums2 into nums1 in-place.

**Example:**
```
Input: nums1=[1,2,3,0,0,0], m=3, nums2=[2,5,6], n=3
Output: [1,2,2,3,5,6]
```

**Solution:**
```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1, j = n - 1, k = m + n - 1;
    while (i >= 0 && j >= 0) {
        nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
    }
    while (j >= 0) nums1[k--] = nums2[j--];
}
```
**Time:** O(m+n) | **Space:** O(1)

---

### Q8. Rotate Array
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Rotate array to the right by k steps.

**Example:**
```
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
```

**Solution:**
```java
public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
}
private void reverse(int[] nums, int l, int r) {
    while (l < r) { int tmp = nums[l]; nums[l++] = nums[r]; nums[r--] = tmp; }
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q9. Product of Array Except Self
**Difficulty:** Medium | **Companies:** Amazon, Meta, Apple, Google

**Problem:** Return array where output[i] is product of all elements except nums[i]. No division allowed.

**Example:**
```
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
```

**Solution:**
```java
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    result[0] = 1;
    for (int i = 1; i < n; i++) result[i] = result[i-1] * nums[i-1];
    int right = 1;
    for (int i = n - 1; i >= 0; i--) {
        result[i] *= right;
        right *= nums[i];
    }
    return result;
}
```
**Time:** O(n) | **Space:** O(1) extra (output array excluded)

---

### Q10. Maximum Product Subarray
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Find the contiguous subarray with the largest product.

**Example:**
```
Input: nums = [2,3,-2,4]
Output: 6
```

**Solution:**
```java
public int maxProduct(int[] nums) {
    int maxProd = nums[0], minProd = nums[0], result = nums[0];
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] < 0) { int tmp = maxProd; maxProd = minProd; minProd = tmp; }
        maxProd = Math.max(nums[i], maxProd * nums[i]);
        minProd = Math.min(nums[i], minProd * nums[i]);
        result = Math.max(result, maxProd);
    }
    return result;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q11. Find Minimum in Rotated Sorted Array
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Find the minimum element in a rotated sorted array.

**Example:**
```
Input: nums = [3,4,5,1,2]
Output: 1
```

**Solution:**
```java
public int findMin(int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] > nums[r]) l = mid + 1;
        else r = mid;
    }
    return nums[l];
}
```
**Time:** O(log n) | **Space:** O(1)

---

### Q12. Search in Rotated Sorted Array
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta, Apple

**Problem:** Search a target in a rotated sorted array. Return index or -1.

**Example:**
```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

**Solution:**
```java
public int search(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    while (l <= r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) return mid;
        if (nums[l] <= nums[mid]) {
            if (nums[l] <= target && target < nums[mid]) r = mid - 1;
            else l = mid + 1;
        } else {
            if (nums[mid] < target && target <= nums[r]) l = mid + 1;
            else r = mid - 1;
        }
    }
    return -1;
}
```
**Time:** O(log n) | **Space:** O(1)

---

### Q13. 3Sum
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta, Apple

**Problem:** Find all unique triplets that sum to zero.

**Example:**
```
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
```

**Solution:**
```java
public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] == nums[i-1]) continue;
        int l = i + 1, r = nums.length - 1;
        while (l < r) {
            int sum = nums[i] + nums[l] + nums[r];
            if (sum == 0) {
                result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                while (l < r && nums[l] == nums[l+1]) l++;
                while (l < r && nums[r] == nums[r-1]) r--;
                l++; r--;
            } else if (sum < 0) l++;
            else r--;
        }
    }
    return result;
}
```
**Time:** O(n²) | **Space:** O(1) extra

---

### Q14. Container With Most Water
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Find two lines that together with the x-axis form a container holding the most water.

**Example:**
```
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
```

**Solution:**
```java
public int maxArea(int[] height) {
    int l = 0, r = height.length - 1, maxWater = 0;
    while (l < r) {
        maxWater = Math.max(maxWater, Math.min(height[l], height[r]) * (r - l));
        if (height[l] < height[r]) l++;
        else r--;
    }
    return maxWater;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q15. Trapping Rain Water
**Difficulty:** Hard (but common Medium-level interview) | **Companies:** Amazon, Google, Meta

**Problem:** Compute how much water can be trapped between bars.

**Example:**
```
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
```

**Solution:**
```java
public int trap(int[] height) {
    int l = 0, r = height.length - 1, leftMax = 0, rightMax = 0, water = 0;
    while (l < r) {
        if (height[l] < height[r]) {
            if (height[l] >= leftMax) leftMax = height[l];
            else water += leftMax - height[l];
            l++;
        } else {
            if (height[r] >= rightMax) rightMax = height[r];
            else water += rightMax - height[r];
            r--;
        }
    }
    return water;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q16. Sort Colors (Dutch National Flag)
**Difficulty:** Medium | **Companies:** Meta, Amazon

**Problem:** Sort array containing only 0s, 1s, 2s in-place.

**Example:**
```
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```

**Solution:**
```java
public void sortColors(int[] nums) {
    int lo = 0, mid = 0, hi = nums.length - 1;
    while (mid <= hi) {
        if (nums[mid] == 0) { swap(nums, lo++, mid++); }
        else if (nums[mid] == 1) { mid++; }
        else { swap(nums, mid, hi--); }
    }
}
private void swap(int[] nums, int i, int j) {
    int tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q17. Find the Duplicate Number
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find the duplicate in array of n+1 integers in range [1,n]. No extra space.

**Example:**
```
Input: nums = [1,3,4,2,2]
Output: 2
```

**Solution (Floyd's Cycle):**
```java
public int findDuplicate(int[] nums) {
    int slow = nums[0], fast = nums[0];
    do { slow = nums[slow]; fast = nums[nums[fast]]; } while (slow != fast);
    slow = nums[0];
    while (slow != fast) { slow = nums[slow]; fast = nums[fast]; }
    return slow;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q18. Subarray Sum Equals K
**Difficulty:** Medium | **Companies:** Meta, Amazon, Google

**Problem:** Count the number of subarrays whose sum equals k.

**Example:**
```
Input: nums = [1,1,1], k = 2
Output: 2
```

**Solution:**
```java
public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> prefixCount = new HashMap<>();
    prefixCount.put(0, 1);
    int sum = 0, count = 0;
    for (int num : nums) {
        sum += num;
        count += prefixCount.getOrDefault(sum - k, 0);
        prefixCount.merge(sum, 1, Integer::sum);
    }
    return count;
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q19. Find All Duplicates in an Array
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find all elements appearing twice in array of n integers (1 ≤ a[i] ≤ n).

**Example:**
```
Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
```

**Solution:**
```java
public List<Integer> findDuplicates(int[] nums) {
    List<Integer> result = new ArrayList<>();
    for (int num : nums) {
        int idx = Math.abs(num) - 1;
        if (nums[idx] < 0) result.add(idx + 1);
        else nums[idx] = -nums[idx];
    }
    return result;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q20. First Missing Positive
**Difficulty:** Medium | **Companies:** Amazon, Meta

**Problem:** Find the smallest missing positive integer. O(n) time, O(1) space.

**Example:**
```
Input: nums = [3,4,-1,1]
Output: 2
```

**Solution:**
```java
public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
        while (nums[i] > 0 && nums[i] <= n && nums[nums[i]-1] != nums[i]) {
            int tmp = nums[nums[i]-1]; nums[nums[i]-1] = nums[i]; nums[i] = tmp;
        }
    }
    for (int i = 0; i < n; i++) if (nums[i] != i + 1) return i + 1;
    return n + 1;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q21. Majority Element
**Difficulty:** Easy | **Companies:** Amazon, Google, Apple

**Problem:** Find the element appearing more than n/2 times (guaranteed to exist).

**Example:**
```
Input: nums = [3,2,3]
Output: 3
```

**Solution (Boyer-Moore Voting):**
```java
public int majorityElement(int[] nums) {
    int count = 0, candidate = 0;
    for (int num : nums) {
        if (count == 0) candidate = num;
        count += (num == candidate) ? 1 : -1;
    }
    return candidate;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q22. Missing Number
**Difficulty:** Easy | **Companies:** Amazon, Apple

**Problem:** Given array containing n distinct numbers in range [0,n], find the missing one.

**Example:**
```
Input: nums = [3,0,1]
Output: 2
```

**Solution:**
```java
public int missingNumber(int[] nums) {
    int n = nums.length, sum = n * (n + 1) / 2;
    for (int num : nums) sum -= num;
    return sum;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q23. Merge Intervals
**Difficulty:** Medium | **Companies:** Google, Meta, Amazon, Apple

**Problem:** Merge all overlapping intervals.

**Example:**
```
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
```

**Solution:**
```java
public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    List<int[]> result = new ArrayList<>();
    for (int[] interval : intervals) {
        if (result.isEmpty() || result.get(result.size()-1)[1] < interval[0]) {
            result.add(interval);
        } else {
            result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1], interval[1]);
        }
    }
    return result.toArray(new int[0][]);
}
```
**Time:** O(n log n) | **Space:** O(n)

---

### Q24. Top K Frequent Elements
**Difficulty:** Medium | **Companies:** Amazon, Meta, Google

**Problem:** Return the k most frequent elements.

**Example:**
```
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
```

**Solution (Bucket Sort):**
```java
public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int n : nums) freq.merge(n, 1, Integer::sum);
    List<Integer>[] bucket = new List[nums.length + 1];
    for (int key : freq.keySet()) {
        int f = freq.get(key);
        if (bucket[f] == null) bucket[f] = new ArrayList<>();
        bucket[f].add(key);
    }
    int[] result = new int[k];
    int idx = 0;
    for (int i = bucket.length - 1; i >= 0 && idx < k; i--) {
        if (bucket[i] != null) for (int n : bucket[i]) if (idx < k) result[idx++] = n;
    }
    return result;
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q25. Longest Consecutive Sequence
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Find the length of the longest consecutive elements sequence. O(n) time.

**Example:**
```
Input: nums = [100,4,200,1,3,2]
Output: 4  (sequence: 1,2,3,4)
```

**Solution:**
```java
public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums) set.add(n);
    int longest = 0;
    for (int n : set) {
        if (!set.contains(n - 1)) {
            int length = 1;
            while (set.contains(n + length)) length++;
            longest = Math.max(longest, length);
        }
    }
    return longest;
}
```
**Time:** O(n) | **Space:** O(n)

---

## SECTION 2: STRINGS (Q26–Q45)

---

### Q26. Valid Anagram
**Difficulty:** Easy | **Companies:** Amazon, Google, Meta

**Problem:** Given two strings, return true if t is an anagram of s.

**Example:**
```
Input: s = "anagram", t = "nagaram"
Output: true
```

**Solution:**
```java
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] count = new int[26];
    for (char c : s.toCharArray()) count[c - 'a']++;
    for (char c : t.toCharArray()) if (--count[c - 'a'] < 0) return false;
    return true;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q27. Group Anagrams
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta, Apple

**Problem:** Group strings that are anagrams of each other.

**Example:**
```
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
```

**Solution:**
```java
public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String key = new String(arr);
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
    }
    return new ArrayList<>(map.values());
}
```
**Time:** O(n·k log k) | **Space:** O(n·k)

---

### Q28. Valid Palindrome
**Difficulty:** Easy | **Companies:** Meta, Amazon, Apple

**Problem:** A phrase is a palindrome if it reads the same forward and backward (considering only alphanumeric chars).

**Example:**
```
Input: s = "A man, a plan, a canal: Panama"
Output: true
```

**Solution:**
```java
public boolean isPalindrome(String s) {
    int l = 0, r = s.length() - 1;
    while (l < r) {
        while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
        while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
        if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
        l++; r--;
    }
    return true;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q29. Longest Substring Without Repeating Characters
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta, Apple

**Problem:** Find the length of the longest substring without repeating characters.

**Example:**
```
Input: s = "abcabcbb"
Output: 3  ("abc")
```

**Solution:**
```java
public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int maxLen = 0, left = 0;
    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        if (map.containsKey(c)) left = Math.max(left, map.get(c) + 1);
        map.put(c, right);
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
```
**Time:** O(n) | **Space:** O(min(m,n)) where m=charset size

---

### Q30. Longest Repeating Character Replacement
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Replace at most k characters to make the substring contain the same letter. Find max length.

**Example:**
```
Input: s = "AABABBA", k = 1
Output: 4
```

**Solution:**
```java
public int characterReplacement(String s, int k) {
    int[] count = new int[26];
    int maxCount = 0, maxLen = 0, left = 0;
    for (int right = 0; right < s.length(); right++) {
        maxCount = Math.max(maxCount, ++count[s.charAt(right) - 'A']);
        while (right - left + 1 - maxCount > k) count[s.charAt(left++) - 'A']--;
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q31. Minimum Window Substring
**Difficulty:** Hard (very common in MAANG) | **Companies:** Google, Meta, Amazon

**Problem:** Find the minimum window substring of s that contains all chars of t.

**Example:**
```
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
```

**Solution:**
```java
public String minWindow(String s, String t) {
    Map<Character, Integer> need = new HashMap<>();
    for (char c : t.toCharArray()) need.merge(c, 1, Integer::sum);
    int left = 0, minLen = Integer.MAX_VALUE, minStart = 0, have = 0, required = need.size();
    Map<Character, Integer> window = new HashMap<>();
    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        window.merge(c, 1, Integer::sum);
        if (need.containsKey(c) && window.get(c).equals(need.get(c))) have++;
        while (have == required) {
            if (right - left + 1 < minLen) { minLen = right - left + 1; minStart = left; }
            char lc = s.charAt(left);
            window.merge(lc, -1, Integer::sum);
            if (need.containsKey(lc) && window.get(lc) < need.get(lc)) have--;
            left++;
        }
    }
    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
}
```
**Time:** O(|s|+|t|) | **Space:** O(|s|+|t|)

---

### Q32. Permutation in String
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Return true if one of s1's permutations is a substring of s2.

**Example:**
```
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
```

**Solution:**
```java
public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) return false;
    int[] count = new int[26];
    for (char c : s1.toCharArray()) count[c - 'a']++;
    int[] window = new int[26];
    for (int i = 0; i < s2.length(); i++) {
        window[s2.charAt(i) - 'a']++;
        if (i >= s1.length()) window[s2.charAt(i - s1.length()) - 'a']--;
        if (Arrays.equals(count, window)) return true;
    }
    return false;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q33. Find All Anagrams in a String
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Return all start indices of anagrams of p in s.

**Example:**
```
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
```

**Solution:**
```java
public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    int[] pCount = new int[26], sCount = new int[26];
    for (char c : p.toCharArray()) pCount[c - 'a']++;
    for (int i = 0; i < s.length(); i++) {
        sCount[s.charAt(i) - 'a']++;
        if (i >= p.length()) sCount[s.charAt(i - p.length()) - 'a']--;
        if (Arrays.equals(pCount, sCount)) result.add(i - p.length() + 1);
    }
    return result;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q34. Longest Common Prefix
**Difficulty:** Easy | **Companies:** Amazon, Google, Apple

**Problem:** Find the longest common prefix string among an array of strings.

**Example:**
```
Input: strs = ["flower","flow","flight"]
Output: "fl"
```

**Solution:**
```java
public String longestCommonPrefix(String[] strs) {
    String prefix = strs[0];
    for (String s : strs) {
        while (!s.startsWith(prefix)) prefix = prefix.substring(0, prefix.length() - 1);
        if (prefix.isEmpty()) return "";
    }
    return prefix;
}
```
**Time:** O(S) where S = total chars | **Space:** O(1)

---

### Q35. Valid Parentheses
**Difficulty:** Easy | **Companies:** Amazon, Google, Meta, Apple

**Problem:** Determine if the input string of brackets is valid.

**Example:**
```
Input: s = "()[]{}"
Output: true
```

**Solution:**
```java
public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
        if (c == '(' || c == '[' || c == '{') stack.push(c);
        else {
            if (stack.isEmpty()) return false;
            char top = stack.pop();
            if (c == ')' && top != '(') return false;
            if (c == ']' && top != '[') return false;
            if (c == '}' && top != '{') return false;
        }
    }
    return stack.isEmpty();
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q36. Generate Parentheses
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Generate all combinations of n pairs of well-formed parentheses.

**Example:**
```
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
```

**Solution:**
```java
public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    backtrack(result, new StringBuilder(), 0, 0, n);
    return result;
}
private void backtrack(List<String> result, StringBuilder sb, int open, int close, int max) {
    if (sb.length() == max * 2) { result.add(sb.toString()); return; }
    if (open < max) { sb.append('('); backtrack(result, sb, open+1, close, max); sb.deleteCharAt(sb.length()-1); }
    if (close < open) { sb.append(')'); backtrack(result, sb, open, close+1, max); sb.deleteCharAt(sb.length()-1); }
}
```
**Time:** O(4^n/√n) | **Space:** O(n)

---

### Q37. Reverse Words in a String
**Difficulty:** Medium | **Companies:** Amazon, Meta

**Problem:** Reverse the order of words in a string.

**Example:**
```
Input: s = "the sky is blue"
Output: "blue is sky the"
```

**Solution:**
```java
public String reverseWords(String s) {
    String[] words = s.trim().split("\\s+");
    StringBuilder sb = new StringBuilder();
    for (int i = words.length - 1; i >= 0; i--) {
        sb.append(words[i]);
        if (i > 0) sb.append(' ');
    }
    return sb.toString();
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q38. String to Integer (atoi)
**Difficulty:** Medium | **Companies:** Amazon, Microsoft

**Problem:** Implement atoi which converts a string to a 32-bit signed integer.

**Example:**
```
Input: s = "   -42"
Output: -42
```

**Solution:**
```java
public int myAtoi(String s) {
    int i = 0, n = s.length(), sign = 1;
    long result = 0;
    while (i < n && s.charAt(i) == ' ') i++;
    if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
        sign = s.charAt(i++) == '-' ? -1 : 1;
    }
    while (i < n && Character.isDigit(s.charAt(i))) {
        result = result * 10 + (s.charAt(i++) - '0');
        if (result * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
    }
    return (int)(result * sign);
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q39. Decode String
**Difficulty:** Medium | **Companies:** Google, Amazon

**Problem:** Decode encoded string format k[encoded_string].

**Example:**
```
Input: s = "3[a2[c]]"
Output: "accaccacc"
```

**Solution:**
```java
public String decodeString(String s) {
    Deque<Integer> counts = new ArrayDeque<>();
    Deque<StringBuilder> strings = new ArrayDeque<>();
    StringBuilder current = new StringBuilder();
    int k = 0;
    for (char c : s.toCharArray()) {
        if (Character.isDigit(c)) {
            k = k * 10 + (c - '0');
        } else if (c == '[') {
            counts.push(k); k = 0;
            strings.push(current); current = new StringBuilder();
        } else if (c == ']') {
            StringBuilder prev = strings.pop();
            int count = counts.pop();
            for (int i = 0; i < count; i++) prev.append(current);
            current = prev;
        } else {
            current.append(c);
        }
    }
    return current.toString();
}
```
**Time:** O(max_k^count * n) | **Space:** O(n)

---

### Q40. Longest Palindromic Substring
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Find the longest palindromic substring.

**Example:**
```
Input: s = "babad"
Output: "bab" or "aba"
```

**Solution (Expand Around Center):**
```java
public String longestPalindrome(String s) {
    int start = 0, maxLen = 1;
    for (int i = 0; i < s.length(); i++) {
        int odd = expand(s, i, i), even = expand(s, i, i + 1);
        int len = Math.max(odd, even);
        if (len > maxLen) {
            maxLen = len;
            start = i - (len - 1) / 2;
        }
    }
    return s.substring(start, start + maxLen);
}
private int expand(String s, int l, int r) {
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { l--; r++; }
    return r - l - 1;
}
```
**Time:** O(n²) | **Space:** O(1)

---

### Q41. Palindromic Substrings
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Count the number of palindromic substrings.

**Example:**
```
Input: s = "aaa"
Output: 6  ("a","a","a","aa","aa","aaa")
```

**Solution:**
```java
public int countSubstrings(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
        count += expand(s, i, i);
        count += expand(s, i, i + 1);
    }
    return count;
}
private int expand(String s, int l, int r) {
    int count = 0;
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { l--; r++; count++; }
    return count;
}
```
**Time:** O(n²) | **Space:** O(1)

---

### Q42. Word Pattern
**Difficulty:** Easy | **Companies:** Google, Amazon

**Problem:** Given a pattern and a string, find if the string follows the same pattern.

**Example:**
```
Input: pattern = "abba", s = "dog cat cat dog"
Output: true
```

**Solution:**
```java
public boolean wordPattern(String pattern, String s) {
    String[] words = s.split(" ");
    if (words.length != pattern.length()) return false;
    Map<Character, String> charToWord = new HashMap<>();
    Map<String, Character> wordToChar = new HashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
        char c = pattern.charAt(i);
        String w = words[i];
        if (charToWord.containsKey(c) && !charToWord.get(c).equals(w)) return false;
        if (wordToChar.containsKey(w) && wordToChar.get(w) != c) return false;
        charToWord.put(c, w);
        wordToChar.put(w, c);
    }
    return true;
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q43. Isomorphic Strings
**Difficulty:** Easy | **Companies:** Google, Amazon

**Problem:** Two strings are isomorphic if characters in s can be replaced to get t.

**Example:**
```
Input: s = "egg", t = "add"
Output: true
```

**Solution:**
```java
public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> st = new HashMap<>(), ts = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
        char sc = s.charAt(i), tc = t.charAt(i);
        if (st.containsKey(sc) && st.get(sc) != tc) return false;
        if (ts.containsKey(tc) && ts.get(tc) != sc) return false;
        st.put(sc, tc); ts.put(tc, sc);
    }
    return true;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q44. Roman to Integer
**Difficulty:** Easy | **Companies:** Amazon, Google, Meta

**Problem:** Convert a Roman numeral string to an integer.

**Example:**
```
Input: s = "MCMXCIV"
Output: 1994
```

**Solution:**
```java
public int romanToInt(String s) {
    Map<Character, Integer> map = Map.of('I',1,'V',5,'X',10,'L',50,'C',100,'D',500,'M',1000);
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
        int val = map.get(s.charAt(i));
        if (i + 1 < s.length() && val < map.get(s.charAt(i + 1))) result -= val;
        else result += val;
    }
    return result;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q45. Word Break
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Return true if s can be segmented into words from the dictionary.

**Example:**
```
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
```

**Solution:**
```java
public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>(wordDict);
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++) {
        for (int j = 0; j < i; j++) {
            if (dp[j] && set.contains(s.substring(j, i))) { dp[i] = true; break; }
        }
    }
    return dp[s.length()];
}
```
**Time:** O(n²) | **Space:** O(n)

---

## SECTION 3: LINKED LISTS (Q46–Q60)

---

### Q46. Reverse Linked List
**Difficulty:** Easy | **Companies:** Amazon, Google, Meta, Apple

**Problem:** Reverse a singly linked list.

**Example:**
```
Input: 1->2->3->4->5
Output: 5->4->3->2->1
```

**Solution:**
```java
public ListNode reverseList(ListNode head) {
    ListNode prev = null, curr = head;
    while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q47. Merge Two Sorted Lists
**Difficulty:** Easy | **Companies:** Amazon, Google, Meta, Apple

**Problem:** Merge two sorted linked lists and return the merged list.

**Example:**
```
Input: l1 = 1->2->4, l2 = 1->3->4
Output: 1->1->2->3->4->4
```

**Solution:**
```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0), curr = dummy;
    while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) { curr.next = l1; l1 = l1.next; }
        else { curr.next = l2; l2 = l2.next; }
        curr = curr.next;
    }
    curr.next = l1 != null ? l1 : l2;
    return dummy.next;
}
```
**Time:** O(m+n) | **Space:** O(1)

---

### Q48. Linked List Cycle
**Difficulty:** Easy | **Companies:** Amazon, Google, Meta

**Problem:** Determine if a linked list has a cycle.

**Example:**
```
Input: 3->2->0->-4 (tail connects to node 1)
Output: true
```

**Solution (Floyd's):**
```java
public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) return true;
    }
    return false;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q49. Find the Start of Cycle (Linked List Cycle II)
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Return the node where the cycle begins, or null.

**Example:**
```
Input: 3->2->0->-4 (tail connects to node index 1)
Output: Node with value 2
```

**Solution:**
```java
public ListNode detectCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next; fast = fast.next.next;
        if (slow == fast) {
            slow = head;
            while (slow != fast) { slow = slow.next; fast = fast.next; }
            return slow;
        }
    }
    return null;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q50. Remove Nth Node From End of List
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Remove the nth node from the end of the list and return the head.

**Example:**
```
Input: 1->2->3->4->5, n=2
Output: 1->2->3->5
```

**Solution:**
```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy, slow = dummy;
    for (int i = 0; i <= n; i++) fast = fast.next;
    while (fast != null) { fast = fast.next; slow = slow.next; }
    slow.next = slow.next.next;
    return dummy.next;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q51. Intersection of Two Linked Lists
**Difficulty:** Easy | **Companies:** Amazon, Google, Meta

**Problem:** Find the node at which two linked lists intersect.

**Example:**
```
Input: listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
Output: Node with value 8
```

**Solution:**
```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode a = headA, b = headB;
    while (a != b) {
        a = a == null ? headB : a.next;
        b = b == null ? headA : b.next;
    }
    return a;
}
```
**Time:** O(m+n) | **Space:** O(1)

---

### Q52. Palindrome Linked List
**Difficulty:** Easy | **Companies:** Amazon, Meta

**Problem:** Check if a linked list is a palindrome.

**Example:**
```
Input: 1->2->2->1
Output: true
```

**Solution:**
```java
public boolean isPalindrome(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
    ListNode prev = null;
    while (slow != null) { ListNode next = slow.next; slow.next = prev; prev = slow; slow = next; }
    ListNode left = head, right = prev;
    while (right != null) { if (left.val != right.val) return false; left = left.next; right = right.next; }
    return true;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q53. Reorder List
**Difficulty:** Medium | **Companies:** Amazon, Meta

**Problem:** Reorder list L0→L1→…→Ln to L0→Ln→L1→Ln-1→L2→Ln-2→…

**Example:**
```
Input: 1->2->3->4
Output: 1->4->2->3
```

**Solution:**
```java
public void reorderList(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) { slow = slow.next; fast = fast.next.next; }
    ListNode second = slow.next; slow.next = null;
    ListNode prev = null;
    while (second != null) { ListNode next = second.next; second.next = prev; prev = second; second = next; }
    ListNode first = head; second = prev;
    while (second != null) {
        ListNode tmp1 = first.next, tmp2 = second.next;
        first.next = second; second.next = tmp1;
        first = tmp1; second = tmp2;
    }
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q54. Add Two Numbers
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Add two numbers represented as reversed linked lists.

**Example:**
```
Input: l1 = 2->4->3, l2 = 5->6->4
Output: 7->0->8  (342 + 465 = 807)
```

**Solution:**
```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0), curr = dummy;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
        int sum = carry;
        if (l1 != null) { sum += l1.val; l1 = l1.next; }
        if (l2 != null) { sum += l2.val; l2 = l2.next; }
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
    }
    return dummy.next;
}
```
**Time:** O(max(m,n)) | **Space:** O(max(m,n))

---

### Q55. Copy List with Random Pointer
**Difficulty:** Medium | **Companies:** Amazon, Meta

**Problem:** Deep copy a linked list where each node has a random pointer.

**Example:**
```
Input: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: Deep copy of the list
```

**Solution:**
```java
public Node copyRandomList(Node head) {
    if (head == null) return null;
    Map<Node, Node> map = new HashMap<>();
    Node curr = head;
    while (curr != null) { map.put(curr, new Node(curr.val)); curr = curr.next; }
    curr = head;
    while (curr != null) {
        map.get(curr).next = map.get(curr.next);
        map.get(curr).random = map.get(curr.random);
        curr = curr.next;
    }
    return map.get(head);
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q56. LRU Cache
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta, Apple

**Problem:** Design a data structure implementing LRU cache with O(1) get and put.

**Example:**
```
LRUCache cache = new LRUCache(2);
cache.put(1,1); cache.put(2,2); cache.get(1)→1; cache.put(3,3); cache.get(2)→-1
```

**Solution:**
```java
class LRUCache {
    private Map<Integer, Integer> map = new LinkedHashMap<>(16, 0.75f, true) {
        protected boolean removeEldestEntry(Map.Entry e) { return size() > capacity; }
    };
    private int capacity;
    public LRUCache(int capacity) { this.capacity = capacity; }
    public int get(int key) { return map.getOrDefault(key, -1); }
    public void put(int key, int value) { map.put(key, value); }
}
```
**Time:** O(1) average | **Space:** O(capacity)

---

### Q57. Sort List
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Sort a linked list in O(n log n) time and O(1) space.

**Example:**
```
Input: 4->2->1->3
Output: 1->2->3->4
```

**Solution (Merge Sort):**
```java
public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode mid = getMid(head);
    ListNode right = sortList(mid.next); mid.next = null;
    ListNode left = sortList(head);
    return merge(left, right);
}
private ListNode getMid(ListNode head) {
    ListNode slow = head, fast = head.next;
    while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
    return slow;
}
private ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0), curr = dummy;
    while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) { curr.next = l1; l1 = l1.next; }
        else { curr.next = l2; l2 = l2.next; }
        curr = curr.next;
    }
    curr.next = l1 != null ? l1 : l2;
    return dummy.next;
}
```
**Time:** O(n log n) | **Space:** O(log n) recursion stack

---

### Q58. Odd Even Linked List
**Difficulty:** Medium | **Companies:** Amazon, Meta

**Problem:** Group all odd nodes together followed by even nodes.

**Example:**
```
Input: 1->2->3->4->5
Output: 1->3->5->2->4
```

**Solution:**
```java
public ListNode oddEvenList(ListNode head) {
    if (head == null) return null;
    ListNode odd = head, even = head.next, evenHead = even;
    while (even != null && even.next != null) {
        odd.next = even.next; odd = odd.next;
        even.next = odd.next; even = even.next;
    }
    odd.next = evenHead;
    return head;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q59. Rotate List
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Rotate the list to the right by k places.

**Example:**
```
Input: 1->2->3->4->5, k=2
Output: 4->5->1->2->3
```

**Solution:**
```java
public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) return head;
    int len = 1; ListNode tail = head;
    while (tail.next != null) { tail = tail.next; len++; }
    k %= len;
    if (k == 0) return head;
    tail.next = head;
    ListNode newTail = head;
    for (int i = 0; i < len - k - 1; i++) newTail = newTail.next;
    ListNode newHead = newTail.next; newTail.next = null;
    return newHead;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q60. Swap Nodes in Pairs
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Swap every two adjacent nodes and return the head.

**Example:**
```
Input: 1->2->3->4
Output: 2->1->4->3
```

**Solution:**
```java
public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    while (prev.next != null && prev.next.next != null) {
        ListNode a = prev.next, b = prev.next.next;
        prev.next = b; a.next = b.next; b.next = a;
        prev = a;
    }
    return dummy.next;
}
```
**Time:** O(n) | **Space:** O(1)

---

## SECTION 4: STACKS & QUEUES (Q61–Q75)

---

### Q61. Min Stack
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Design a stack that supports push, pop, top, and retrieving the minimum element in O(1).

**Example:**
```
MinStack s; s.push(-2); s.push(0); s.push(-3); s.getMin()→-3; s.pop(); s.top()→0; s.getMin()→-2
```

**Solution:**
```java
class MinStack {
    Deque<Integer> stack = new ArrayDeque<>(), minStack = new ArrayDeque<>();
    public void push(int val) { stack.push(val); minStack.push(minStack.isEmpty() ? val : Math.min(val, minStack.peek())); }
    public void pop() { stack.pop(); minStack.pop(); }
    public int top() { return stack.peek(); }
    public int getMin() { return minStack.peek(); }
}
```
**Time:** O(1) all ops | **Space:** O(n)

---

### Q62. Daily Temperatures
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Return array where answer[i] is the number of days until a warmer temperature.

**Example:**
```
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
```

**Solution:**
```java
public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] result = new int[n];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
            int idx = stack.pop();
            result[idx] = i - idx;
        }
        stack.push(i);
    }
    return result;
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q63. Largest Rectangle in Histogram
**Difficulty:** Hard (common MAANG) | **Companies:** Amazon, Google, Meta

**Problem:** Find the largest rectangle in a histogram.

**Example:**
```
Input: heights = [2,1,5,6,2,3]
Output: 10
```

**Solution:**
```java
public int largestRectangleArea(int[] heights) {
    Deque<Integer> stack = new ArrayDeque<>();
    int maxArea = 0;
    for (int i = 0; i <= heights.length; i++) {
        int h = i == heights.length ? 0 : heights[i];
        while (!stack.isEmpty() && h < heights[stack.peek()]) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        stack.push(i);
    }
    return maxArea;
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q64. Evaluate Reverse Polish Notation
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Evaluate the value of an arithmetic expression in Reverse Polish Notation.

**Example:**
```
Input: tokens = ["2","1","+","3","*"]
Output: 9
```

**Solution:**
```java
public int evalRPN(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (String token : tokens) {
        if ("+-*/".contains(token)) {
            int b = stack.pop(), a = stack.pop();
            switch (token) {
                case "+": stack.push(a + b); break;
                case "-": stack.push(a - b); break;
                case "*": stack.push(a * b); break;
                case "/": stack.push(a / b); break;
            }
        } else stack.push(Integer.parseInt(token));
    }
    return stack.pop();
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q65. Car Fleet
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Determine how many car fleets arrive at target destination.

**Example:**
```
Input: target=12, position=[10,8,0,5,3], speed=[2,4,1,1,3]
Output: 3
```

**Solution:**
```java
public int carFleet(int target, int[] position, int[] speed) {
    int n = position.length;
    double[][] cars = new double[n][2];
    for (int i = 0; i < n; i++) cars[i] = new double[]{position[i], (double)(target - position[i]) / speed[i]};
    Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
    int fleets = 0;
    double maxTime = 0;
    for (double[] car : cars) {
        if (car[1] > maxTime) { maxTime = car[1]; fleets++; }
    }
    return fleets;
}
```
**Time:** O(n log n) | **Space:** O(n)

---

### Q66. Next Greater Element I
**Difficulty:** Easy | **Companies:** Amazon, Google

**Problem:** Find the next greater element for each element of nums1 in nums2.

**Example:**
```
Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
```

**Solution:**
```java
public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    Deque<Integer> stack = new ArrayDeque<>();
    for (int num : nums2) {
        while (!stack.isEmpty() && stack.peek() < num) map.put(stack.pop(), num);
        stack.push(num);
    }
    int[] result = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) result[i] = map.getOrDefault(nums1[i], -1);
    return result;
}
```
**Time:** O(m+n) | **Space:** O(n)

---

### Q67. Asteroid Collision
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find the state of asteroids after all collisions. Positive=right, negative=left. Same size both explode.

**Example:**
```
Input: asteroids = [5,10,-5]
Output: [5,10]
```

**Solution:**
```java
public int[] asteroidCollision(int[] asteroids) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (int ast : asteroids) {
        boolean alive = true;
        while (alive && ast < 0 && !stack.isEmpty() && stack.peek() > 0) {
            if (stack.peek() < -ast) { stack.pop(); }
            else if (stack.peek() == -ast) { stack.pop(); alive = false; }
            else { alive = false; }
        }
        if (alive) stack.push(ast);
    }
    int[] result = new int[stack.size()];
    for (int i = result.length - 1; i >= 0; i--) result[i] = stack.pop();
    return result;
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q68. Task Scheduler
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Given tasks and cooldown n, find minimum intervals needed.

**Example:**
```
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
```

**Solution:**
```java
public int leastInterval(char[] tasks, int n) {
    int[] freq = new int[26];
    for (char c : tasks) freq[c - 'A']++;
    Arrays.sort(freq);
    int maxFreq = freq[25], idleTime = (maxFreq - 1) * n;
    for (int i = 24; i >= 0 && idleTime > 0; i--) idleTime -= Math.min(freq[i], maxFreq - 1);
    idleTime = Math.max(0, idleTime);
    return tasks.length + idleTime;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q69. Simplify Path
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Given a Unix file path, simplify it to canonical form.

**Example:**
```
Input: path = "/home//foo/"
Output: "/home/foo"
```

**Solution:**
```java
public String simplifyPath(String path) {
    Deque<String> stack = new ArrayDeque<>();
    for (String part : path.split("/")) {
        if (part.equals("..")) { if (!stack.isEmpty()) stack.pop(); }
        else if (!part.isEmpty() && !part.equals(".")) { stack.push(part); }
    }
    StringBuilder sb = new StringBuilder();
    for (String dir : stack) sb.insert(0, "/" + dir);
    return sb.length() == 0 ? "/" : sb.toString();
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q70. Sliding Window Maximum
**Difficulty:** Hard (common MAANG) | **Companies:** Amazon, Google

**Problem:** Find the maximum in each sliding window of size k.

**Example:**
```
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
```

**Solution (Monotonic Deque):**
```java
public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    int[] result = new int[n - k + 1];
    Deque<Integer> dq = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
        if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) dq.pollFirst();
        while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
        dq.offerLast(i);
        if (i >= k - 1) result[i - k + 1] = nums[dq.peekFirst()];
    }
    return result;
}
```
**Time:** O(n) | **Space:** O(k)

---

### Q71. Number of Recent Calls
**Difficulty:** Easy | **Companies:** Amazon, Google

**Problem:** Count requests in the last 3000ms.

**Solution:**
```java
class RecentCounter {
    Deque<Integer> queue = new ArrayDeque<>();
    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) queue.poll();
        return queue.size();
    }
}
```
**Time:** O(1) amortized | **Space:** O(n)

---

### Q72. Online Stock Span
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Collect daily price quotes and return the span (consecutive days ≤ today's price).

**Solution:**
```java
class StockSpanner {
    Deque<int[]> stack = new ArrayDeque<>();
    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) span += stack.pop()[1];
        stack.push(new int[]{price, span});
        return span;
    }
}
```
**Time:** O(1) amortized | **Space:** O(n)

---

### Q73. Implement Queue using Stacks
**Difficulty:** Easy | **Companies:** Amazon, Meta

**Problem:** Implement a first-in-first-out queue using only two stacks.

**Solution:**
```java
class MyQueue {
    Deque<Integer> in = new ArrayDeque<>(), out = new ArrayDeque<>();
    public void push(int x) { in.push(x); }
    public int pop() { move(); return out.pop(); }
    public int peek() { move(); return out.peek(); }
    public boolean empty() { return in.isEmpty() && out.isEmpty(); }
    private void move() { if (out.isEmpty()) while (!in.isEmpty()) out.push(in.pop()); }
}
```
**Time:** O(1) amortized | **Space:** O(n)

---

### Q74. Basic Calculator II
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Evaluate a string expression with +, -, *, / (integer division).

**Example:**
```
Input: s = " 3+5 / 2 "
Output: 5
```

**Solution:**
```java
public int calculate(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    int num = 0; char op = '+';
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (Character.isDigit(c)) num = num * 10 + (c - '0');
        if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
            if (op == '+') stack.push(num);
            else if (op == '-') stack.push(-num);
            else if (op == '*') stack.push(stack.pop() * num);
            else stack.push(stack.pop() / num);
            op = c; num = 0;
        }
    }
    int result = 0;
    while (!stack.isEmpty()) result += stack.pop();
    return result;
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q75. Implement Stack using Queues
**Difficulty:** Easy | **Companies:** Amazon, Meta

**Problem:** Implement a last-in-first-out stack using only queues.

**Solution:**
```java
class MyStack {
    Queue<Integer> queue = new LinkedList<>();
    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < queue.size() - 1; i++) queue.offer(queue.poll());
    }
    public int pop() { return queue.poll(); }
    public int top() { return queue.peek(); }
    public boolean empty() { return queue.isEmpty(); }
}
```
**Time:** O(n) push, O(1) others | **Space:** O(n)

---

## SECTION 5: TREES (Q76–Q105)

---

### Q76. Maximum Depth of Binary Tree
**Difficulty:** Easy | **Companies:** Amazon, Google, Meta

**Example:**
```
Input: [3,9,20,null,null,15,7]
Output: 3
```

**Solution:**
```java
public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
}
```
**Time:** O(n) | **Space:** O(h)

---

### Q77. Invert Binary Tree
**Difficulty:** Easy | **Companies:** Google, Amazon

**Solution:**
```java
public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    TreeNode tmp = root.left;
    root.left = invertTree(root.right);
    root.right = invertTree(tmp);
    return root;
}
```
**Time:** O(n) | **Space:** O(h)

---

### Q78. Symmetric Tree
**Difficulty:** Easy | **Companies:** Amazon, Google, Meta

**Example:**
```
Input: [1,2,2,3,4,4,3]
Output: true
```

**Solution:**
```java
public boolean isSymmetric(TreeNode root) {
    return isMirror(root.left, root.right);
}
private boolean isMirror(TreeNode l, TreeNode r) {
    if (l == null && r == null) return true;
    if (l == null || r == null) return false;
    return l.val == r.val && isMirror(l.left, r.right) && isMirror(l.right, r.left);
}
```
**Time:** O(n) | **Space:** O(h)

---

### Q79. Binary Tree Level Order Traversal
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta, Apple

**Example:**
```
Input: [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
```

**Solution:**
```java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        int size = queue.size();
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            level.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        result.add(level);
    }
    return result;
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q80. Binary Tree Right Side View
**Difficulty:** Medium | **Companies:** Amazon, Meta

**Example:**
```
Input: [1,2,3,null,5,null,4]
Output: [1,3,4]
```

**Solution:**
```java
public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            if (i == size - 1) result.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }
    return result;
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q81. Lowest Common Ancestor of BST
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Solution:**
```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
    if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
    return root;
}
```
**Time:** O(h) | **Space:** O(h)

---

### Q82. Lowest Common Ancestor of Binary Tree
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Solution:**
```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    return left == null ? right : right == null ? left : root;
}
```
**Time:** O(n) | **Space:** O(h)

---

### Q83. Validate Binary Search Tree
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta, Apple

**Example:**
```
Input: [2,1,3]
Output: true
```

**Solution:**
```java
public boolean isValidBST(TreeNode root) {
    return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
}
private boolean validate(TreeNode node, long min, long max) {
    if (node == null) return true;
    if (node.val <= min || node.val >= max) return false;
    return validate(node.left, min, node.val) && validate(node.right, node.val, max);
}
```
**Time:** O(n) | **Space:** O(h)

---

### Q84. Kth Smallest Element in a BST
**Difficulty:** Medium | **Companies:** Amazon, Google

**Solution:**
```java
public int kthSmallest(TreeNode root, int k) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
        while (curr != null) { stack.push(curr); curr = curr.left; }
        curr = stack.pop();
        if (--k == 0) return curr.val;
        curr = curr.right;
    }
    return -1;
}
```
**Time:** O(h+k) | **Space:** O(h)

---

### Q85. Diameter of Binary Tree
**Difficulty:** Easy | **Companies:** Amazon, Google, Meta

**Example:**
```
Input: [1,2,3,4,5]
Output: 3  (path: 4->2->1->3 or 5->2->1->3)
```

**Solution:**
```java
int maxDiameter = 0;
public int diameterOfBinaryTree(TreeNode root) {
    depth(root);
    return maxDiameter;
}
private int depth(TreeNode node) {
    if (node == null) return 0;
    int left = depth(node.left), right = depth(node.right);
    maxDiameter = Math.max(maxDiameter, left + right);
    return 1 + Math.max(left, right);
}
```
**Time:** O(n) | **Space:** O(h)

---

### Q86. Balanced Binary Tree
**Difficulty:** Easy | **Companies:** Amazon, Google

**Solution:**
```java
public boolean isBalanced(TreeNode root) {
    return checkHeight(root) != -1;
}
private int checkHeight(TreeNode node) {
    if (node == null) return 0;
    int left = checkHeight(node.left);
    if (left == -1) return -1;
    int right = checkHeight(node.right);
    if (right == -1) return -1;
    if (Math.abs(left - right) > 1) return -1;
    return 1 + Math.max(left, right);
}
```
**Time:** O(n) | **Space:** O(h)

---

### Q87. Path Sum
**Difficulty:** Easy | **Companies:** Amazon, Meta

**Solution:**
```java
public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;
    if (root.left == null && root.right == null) return root.val == targetSum;
    return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
}
```
**Time:** O(n) | **Space:** O(h)

---

### Q88. Path Sum II
**Difficulty:** Medium | **Companies:** Amazon, Meta

**Problem:** Find all root-to-leaf paths where sum equals targetSum.

**Solution:**
```java
public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    dfs(root, targetSum, new ArrayList<>(), result);
    return result;
}
private void dfs(TreeNode node, int remaining, List<Integer> path, List<List<Integer>> result) {
    if (node == null) return;
    path.add(node.val);
    if (node.left == null && node.right == null && remaining == node.val) result.add(new ArrayList<>(path));
    dfs(node.left, remaining - node.val, path, result);
    dfs(node.right, remaining - node.val, path, result);
    path.remove(path.size() - 1);
}
```
**Time:** O(n²) | **Space:** O(h)

---

### Q89. Binary Tree Maximum Path Sum
**Difficulty:** Hard (very common) | **Companies:** Amazon, Google, Meta

**Example:**
```
Input: [-10,9,20,null,null,15,7]
Output: 42  (path: 15->20->7)
```

**Solution:**
```java
int maxSum = Integer.MIN_VALUE;
public int maxPathSum(TreeNode root) {
    gain(root);
    return maxSum;
}
private int gain(TreeNode node) {
    if (node == null) return 0;
    int left = Math.max(0, gain(node.left));
    int right = Math.max(0, gain(node.right));
    maxSum = Math.max(maxSum, left + right + node.val);
    return node.val + Math.max(left, right);
}
```
**Time:** O(n) | **Space:** O(h)

---

### Q90. Subtree of Another Tree
**Difficulty:** Easy | **Companies:** Amazon, Google

**Solution:**
```java
public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null) return false;
    if (isSameTree(root, subRoot)) return true;
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
}
private boolean isSameTree(TreeNode s, TreeNode t) {
    if (s == null && t == null) return true;
    if (s == null || t == null || s.val != t.val) return false;
    return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
}
```
**Time:** O(m*n) | **Space:** O(h)

---

### Q91. Construct Binary Tree from Preorder and Inorder
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Example:**
```
Input: preorder=[3,9,20,15,7], inorder=[9,3,15,20,7]
Output: Tree: [3,9,20,null,null,15,7]
```

**Solution:**
```java
public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
    return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
}
private TreeNode build(int[] pre, int ps, int pe, int is, int ie, Map<Integer, Integer> map) {
    if (ps > pe || is > ie) return null;
    TreeNode root = new TreeNode(pre[ps]);
    int mid = map.get(pre[ps]);
    root.left = build(pre, ps + 1, ps + mid - is, is, mid - 1, map);
    root.right = build(pre, ps + mid - is + 1, pe, mid + 1, ie, map);
    return root;
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q92. Flatten Binary Tree to Linked List
**Difficulty:** Medium | **Companies:** Amazon, Google

**Example:**
```
Input: [1,2,5,3,4,null,6]
Output: 1->2->3->4->5->6 (right pointers only)
```

**Solution:**
```java
public void flatten(TreeNode root) {
    if (root == null) return;
    flatten(root.left);
    flatten(root.right);
    TreeNode right = root.right;
    root.right = root.left;
    root.left = null;
    TreeNode curr = root;
    while (curr.right != null) curr = curr.right;
    curr.right = right;
}
```
**Time:** O(n) | **Space:** O(h)

---

### Q93. Count Good Nodes in Binary Tree
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Count nodes where no node in the path has value greater than this node's value.

**Solution:**
```java
public int goodNodes(TreeNode root) {
    return dfs(root, Integer.MIN_VALUE);
}
private int dfs(TreeNode node, int maxSoFar) {
    if (node == null) return 0;
    int count = node.val >= maxSoFar ? 1 : 0;
    int newMax = Math.max(maxSoFar, node.val);
    return count + dfs(node.left, newMax) + dfs(node.right, newMax);
}
```
**Time:** O(n) | **Space:** O(h)

---

### Q94. Binary Tree Zigzag Level Order Traversal
**Difficulty:** Medium | **Companies:** Amazon, Meta

**Solution:**
```java
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean leftToRight = true;
    while (!queue.isEmpty()) {
        int size = queue.size();
        LinkedList<Integer> level = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            if (leftToRight) level.addLast(node.val); else level.addFirst(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        result.add(level);
        leftToRight = !leftToRight;
    }
    return result;
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q95. Convert Sorted Array to BST
**Difficulty:** Easy | **Companies:** Amazon, Google

**Solution:**
```java
public TreeNode sortedArrayToBST(int[] nums) {
    return build(nums, 0, nums.length - 1);
}
private TreeNode build(int[] nums, int l, int r) {
    if (l > r) return null;
    int mid = l + (r - l) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = build(nums, l, mid - 1);
    node.right = build(nums, mid + 1, r);
    return node;
}
```
**Time:** O(n) | **Space:** O(log n)

---

### Q96. Serialize and Deserialize Binary Tree
**Difficulty:** Hard (very common) | **Companies:** Amazon, Google, Meta

**Solution:**
```java
public String serialize(TreeNode root) {
    if (root == null) return "null";
    return root.val + "," + serialize(root.left) + "," + serialize(root.right);
}
private int idx = 0;
public TreeNode deserialize(String data) {
    String[] nodes = data.split(","); idx = 0;
    return buildTree(nodes);
}
private TreeNode buildTree(String[] nodes) {
    if (nodes[idx].equals("null")) { idx++; return null; }
    TreeNode node = new TreeNode(Integer.parseInt(nodes[idx++]));
    node.left = buildTree(nodes);
    node.right = buildTree(nodes);
    return node;
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q97. Binary Search Tree Iterator
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Implement an iterator over BST with next() and hasNext() in O(h) space.

**Solution:**
```java
class BSTIterator {
    Deque<TreeNode> stack = new ArrayDeque<>();
    public BSTIterator(TreeNode root) { pushLeft(root); }
    public int next() {
        TreeNode node = stack.pop();
        pushLeft(node.right);
        return node.val;
    }
    public boolean hasNext() { return !stack.isEmpty(); }
    private void pushLeft(TreeNode node) {
        while (node != null) { stack.push(node); node = node.left; }
    }
}
```
**Time:** O(1) amortized | **Space:** O(h)

---

### Q98. Same Tree
**Difficulty:** Easy | **Companies:** Amazon, Google

**Solution:**
```java
public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null || p.val != q.val) return false;
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
}
```
**Time:** O(n) | **Space:** O(h)

---

### Q99. Minimum Depth of Binary Tree
**Difficulty:** Easy | **Companies:** Amazon, Meta

**Solution:**
```java
public int minDepth(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) return 1;
    if (root.left == null) return 1 + minDepth(root.right);
    if (root.right == null) return 1 + minDepth(root.left);
    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
}
```
**Time:** O(n) | **Space:** O(h)

---

### Q100. Sum Root to Leaf Numbers
**Difficulty:** Medium | **Companies:** Amazon, Google

**Example:**
```
Input: [1,2,3]
Output: 25  (12 + 13)
```

**Solution:**
```java
public int sumNumbers(TreeNode root) {
    return dfs(root, 0);
}
private int dfs(TreeNode node, int current) {
    if (node == null) return 0;
    current = current * 10 + node.val;
    if (node.left == null && node.right == null) return current;
    return dfs(node.left, current) + dfs(node.right, current);
}
```
**Time:** O(n) | **Space:** O(h)

---

### Q101. Populating Next Right Pointers
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Solution (O(1) space):**
```java
public Node connect(Node root) {
    Node curr = root;
    while (curr != null && curr.left != null) {
        Node tmp = curr;
        while (tmp != null) {
            tmp.left.next = tmp.right;
            if (tmp.next != null) tmp.right.next = tmp.next.left;
            tmp = tmp.next;
        }
        curr = curr.left;
    }
    return root;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q102. Path Sum III
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Count paths that sum to target (not required to start/end at root/leaf).

**Solution:**
```java
public int pathSum(TreeNode root, int targetSum) {
    Map<Long, Integer> prefixCount = new HashMap<>();
    prefixCount.put(0L, 1);
    return dfs(root, 0L, targetSum, prefixCount);
}
private int dfs(TreeNode node, long curr, int target, Map<Long, Integer> map) {
    if (node == null) return 0;
    curr += node.val;
    int count = map.getOrDefault(curr - target, 0);
    map.merge(curr, 1, Integer::sum);
    count += dfs(node.left, curr, target, map) + dfs(node.right, curr, target, map);
    map.merge(curr, -1, Integer::sum);
    return count;
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q103. Recover Binary Search Tree
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Two nodes of the BST are swapped. Recover the tree without changing its structure.

**Solution:**
```java
TreeNode first, second, prev;
public void recoverTree(TreeNode root) {
    inorder(root);
    int tmp = first.val; first.val = second.val; second.val = tmp;
}
private void inorder(TreeNode node) {
    if (node == null) return;
    inorder(node.left);
    if (prev != null && prev.val > node.val) {
        if (first == null) first = prev;
        second = node;
    }
    prev = node;
    inorder(node.right);
}
```
**Time:** O(n) | **Space:** O(h)

---

### Q104. All Nodes Distance K in Binary Tree
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find all nodes at distance K from target node.

**Solution:**
```java
public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    buildParentMap(root, null, parent);
    List<Integer> result = new ArrayList<>();
    Set<TreeNode> visited = new HashSet<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(target); visited.add(target);
    int dist = 0;
    while (!queue.isEmpty()) {
        if (dist == k) { for (TreeNode n : queue) result.add(n.val); return result; }
        int size = queue.size(); dist++;
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            for (TreeNode neighbor : new TreeNode[]{node.left, node.right, parent.get(node)}) {
                if (neighbor != null && !visited.contains(neighbor)) { visited.add(neighbor); queue.offer(neighbor); }
            }
        }
    }
    return result;
}
private void buildParentMap(TreeNode node, TreeNode par, Map<TreeNode, TreeNode> map) {
    if (node == null) return;
    map.put(node, par);
    buildParentMap(node.left, node, map);
    buildParentMap(node.right, node, map);
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q105. Find Duplicate Subtrees
**Difficulty:** Medium | **Companies:** Amazon, Google

**Solution:**
```java
public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    List<TreeNode> result = new ArrayList<>();
    Map<String, Integer> count = new HashMap<>();
    serialize(root, count, result);
    return result;
}
private String serialize(TreeNode node, Map<String, Integer> count, List<TreeNode> result) {
    if (node == null) return "#";
    String key = node.val + "," + serialize(node.left, count, result) + "," + serialize(node.right, count, result);
    count.merge(key, 1, Integer::sum);
    if (count.get(key) == 2) result.add(node);
    return key;
}
```
**Time:** O(n²) | **Space:** O(n²)
