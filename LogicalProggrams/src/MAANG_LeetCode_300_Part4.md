# MAANG LeetCode — Part 4 (Q261–Q300) | Medium–Hard

---

## SECTION 17: ADVANCED DYNAMIC PROGRAMMING (Q261–Q285)

---

### Q261. Dungeon Game
**Difficulty:** Hard | **Companies:** Amazon, Google

**Problem:** Knight starts at top-left, must reach bottom-right princess. Find minimum initial health.

**Example:**
```
Input: [[-2,-3,3],[-5,-10,1],[10,30,-5]]
Output: 7
```

**Solution:**
```java
public int calculateMinimumHP(int[][] dungeon) {
    int m = dungeon.length, n = dungeon[0].length;
    int[][] dp = new int[m][n];
    for (int i = m-1; i >= 0; i--) {
        for (int j = n-1; j >= 0; j--) {
            int need;
            if (i == m-1 && j == n-1) need = 1;
            else if (i == m-1) need = dp[i][j+1];
            else if (j == n-1) need = dp[i+1][j];
            else need = Math.min(dp[i+1][j], dp[i][j+1]);
            dp[i][j] = Math.max(need - dungeon[i][j], 1);
        }
    }
    return dp[0][0];
}
```
**Time:** O(m·n) | **Space:** O(m·n)

---

### Q262. Cherry Pickup II
**Difficulty:** Hard | **Companies:** Amazon, Google

**Problem:** Two robots start at top corners of a grid, collect maximum cherries moving down.

**Solution (3D DP):**
```java
public int cherryPickup(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][][] dp = new int[m][n][n];
    for (int[][] a : dp) for (int[] b : a) Arrays.fill(b, Integer.MIN_VALUE);
    dp[0][0][n-1] = grid[0][0] + grid[0][n-1];
    for (int r = 1; r < m; r++) {
        for (int c1 = 0; c1 < n; c1++) {
            for (int c2 = 0; c2 < n; c2++) {
                int best = Integer.MIN_VALUE;
                for (int dc1 = -1; dc1 <= 1; dc1++) {
                    for (int dc2 = -1; dc2 <= 1; dc2++) {
                        int pc1 = c1+dc1, pc2 = c2+dc2;
                        if (pc1>=0&&pc1<n&&pc2>=0&&pc2<n&&dp[r-1][pc1][pc2]!=Integer.MIN_VALUE)
                            best = Math.max(best, dp[r-1][pc1][pc2]);
                    }
                }
                if (best != Integer.MIN_VALUE) {
                    int cherries = grid[r][c1] + (c1!=c2 ? grid[r][c2] : 0);
                    dp[r][c1][c2] = best + cherries;
                }
            }
        }
    }
    int result = 0;
    for (int[] row : dp[m-1]) for (int v : row) result = Math.max(result, v);
    return result;
}
```
**Time:** O(m·n²) | **Space:** O(m·n²)

---

### Q263. Stone Game
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Two players alternate picking from ends of piles array. Alex always wins (math insight).

**Solution:**
```java
public boolean stoneGame(int[] piles) {
    return true; // Alex always wins with optimal play (even number of piles)
}
// DP version for generalization:
public boolean stoneGameDP(int[] piles) {
    int n = piles.length;
    int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++) dp[i][i] = piles[i];
    for (int len = 2; len <= n; len++) {
        for (int i = 0; i + len - 1 < n; i++) {
            int j = i + len - 1;
            dp[i][j] = Math.max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1]);
        }
    }
    return dp[0][n-1] > 0;
}
```
**Time:** O(n²) | **Space:** O(n²)

---

### Q264. Minimum Cost For Tickets
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Given travel days and pass costs [1-day, 7-day, 30-day], find minimum cost.

**Example:**
```
Input: days=[1,4,6,7,8,20], costs=[2,7,15]
Output: 11
```

**Solution:**
```java
public int mincostTickets(int[] days, int[] costs) {
    Set<Integer> travelDays = new HashSet<>();
    for (int d : days) travelDays.add(d);
    int[] dp = new int[366];
    for (int i = 1; i <= 365; i++) {
        if (!travelDays.contains(i)) { dp[i] = dp[i-1]; continue; }
        dp[i] = Math.min(dp[i-1] + costs[0],
                 Math.min(dp[Math.max(0,i-7)] + costs[1],
                          dp[Math.max(0,i-30)] + costs[2]));
    }
    return dp[365];
}
```
**Time:** O(365) = O(1) | **Space:** O(365) = O(1)

