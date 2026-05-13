# MAANG LeetCode 200 — Part 2 (Q106–Q200)

---

## SECTION 6: BINARY SEARCH (Q106–Q120)

---

### Q106. Binary Search
**Difficulty:** Easy | **Companies:** Amazon, Google, Meta

**Example:**
```
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
```

**Solution:**
```java
public int search(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    while (l <= r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) l = mid + 1;
        else r = mid - 1;
    }
    return -1;
}
```
**Time:** O(log n) | **Space:** O(1)

---

### Q107. Search a 2D Matrix
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Search for target in matrix where each row is sorted and first integer > last of previous row.

**Example:**
```
Input: matrix=[[1,3,5,7],[10,11,16,20],[23,30,34,60]], target=3
Output: true
```

**Solution:**
```java
public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length;
    int l = 0, r = m * n - 1;
    while (l <= r) {
        int mid = l + (r - l) / 2;
        int val = matrix[mid / n][mid % n];
        if (val == target) return true;
        else if (val < target) l = mid + 1;
        else r = mid - 1;
    }
    return false;
}
```
**Time:** O(log(m·n)) | **Space:** O(1)

---

### Q108. First Bad Version
**Difficulty:** Easy | **Companies:** Amazon, Meta

**Solution:**
```java
public int firstBadVersion(int n) {
    int l = 1, r = n;
    while (l < r) {
        int mid = l + (r - l) / 2;
        if (isBadVersion(mid)) r = mid;
        else l = mid + 1;
    }
    return l;
}
```
**Time:** O(log n) | **Space:** O(1)

---

### Q109. Find Peak Element
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Find a peak element (greater than neighbors). Multiple peaks may exist.

**Example:**
```
Input: nums = [1,2,3,1]
Output: 2
```

**Solution:**
```java
public int findPeakElement(int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] > nums[mid + 1]) r = mid;
        else l = mid + 1;
    }
    return l;
}
```
**Time:** O(log n) | **Space:** O(1)

---

### Q110. Kth Largest Element in an Array
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta, Apple

**Example:**
```
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
```

**Solution (QuickSelect):**
```java
public int findKthLargest(int[] nums, int k) {
    return quickSelect(nums, 0, nums.length - 1, nums.length - k);
}
private int quickSelect(int[] nums, int l, int r, int k) {
    int pivot = nums[r], p = l;
    for (int i = l; i < r; i++) if (nums[i] <= pivot) swap(nums, i, p++);
    swap(nums, p, r);
    if (p == k) return nums[p];
    return p < k ? quickSelect(nums, p + 1, r, k) : quickSelect(nums, l, p - 1, k);
}
private void swap(int[] nums, int i, int j) { int t = nums[i]; nums[i] = nums[j]; nums[j] = t; }
```
**Time:** O(n) average | **Space:** O(1)

---

### Q111. Koko Eating Bananas
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find minimum eating speed k such that Koko can eat all bananas in h hours.

**Example:**
```
Input: piles = [3,6,7,11], h = 8
Output: 4
```

**Solution:**
```java
public int minEatingSpeed(int[] piles, int h) {
    int l = 1, r = Arrays.stream(piles).max().getAsInt();
    while (l < r) {
        int mid = l + (r - l) / 2;
        long hours = 0;
        for (int p : piles) hours += (p + mid - 1) / mid;
        if (hours <= h) r = mid; else l = mid + 1;
    }
    return l;
}
```
**Time:** O(n log m) | **Space:** O(1)

---

### Q112. Capacity to Ship Packages Within D Days
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find the minimum weight capacity to ship all packages within D days.

**Example:**
```
Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
```

**Solution:**
```java
public int shipWithinDays(int[] weights, int days) {
    int l = Arrays.stream(weights).max().getAsInt();
    int r = Arrays.stream(weights).sum();
    while (l < r) {
        int mid = l + (r - l) / 2;
        int daysNeeded = 1, curr = 0;
        for (int w : weights) {
            if (curr + w > mid) { daysNeeded++; curr = 0; }
            curr += w;
        }
        if (daysNeeded <= days) r = mid; else l = mid + 1;
    }
    return l;
}
```
**Time:** O(n log S) | **Space:** O(1)

---

### Q113. Find K Closest Elements
**Difficulty:** Medium | **Companies:** Amazon, Google

**Example:**
```
Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
```

**Solution:**
```java
public List<Integer> findClosestElements(int[] arr, int k, int x) {
    int l = 0, r = arr.length - k;
    while (l < r) {
        int mid = l + (r - l) / 2;
        if (x - arr[mid] > arr[mid + k] - x) l = mid + 1;
        else r = mid;
    }
    List<Integer> result = new ArrayList<>();
    for (int i = l; i < l + k; i++) result.add(arr[i]);
    return result;
}
```
**Time:** O(log(n-k) + k) | **Space:** O(1)

---

### Q114. Search a 2D Matrix II
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Search in matrix where each row and column is sorted in ascending order.

**Example:**
```
Input: matrix=[[1,4,7,11],[2,5,8,12],[3,6,9,16],[10,13,14,17]], target=5
Output: true
```

**Solution:**
```java
public boolean searchMatrix(int[][] matrix, int target) {
    int row = 0, col = matrix[0].length - 1;
    while (row < matrix.length && col >= 0) {
        if (matrix[row][col] == target) return true;
        else if (matrix[row][col] > target) col--;
        else row++;
    }
    return false;
}
```
**Time:** O(m+n) | **Space:** O(1)

---

### Q115. Split Array Largest Sum
**Difficulty:** Hard (common MAANG) | **Companies:** Amazon, Google

**Problem:** Split array into m subarrays to minimize the largest sum.

**Example:**
```
Input: nums = [7,2,5,10,8], m = 2
Output: 18
```

**Solution:**
```java
public int splitArray(int[] nums, int m) {
    int l = Arrays.stream(nums).max().getAsInt();
    int r = Arrays.stream(nums).sum();
    while (l < r) {
        int mid = l + (r - l) / 2;
        int parts = 1, curr = 0;
        for (int n : nums) {
            if (curr + n > mid) { parts++; curr = 0; }
            curr += n;
        }
        if (parts <= m) r = mid; else l = mid + 1;
    }
    return l;
}
```
**Time:** O(n log S) | **Space:** O(1)

---

### Q116. Median of Two Sorted Arrays
**Difficulty:** Hard | **Companies:** Amazon, Google, Meta

**Example:**
```
Input: nums1 = [1,3], nums2 = [2]
Output: 2.0
```

**Solution:**
```java
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
    int m = nums1.length, n = nums2.length;
    int l = 0, r = m;
    while (l <= r) {
        int i = l + (r - l) / 2, j = (m + n + 1) / 2 - i;
        int maxL1 = i == 0 ? Integer.MIN_VALUE : nums1[i-1];
        int minR1 = i == m ? Integer.MAX_VALUE : nums1[i];
        int maxL2 = j == 0 ? Integer.MIN_VALUE : nums2[j-1];
        int minR2 = j == n ? Integer.MAX_VALUE : nums2[j];
        if (maxL1 <= minR2 && maxL2 <= minR1) {
            if ((m + n) % 2 == 0) return (Math.max(maxL1, maxL2) + Math.min(minR1, minR2)) / 2.0;
            else return Math.max(maxL1, maxL2);
        } else if (maxL1 > minR2) r = i - 1;
        else l = i + 1;
    }
    return 0;
}
```
**Time:** O(log(min(m,n))) | **Space:** O(1)

---

### Q117. Random Pick with Weight
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Solution:**
```java
class Solution {
    int[] prefixSum;
    Random rand = new Random();
    public Solution(int[] w) {
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) prefixSum[i] = prefixSum[i-1] + w[i];
    }
    public int pickIndex() {
        int target = rand.nextInt(prefixSum[prefixSum.length - 1]) + 1;
        int l = 0, r = prefixSum.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (prefixSum[mid] < target) l = mid + 1; else r = mid;
        }
        return l;
    }
}
```
**Time:** O(log n) per pick | **Space:** O(n)

---

### Q118. Time Based Key-Value Store
**Difficulty:** Medium | **Companies:** Google, Amazon

**Problem:** Design a key-value store with timestamps; get returns value with largest timestamp ≤ given timestamp.