---

### Q265. Integer Break
**Difficulty:** Medium | **Companies:** Google, Amazon

**Problem:** Break n into ≥2 positive integers to maximize their product.

**Example:**
```
Input: n = 10
Output: 36  (3+3+4)
```

**Solution:**
```java
public int integerBreak(int n) {
    if (n <= 3) return n - 1;
    int[] dp = new int[n + 1];
    dp[1] = 1; dp[2] = 1; dp[3] = 2;
    for (int i = 4; i <= n; i++)
        for (int j = 1; j <= i/2; j++)
            dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i-j, dp[i-j]));
    return dp[n];
}
```
**Time:** O(n²) | **Space:** O(n)

---

### Q266. Out of Boundary Paths
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Count paths that move out of m×n grid in exactly maxMove moves from (startRow, startCol).

**Solution:**
```java
public int findPaths(int m, int n, int maxMove, int startRow, int startCol) {
    int MOD = 1_000_000_007;
    int[][] dp = new int[m][n];
    dp[startRow][startCol] = 1;
    int count = 0;
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    for (int move = 0; move < maxMove; move++) {
        int[][] next = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;
                for (int[] d : dirs) {
                    int r = i+d[0], c = j+d[1];
                    if (r<0||r>=m||c<0||c>=n) count = (count + dp[i][j]) % MOD;
                    else next[r][c] = (next[r][c] + dp[i][j]) % MOD;
                }
            }
        }
        dp = next;
    }
    return count;
}
```
**Time:** O(maxMove·m·n) | **Space:** O(m·n)

---

### Q267. Minimum Difficulty of a Job Schedule
**Difficulty:** Hard | **Companies:** Amazon

**Problem:** Schedule jobs over d days such that each day has ≥1 job (in order). Minimize max difficulty sum.

**Solution:**
```java
public int minDifficulty(int[] jobDifficulty, int d) {
    int n = jobDifficulty.length;
    if (n < d) return -1;
    int[][] dp = new int[d][n];
    for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
    dp[0][0] = jobDifficulty[0];
    for (int j = 1; j < n; j++) dp[0][j] = Math.max(dp[0][j-1], jobDifficulty[j]);
    for (int day = 1; day < d; day++) {
        for (int j = day; j < n; j++) {
            int maxDiff = 0;
            for (int k = j; k >= day; k--) {
                maxDiff = Math.max(maxDiff, jobDifficulty[k]);
                if (dp[day-1][k-1] != Integer.MAX_VALUE)
                    dp[day][j] = Math.min(dp[day][j], dp[day-1][k-1] + maxDiff);
            }
        }
    }
    return dp[d-1][n-1];
}
```
**Time:** O(d·n²) | **Space:** O(d·n)

---

### Q268. Frog Jump
**Difficulty:** Hard | **Companies:** Amazon, Google

**Problem:** Frog at 0, must reach last stone. From stone i can jump k-1, k, or k+1 (last jump was k). Can it cross?

**Solution:**
```java
public boolean canCross(int[] stones) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int s : stones) map.put(s, new HashSet<>());
    map.get(0).add(0);
    for (int s : stones) {
        for (int k : map.get(s)) {
            for (int step = k-1; step <= k+1; step++) {
                if (step > 0 && map.containsKey(s + step)) map.get(s + step).add(step);
            }
        }
    }
    return !map.get(stones[stones.length-1]).isEmpty();
}
```
**Time:** O(n²) | **Space:** O(n²)

---

### Q269. Best Time to Buy Sell Stock IV (at most k transactions)
**Difficulty:** Hard | **Companies:** Amazon, Google

**Solution:**
```java
public int maxProfit(int k, int[] prices) {
    int n = prices.length;
    if (k >= n/2) {
        int profit = 0;
        for (int i = 1; i < n; i++) profit += Math.max(0, prices[i]-prices[i-1]);
        return profit;
    }
    int[] buy = new int[k+1], sell = new int[k+1];
    Arrays.fill(buy, Integer.MIN_VALUE);
    for (int p : prices) {
        for (int t = 1; t <= k; t++) {
            buy[t] = Math.max(buy[t], sell[t-1] - p);
            sell[t] = Math.max(sell[t], buy[t] + p);
        }
    }
    return sell[k];
}
```
**Time:** O(n·k) | **Space:** O(k)

---

### Q270. Paint House II
**Difficulty:** Hard | **Companies:** Amazon, Google

**Problem:** Paint n houses with k colors. No two adjacent same color. Minimize cost.

**Solution (O(nk) optimized):**
```java
public int minCostII(int[][] costs) {
    int n = costs.length, k = costs[0].length;
    int min1 = 0, min2 = 0, lastColor = -1;
    for (int i = 0; i < n; i++) {
        int newMin1 = Integer.MAX_VALUE, newMin2 = Integer.MAX_VALUE, newLastColor = -1;
        for (int j = 0; j < k; j++) {
            int cost = costs[i][j] + (j == lastColor ? min2 : min1);
            if (cost < newMin1) { newMin2 = newMin1; newMin1 = cost; newLastColor = j; }
            else if (cost < newMin2) newMin2 = cost;
        }
        min1 = newMin1; min2 = newMin2; lastColor = newLastColor;
    }
    return min1;
}
```
**Time:** O(n·k) | **Space:** O(1)

---

### Q271. Strange Printer
**Difficulty:** Hard | **Companies:** Amazon, Google

**Problem:** Printer can print a sequence of same characters in one turn. Find minimum turns to print string.

**Solution:**
```java
public int strangePrinter(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];
    for (int len = 1; len <= n; len++) {
        for (int i = 0; i + len - 1 < n; i++) {
            int j = i + len - 1;
            dp[i][j] = len;
            for (int k = i; k < j; k++) {
                int val = dp[i][k] + dp[k+1][j];
                if (s.charAt(k) == s.charAt(j)) val--;
                dp[i][j] = Math.min(dp[i][j], val);
            }
        }
    }
    return dp[0][n-1];
}
```
**Time:** O(n³) | **Space:** O(n²)

---

### Q272. Count Different Palindromic Subsequences
**Difficulty:** Hard | **Companies:** Google

**Problem:** Count distinct palindromic subsequences in string s.

**Solution:**
```java
public int countPalindromicSubsequences(String s) {
    int n = s.length(), MOD = 1_000_000_007;
    long[][] dp = new long[n][n];
    for (int i = 0; i < n; i++) dp[i][i] = 1;
    for (int len = 2; len <= n; len++) {
        for (int i = 0; i <= n - len; i++) {
            int j = i + len - 1;
            if (s.charAt(i) == s.charAt(j)) {
                int lo = i+1, hi = j-1;
                while (lo <= hi && s.charAt(lo) != s.charAt(i)) lo++;
                while (lo <= hi && s.charAt(hi) != s.charAt(j)) hi--;
                if (lo > hi) dp[i][j] = dp[i+1][j-1]*2 + 2;
                else if (lo == hi) dp[i][j] = dp[i+1][j-1]*2 + 1;
                else dp[i][j] = dp[i+1][j-1]*2 - dp[lo+1][hi-1];
            } else {
                dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
            }
            dp[i][j] = (dp[i][j] % MOD + MOD) % MOD;
        }
    }
    return (int) dp[0][n-1];
}
```
**Time:** O(n²) | **Space:** O(n²)

---

### Q273. Maximal Rectangle
**Difficulty:** Hard | **Companies:** Amazon, Google, Meta

**Problem:** Find the largest rectangle containing only 1s in a binary matrix.

**Solution:**
```java
public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) return 0;
    int n = matrix[0].length, maxArea = 0;
    int[] heights = new int[n];
    for (char[] row : matrix) {
        for (int j = 0; j < n; j++) heights[j] = row[j]=='1' ? heights[j]+1 : 0;
        maxArea = Math.max(maxArea, largestRect(heights));
    }
    return maxArea;
}
private int largestRect(int[] heights) {
    Deque<Integer> stack = new ArrayDeque<>();
    int max = 0;
    for (int i = 0; i <= heights.length; i++) {
        int h = i == heights.length ? 0 : heights[i];
        while (!stack.isEmpty() && h < heights[stack.peek()]) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(max, height * width);
        }
        stack.push(i);
    }
    return max;
}
```
**Time:** O(m·n) | **Space:** O(n)

---

### Q274. Remove Boxes
**Difficulty:** Hard | **Companies:** Google

**Problem:** Remove boxes to gain points. Remove k consecutive same-colored boxes → k² points.