**Solution:**
```java
class TimeMap {
    Map<String, List<int[]>> map = new HashMap<>();
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{timestamp, value.hashCode()});
    }
    // Full solution stores string values:
    Map<String, List<Object[]>> store = new HashMap<>();
    public void set2(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new ArrayList<>()).add(new Object[]{timestamp, value});
    }
    public String get(String key, int timestamp) {
        List<Object[]> list = store.getOrDefault(key, new ArrayList<>());
        int l = 0, r = list.size() - 1;
        String result = "";
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((int)list.get(mid)[0] <= timestamp) { result = (String)list.get(mid)[1]; l = mid + 1; }
            else r = mid - 1;
        }
        return result;
    }
}
```
**Time:** O(log n) get | **Space:** O(n)

---

### Q119. Sqrt(x)
**Difficulty:** Easy | **Companies:** Amazon, Google

**Solution:**
```java
public int mySqrt(int x) {
    long l = 0, r = x;
    while (l < r) {
        long mid = l + (r - l + 1) / 2;
        if (mid * mid <= x) l = mid; else r = mid - 1;
    }
    return (int) l;
}
```
**Time:** O(log x) | **Space:** O(1)

---

### Q120. Count of Smaller Numbers After Self
**Difficulty:** Hard | **Companies:** Amazon, Google

**Example:**
```
Input: nums = [5,2,6,1]
Output: [2,1,1,0]
```

**Solution (Merge Sort):**
```java
public List<Integer> countSmaller(int[] nums) {
    int n = nums.length;
    int[] result = new int[n], indices = new int[n];
    for (int i = 0; i < n; i++) indices[i] = i;
    mergeSort(nums, indices, result, 0, n - 1);
    List<Integer> list = new ArrayList<>();
    for (int r : result) list.add(r);
    return list;
}
private void mergeSort(int[] nums, int[] indices, int[] result, int l, int r) {
    if (l >= r) return;
    int mid = l + (r - l) / 2;
    mergeSort(nums, indices, result, l, mid);
    mergeSort(nums, indices, result, mid + 1, r);
    merge(nums, indices, result, l, mid, r);
}
private void merge(int[] nums, int[] indices, int[] result, int l, int mid, int r) {
    int[] tmp = new int[r - l + 1];
    int i = l, j = mid + 1, k = 0, rightCount = 0;
    while (i <= mid && j <= r) {
        if (nums[indices[j]] < nums[indices[i]]) { rightCount++; tmp[k++] = indices[j++]; }
        else { result[indices[i]] += rightCount; tmp[k++] = indices[i++]; }
    }
    while (i <= mid) { result[indices[i]] += rightCount; tmp[k++] = indices[i++]; }
    while (j <= r) tmp[k++] = indices[j++];
    System.arraycopy(tmp, 0, indices, l, tmp.length);
}
```
**Time:** O(n log n) | **Space:** O(n)

---

## SECTION 7: DYNAMIC PROGRAMMING (Q121–Q155)

---

### Q121. Climbing Stairs
**Difficulty:** Easy | **Companies:** Amazon, Google, Apple

**Problem:** n steps to the top, can take 1 or 2 steps. How many distinct ways?

**Example:**
```
Input: n = 3
Output: 3
```