**Solution:**
```java
public int removeBoxes(int[] boxes) {
    int n = boxes.length;
    int[][][] dp = new int[n][n][n];
    return dfs(boxes, dp, 0, n-1, 0);
}
private int dfs(int[] boxes, int[][][] dp, int l, int r, int k) {
    if (l > r) return 0;
    if (dp[l][r][k] != 0) return dp[l][r][k];
    while (r > l && boxes[r] == boxes[r-1]) { r--; k++; }
    dp[l][r][k] = (k+1)*(k+1) + dfs(boxes, dp, l, r-1, 0);
    for (int i = l; i < r; i++) {
        if (boxes[i] == boxes[r]) {
            dp[l][r][k] = Math.max(dp[l][r][k], dfs(boxes,dp,i+1,r-1,0)+dfs(boxes,dp,l,i,k+1));
        }
    }
    return dp[l][r][k];
}
```
**Time:** O(n⁴) | **Space:** O(n³)

---

### Q275. Minimum Window Substring (DP approach awareness)
**Difficulty:** Hard | **Companies:** Amazon, Google

**Additional variant — count distinct windows:**
```java
// Number of substrings with exactly k distinct chars
public int subarraysWithKDistinct(int[] nums, int k) {
    return atMost(nums, k) - atMost(nums, k-1);
}
private int atMost(int[] nums, int k) {
    Map<Integer, Integer> count = new HashMap<>();
    int l = 0, result = 0;
    for (int r = 0; r < nums.length; r++) {
        count.merge(nums[r], 1, Integer::sum);
        while (count.size() > k) {
            count.merge(nums[l], -1, Integer::sum);
            if (count.get(nums[l]) == 0) count.remove(nums[l]);
            l++;
        }
        result += r - l + 1;
    }
    return result;
}
```
**Time:** O(n) | **Space:** O(k)

---

### Q276. Arithmetic Slices II — Subsequence
**Difficulty:** Hard | **Companies:** Google

**Problem:** Count arithmetic subsequences of length ≥ 3.

**Solution:**
```java
public int numberOfArithmeticSlices(int[] nums) {
    int n = nums.length, total = 0;
    List<Map<Long, Integer>> dp = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        dp.add(new HashMap<>());
        for (int j = 0; j < i; j++) {
            long diff = (long)nums[i] - nums[j];
            int count = dp.get(j).getOrDefault(diff, 0);
            total += count;
            dp.get(i).merge(diff, count+1, Integer::sum);
        }
    }
    return total;
}
```
**Time:** O(n²) | **Space:** O(n²)

---

### Q277. Freedom Trail
**Difficulty:** Hard | **Companies:** Google

**Problem:** Rotate ring to spell each character of key. Minimize total steps.

**Solution:**
```java
public int findRotateSteps(String ring, String key) {
    int n = ring.length(), m = key.length();
    Map<Character, List<Integer>> pos = new HashMap<>();
    for (int i = 0; i < n; i++) pos.computeIfAbsent(ring.charAt(i), k->new ArrayList<>()).add(i);
    int[][] dp = new int[m+1][n];
    for (int i = m-1; i >= 0; i--) {
        Arrays.fill(dp[i], Integer.MAX_VALUE);
        for (int j = 0; j < n; j++) {
            for (int k : pos.get(key.charAt(i))) {
                int diff = Math.abs(j-k);
                int step = 1 + Math.min(diff, n-diff) + dp[i+1][k];
                dp[i][j] = Math.min(dp[i][j], step);
            }
        }
    }
    return dp[0][0];
}
```
**Time:** O(m·n²) | **Space:** O(m·n)

---

### Q278. Concatenated Words
**Difficulty:** Hard | **Companies:** Amazon, Google

**Problem:** Find all words that can be formed by concatenating shorter words from the same list.

**Solution:**
```java
public List<String> findAllConcatenatedWordsInADict(String[] words) {
    Set<String> dict = new HashSet<>(Arrays.asList(words));
    List<String> result = new ArrayList<>();
    for (String word : words) {
        int n = word.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = (i==n?1:0); j < i; j++) {
                if (dp[j] && dict.contains(word.substring(j,i))) { dp[i]=true; break; }
            }
        }
        if (dp[n]) result.add(word);
    }
    return result;
}
```
**Time:** O(n·L²) | **Space:** O(n·L)

---

### Q279. Maximum Profit in Job Scheduling (revisited with better explanation)

See Q136. Key insight: sort by end time, binary search for compatible last job.

---

### Q280. Number of Ways to Stay in the Same Place After Some Steps
**Difficulty:** Hard | **Companies:** Amazon, Google