**Solution:**
```java
public int climbStairs(int n) {
    if (n <= 2) return n;
    int a = 1, b = 2;
    for (int i = 3; i <= n; i++) { int c = a + b; a = b; b = c; }
    return b;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q122. House Robber
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Rob houses (not adjacent) to maximize money.

**Example:**
```
Input: nums = [2,7,9,3,1]
Output: 12
```

**Solution:**
```java
public int rob(int[] nums) {
    int prev2 = 0, prev1 = 0;
    for (int num : nums) { int curr = Math.max(prev1, prev2 + num); prev2 = prev1; prev1 = curr; }
    return prev1;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q123. House Robber II
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Houses in a circle. Rob maximum (first and last can't both be robbed).

**Example:**
```
Input: nums = [2,3,2]
Output: 3
```

**Solution:**
```java
public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];
    return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
}
private int robRange(int[] nums, int l, int r) {
    int prev2 = 0, prev1 = 0;
    for (int i = l; i <= r; i++) { int curr = Math.max(prev1, prev2 + nums[i]); prev2 = prev1; prev1 = curr; }
    return prev1;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q124. Jump Game
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Can you reach the last index? Each element is max jump length.

**Example:**
```
Input: nums = [2,3,1,1,4]
Output: true
```

**Solution:**
```java
public boolean canJump(int[] nums) {
    int maxReach = 0;
    for (int i = 0; i < nums.length; i++) {
        if (i > maxReach) return false;
        maxReach = Math.max(maxReach, i + nums[i]);
    }
    return true;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q125. Jump Game II
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find minimum number of jumps to reach the last index.

**Example:**
```
Input: nums = [2,3,1,1,4]
Output: 2
```

**Solution:**
```java
public int jump(int[] nums) {
    int jumps = 0, currentEnd = 0, farthest = 0;
    for (int i = 0; i < nums.length - 1; i++) {
        farthest = Math.max(farthest, i + nums[i]);
        if (i == currentEnd) { jumps++; currentEnd = farthest; }
    }
    return jumps;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q126. Coin Change
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta, Apple

**Problem:** Find minimum coins to make the amount.

**Example:**
```
Input: coins = [1,5,11], amount = 15
Output: 3
```

**Solution:**
```java
public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
        for (int coin : coins) {
            if (coin <= i) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
    }
    return dp[amount] > amount ? -1 : dp[amount];
}
```
**Time:** O(n·amount) | **Space:** O(amount)

---

### Q127. Coin Change II
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Return number of combinations to make up the amount.

**Example:**
```
Input: amount = 5, coins = [1,2,5]
Output: 4
```

**Solution:**
```java
public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int coin : coins) for (int i = coin; i <= amount; i++) dp[i] += dp[i - coin];
    return dp[amount];
}
```
**Time:** O(n·amount) | **Space:** O(amount)

---

### Q128. Longest Increasing Subsequence
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Example:**
```
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4  ([2,3,7,101])
```

**Solution (Binary Search O(n log n)):**
```java
public int lengthOfLIS(int[] nums) {
    List<Integer> tails = new ArrayList<>();
    for (int num : nums) {
        int l = 0, r = tails.size();
        while (l < r) { int mid = l + (r - l) / 2; if (tails.get(mid) < num) l = mid + 1; else r = mid; }
        if (l == tails.size()) tails.add(num); else tails.set(l, num);
    }
    return tails.size();
}
```
**Time:** O(n log n) | **Space:** O(n)

---

### Q129. Longest Common Subsequence
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta, Apple

**Example:**
```
Input: text1 = "abcde", text2 = "ace"
Output: 3  ("ace")
```

**Solution:**
```java
public int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length(), n = text2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (text1.charAt(i-1) == text2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
            else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
    }
    return dp[m][n];
}
```
**Time:** O(m·n) | **Space:** O(m·n)

---

### Q130. Edit Distance
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Find minimum edit operations (insert, delete, replace) to convert word1 to word2.

**Example:**
```
Input: word1 = "horse", word2 = "ros"
Output: 3
```

**Solution:**
```java
public int minDistance(String word1, String word2) {
    int m = word1.length(), n = word2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) dp[i][0] = i;
    for (int j = 0; j <= n; j++) dp[0][j] = j;
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
            else dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
        }
    }
    return dp[m][n];
}
```
**Time:** O(m·n) | **Space:** O(m·n)

---

### Q131. Partition Equal Subset Sum
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Can you partition array into two subsets with equal sum?

**Example:**
```
Input: nums = [1,5,11,5]
Output: true  ([1,5,5] and [11])
```

**Solution:**
```java
public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int n : nums) sum += n;
    if (sum % 2 != 0) return false;
    int target = sum / 2;
    boolean[] dp = new boolean[target + 1];
    dp[0] = true;
    for (int num : nums) for (int j = target; j >= num; j--) dp[j] |= dp[j - num];
    return dp[target];
}
```
**Time:** O(n·sum) | **Space:** O(sum)

---

### Q132. Target Sum
**Difficulty:** Medium | **Companies:** Amazon, Meta

**Problem:** Assign + or - to each number to reach target. Count ways.

**Example:**
```
Input: nums = [1,1,1,1,1], target = 3
Output: 5
```

**Solution:**
```java
public int findTargetSumWays(int[] nums, int target) {
    Map<Integer, Integer> dp = new HashMap<>();
    dp.put(0, 1);
    for (int num : nums) {
        Map<Integer, Integer> next = new HashMap<>();
        for (Map.Entry<Integer, Integer> e : dp.entrySet()) {
            next.merge(e.getKey() + num, e.getValue(), Integer::sum);
            next.merge(e.getKey() - num, e.getValue(), Integer::sum);
        }
        dp = next;
    }
    return dp.getOrDefault(target, 0);
}
```
**Time:** O(n·sum) | **Space:** O(sum)

---

### Q133. Unique Paths
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Count paths from top-left to bottom-right in m×n grid (only right or down).

**Example:**
```
Input: m = 3, n = 7
Output: 28
```

**Solution:**
```java
public int uniquePaths(int m, int n) {
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    for (int i = 1; i < m; i++) for (int j = 1; j < n; j++) dp[j] += dp[j - 1];
    return dp[n - 1];
}
```
**Time:** O(m·n) | **Space:** O(n)

---

### Q134. Minimum Path Sum
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Find path from top-left to bottom-right with minimum sum.

**Example:**
```
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
```

**Solution:**
```java
public int minPathSum(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (i == 0 && j == 0) continue;
            else if (i == 0) grid[i][j] += grid[i][j-1];
            else if (j == 0) grid[i][j] += grid[i-1][j];
            else grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
        }
    }
    return grid[m-1][n-1];
}
```
**Time:** O(m·n) | **Space:** O(1)

---

### Q135. Decode Ways
**Difficulty:** Medium | **Companies:** Amazon, Meta

**Problem:** Count number of ways to decode digit string (A=1, B=2, ..., Z=26).

**Example:**
```
Input: s = "226"
Output: 3  ("BBF","BZ","VF")
```

**Solution:**
```java
public int numDecodings(String s) {
    int n = s.length();
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = s.charAt(0) == '0' ? 0 : 1;
    for (int i = 2; i <= n; i++) {
        int oneDigit = Integer.parseInt(s.substring(i-1, i));
        int twoDigit = Integer.parseInt(s.substring(i-2, i));
        if (oneDigit >= 1) dp[i] += dp[i-1];
        if (twoDigit >= 10 && twoDigit <= 26) dp[i] += dp[i-2];
    }
    return dp[n];
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q136. Maximum Profit in Job Scheduling
**Difficulty:** Hard (common MAANG) | **Companies:** Amazon, Google

**Problem:** Select non-overlapping jobs to maximize profit.

**Example:**
```
Input: startTime=[1,2,3,3], endTime=[3,4,5,6], profit=[50,10,40,70]
Output: 120
```

**Solution:**
```java
public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    int n = startTime.length;
    int[][] jobs = new int[n][3];
    for (int i = 0; i < n; i++) jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
    Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
    int[] ends = new int[n];
    for (int i = 0; i < n; i++) ends[i] = jobs[i][1];
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        int start = jobs[i-1][0];
        int idx = upperBound(ends, start, i - 1);
        dp[i] = Math.max(dp[i-1], dp[idx] + jobs[i-1][2]);
    }
    return dp[n];
}
private int upperBound(int[] ends, int start, int limit) {
    int l = 0, r = limit;
    while (l < r) { int mid = l + (r - l) / 2; if (ends[mid] <= start) l = mid + 1; else r = mid; }
    return l;
}
```
**Time:** O(n log n) | **Space:** O(n)

---

### Q137. Triangle
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find minimum path sum from top to bottom of triangle.

**Example:**
```
Input: [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11  (2+3+5+1)
```

**Solution:**
```java
public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[] dp = new int[n];
    for (int i = 0; i < n; i++) dp[i] = triangle.get(n-1).get(i);
    for (int row = n - 2; row >= 0; row--) {
        for (int col = 0; col <= row; col++) {
            dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
        }
    }
    return dp[0];
}
```
**Time:** O(n²) | **Space:** O(n)

---

### Q138. Maximal Square
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Find the largest square containing only 1s in a binary matrix.

**Example:**
```
Input: [["1","0","1","0"],["1","0","1","1"],["1","1","1","1"],["1","0","0","1"]]
Output: 4
```

**Solution:**
```java
public int maximalSquare(char[][] matrix) {
    int m = matrix.length, n = matrix[0].length, maxSide = 0;
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (matrix[i-1][j-1] == '1') {
                dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
    }
    return maxSide * maxSide;
}
```
**Time:** O(m·n) | **Space:** O(m·n)

---

### Q139. Palindromic Substrings (Count with DP)
**Difficulty:** Medium | **Companies:** Amazon, Google

**Solution (using DP table):**
```java
public int countSubstrings(String s) {
    int n = s.length(), count = 0;
    boolean[][] dp = new boolean[n][n];
    for (int len = 1; len <= n; len++) {
        for (int i = 0; i + len - 1 < n; i++) {
            int j = i + len - 1;
            if (s.charAt(i) == s.charAt(j) && (len <= 2 || dp[i+1][j-1])) {
                dp[i][j] = true; count++;
            }
        }
    }
    return count;
}
```
**Time:** O(n²) | **Space:** O(n²)

---

### Q140. Longest Palindromic Subsequence
**Difficulty:** Medium | **Companies:** Amazon, Google

**Example:**
```
Input: s = "bbbab"
Output: 4  ("bbbb")
```

**Solution:**
```java
public int longestPalindromeSubseq(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++) dp[i][i] = 1;
    for (int len = 2; len <= n; len++) {
        for (int i = 0; i + len - 1 < n; i++) {
            int j = i + len - 1;
            if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1] + 2;
            else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
        }
    }
    return dp[0][n-1];
}
```
**Time:** O(n²) | **Space:** O(n²)

---

### Q141. Burst Balloons
**Difficulty:** Hard | **Companies:** Amazon, Google

**Problem:** Burst balloons to maximize coins. Coins = left * balloon * right.

**Example:**
```
Input: nums = [3,1,5,8]
Output: 167
```

**Solution:**
```java
public int maxCoins(int[] nums) {
    int n = nums.length;
    int[] balls = new int[n + 2];
    balls[0] = balls[n + 1] = 1;
    for (int i = 0; i < n; i++) balls[i + 1] = nums[i];
    int[][] dp = new int[n + 2][n + 2];
    for (int len = 1; len <= n; len++) {
        for (int l = 1; l + len - 1 <= n; l++) {
            int r = l + len - 1;
            for (int k = l; k <= r; k++) {
                dp[l][r] = Math.max(dp[l][r], balls[l-1]*balls[k]*balls[r+1] + dp[l][k-1] + dp[k+1][r]);
            }
        }
    }
    return dp[1][n];
}
```
**Time:** O(n³) | **Space:** O(n²)

---

### Q142. Russian Doll Envelopes
**Difficulty:** Hard | **Companies:** Amazon, Google

**Problem:** Find max number of envelopes you can "Russian doll" (strictly increasing in both w and h).

**Example:**
```
Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3  ([2,3]->[5,4]->[6,7])
```

**Solution:**
```java
public int maxEnvelopes(int[][] envelopes) {
    Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
    List<Integer> dp = new ArrayList<>();
    for (int[] e : envelopes) {
        int h = e[1], l = 0, r = dp.size();
        while (l < r) { int mid = l + (r - l) / 2; if (dp.get(mid) < h) l = mid + 1; else r = mid; }
        if (l == dp.size()) dp.add(h); else dp.set(l, h);
    }
    return dp.size();
}
```
**Time:** O(n log n) | **Space:** O(n)

---

### Q143. Unique Paths II (with obstacles)
**Difficulty:** Medium | **Companies:** Amazon, Google

**Solution:**
```java
public int uniquePathsWithObstacles(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[] dp = new int[n];
    dp[0] = grid[0][0] == 0 ? 1 : 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1) dp[j] = 0;
            else if (j > 0) dp[j] += dp[j - 1];
        }
    }
    return dp[n - 1];
}
```
**Time:** O(m·n) | **Space:** O(n)

---

### Q144. Arithmetic Slices
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Count number of arithmetic slices (subarrays of length ≥ 3).

**Example:**
```
Input: nums = [1,2,3,4]
Output: 3  ([1,2,3],[2,3,4],[1,2,3,4])
```

**Solution:**
```java
public int numberOfArithmeticSlices(int[] nums) {
    int count = 0, curr = 0;
    for (int i = 2; i < nums.length; i++) {
        if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) count += ++curr;
        else curr = 0;
    }
    return count;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q145. Minimum Falling Path Sum
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find minimum falling path sum (from top to bottom, move to adjacent column).

**Example:**
```
Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
```

**Solution:**
```java
public int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int best = matrix[i-1][j];
            if (j > 0) best = Math.min(best, matrix[i-1][j-1]);
            if (j < n-1) best = Math.min(best, matrix[i-1][j+1]);
            matrix[i][j] += best;
        }
    }
    int min = Integer.MAX_VALUE;
    for (int v : matrix[n-1]) min = Math.min(min, v);
    return min;
}
```
**Time:** O(n²) | **Space:** O(1)

---

### Q146. Interleaving String
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Check if s3 is formed by interleaving s1 and s2.

**Example:**
```
Input: s1="aabcc", s2="dbbca", s3="aadbbcbcac"
Output: true
```

**Solution:**
```java
public boolean isInterleave(String s1, String s2, String s3) {
    int m = s1.length(), n = s2.length();
    if (m + n != s3.length()) return false;
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    for (int i = 1; i <= m; i++) dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
    for (int j = 1; j <= n; j++) dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
    for (int i = 1; i <= m; i++) for (int j = 1; j <= n; j++) {
        dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) ||
                   (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
    }
    return dp[m][n];
}
```
**Time:** O(m·n) | **Space:** O(m·n)

---

### Q147. Distinct Subsequences
**Difficulty:** Hard | **Companies:** Amazon, Google

**Problem:** Count distinct subsequences of s that equal t.

**Example:**
```
Input: s = "rabbbit", t = "rabbit"
Output: 3
```

**Solution:**
```java
public int numDistinct(String s, String t) {
    int m = s.length(), n = t.length();
    long[][] dp = new long[m + 1][n + 1];
    for (int i = 0; i <= m; i++) dp[i][0] = 1;
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            dp[i][j] = dp[i-1][j];
            if (s.charAt(i-1) == t.charAt(j-1)) dp[i][j] += dp[i-1][j-1];
        }
    }
    return (int) dp[m][n];
}
```
**Time:** O(m·n) | **Space:** O(m·n)

---

### Q148. Best Time to Buy and Sell Stock with Cooldown
**Difficulty:** Medium | **Companies:** Amazon, Google

**Solution:**
```java
public int maxProfit(int[] prices) {
    int hold = Integer.MIN_VALUE, sold = 0, rest = 0;
    for (int p : prices) {
        int prevSold = sold;
        sold = hold + p;
        hold = Math.max(hold, rest - p);
        rest = Math.max(rest, prevSold);
    }
    return Math.max(sold, rest);
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q149. Best Time to Buy Sell Stock with Transaction Fee
**Difficulty:** Medium | **Companies:** Amazon, Google

**Solution:**
```java
public int maxProfit(int[] prices, int fee) {
    int cash = 0, hold = -prices[0];
    for (int p : prices) {
        cash = Math.max(cash, hold + p - fee);
        hold = Math.max(hold, cash - p);
    }
    return cash;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q150. Buy and Sell Stock III (at most 2 transactions)
**Difficulty:** Hard | **Companies:** Amazon, Google

**Solution:**
```java
public int maxProfit(int[] prices) {
    int buy1 = Integer.MIN_VALUE, sell1 = 0, buy2 = Integer.MIN_VALUE, sell2 = 0;
    for (int p : prices) {
        buy1 = Math.max(buy1, -p);
        sell1 = Math.max(sell1, buy1 + p);
        buy2 = Math.max(buy2, sell1 - p);
        sell2 = Math.max(sell2, buy2 + p);
    }
    return sell2;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q151. Word Break II
**Difficulty:** Hard | **Companies:** Amazon, Google, Meta

**Problem:** Return all possible sentences from word break.

**Example:**
```
Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
```

**Solution:**
```java
public List<String> wordBreak(String s, List<String> wordDict) {
    Set<String> dict = new HashSet<>(wordDict);
    Map<Integer, List<String>> memo = new HashMap<>();
    return dfs(s, 0, dict, memo);
}
private List<String> dfs(String s, int start, Set<String> dict, Map<Integer, List<String>> memo) {
    if (memo.containsKey(start)) return memo.get(start);
    List<String> result = new ArrayList<>();
    if (start == s.length()) { result.add(""); return result; }
    for (int end = start + 1; end <= s.length(); end++) {
        String word = s.substring(start, end);
        if (dict.contains(word)) {
            for (String rest : dfs(s, end, dict, memo)) {
                result.add(word + (rest.isEmpty() ? "" : " " + rest));
            }
        }
    }
    memo.put(start, result);
    return result;
}
```
**Time:** O(n² · 2^n) worst | **Space:** O(n · 2^n)

---

### Q152. Perfect Squares
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find minimum number of perfect square numbers that sum to n.

**Example:**
```
Input: n = 12
Output: 3  (4+4+4)
```

**Solution:**
```java
public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, n + 1);
    dp[0] = 0;
    for (int i = 1; i <= n; i++) for (int j = 1; j * j <= i; j++) dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
    return dp[n];
}
```
**Time:** O(n·√n) | **Space:** O(n)

---

### Q153. Counting Bits
**Difficulty:** Easy | **Companies:** Amazon, Google

**Problem:** For every number in [0,n], count bits set to 1.

**Solution:**
```java
public int[] countBits(int n) {
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) dp[i] = dp[i >> 1] + (i & 1);
    return dp;
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q154. Combination Sum IV
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find number of ordered combinations summing to target.

**Example:**
```
Input: nums = [1,2,3], target = 4
Output: 7
```

**Solution:**
```java
public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int i = 1; i <= target; i++) for (int num : nums) if (i >= num) dp[i] += dp[i - num];
    return dp[target];
}
```
**Time:** O(target·n) | **Space:** O(target)

---

### Q155. Maximum Length of Repeated Subarray
**Difficulty:** Medium | **Companies:** Amazon, Google

**Example:**
```
Input: nums1=[1,2,3,2,1], nums2=[3,2,1,4,7]
Output: 3  ([3,2,1])
```

**Solution:**
```java
public int findLength(int[] nums1, int[] nums2) {
    int m = nums1.length, n = nums2.length, max = 0;
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (nums1[i-1] == nums2[j-1]) { dp[i][j] = dp[i-1][j-1] + 1; max = Math.max(max, dp[i][j]); }
        }
    }
    return max;
}
```
**Time:** O(m·n) | **Space:** O(m·n)

---

## SECTION 8: GRAPHS (Q156–Q175)

---

### Q156. Number of Islands
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta, Apple

**Example:**
```
Input: grid of '1's and '0's
Output: number of connected '1' groups
```

**Solution:**
```java
public int numIslands(char[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == '1') { dfs(grid, i, j); count++; }
        }
    }
    return count;
}
private void dfs(char[][] grid, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') return;
    grid[i][j] = '0';
    dfs(grid, i+1, j); dfs(grid, i-1, j); dfs(grid, i, j+1); dfs(grid, i, j-1);
}
```
**Time:** O(m·n) | **Space:** O(m·n)

---

### Q157. Max Area of Island
**Difficulty:** Medium | **Companies:** Amazon, Google

**Solution:**
```java
public int maxAreaOfIsland(int[][] grid) {
    int maxArea = 0;
    for (int i = 0; i < grid.length; i++)
        for (int j = 0; j < grid[0].length; j++)
            if (grid[i][j] == 1) maxArea = Math.max(maxArea, dfs(grid, i, j));
    return maxArea;
}
private int dfs(int[][] grid, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;
    grid[i][j] = 0;
    return 1 + dfs(grid,i+1,j) + dfs(grid,i-1,j) + dfs(grid,i,j+1) + dfs(grid,i,j-1);
}
```
**Time:** O(m·n) | **Space:** O(m·n)

---

### Q158. Course Schedule
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Can you finish all courses given prerequisites? Detect cycle in directed graph.

**Example:**
```
Input: numCourses=2, prerequisites=[[1,0]]
Output: true
```

**Solution (Topological Sort / BFS):**
```java
public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] inDegree = new int[numCourses];
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
    for (int[] p : prerequisites) { graph.get(p[1]).add(p[0]); inDegree[p[0]]++; }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) if (inDegree[i] == 0) queue.offer(i);
    int processed = 0;
    while (!queue.isEmpty()) {
        int course = queue.poll(); processed++;
        for (int next : graph.get(course)) if (--inDegree[next] == 0) queue.offer(next);
    }
    return processed == numCourses;
}
```
**Time:** O(V+E) | **Space:** O(V+E)

---

### Q159. Course Schedule II
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Return topological order of courses, or empty if impossible.

**Solution:**
```java
public int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] inDegree = new int[numCourses];
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
    for (int[] p : prerequisites) { graph.get(p[1]).add(p[0]); inDegree[p[0]]++; }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) if (inDegree[i] == 0) queue.offer(i);
    int[] order = new int[numCourses]; int idx = 0;
    while (!queue.isEmpty()) {
        int c = queue.poll(); order[idx++] = c;
        for (int next : graph.get(c)) if (--inDegree[next] == 0) queue.offer(next);
    }
    return idx == numCourses ? order : new int[]{};
}
```
**Time:** O(V+E) | **Space:** O(V+E)

---

### Q160. Pacific Atlantic Water Flow
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find cells that can flow to both Pacific and Atlantic oceans.

**Solution:**
```java
public List<List<Integer>> pacificAtlantic(int[][] heights) {
    int m = heights.length, n = heights[0].length;
    boolean[][] pac = new boolean[m][n], atl = new boolean[m][n];
    Queue<int[]> pq = new LinkedList<>(), aq = new LinkedList<>();
    for (int i = 0; i < m; i++) { pq.offer(new int[]{i,0}); pac[i][0]=true; aq.offer(new int[]{i,n-1}); atl[i][n-1]=true; }
    for (int j = 0; j < n; j++) { pq.offer(new int[]{0,j}); pac[0][j]=true; aq.offer(new int[]{m-1,j}); atl[m-1][j]=true; }
    bfs(heights, pq, pac); bfs(heights, aq, atl);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) if (pac[i][j] && atl[i][j]) result.add(Arrays.asList(i,j));
    return result;
}
private void bfs(int[][] h, Queue<int[]> q, boolean[][] visited) {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    while (!q.isEmpty()) {
        int[] cell = q.poll();
        for (int[] d : dirs) {
            int r = cell[0]+d[0], c = cell[1]+d[1];
            if (r>=0&&r<h.length&&c>=0&&c<h[0].length&&!visited[r][c]&&h[r][c]>=h[cell[0]][cell[1]]) {
                visited[r][c]=true; q.offer(new int[]{r,c});
            }
        }
    }
}
```
**Time:** O(m·n) | **Space:** O(m·n)

---

### Q161. Rotting Oranges
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Find minimum minutes for all fresh oranges to rot (BFS multi-source).

**Example:**
```
Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
```

**Solution:**
```java
public int orangesRotting(int[][] grid) {
    int m = grid.length, n = grid[0].length, fresh = 0, minutes = 0;
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
        if (grid[i][j] == 2) queue.offer(new int[]{i,j});
        else if (grid[i][j] == 1) fresh++;
    }
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    while (!queue.isEmpty() && fresh > 0) {
        int size = queue.size(); minutes++;
        for (int k = 0; k < size; k++) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0]+d[0], c = cell[1]+d[1];
                if (r>=0&&r<m&&c>=0&&c<n&&grid[r][c]==1) { grid[r][c]=2; fresh--; queue.offer(new int[]{r,c}); }
            }
        }
    }
    return fresh == 0 ? minutes : -1;
}
```
**Time:** O(m·n) | **Space:** O(m·n)

---

### Q162. Word Ladder
**Difficulty:** Hard | **Companies:** Amazon, Google, Meta

**Problem:** Find shortest transformation sequence length from beginWord to endWord.

**Example:**
```
Input: beginWord="hit", endWord="cog", wordList=["hot","dot","dog","lot","log","cog"]
Output: 5
```

**Solution:**
```java
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord)) return 0;
    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    int steps = 1;
    while (!queue.isEmpty()) {
        int size = queue.size(); steps++;
        for (int k = 0; k < size; k++) {
            char[] word = queue.poll().toCharArray();
            for (int i = 0; i < word.length; i++) {
                char original = word[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    word[i] = c;
                    String newWord = new String(word);
                    if (newWord.equals(endWord)) return steps;
                    if (wordSet.contains(newWord)) { wordSet.remove(newWord); queue.offer(newWord); }
                }
                word[i] = original;
            }
        }
    }
    return 0;
}
```
**Time:** O(M²·N) | **Space:** O(M²·N)

---

### Q163. Clone Graph
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Solution:**
```java
public Node cloneGraph(Node node) {
    if (node == null) return null;
    Map<Node, Node> visited = new HashMap<>();
    return dfs(node, visited);
}
private Node dfs(Node node, Map<Node, Node> visited) {
    if (visited.containsKey(node)) return visited.get(node);
    Node clone = new Node(node.val);
    visited.put(node, clone);
    for (Node neighbor : node.neighbors) clone.neighbors.add(dfs(neighbor, visited));
    return clone;
}
```
**Time:** O(V+E) | **Space:** O(V)

---

### Q164. Surrounded Regions
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Capture all 'O' regions not connected to border.

**Solution:**
```java
public void solve(char[][] board) {
    int m = board.length, n = board[0].length;
    for (int i = 0; i < m; i++) { dfs(board,i,0); dfs(board,i,n-1); }
    for (int j = 0; j < n; j++) { dfs(board,0,j); dfs(board,m-1,j); }
    for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
        if (board[i][j] == 'S') board[i][j] = 'O';
        else if (board[i][j] == 'O') board[i][j] = 'X';
    }
}
private void dfs(char[][] b, int i, int j) {
    if (i<0||i>=b.length||j<0||j>=b[0].length||b[i][j]!='O') return;
    b[i][j]='S'; dfs(b,i+1,j); dfs(b,i-1,j); dfs(b,i,j+1); dfs(b,i,j-1);
}
```
**Time:** O(m·n) | **Space:** O(m·n)

---

### Q165. Number of Connected Components (Union-Find)
**Difficulty:** Medium | **Companies:** Amazon, Google

**Solution:**
```java
public int countComponents(int n, int[][] edges) {
    int[] parent = new int[n];
    for (int i = 0; i < n; i++) parent[i] = i;
    int components = n;
    for (int[] e : edges) {
        int p1 = find(parent, e[0]), p2 = find(parent, e[1]);
        if (p1 != p2) { parent[p1] = p2; components--; }
    }
    return components;
}
private int find(int[] parent, int x) {
    if (parent[x] != x) parent[x] = find(parent, parent[x]);
    return parent[x];
}
```
**Time:** O(n·α(n)) | **Space:** O(n)

---

### Q166. Redundant Connection
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find the edge that makes the graph contain a cycle.

**Solution:**
```java
public int[] findRedundantConnection(int[][] edges) {
    int n = edges.length;
    int[] parent = new int[n + 1];
    for (int i = 0; i <= n; i++) parent[i] = i;
    for (int[] edge : edges) {
        int p1 = find(parent, edge[0]), p2 = find(parent, edge[1]);
        if (p1 == p2) return edge;
        parent[p1] = p2;
    }
    return new int[]{};
}
private int find(int[] parent, int x) {
    if (parent[x] != x) parent[x] = find(parent, parent[x]);
    return parent[x];
}
```
**Time:** O(n·α(n)) | **Space:** O(n)

---

### Q167. Number of Provinces
**Difficulty:** Medium | **Companies:** Amazon, Google

**Solution:**
```java
public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length, provinces = 0;
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
        if (!visited[i]) { dfs(isConnected, visited, i); provinces++; }
    }
    return provinces;
}
private void dfs(int[][] grid, boolean[] visited, int i) {
    visited[i] = true;
    for (int j = 0; j < grid.length; j++) if (grid[i][j] == 1 && !visited[j]) dfs(grid, visited, j);
}
```
**Time:** O(n²) | **Space:** O(n)

---

### Q168. 01 Matrix
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Find distance of nearest 0 for each cell.

**Solution:**
```java
public int[][] updateMatrix(int[][] mat) {
    int m = mat.length, n = mat[0].length;
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
        if (mat[i][j] == 0) queue.offer(new int[]{i,j});
        else mat[i][j] = Integer.MAX_VALUE;
    }
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    while (!queue.isEmpty()) {
        int[] cell = queue.poll();
        for (int[] d : dirs) {
            int r = cell[0]+d[0], c = cell[1]+d[1];
            if (r>=0&&r<m&&c>=0&&c<n&&mat[r][c]>mat[cell[0]][cell[1]]+1) {
                mat[r][c]=mat[cell[0]][cell[1]]+1; queue.offer(new int[]{r,c});
            }
        }
    }
    return mat;
}
```
**Time:** O(m·n) | **Space:** O(m·n)

---

### Q169. Shortest Path in Binary Matrix
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find shortest clear path from top-left to bottom-right in binary matrix.

**Solution:**
```java
public int shortestPathBinaryMatrix(int[][] grid) {
    int n = grid.length;
    if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{0,0,1});
    grid[0][0] = 1;
    int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    while (!queue.isEmpty()) {
        int[] curr = queue.poll();
        if (curr[0] == n-1 && curr[1] == n-1) return curr[2];
        for (int[] d : dirs) {
            int r = curr[0]+d[0], c = curr[1]+d[1];
            if (r>=0&&r<n&&c>=0&&c<n&&grid[r][c]==0) { grid[r][c]=1; queue.offer(new int[]{r,c,curr[2]+1}); }
        }
    }
    return -1;
}
```
**Time:** O(n²) | **Space:** O(n²)

---

### Q170. Graph Valid Tree
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Given n nodes and edges, determine if they form a valid tree (connected, no cycles).

**Solution:**
```java
public boolean validTree(int n, int[][] edges) {
    if (edges.length != n - 1) return false;
    int[] parent = new int[n];
    for (int i = 0; i < n; i++) parent[i] = i;
    for (int[] e : edges) {
        int p1 = find(parent, e[0]), p2 = find(parent, e[1]);
        if (p1 == p2) return false;
        parent[p1] = p2;
    }
    return true;
}
private int find(int[] p, int x) { return p[x] == x ? x : (p[x] = find(p, p[x])); }
```
**Time:** O(n·α(n)) | **Space:** O(n)

---

### Q171. Alien Dictionary
**Difficulty:** Hard | **Companies:** Amazon, Google, Meta

**Problem:** Derive character order from sorted alien language word list.

**Solution:**
```java
public String alienOrder(String[] words) {
    Map<Character, Set<Character>> graph = new HashMap<>();
    Map<Character, Integer> inDegree = new HashMap<>();
    for (String w : words) for (char c : w.toCharArray()) { inDegree.putIfAbsent(c, 0); graph.putIfAbsent(c, new HashSet<>()); }
    for (int i = 0; i < words.length - 1; i++) {
        String w1 = words[i], w2 = words[i+1];
        if (w1.length() > w2.length() && w1.startsWith(w2)) return "";
        for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
            if (w1.charAt(j) != w2.charAt(j)) {
                if (!graph.get(w1.charAt(j)).contains(w2.charAt(j))) {
                    graph.get(w1.charAt(j)).add(w2.charAt(j)); inDegree.merge(w2.charAt(j), 1, Integer::sum);
                }
                break;
            }
        }
    }
    Queue<Character> queue = new LinkedList<>();
    for (char c : inDegree.keySet()) if (inDegree.get(c) == 0) queue.offer(c);
    StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()) {
        char c = queue.poll(); sb.append(c);
        for (char next : graph.get(c)) if (inDegree.merge(next, -1, Integer::sum) == 0) queue.offer(next);
    }
    return sb.length() == inDegree.size() ? sb.toString() : "";
}
```
**Time:** O(C) where C = total chars | **Space:** O(1) since at most 26 chars

---

### Q172. Network Delay Time
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find minimum time for all nodes to receive signal (Dijkstra).

**Example:**
```
Input: times=[[2,1,1],[2,3,1],[3,4,1]], n=4, k=2
Output: 2
```

**Solution:**
```java
public int networkDelayTime(int[][] times, int n, int k) {
    Map<Integer, List<int[]>> graph = new HashMap<>();
    for (int[] t : times) graph.computeIfAbsent(t[0], x -> new ArrayList<>()).add(new int[]{t[1],t[2]});
    int[] dist = new int[n + 1]; Arrays.fill(dist, Integer.MAX_VALUE); dist[k] = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
    pq.offer(new int[]{0, k});
    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        if (curr[0] > dist[curr[1]]) continue;
        for (int[] next : graph.getOrDefault(curr[1], new ArrayList<>())) {
            int newDist = dist[curr[1]] + next[1];
            if (newDist < dist[next[0]]) { dist[next[0]] = newDist; pq.offer(new int[]{newDist, next[0]}); }
        }
    }
    int maxDist = 0;
    for (int i = 1; i <= n; i++) { if (dist[i] == Integer.MAX_VALUE) return -1; maxDist = Math.max(maxDist, dist[i]); }
    return maxDist;
}
```
**Time:** O((V+E) log V) | **Space:** O(V+E)

---

### Q173. Evaluate Division
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Evaluate queries given equations and values (e.g. a/b = 2.0).

**Solution:**
```java
public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Map<String, Map<String, Double>> graph = new HashMap<>();
    for (int i = 0; i < equations.size(); i++) {
        String a = equations.get(i).get(0), b = equations.get(i).get(1);
        graph.computeIfAbsent(a, x -> new HashMap<>()).put(b, values[i]);
        graph.computeIfAbsent(b, x -> new HashMap<>()).put(a, 1.0/values[i]);
    }
    double[] result = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
        String src = queries.get(i).get(0), dst = queries.get(i).get(1);
        if (!graph.containsKey(src) || !graph.containsKey(dst)) result[i] = -1.0;
        else result[i] = bfs(graph, src, dst);
    }
    return result;
}
private double bfs(Map<String, Map<String, Double>> graph, String src, String dst) {
    if (src.equals(dst)) return 1.0;
    Set<String> visited = new HashSet<>();
    Queue<Object[]> queue = new LinkedList<>();
    queue.offer(new Object[]{src, 1.0}); visited.add(src);
    while (!queue.isEmpty()) {
        Object[] curr = queue.poll(); String node = (String)curr[0]; double val = (double)curr[1];
        for (Map.Entry<String, Double> e : graph.get(node).entrySet()) {
            if (e.getKey().equals(dst)) return val * e.getValue();
            if (!visited.contains(e.getKey())) { visited.add(e.getKey()); queue.offer(new Object[]{e.getKey(), val*e.getValue()}); }
        }
    }
    return -1.0;
}
```
**Time:** O((V+E)·Q) | **Space:** O(V+E)

---

### Q174. Walls and Gates
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Fill each empty room with distance to nearest gate. BFS multi-source.

**Solution:**
```java
public void wallsAndGates(int[][] rooms) {
    int m = rooms.length, n = rooms[0].length;
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) if (rooms[i][j] == 0) queue.offer(new int[]{i,j});
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    while (!queue.isEmpty()) {
        int[] cell = queue.poll();
        for (int[] d : dirs) {
            int r = cell[0]+d[0], c = cell[1]+d[1];
            if (r>=0&&r<m&&c>=0&&c<n&&rooms[r][c]==Integer.MAX_VALUE) {
                rooms[r][c] = rooms[cell[0]][cell[1]] + 1; queue.offer(new int[]{r,c});
            }
        }
    }
}
```
**Time:** O(m·n) | **Space:** O(m·n)

---

### Q175. Cheapest Flights Within K Stops (Bellman-Ford)
**Difficulty:** Medium | **Companies:** Amazon, Google

**Solution:**
```java
public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    int[] dist = new int[n]; Arrays.fill(dist, Integer.MAX_VALUE); dist[src] = 0;
    for (int i = 0; i <= k; i++) {
        int[] temp = Arrays.copyOf(dist, n);
        for (int[] f : flights) {
            if (dist[f[0]] != Integer.MAX_VALUE && dist[f[0]] + f[2] < temp[f[1]]) temp[f[1]] = dist[f[0]] + f[2];
        }
        dist = temp;
    }
    return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
}
```
**Time:** O(k·E) | **Space:** O(n)

---

## SECTION 9: GREEDY (Q176–Q185)

---

### Q176. Best Time to Buy and Sell Stock II
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Multiple transactions allowed. Maximize profit.

**Solution:**
```java
public int maxProfit(int[] prices) {
    int profit = 0;
    for (int i = 1; i < prices.length; i++) profit += Math.max(0, prices[i] - prices[i-1]);
    return profit;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q177. Gas Station
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find starting gas station to complete the circuit.

**Example:**
```
Input: gas=[1,2,3,4,5], cost=[3,4,5,1,2]
Output: 3
```

**Solution:**
```java
public int canCompleteCircuit(int[] gas, int[] cost) {
    int totalGas = 0, currGas = 0, start = 0;
    for (int i = 0; i < gas.length; i++) {
        totalGas += gas[i] - cost[i];
        currGas += gas[i] - cost[i];
        if (currGas < 0) { start = i + 1; currGas = 0; }
    }
    return totalGas >= 0 ? start : -1;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q178. Assign Cookies
**Difficulty:** Easy | **Companies:** Amazon

**Problem:** Assign cookies to maximize satisfied children. Cookie s[j] satisfies child g[i] if s[j] >= g[i].

**Solution:**
```java
public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g); Arrays.sort(s);
    int child = 0, cookie = 0;
    while (child < g.length && cookie < s.length) {
        if (s[cookie] >= g[child]) child++;
        cookie++;
    }
    return child;
}
```
**Time:** O(n log n) | **Space:** O(1)

---

### Q179. Queue Reconstruction by Height
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Reconstruct queue where each person is described as [h, k] (height, people in front with h' >= h).

**Example:**
```
Input: [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
```

**Solution:**
```java
public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
    List<int[]> list = new ArrayList<>();
    for (int[] p : people) list.add(p[1], p);
    return list.toArray(new int[0][]);
}
```
**Time:** O(n²) | **Space:** O(n)

---

### Q180. Non-overlapping Intervals
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Find minimum number of intervals to remove to make the rest non-overlapping.

**Solution:**
```java
public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
    int count = 0, end = Integer.MIN_VALUE;
    for (int[] interval : intervals) {
        if (interval[0] >= end) end = interval[1];
        else count++;
    }
    return count;
}
```
**Time:** O(n log n) | **Space:** O(1)

---

### Q181. Partition Labels
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Partition string into as many parts as possible so each letter appears in at most one part.

**Example:**
```
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
```

**Solution:**
```java
public List<Integer> partitionLabels(String s) {
    int[] last = new int[26];
    for (int i = 0; i < s.length(); i++) last[s.charAt(i) - 'a'] = i;
    List<Integer> result = new ArrayList<>();
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        end = Math.max(end, last[s.charAt(i) - 'a']);
        if (i == end) { result.add(end - start + 1); start = end + 1; }
    }
    return result;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q182. Two City Scheduling
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Send n people to city A and n to city B (2n total) with minimum total cost.