**Solution:**
```java
public int numWays(int steps, int arrLen) {
    int MOD = 1_000_000_007;
    int maxPos = Math.min(steps/2+1, arrLen);
    int[] dp = new int[maxPos];
    dp[0] = 1;
    for (int s = 0; s < steps; s++) {
        int[] next = new int[maxPos];
        for (int i = 0; i < maxPos; i++) {
            if (dp[i] == 0) continue;
            next[i] = (next[i] + dp[i]) % MOD;
            if (i > 0) next[i-1] = (next[i-1] + dp[i]) % MOD;
            if (i < maxPos-1) next[i+1] = (next[i+1] + dp[i]) % MOD;
        }
        dp = next;
    }
    return dp[0];
}
```
**Time:** O(steps·min(steps,arrLen)) | **Space:** O(min(steps,arrLen))

---

### Q281. Largest Divisible Subset
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find the largest subset where every pair (a,b) satisfies a%b==0 or b%a==0.

**Solution:**
```java
public List<Integer> largestDivisibleSubset(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int[] dp = new int[n], parent = new int[n];
    Arrays.fill(parent, -1);
    int maxLen = 1, maxIdx = 0;
    for (int i = 1; i < n; i++) {
        dp[i] = 1;
        for (int j = i-1; j >= 0; j--) {
            if (nums[i] % nums[j] == 0 && dp[j]+1 > dp[i]) { dp[i]=dp[j]+1; parent[i]=j; }
        }
        if (dp[i] > maxLen) { maxLen=dp[i]; maxIdx=i; }
    }
    List<Integer> result = new ArrayList<>();
    for (int i = maxIdx; i != -1; i = parent[i]) result.add(0, nums[i]);
    return result;
}
```
**Time:** O(n²) | **Space:** O(n)

---

### Q282. Minimum Operations to Make Array Increasing
**Difficulty:** Easy | **Companies:** Amazon, Google

**Solution:**
```java
public int minOperations(int[] nums) {
    int ops = 0;
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] <= nums[i-1]) { ops += nums[i-1]-nums[i]+1; nums[i]=nums[i-1]+1; }
    }
    return ops;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q283. Number of Dice Rolls With Target Sum
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** n dice each with k faces. Count ways to roll target sum.

**Solution:**
```java
public int numRollsToTarget(int n, int k, int target) {
    int MOD = 1_000_000_007;
    int[] dp = new int[target+1];
    dp[0] = 1;
    for (int i = 0; i < n; i++) {
        int[] next = new int[target+1];
        for (int j = 0; j <= target; j++) {
            if (dp[j] == 0) continue;
            for (int face = 1; face <= k && j+face <= target; face++)
                next[j+face] = (next[j+face] + dp[j]) % MOD;
        }
        dp = next;
    }
    return dp[target];
}
```
**Time:** O(n·target·k) | **Space:** O(target)

---

### Q284. Painting the Walls
**Difficulty:** Hard | **Companies:** Amazon, Google

**Problem:** Paid painter and free painter (works while paid works). Minimize cost to paint all walls.

**Solution (0/1 Knapsack):**
```java
public int paintWalls(int[] cost, int[] time) {
    int n = cost.length;
    int[] dp = new int[n+1];
    Arrays.fill(dp, (int)1e9);
    dp[0] = 0;
    for (int i = 0; i < n; i++) {
        for (int j = n; j >= 0; j--) {
            dp[Math.min(n, j + time[i] + 1)] = Math.min(dp[Math.min(n, j + time[i] + 1)], dp[j] + cost[i]);
        }
    }
    return dp[n];
}
```
**Time:** O(n²) | **Space:** O(n)

---

### Q285. Maximal Score After Applying K Operations
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Pick element, add to score, replace with ceil(val/3). Repeat k times. Maximize score.

**Solution:**
```java
public long maxKelements(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int n : nums) pq.offer(n);
    long score = 0;
    while (k-- > 0) {
        int top = pq.poll();
        score += top;
        pq.offer((top + 2) / 3);
    }
    return score;
}
```
**Time:** O((n+k) log n) | **Space:** O(n)

---

## SECTION 18: DESIGN PROBLEMS (Q286–Q294)

---

### Q286. LFU Cache
**Difficulty:** Hard | **Companies:** Amazon, Meta

**Problem:** Design Least Frequently Used cache with O(1) get and put.

**Solution:**
```java
class LFUCache {
    int capacity, minFreq;
    Map<Integer, Integer> keyVal = new HashMap<>(), keyFreq = new HashMap<>();
    Map<Integer, LinkedHashSet<Integer>> freqKeys = new HashMap<>();

    public LFUCache(int capacity) { this.capacity = capacity; }

    public int get(int key) {
        if (!keyVal.containsKey(key)) return -1;
        updateFreq(key);
        return keyVal.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;
        if (keyVal.containsKey(key)) { keyVal.put(key, value); updateFreq(key); return; }
        if (keyVal.size() >= capacity) {
            int evict = freqKeys.get(minFreq).iterator().next();
            freqKeys.get(minFreq).remove(evict);
            keyVal.remove(evict); keyFreq.remove(evict);
        }
        keyVal.put(key, value); keyFreq.put(key, 1);
        freqKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFreq = 1;
    }

    private void updateFreq(int key) {
        int freq = keyFreq.get(key);
        keyFreq.put(key, freq+1);
        freqKeys.get(freq).remove(key);
        if (freqKeys.get(freq).isEmpty()) { freqKeys.remove(freq); if (minFreq==freq) minFreq++; }
        freqKeys.computeIfAbsent(freq+1, k -> new LinkedHashSet<>()).add(key);
    }
}
```
**Time:** O(1) all ops | **Space:** O(capacity)

---

### Q287. Design Twitter
**Difficulty:** Medium | **Companies:** Amazon

**Problem:** Design Twitter with postTweet, getNewsFeed, follow, unfollow.

**Solution:**
```java
class Twitter {
    int timestamp = 0;
    Map<Integer, List<int[]>> tweets = new HashMap<>();
    Map<Integer, Set<Integer>> following = new HashMap<>();

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{timestamp++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        Set<Integer> users = new HashSet<>(following.getOrDefault(userId, new HashSet<>()));
        users.add(userId);
        for (int u : users) {
            List<int[]> t = tweets.getOrDefault(u, new ArrayList<>());
            for (int i = t.size()-1; i >= Math.max(0, t.size()-10); i--) pq.offer(t.get(i));
        }
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty() && result.size() < 10) result.add(pq.poll()[1]);
        return result;
    }

    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        following.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}
```
**Time:** O(n log n) getNewsFeed | **Space:** O(n)

---

### Q288. Insert Delete GetRandom O(1)
**Difficulty:** Medium | **Companies:** Amazon, Meta, Google

**Solution:**
```java
class RandomizedSet {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random rand = new Random();

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int idx = map.get(val), last = list.get(list.size()-1);
        list.set(idx, last); map.put(last, idx);
        list.remove(list.size()-1); map.remove(val);
        return true;
    }

    public int getRandom() { return list.get(rand.nextInt(list.size())); }
}
```
**Time:** O(1) all ops | **Space:** O(n)

---

### Q289. All O'one Data Structure
**Difficulty:** Hard | **Companies:** Amazon, Google

**Problem:** O(1) inc, dec, getMaxKey, getMinKey.

**Solution:**
```java
class AllOne {
    TreeMap<Integer, Set<String>> countToKeys = new TreeMap<>();
    Map<String, Integer> keyToCount = new HashMap<>();

    public void inc(String key) {
        int cnt = keyToCount.getOrDefault(key, 0);
        keyToCount.put(key, cnt+1);
        countToKeys.computeIfAbsent(cnt+1, k->new LinkedHashSet<>()).add(key);
        if (cnt > 0) { countToKeys.get(cnt).remove(key); if (countToKeys.get(cnt).isEmpty()) countToKeys.remove(cnt); }
    }

    public void dec(String key) {
        int cnt = keyToCount.get(key);
        countToKeys.get(cnt).remove(key); if (countToKeys.get(cnt).isEmpty()) countToKeys.remove(cnt);
        if (cnt == 1) keyToCount.remove(key);
        else { keyToCount.put(key, cnt-1); countToKeys.computeIfAbsent(cnt-1, k->new LinkedHashSet<>()).add(key); }
    }