**Example:**
```
Input: costs = [[10,20],[30,200],[400,50],[30,20]]
Output: 110
```

**Solution:**
```java
public int twoCitySchedCost(int[][] costs) {
    Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
    int total = 0, n = costs.length / 2;
    for (int i = 0; i < n; i++) total += costs[i][0];
    for (int i = n; i < costs.length; i++) total += costs[i][1];
    return total;
}
```
**Time:** O(n log n) | **Space:** O(1)

---

### Q183. Lemonade Change
**Difficulty:** Easy | **Companies:** Amazon

**Solution:**
```java
public boolean lemonadeChange(int[] bills) {
    int five = 0, ten = 0;
    for (int bill : bills) {
        if (bill == 5) five++;
        else if (bill == 10) { if (five == 0) return false; five--; ten++; }
        else { if (ten > 0 && five > 0) { ten--; five--; } else if (five >= 3) five -= 3; else return false; }
    }
    return true;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q184. Minimum Number of Arrows to Burst Balloons
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find minimum arrows to burst all balloons (represented as intervals on x-axis).

**Solution:**
```java
public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
    int arrows = 1, end = points[0][1];
    for (int[] p : points) {
        if (p[0] > end) { arrows++; end = p[1]; }
    }
    return arrows;
}
```
**Time:** O(n log n) | **Space:** O(1)

---

### Q185. Meeting Rooms II
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta, Apple

**Problem:** Find minimum number of conference rooms required.

**Solution:**
```java
public int minMeetingRooms(int[][] intervals) {
    int n = intervals.length;
    int[] start = new int[n], end = new int[n];
    for (int i = 0; i < n; i++) { start[i] = intervals[i][0]; end[i] = intervals[i][1]; }
    Arrays.sort(start); Arrays.sort(end);
    int rooms = 0, endPtr = 0;
    for (int i = 0; i < n; i++) {
        if (start[i] < end[endPtr]) rooms++;
        else endPtr++;
    }
    return rooms;
}
```
**Time:** O(n log n) | **Space:** O(n)

---

## SECTION 10: BACKTRACKING (Q186–Q197)

---

### Q186. Subsets
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Example:**
```
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
```

**Solution:**
```java
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, 0, new ArrayList<>(), result);
    return result;
}
private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
    result.add(new ArrayList<>(current));
    for (int i = start; i < nums.length; i++) {
        current.add(nums[i]);
        backtrack(nums, i + 1, current, result);
        current.remove(current.size() - 1);
    }
}
```
**Time:** O(n·2^n) | **Space:** O(n)

---

### Q187. Subsets II (with duplicates)
**Difficulty:** Medium | **Companies:** Amazon, Google

**Solution:**
```java
public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, 0, new ArrayList<>(), result);
    return result;
}
private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
    result.add(new ArrayList<>(current));
    for (int i = start; i < nums.length; i++) {
        if (i > start && nums[i] == nums[i-1]) continue;
        current.add(nums[i]);
        backtrack(nums, i + 1, current, result);
        current.remove(current.size() - 1);
    }
}
```
**Time:** O(n·2^n) | **Space:** O(n)

---

### Q188. Permutations
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Solution:**
```java
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
    return result;
}
private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
    if (current.size() == nums.length) { result.add(new ArrayList<>(current)); return; }
    for (int i = 0; i < nums.length; i++) {
        if (used[i]) continue;
        used[i] = true; current.add(nums[i]);
        backtrack(nums, used, current, result);
        used[i] = false; current.remove(current.size() - 1);
    }
}
```
**Time:** O(n·n!) | **Space:** O(n)

---

### Q189. Permutations II (with duplicates)
**Difficulty:** Medium | **Companies:** Amazon, Google

**Solution:**
```java
public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
    return result;
}
private void backtrack(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> result) {
    if (curr.size() == nums.length) { result.add(new ArrayList<>(curr)); return; }
    for (int i = 0; i < nums.length; i++) {
        if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) continue;
        used[i] = true; curr.add(nums[i]);
        backtrack(nums, used, curr, result);
        used[i] = false; curr.remove(curr.size() - 1);
    }
}
```
**Time:** O(n·n!) | **Space:** O(n)

---

### Q190. Combination Sum
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Find all combinations that sum to target (can reuse elements).

**Solution:**
```java
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(candidates, target, 0, new ArrayList<>(), result);
    return result;
}
private void backtrack(int[] candidates, int remaining, int start, List<Integer> current, List<List<Integer>> result) {
    if (remaining == 0) { result.add(new ArrayList<>(current)); return; }
    for (int i = start; i < candidates.length; i++) {
        if (candidates[i] > remaining) break;
        current.add(candidates[i]);
        backtrack(candidates, remaining - candidates[i], i, current, result);
        current.remove(current.size() - 1);
    }
}
```
**Time:** O(n^(T/M)) | **Space:** O(T/M)

---

### Q191. Combination Sum II
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Combination sum where each element can only be used once.

**Solution:**
```java
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    backtrack(candidates, target, 0, new ArrayList<>(), result);
    return result;
}
private void backtrack(int[] candidates, int remaining, int start, List<Integer> current, List<List<Integer>> result) {
    if (remaining == 0) { result.add(new ArrayList<>(current)); return; }
    for (int i = start; i < candidates.length; i++) {
        if (i > start && candidates[i] == candidates[i-1]) continue;
        if (candidates[i] > remaining) break;
        current.add(candidates[i]);
        backtrack(candidates, remaining - candidates[i], i + 1, current, result);
        current.remove(current.size() - 1);
    }
}
```
**Time:** O(2^n) | **Space:** O(n)

---

### Q192. Word Search
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Given board and word, find if word exists in grid using adjacent cells.

**Solution:**
```java
public boolean exist(char[][] board, String word) {
    int m = board.length, n = board[0].length;
    for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) if (dfs(board, word, i, j, 0)) return true;
    return false;
}
private boolean dfs(char[][] board, String word, int i, int j, int k) {
    if (k == word.length()) return true;
    if (i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!=word.charAt(k)) return false;
    char tmp = board[i][j]; board[i][j] = '#';
    boolean found = dfs(board,word,i+1,j,k+1)||dfs(board,word,i-1,j,k+1)||dfs(board,word,i,j+1,k+1)||dfs(board,word,i,j-1,k+1);
    board[i][j] = tmp;
    return found;
}
```
**Time:** O(m·n·4^L) | **Space:** O(L)

---

### Q193. Letter Combinations of a Phone Number
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Solution:**
```java
public List<String> letterCombinations(String digits) {
    if (digits.isEmpty()) return new ArrayList<>();
    String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> result = new ArrayList<>();
    backtrack(digits, 0, new StringBuilder(), map, result);
    return result;
}
private void backtrack(String digits, int idx, StringBuilder sb, String[] map, List<String> result) {
    if (idx == digits.length()) { result.add(sb.toString()); return; }
    for (char c : map[digits.charAt(idx) - '0'].toCharArray()) {
        sb.append(c); backtrack(digits, idx+1, sb, map, result); sb.deleteCharAt(sb.length()-1);
    }
}
```
**Time:** O(4^n·n) | **Space:** O(n)

---

### Q194. N-Queens (Count solutions)
**Difficulty:** Hard | **Companies:** Amazon, Google

**Problem:** Place n queens on n×n board with no attacks. Return all solutions.

**Solution:**
```java
public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<>();
    int[] queens = new int[n];
    Arrays.fill(queens, -1);
    Set<Integer> cols = new HashSet<>(), diag1 = new HashSet<>(), diag2 = new HashSet<>();
    backtrack(0, n, queens, cols, diag1, diag2, result);
    return result;
}
private void backtrack(int row, int n, int[] queens, Set<Integer> cols, Set<Integer> d1, Set<Integer> d2, List<List<String>> result) {
    if (row == n) { result.add(buildBoard(queens, n)); return; }
    for (int col = 0; col < n; col++) {
        if (cols.contains(col) || d1.contains(row-col) || d2.contains(row+col)) continue;
        queens[row]=col; cols.add(col); d1.add(row-col); d2.add(row+col);
        backtrack(row+1, n, queens, cols, d1, d2, result);
        queens[row]=-1; cols.remove(col); d1.remove(row-col); d2.remove(row+col);
    }
}
private List<String> buildBoard(int[] queens, int n) {
    List<String> board = new ArrayList<>();
    for (int r = 0; r < n; r++) {
        char[] row = new char[n]; Arrays.fill(row, '.'); row[queens[r]] = 'Q'; board.add(new String(row));
    }
    return board;
}
```
**Time:** O(n!) | **Space:** O(n)

---

### Q195. Palindrome Partitioning
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Partition s such that every substring of the partition is a palindrome. Return all possible partitionings.

**Example:**
```
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
```

**Solution:**
```java
public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    backtrack(s, 0, new ArrayList<>(), result);
    return result;
}
private void backtrack(String s, int start, List<String> current, List<List<String>> result) {
    if (start == s.length()) { result.add(new ArrayList<>(current)); return; }
    for (int end = start + 1; end <= s.length(); end++) {
        String sub = s.substring(start, end);
        if (isPalin(sub)) {
            current.add(sub);
            backtrack(s, end, current, result);
            current.remove(current.size() - 1);
        }
    }
}
private boolean isPalin(String s) {
    int l = 0, r = s.length() - 1;
    while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
    return true;
}
```
**Time:** O(n·2^n) | **Space:** O(n)

---

## SECTION 11: MATH & BIT MANIPULATION (Q196–Q200)

---

### Q196. Single Number
**Difficulty:** Easy | **Companies:** Amazon, Google

**Problem:** Find the element appearing once; all others appear twice.

**Solution:**
```java
public int singleNumber(int[] nums) {
    int result = 0;
    for (int n : nums) result ^= n;
    return result;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q197. Reverse Bits
**Difficulty:** Easy | **Companies:** Amazon, Apple

**Solution:**
```java
public int reverseBits(int n) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
        result = (result << 1) | (n & 1);
        n >>= 1;
    }
    return result;
}
```
**Time:** O(1) | **Space:** O(1)

---

### Q198. Number of 1 Bits (Hamming Weight)
**Difficulty:** Easy | **Companies:** Amazon, Apple

**Solution:**
```java
public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) { n &= (n - 1); count++; }
    return count;
}
```
**Time:** O(k) where k=set bits | **Space:** O(1)

---

### Q199. Power of Two
**Difficulty:** Easy | **Companies:** Amazon, Google

**Solution:**
```java
public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
}
```
**Time:** O(1) | **Space:** O(1)

---

### Q200. Happy Number
**Difficulty:** Easy | **Companies:** Amazon, Google

**Problem:** Repeatedly replace n with sum of squares of digits. Return true if it reaches 1.

**Example:**
```
Input: n = 19
Output: true  (1²+9²=82 → 8²+2²=68 → ... → 1)
```

**Solution (Floyd's Cycle):**
```java
public boolean isHappy(int n) {
    int slow = n, fast = getNext(n);
    while (fast != 1 && slow != fast) { slow = getNext(slow); fast = getNext(getNext(fast)); }
    return fast == 1;
}
private int getNext(int n) {
    int sum = 0;
    while (n > 0) { int d = n % 10; sum += d * d; n /= 10; }
    return sum;
}
```
**Time:** O(log n) | **Space:** O(1)

---

## Summary Table

| # | Problem | Difficulty | Key Technique |
|---|---------|------------|---------------|
| 1 | Two Sum | Easy | HashMap |
| 2 | Best Time to Buy/Sell Stock | Easy | Greedy |
| 3 | Contains Duplicate | Easy | HashSet |
| 4 | Maximum Subarray | Easy | Kadane's |
| 5 | Move Zeroes | Easy | Two Pointer |
| 9 | Product of Array Except Self | Medium | Prefix/Suffix |
| 13 | 3Sum | Medium | Sort + Two Pointer |
| 15 | Trapping Rain Water | Hard | Two Pointer |
| 17 | Find Duplicate Number | Medium | Floyd's Cycle |
| 18 | Subarray Sum Equals K | Medium | Prefix Sum |
| 23 | Merge Intervals | Medium | Sort + Merge |
| 25 | Longest Consecutive Sequence | Medium | HashSet |
| 29 | Longest Substring No Repeat | Medium | Sliding Window |
| 31 | Minimum Window Substring | Hard | Sliding Window |
| 46 | Reverse Linked List | Easy | In-place |
| 48 | Linked List Cycle | Easy | Floyd's |
| 56 | LRU Cache | Medium | LinkedHashMap |
| 63 | Largest Rectangle Histogram | Hard | Monotonic Stack |
| 70 | Sliding Window Maximum | Hard | Monotonic Deque |
| 76 | Max Depth Binary Tree | Easy | DFS |
| 81 | LCA BST | Medium | BST Property |
| 82 | LCA Binary Tree | Medium | DFS |
| 83 | Validate BST | Medium | Min/Max DFS |
| 89 | Binary Tree Max Path Sum | Hard | DFS + global max |
| 96 | Serialize/Deserialize Tree | Hard | DFS |
| 106 | Binary Search | Easy | Binary Search |
| 110 | Kth Largest | Medium | QuickSelect |
| 116 | Median of Two Sorted Arrays | Hard | Binary Search |
| 121 | Climbing Stairs | Easy | DP (Fibonacci) |
| 126 | Coin Change | Medium | DP |
| 128 | LIS | Medium | DP + BinSearch |
| 129 | LCS | Medium | 2D DP |
| 130 | Edit Distance | Medium | 2D DP |
| 131 | Partition Equal Subset | Medium | 0/1 Knapsack |
| 156 | Number of Islands | Medium | DFS/BFS |
| 158 | Course Schedule | Medium | Topo Sort |
| 160 | Pacific Atlantic Flow | Medium | Multi-source BFS |
| 162 | Word Ladder | Hard | BFS |
| 165 | Connected Components | Medium | Union-Find |
| 186 | Subsets | Medium | Backtracking |
| 188 | Permutations | Medium | Backtracking |
| 190 | Combination Sum | Medium | Backtracking |
| 192 | Word Search | Medium | DFS |
| 196 | Single Number | Easy | XOR |
| 200 | Happy Number | Easy | Floyd's Cycle |