    public String getMaxKey() { return countToKeys.isEmpty()?"":countToKeys.lastEntry().getValue().iterator().next(); }
    public String getMinKey() { return countToKeys.isEmpty()?"":countToKeys.firstEntry().getValue().iterator().next(); }
}
```
**Time:** O(log n) per op (O(1) with doubly-linked list variant) | **Space:** O(n)

---

### Q290. Design Tic-Tac-Toe
**Difficulty:** Medium | **Companies:** Amazon, Google

**Solution:**
```java
class TicTacToe {
    int[] rows, cols, diag = new int[2];
    int n;
    public TicTacToe(int n) { this.n = n; rows = new int[n]; cols = new int[n]; }
    public int move(int row, int col, int player) {
        int add = player == 1 ? 1 : -1, target = player == 1 ? n : -n;
        rows[row] += add; cols[col] += add;
        if (row == col) diag[0] += add;
        if (row + col == n-1) diag[1] += add;
        if (rows[row]==target||cols[col]==target||diag[0]==target||diag[1]==target) return player;
        return 0;
    }
}
```
**Time:** O(1) per move | **Space:** O(n)

---

### Q291. Snapshot Array
**Difficulty:** Medium | **Companies:** Amazon, Google

**Solution:**
```java
class SnapshotArray {
    List<int[]>[] data;
    int snapId = 0;
    public SnapshotArray(int length) {
        data = new List[length];
        for (int i = 0; i < length; i++) { data[i] = new ArrayList<>(); data[i].add(new int[]{0, 0}); }
    }
    public void set(int index, int val) {
        List<int[]> d = data[index];
        if (d.get(d.size()-1)[0] == snapId) d.get(d.size()-1)[1] = val;
        else d.add(new int[]{snapId, val});
    }
    public int snap() { return snapId++; }
    public int get(int index, int snap_id) {
        List<int[]> d = data[index];
        int l = 0, r = d.size()-1;
        while (l < r) { int mid = l+(r-l+1)/2; if (d.get(mid)[0]<=snap_id) l=mid; else r=mid-1; }
        return d.get(l)[1];
    }
}
```
**Time:** O(log n) get | **Space:** O(n·snaps)

---

### Q292. Design File System
**Difficulty:** Medium | **Companies:** Amazon, Google

**Solution:**
```java
class FileSystem {
    Map<String, Integer> paths = new HashMap<>();
    public FileSystem() { paths.put("", 0); }
    public boolean createPath(String path, int value) {
        int idx = path.lastIndexOf('/');
        String parent = path.substring(0, idx);
        if (!paths.containsKey(parent) || paths.containsKey(path)) return false;
        paths.put(path, value);
        return true;
    }
    public int get(String path) { return paths.getOrDefault(path, -1); }
}
```
**Time:** O(L) per op | **Space:** O(n·L)

---

### Q293. Encode and Decode Strings
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Design encode/decode for a list of strings to be transmitted as a single string.

**Solution:**
```java
public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String s : strs) sb.append(s.length()).append('#').append(s);
    return sb.toString();
}
public List<String> decode(String s) {
    List<String> result = new ArrayList<>();
    int i = 0;
    while (i < s.length()) {
        int j = s.indexOf('#', i);
        int len = Integer.parseInt(s.substring(i, j));
        result.add(s.substring(j+1, j+1+len));
        i = j + 1 + len;
    }
    return result;
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q294. Range Sum Query — Mutable (BIT/Fenwick Tree)
**Difficulty:** Medium | **Companies:** Amazon, Google

**Solution:**
```java
class NumArray {
    int[] tree, nums;
    int n;
    public NumArray(int[] nums) {
        this.n = nums.length; this.nums = new int[n]; this.tree = new int[n+1];
        for (int i = 0; i < n; i++) update(i, nums[i]);
    }
    public void update(int i, int val) {
        int diff = val - nums[i]; nums[i] = val;
        for (i++; i <= n; i += i & (-i)) tree[i] += diff;
    }
    public int sumRange(int l, int r) { return query(r+1) - query(l); }
    private int query(int i) { int sum = 0; for (; i > 0; i -= i & (-i)) sum += tree[i]; return sum; }
}
```
**Time:** O(log n) update/query | **Space:** O(n)

---

## SECTION 19: MATH & BIT MANIPULATION (Q295–Q300)

---

### Q295. Count Primes (Sieve of Eratosthenes)
**Difficulty:** Medium | **Companies:** Amazon, Google

**Solution:**
```java
public int countPrimes(int n) {
    boolean[] notPrime = new boolean[n];
    int count = 0;
    for (int i = 2; i < n; i++) {
        if (!notPrime[i]) {
            count++;
            for (long j = (long)i*i; j < n; j += i) notPrime[(int)j] = true;
        }
    }
    return count;
}
```
**Time:** O(n log log n) | **Space:** O(n)

---

### Q296. Divide Two Integers (without multiplication/division)
**Difficulty:** Medium | **Companies:** Amazon, Google

**Solution:**
```java
public int divide(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
    long a = Math.abs((long)dividend), b = Math.abs((long)divisor);
    int sign = (dividend > 0) == (divisor > 0) ? 1 : -1;
    long result = 0;
    while (a >= b) {
        long tmp = b, multiple = 1;
        while (a >= tmp << 1) { tmp <<= 1; multiple <<= 1; }
        a -= tmp; result += multiple;
    }
    return (int)(sign * result);
}
```
**Time:** O(log² n) | **Space:** O(1)

---

### Q297. Pow(x, n)
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Solution (Fast Exponentiation):**
```java
public double myPow(double x, int n) {
    long N = n;
    if (N < 0) { x = 1/x; N = -N; }
    double result = 1;
    while (N > 0) {
        if ((N & 1) == 1) result *= x;
        x *= x; N >>= 1;
    }
    return result;
}
```
**Time:** O(log n) | **Space:** O(1)

---

### Q298. Excel Sheet Column Number
**Difficulty:** Easy | **Companies:** Amazon, Google

**Example:**
```
"AB" → 28
```

**Solution:**
```java
public int titleToNumber(String columnTitle) {
    int result = 0;
    for (char c : columnTitle.toCharArray()) result = result * 26 + (c - 'A' + 1);
    return result;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q299. Trailing Zeroes in Factorial
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Count trailing zeroes in n! (each zero = one factor of 10 = one pair of 2×5; count 5s).

**Solution:**
```java
public int trailingZeroes(int n) {
    int count = 0;
    while (n >= 5) { n /= 5; count += n; }
    return count;
}
```
**Time:** O(log n) | **Space:** O(1)

---

### Q300. Maximum Number of Visible Points
**Difficulty:** Hard | **Companies:** Google

**Problem:** Standing at location, with angle-degree view field, maximize visible points.

**Solution:**
```java
public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
    int lx = location.get(0), ly = location.get(1);
    List<Double> angles = new ArrayList<>();
    int atLocation = 0;
    for (List<Integer> p : points) {
        int dx = p.get(0)-lx, dy = p.get(1)-ly;
        if (dx==0 && dy==0) { atLocation++; continue; }
        angles.add(Math.toDegrees(Math.atan2(dy, dx)));
    }
    Collections.sort(angles);
    int n = angles.size();
    for (int i = 0; i < n; i++) angles.add(angles.get(i)+360);
    int maxVisible = 0, l = 0;
    for (int r = 0; r < angles.size(); r++) {
        while (angles.get(r)-angles.get(l) > angle) l++;
        maxVisible = Math.max(maxVisible, r-l+1);
    }
    return maxVisible + atLocation;
}
```
**Time:** O(n log n) | **Space:** O(n)

---

## Full 300-Question Summary

| Section | Q Range | Key Topics |
|---------|---------|------------|
| Arrays | 1–25 | HashMap, Kadane, Prefix Sum, Merge Intervals |
| Strings | 26–45 | Anagram, Sliding Window, Palindrome, DP |
| Linked Lists | 46–60 | Floyd's Cycle, Two Pointers, Merge Sort |
| Stacks & Queues | 61–75 | Monotonic Stack/Deque, Min Stack |
| Trees | 76–105 | BFS/DFS, BST, LCA, Serialize |
| Binary Search | 106–120 | Standard BS, QuickSelect, Median |
| Dynamic Programming | 121–155 | Knapsack, LIS, LCS, Stock Problems |
| Graphs | 156–175 | DFS/BFS, Union-Find, Topo Sort |
| Greedy | 176–185 | Intervals, Scheduling, Partitioning |
| Backtracking | 186–195 | Subsets, Permutations, N-Queens |
| Math & Bits | 196–200 | XOR, Bit tricks |
| Advanced Arrays | 201–215 | Rotate, Spiral, Matrix DP |
| Advanced Strings | 216–225 | Regex, Wildcard, Parentheses |
| Heap | 226–238 | Merge K Lists, Median Stream, Dijkstra |
| Trie | 239–245 | Prefix Tree, Word Search II |
| Advanced Graphs | 246–260 | Tarjan's Bridges, Eulerian Path |
| Advanced DP | 261–285 | Interval DP, Multi-dim DP |
| Design | 286–294 | LFU, BIT, Twitter, RandomSet |
| Math | 295–300 | Sieve, Fast Exp, Factorial |
