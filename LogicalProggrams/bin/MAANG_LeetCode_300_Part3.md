# MAANG LeetCode — Part 3 (Q201–Q260) | Medium–Hard

---

## SECTION 12: ADVANCED ARRAYS & MATRIX (Q201–Q215)

---

### Q201. Next Permutation
**Difficulty:** Medium | **Companies:** Google, Amazon, Meta

**Problem:** Rearrange numbers into the lexicographically next greater permutation. In-place.

**Example:**
```
Input: nums = [1,2,3]
Output: [1,3,2]
```

**Solution:**
```java
public void nextPermutation(int[] nums) {
    int n = nums.length, i = n - 2;
    while (i >= 0 && nums[i] >= nums[i + 1]) i--;
    if (i >= 0) {
        int j = n - 1;
        while (nums[j] <= nums[i]) j--;
        int tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp;
    }
    int l = i + 1, r = n - 1;
    while (l < r) { int tmp = nums[l]; nums[l++] = nums[r]; nums[r--] = tmp; }
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q202. Rotate Image
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Rotate an n×n matrix 90 degrees clockwise in-place.

**Example:**
```
Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
```

**Solution:**
```java
public void rotate(int[][] matrix) {
    int n = matrix.length;
    // Transpose
    for (int i = 0; i < n; i++)
        for (int j = i + 1; j < n; j++) {
            int tmp = matrix[i][j]; matrix[i][j] = matrix[j][i]; matrix[j][i] = tmp;
        }
    // Reverse each row
    for (int i = 0; i < n; i++) {
        int l = 0, r = n - 1;
        while (l < r) { int tmp = matrix[i][l]; matrix[i][l++] = matrix[i][r]; matrix[i][r--] = tmp; }
    }
}
```
**Time:** O(n²) | **Space:** O(1)

---

### Q203. Spiral Matrix
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta, Apple

**Problem:** Return all elements of an m×n matrix in spiral order.

**Example:**
```
Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
```

**Solution:**
```java
public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
    while (top <= bottom && left <= right) {
        for (int i = left; i <= right; i++) result.add(matrix[top][i]);
        top++;
        for (int i = top; i <= bottom; i++) result.add(matrix[i][right]);
        right--;
        if (top <= bottom) { for (int i = right; i >= left; i--) result.add(matrix[bottom][i]); bottom--; }
        if (left <= right) { for (int i = bottom; i >= top; i--) result.add(matrix[i][left]); left++; }
    }
    return result;
}
```
**Time:** O(m·n) | **Space:** O(1)

---

### Q204. Set Matrix Zeroes
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** If element is 0, set its entire row and column to 0. In-place.

**Solution:**
```java
public void setZeroes(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    boolean firstRow = false, firstCol = false;
    for (int j = 0; j < n; j++) if (matrix[0][j] == 0) firstRow = true;
    for (int i = 0; i < m; i++) if (matrix[i][0] == 0) firstCol = true;
    for (int i = 1; i < m; i++) for (int j = 1; j < n; j++) if (matrix[i][j] == 0) { matrix[i][0] = 0; matrix[0][j] = 0; }
    for (int i = 1; i < m; i++) for (int j = 1; j < n; j++) if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
    if (firstRow) for (int j = 0; j < n; j++) matrix[0][j] = 0;
    if (firstCol) for (int i = 0; i < m; i++) matrix[i][0] = 0;
}
```
**Time:** O(m·n) | **Space:** O(1)

---

### Q205. Game of Life
**Difficulty:** Medium | **Companies:** Google, Amazon

**Problem:** Apply Conway's Game of Life rules one step. In-place.

**Solution:**
```java
public void gameOfLife(int[][] board) {
    int m = board.length, n = board[0].length;
    int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            int live = 0;
            for (int[] d : dirs) {
                int r = i + d[0], c = j + d[1];
                if (r >= 0 && r < m && c >= 0 && c < n && Math.abs(board[r][c]) == 1) live++;
            }
            if (board[i][j] == 1 && (live < 2 || live > 3)) board[i][j] = -1;
            if (board[i][j] == 0 && live == 3) board[i][j] = 2;
        }
    }
    for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
        if (board[i][j] == -1) board[i][j] = 0;
        if (board[i][j] == 2) board[i][j] = 1;
    }
}
```
**Time:** O(m·n) | **Space:** O(1)

---

### Q206. Jump Game III
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** From index i you can jump to i+arr[i] or i-arr[i]. Can you reach any index with value 0?

**Solution:**
```java
public boolean canReach(int[] arr, int start) {
    if (start < 0 || start >= arr.length || arr[start] < 0) return false;
    if (arr[start] == 0) return true;
    arr[start] = -arr[start];
    return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q207. 4Sum
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find all unique quadruplets summing to target.

**Example:**
```
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
```

**Solution:**
```java
public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    int n = nums.length;
    for (int i = 0; i < n - 3; i++) {
        if (i > 0 && nums[i] == nums[i-1]) continue;
        for (int j = i + 1; j < n - 2; j++) {
            if (j > i + 1 && nums[j] == nums[j-1]) continue;
            int l = j + 1, r = n - 1;
            while (l < r) {
                long sum = (long)nums[i] + nums[j] + nums[l] + nums[r];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l+1]) l++;
                    while (l < r && nums[r] == nums[r-1]) r--;
                    l++; r--;
                } else if (sum < target) l++;
                else r--;
            }
        }
    }
    return result;
}
```
**Time:** O(n³) | **Space:** O(1)

---

### Q208. Minimum Size Subarray Sum
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find the minimal length subarray whose sum ≥ target.

**Example:**
```
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2  ([4,3])
```

**Solution:**
```java
public int minSubArrayLen(int target, int[] nums) {
    int l = 0, sum = 0, minLen = Integer.MAX_VALUE;
    for (int r = 0; r < nums.length; r++) {
        sum += nums[r];
        while (sum >= target) { minLen = Math.min(minLen, r - l + 1); sum -= nums[l++]; }
    }
    return minLen == Integer.MAX_VALUE ? 0 : minLen;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q209. Squares of a Sorted Array
**Difficulty:** Easy | **Companies:** Google, Amazon

**Problem:** Return sorted array of squares of a sorted array.

**Solution:**
```java
public int[] sortedSquares(int[] nums) {
    int n = nums.length, l = 0, r = n - 1, pos = n - 1;
    int[] result = new int[n];
    while (l <= r) {
        int lSq = nums[l] * nums[l], rSq = nums[r] * nums[r];
        if (lSq > rSq) { result[pos--] = lSq; l++; }
        else { result[pos--] = rSq; r--; }
    }
    return result;
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q210. Longest Valid Parentheses
**Difficulty:** Hard | **Companies:** Amazon, Google, Meta

**Problem:** Find the length of the longest valid (well-formed) parentheses substring.

**Example:**
```
Input: s = ")()())"
Output: 4
```

**Solution:**
```java
public int longestValidParentheses(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(-1);
    int maxLen = 0;
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') {
            stack.push(i);
        } else {
            stack.pop();
            if (stack.isEmpty()) stack.push(i);
            else maxLen = Math.max(maxLen, i - stack.peek());
        }
    }
    return maxLen;
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q211. Minimum Remove to Make Valid Parentheses
**Difficulty:** Medium | **Companies:** Meta, Amazon

**Problem:** Remove minimum number of parentheses to make string valid.

**Example:**
```
Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
```

**Solution:**
```java
public String minRemoveToMakeValid(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    Set<Integer> toRemove = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(') stack.push(i);
        else if (c == ')') {
            if (stack.isEmpty()) toRemove.add(i);
            else stack.pop();
        }
    }
    while (!stack.isEmpty()) toRemove.add(stack.pop());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) if (!toRemove.contains(i)) sb.append(s.charAt(i));
    return sb.toString();
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q212. Longest Substring with At Most K Distinct Characters
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find the length of the longest substring with at most k distinct characters.

**Example:**
```
Input: s = "eceba", k = 2
Output: 3  ("ece")
```

**Solution:**
```java
public int lengthOfLongestSubstringKDistinct(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int left = 0, maxLen = 0;
    for (int right = 0; right < s.length(); right++) {
        map.merge(s.charAt(right), 1, Integer::sum);
        while (map.size() > k) {
            char lc = s.charAt(left);
            map.merge(lc, -1, Integer::sum);
            if (map.get(lc) == 0) map.remove(lc);
            left++;
        }
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
```
**Time:** O(n) | **Space:** O(k)

---

### Q213. Vertical Order Traversal of Binary Tree
**Difficulty:** Hard | **Companies:** Amazon, Meta

**Problem:** Return nodes column by column, left to right; within same column sort by row then value.

**Solution:**
```java
public List<List<Integer>> verticalTraversal(TreeNode root) {
    List<int[]> nodes = new ArrayList<>();
    dfs(root, 0, 0, nodes);
    nodes.sort((a, b) -> a[0] != b[0] ? a[0]-b[0] : a[1] != b[1] ? a[1]-b[1] : a[2]-b[2]);
    List<List<Integer>> result = new ArrayList<>();
    int prevCol = Integer.MIN_VALUE;
    for (int[] node : nodes) {
        if (node[0] != prevCol) { result.add(new ArrayList<>()); prevCol = node[0]; }
        result.get(result.size()-1).add(node[2]);
    }
    return result;
}
private void dfs(TreeNode node, int col, int row, List<int[]> nodes) {
    if (node == null) return;
    nodes.add(new int[]{col, row, node.val});
    dfs(node.left, col-1, row+1, nodes);
    dfs(node.right, col+1, row+1, nodes);
}
```
**Time:** O(n log n) | **Space:** O(n)

---

### Q214. Maximum Width of Binary Tree
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find the maximum width of any level (including nulls between leftmost and rightmost nodes).

**Solution:**
```java
public int widthOfBinaryTree(TreeNode root) {
    if (root == null) return 0;
    int maxWidth = 0;
    Queue<long[]> queue = new LinkedList<>();
    queue.offer(new long[]{0, root.val, 0});
    while (!queue.isEmpty()) {
        int size = queue.size();
        long first = 0, last = 0;
        for (int i = 0; i < size; i++) {
            long[] curr = queue.poll();
            long pos = curr[0]; int val = (int)curr[1]; long depth = curr[2];
            if (i == 0) first = pos;
            last = pos;
            TreeNode node = findNode(root, val);
            if (node != null) {
                if (node.left != null) queue.offer(new long[]{2*pos, node.left.val, depth+1});
                if (node.right != null) queue.offer(new long[]{2*pos+1, node.right.val, depth+1});
            }
        }
        maxWidth = (int)Math.max(maxWidth, last - first + 1);
    }
    return maxWidth;
}
```

**Better Solution (index-based):**
```java
public int widthOfBinaryTree(TreeNode root) {
    if (root == null) return 0;
    Queue<Object[]> queue = new LinkedList<>();
    queue.offer(new Object[]{root, 0});
    int maxWidth = 0;
    while (!queue.isEmpty()) {
        int size = queue.size();
        int first = 0, last = 0;
        for (int i = 0; i < size; i++) {
            Object[] curr = queue.poll();
            TreeNode node = (TreeNode) curr[0];
            int idx = (int) curr[1];
            if (i == 0) first = idx;
            last = idx;
            if (node.left != null) queue.offer(new Object[]{node.left, 2 * idx});
            if (node.right != null) queue.offer(new Object[]{node.right, 2 * idx + 1});
        }
        maxWidth = Math.max(maxWidth, last - first + 1);
    }
    return maxWidth;
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q215. Max Consecutive Ones III
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** With at most k zero flips, find the maximum consecutive 1s.

**Example:**
```
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
```

**Solution:**
```java
public int longestOnes(int[] nums, int k) {
    int left = 0, zeros = 0, maxLen = 0;
    for (int right = 0; right < nums.length; right++) {
        if (nums[right] == 0) zeros++;
        while (zeros > k) if (nums[left++] == 0) zeros--;
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
```
**Time:** O(n) | **Space:** O(1)

---

## SECTION 13: ADVANCED STRINGS (Q216–Q225)

---

### Q216. Regular Expression Matching
**Difficulty:** Hard | **Companies:** Google, Meta, Amazon

**Problem:** Implement regex matching with '.' (any char) and '*' (zero or more of preceding).

**Example:**
```
Input: s = "aab", p = "c*a*b"
Output: true
```

**Solution:**
```java
public boolean isMatch(String s, String p) {
    int m = s.length(), n = p.length();
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    for (int j = 2; j <= n; j++) if (p.charAt(j-1) == '*') dp[0][j] = dp[0][j-2];
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            char pc = p.charAt(j-1), sc = s.charAt(i-1);
            if (pc == '*') {
                dp[i][j] = dp[i][j-2];
                if (p.charAt(j-2) == '.' || p.charAt(j-2) == sc) dp[i][j] |= dp[i-1][j];
            } else {
                dp[i][j] = dp[i-1][j-1] && (pc == '.' || pc == sc);
            }
        }
    }
    return dp[m][n];
}
```
**Time:** O(m·n) | **Space:** O(m·n)

---

### Q217. Wildcard Matching
**Difficulty:** Hard | **Companies:** Amazon, Google

**Problem:** Implement wildcard matching with '?' (any single char) and '*' (any sequence).

**Example:**
```
Input: s = "adceb", p = "*a*b"
Output: true
```

**Solution:**
```java
public boolean isMatch(String s, String p) {
    int m = s.length(), n = p.length();
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    for (int j = 1; j <= n; j++) if (p.charAt(j-1) == '*') dp[0][j] = dp[0][j-1];
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            char pc = p.charAt(j-1);
            if (pc == '*') dp[i][j] = dp[i-1][j] || dp[i][j-1];
            else dp[i][j] = dp[i-1][j-1] && (pc == '?' || pc == s.charAt(i-1));
        }
    }
    return dp[m][n];
}
```
**Time:** O(m·n) | **Space:** O(m·n)

---

### Q218. Minimum Window Subsequence
**Difficulty:** Hard | **Companies:** Google, Meta

**Problem:** Find shortest substring of s such that t appears as a subsequence.

**Example:**
```
Input: s = "abcdebdde", t = "bde"
Output: "bcde"
```

**Solution:**
```java
public String minWindow(String s, String t) {
    int si = 0, ti = 0, start = -1, minLen = Integer.MAX_VALUE;
    while (si < s.length()) {
        if (s.charAt(si) == t.charAt(ti)) {
            if (++ti == t.length()) {
                int end = si;
                ti--;
                while (ti >= 0) { if (s.charAt(si) == t.charAt(ti)) ti--; si--; }
                si++; ti = 0;
                if (end - si + 1 < minLen) { minLen = end - si + 1; start = si; }
            }
        }
        si++;
    }
    return start == -1 ? "" : s.substring(start, start + minLen);
}
```
**Time:** O(|s|·|t|) | **Space:** O(1)

---

### Q219. String Compression
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Compress array of chars in-place: "aabccc" → "a2bc3c". Return compressed length.

**Solution:**
```java
public int compress(char[] chars) {
    int write = 0, i = 0;
    while (i < chars.length) {
        char c = chars[i];
        int count = 0;
        while (i < chars.length && chars[i] == c) { i++; count++; }
        chars[write++] = c;
        if (count > 1) for (char d : String.valueOf(count).toCharArray()) chars[write++] = d;
    }
    return write;
}
```
**Time:** O(n) | **Space:** O(1)

---

### Q220. Integer to English Words
**Difficulty:** Hard | **Companies:** Amazon, Google

**Example:**
```
Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
```

**Solution:**
```java
private final String[] ones = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
    "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
private final String[] tens = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
public String numberToWords(int num) {
    if (num == 0) return "Zero";
    return helper(num).trim();
}
private String helper(int num) {
    if (num == 0) return "";
    if (num < 20) return ones[num] + " ";
    if (num < 100) return tens[num/10] + " " + helper(num%10);
    if (num < 1000) return ones[num/100] + " Hundred " + helper(num%100);
    if (num < 1000000) return helper(num/1000) + "Thousand " + helper(num%1000);
    if (num < 1000000000) return helper(num/1000000) + "Million " + helper(num%1000000);
    return helper(num/1000000000) + "Billion " + helper(num%1000000000);
}
```
**Time:** O(1) | **Space:** O(1)

---

### Q221. Count and Say
**Difficulty:** Medium | **Companies:** Amazon, Google

**Example:**
```
Input: n = 4
Output: "1211"  (1→11→21→1211)
```

**Solution:**
```java
public String countAndSay(int n) {
    String result = "1";
    for (int i = 1; i < n; i++) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        while (j < result.length()) {
            char c = result.charAt(j);
            int count = 0;
            while (j < result.length() && result.charAt(j) == c) { j++; count++; }
            sb.append(count).append(c);
        }
        result = sb.toString();
    }
    return result;
}
```
**Time:** O(n·L) | **Space:** O(L)

---

### Q222. Basic Calculator (with parentheses)
**Difficulty:** Hard | **Companies:** Amazon, Google, Meta

**Problem:** Evaluate expression with +, -, and parentheses.

**Solution:**
```java
public int calculate(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    int result = 0, num = 0, sign = 1;
    for (char c : s.toCharArray()) {
        if (Character.isDigit(c)) num = num * 10 + (c - '0');
        else if (c == '+') { result += sign * num; num = 0; sign = 1; }
        else if (c == '-') { result += sign * num; num = 0; sign = -1; }
        else if (c == '(') { stack.push(result); stack.push(sign); result = 0; sign = 1; }
        else if (c == ')') { result += sign * num; num = 0; result *= stack.pop(); result += stack.pop(); }
    }
    return result + sign * num;
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q223. Zigzag Conversion
**Difficulty:** Medium | **Companies:** Amazon, Google

**Example:**
```
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
```

**Solution:**
```java
public String convert(String s, int numRows) {
    if (numRows == 1 || s.length() <= numRows) return s;
    StringBuilder[] rows = new StringBuilder[numRows];
    for (int i = 0; i < numRows; i++) rows[i] = new StringBuilder();
    int row = 0, dir = -1;
    for (char c : s.toCharArray()) {
        rows[row].append(c);
        if (row == 0 || row == numRows - 1) dir = -dir;
        row += dir;
    }
    StringBuilder result = new StringBuilder();
    for (StringBuilder r : rows) result.append(r);
    return result.toString();
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q224. Sentence Screen Fitting
**Difficulty:** Medium | **Companies:** Google

**Problem:** How many times can a sentence be fitted on a screen of rows×cols?

**Solution:**
```java
public int wordsTyping(String[] sentence, int rows, int cols) {
    String s = String.join(" ", sentence) + " ";
    int len = s.length(), start = 0;
    for (int i = 0; i < rows; i++) {
        start += cols;
        if (s.charAt(start % len) == ' ') start++;
        else while (start > 0 && s.charAt((start-1) % len) != ' ') start--;
    }
    return start / len;
}
```
**Time:** O(rows·n) | **Space:** O(n)

---

### Q225. Text Justification
**Difficulty:** Hard | **Companies:** Amazon, Google

**Problem:** Format text with full justification, each line exactly maxWidth characters.

**Solution:**
```java
public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
    int i = 0, n = words.length;
    while (i < n) {
        int lineLen = words[i].length(), j = i + 1;
        while (j < n && lineLen + 1 + words[j].length() <= maxWidth) lineLen += 1 + words[j++].length();
        int numWords = j - i, numSpaces = maxWidth - lineLen + (numWords - 1);
        StringBuilder sb = new StringBuilder(words[i]);
        if (j == n || numWords == 1) {
            for (int k = i + 1; k < j; k++) sb.append(' ').append(words[k]);
            while (sb.length() < maxWidth) sb.append(' ');
        } else {
            int spacePerGap = numSpaces / (numWords - 1), extra = numSpaces % (numWords - 1);
            for (int k = i + 1; k < j; k++) {
                int spaces = spacePerGap + (k - i <= extra ? 1 : 0);
                for (int s = 0; s < spaces; s++) sb.append(' ');
                sb.append(words[k]);
            }
        }
        result.add(sb.toString());
        i = j;
    }
    return result;
}
```
**Time:** O(n·W) | **Space:** O(n·W)

---

## SECTION 14: HEAP / PRIORITY QUEUE (Q226–Q238)

---

### Q226. Merge K Sorted Lists
**Difficulty:** Hard | **Companies:** Amazon, Google, Meta, Apple

**Problem:** Merge k sorted linked lists into one sorted list.

**Solution:**
```java
public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
    for (ListNode node : lists) if (node != null) pq.offer(node);
    ListNode dummy = new ListNode(0), curr = dummy;
    while (!pq.isEmpty()) {
        curr.next = pq.poll();
        curr = curr.next;
        if (curr.next != null) pq.offer(curr.next);
    }
    return dummy.next;
}
```
**Time:** O(n log k) | **Space:** O(k)

---

### Q227. Find Median from Data Stream
**Difficulty:** Hard | **Companies:** Amazon, Google, Meta, Apple

**Problem:** Design a data structure that supports addNum and findMedian in O(log n) and O(1).

**Solution:**
```java
class MedianFinder {
    PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder()); // max heap
    PriorityQueue<Integer> hi = new PriorityQueue<>(); // min heap
    public void addNum(int num) {
        lo.offer(num);
        hi.offer(lo.poll());
        if (lo.size() < hi.size()) lo.offer(hi.poll());
    }
    public double findMedian() {
        return lo.size() > hi.size() ? lo.peek() : (lo.peek() + hi.peek()) / 2.0;
    }
}
```
**Time:** O(log n) add, O(1) find | **Space:** O(n)

---

### Q228. Top K Frequent Words
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Return k most frequent words. Tie-break alphabetically.

**Solution:**
```java
public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> freq = new HashMap<>();
    for (String w : words) freq.merge(w, 1, Integer::sum);
    PriorityQueue<String> pq = new PriorityQueue<>((a, b) ->
        freq.get(a).equals(freq.get(b)) ? b.compareTo(a) : freq.get(a) - freq.get(b));
    for (String w : freq.keySet()) {
        pq.offer(w);
        if (pq.size() > k) pq.poll();
    }
    List<String> result = new ArrayList<>();
    while (!pq.isEmpty()) result.add(0, pq.poll());
    return result;
}
```
**Time:** O(n log k) | **Space:** O(n)

---

### Q229. K Closest Points to Origin
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Solution:**
```java
public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
        (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));
    for (int[] p : points) {
        pq.offer(p);
        if (pq.size() > k) pq.poll();
    }
    return pq.toArray(new int[0][]);
}
```
**Time:** O(n log k) | **Space:** O(k)

---

### Q230. Reorganize String
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Rearrange string so no two adjacent characters are the same.

**Solution:**
```java
public String reorganizeString(String s) {
    int[] freq = new int[26];
    for (char c : s.toCharArray()) freq[c-'a']++;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]-a[1]);
    for (int i = 0; i < 26; i++) if (freq[i] > 0) pq.offer(new int[]{i, freq[i]});
    StringBuilder sb = new StringBuilder();
    while (pq.size() >= 2) {
        int[] a = pq.poll(), b = pq.poll();
        sb.append((char)('a'+a[0])).append((char)('a'+b[0]));
        if (--a[1] > 0) pq.offer(a);
        if (--b[1] > 0) pq.offer(b);
    }
    if (!pq.isEmpty()) {
        if (pq.peek()[1] > 1) return "";
        sb.append((char)('a'+pq.poll()[0]));
    }
    return sb.toString();
}
```
**Time:** O(n log n) | **Space:** O(n)

---

### Q231. Find K Pairs with Smallest Sums
**Difficulty:** Medium | **Companies:** Amazon, Google

**Solution:**
```java
public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums1.length == 0 || nums2.length == 0) return result;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (nums1[a[0]]+nums2[a[1]])-(nums1[b[0]]+nums2[b[1]]));
    for (int i = 0; i < Math.min(nums1.length, k); i++) pq.offer(new int[]{i, 0});
    while (!pq.isEmpty() && k-- > 0) {
        int[] curr = pq.poll();
        result.add(Arrays.asList(nums1[curr[0]], nums2[curr[1]]));
        if (curr[1] + 1 < nums2.length) pq.offer(new int[]{curr[0], curr[1]+1});
    }
    return result;
}
```
**Time:** O(k log k) | **Space:** O(k)

---

### Q232. Ugly Number II
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find the nth ugly number (prime factors only 2, 3, 5).

**Solution:**
```java
public int nthUglyNumber(int n) {
    int[] dp = new int[n];
    dp[0] = 1;
    int p2 = 0, p3 = 0, p5 = 0;
    for (int i = 1; i < n; i++) {
        int next = Math.min(dp[p2]*2, Math.min(dp[p3]*3, dp[p5]*5));
        dp[i] = next;
        if (next == dp[p2]*2) p2++;
        if (next == dp[p3]*3) p3++;
        if (next == dp[p5]*5) p5++;
    }
    return dp[n-1];
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q233. Meeting Rooms III
**Difficulty:** Hard | **Companies:** Amazon, Google

**Problem:** Given n rooms and meetings, find the room that held the most meetings.

**Solution:**
```java
public int mostBooked(int n, int[][] meetings) {
    Arrays.sort(meetings, (a,b)->a[0]-b[0]);
    int[] count = new int[n];
    PriorityQueue<Integer> available = new PriorityQueue<>();
    PriorityQueue<long[]> used = new PriorityQueue<>((a,b)->a[0]!=b[0]?(int)(a[0]-b[0]):(int)(a[1]-b[1]));
    for (int i = 0; i < n; i++) available.offer(i);
    for (int[] m : meetings) {
        long start = m[0], end = m[1];
        while (!used.isEmpty() && used.peek()[0] <= start) available.offer((int)used.poll()[1]);
        if (available.isEmpty()) {
            long[] earliest = used.poll();
            end = earliest[0] + (end - start);
            available.offer((int)earliest[1]);
        }
        int room = available.poll();
        count[room]++;
        used.offer(new long[]{end, room});
    }
    int maxCount = 0, result = 0;
    for (int i = 0; i < n; i++) if (count[i] > maxCount) { maxCount = count[i]; result = i; }
    return result;
}
```
**Time:** O(m log n) | **Space:** O(n)

---

### Q234. Employee Free Time
**Difficulty:** Hard | **Companies:** Amazon, Google

**Problem:** Given each employee's schedule, find the common free time.

**Solution:**
```java
public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    List<Interval> all = new ArrayList<>();
    for (List<Interval> s : schedule) all.addAll(s);
    all.sort((a,b)->a.start-b.start);
    List<Interval> result = new ArrayList<>();
    Interval prev = all.get(0);
    for (Interval curr : all) {
        if (curr.start > prev.end) { result.add(new Interval(prev.end, curr.start)); prev = curr; }
        else if (curr.end > prev.end) prev = curr;
    }
    return result;
}
```
**Time:** O(n log n) | **Space:** O(n)

---

### Q235. IPO (Maximize Capital)
**Difficulty:** Hard | **Companies:** Amazon, Google

**Problem:** Select at most k projects to maximize capital. Each project has cost and profit.

**Solution:**
```java
public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    int n = profits.length;
    int[][] projects = new int[n][2];
    for (int i = 0; i < n; i++) projects[i] = new int[]{capital[i], profits[i]};
    Arrays.sort(projects, (a,b)->a[0]-b[0]);
    PriorityQueue<Integer> maxProfit = new PriorityQueue<>(Collections.reverseOrder());
    int idx = 0;
    for (int i = 0; i < k; i++) {
        while (idx < n && projects[idx][0] <= w) maxProfit.offer(projects[idx++][1]);
        if (maxProfit.isEmpty()) break;
        w += maxProfit.poll();
    }
    return w;
}
```
**Time:** O(n log n + k log n) | **Space:** O(n)

---

### Q236. Swim in Rising Water
**Difficulty:** Hard | **Companies:** Google

**Problem:** Find minimum time t such that there is a path from (0,0) to (n-1,n-1) through cells ≤ t.

**Solution (Dijkstra):**
```java
public int swimInWater(int[][] grid) {
    int n = grid.length;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
    boolean[][] visited = new boolean[n][n];
    pq.offer(new int[]{grid[0][0], 0, 0});
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int t = curr[0], r = curr[1], c = curr[2];
        if (r == n-1 && c == n-1) return t;
        if (visited[r][c]) continue;
        visited[r][c] = true;
        for (int[] d : dirs) {
            int nr = r+d[0], nc = c+d[1];
            if (nr>=0&&nr<n&&nc>=0&&nc<n&&!visited[nr][nc])
                pq.offer(new int[]{Math.max(t, grid[nr][nc]), nr, nc});
        }
    }
    return -1;
}
```
**Time:** O(n² log n) | **Space:** O(n²)

---

### Q237. Minimum Cost to Connect All Points
**Difficulty:** Medium | **Companies:** Google, Amazon

**Problem:** Find minimum cost MST where cost = Manhattan distance.

**Solution (Prim's):**
```java
public int minCostConnectPoints(int[][] points) {
    int n = points.length, total = 0, added = 0;
    int[] minCost = new int[n];
    boolean[] visited = new boolean[n];
    Arrays.fill(minCost, Integer.MAX_VALUE);
    minCost[0] = 0;
    while (added < n) {
        int u = -1;
        for (int i = 0; i < n; i++) if (!visited[i] && (u == -1 || minCost[i] < minCost[u])) u = i;
        visited[u] = true; total += minCost[u]; added++;
        for (int v = 0; v < n; v++) {
            int cost = Math.abs(points[u][0]-points[v][0]) + Math.abs(points[u][1]-points[v][1]);
            if (!visited[v]) minCost[v] = Math.min(minCost[v], cost);
        }
    }
    return total;
}
```
**Time:** O(n²) | **Space:** O(n)

---

### Q238. Kth Largest Element in a Stream
**Difficulty:** Easy | **Companies:** Amazon, Google

**Solution:**
```java
class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int n : nums) add(n);
    }
    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) pq.poll();
        return pq.peek();
    }
}
```
**Time:** O(log k) per add | **Space:** O(k)

---

## SECTION 15: TRIE (Q239–Q245)

---

### Q239. Implement Trie (Prefix Tree)
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Solution:**
```java
class Trie {
    TrieNode root = new TrieNode();
    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c-'a'] == null) curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isEnd;
    }
    public boolean startsWith(String prefix) { return find(prefix) != null; }
    private TrieNode find(String s) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            if (curr.children[c-'a'] == null) return null;
            curr = curr.children[c-'a'];
        }
        return curr;
    }
}
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
}
```
**Time:** O(m) per op | **Space:** O(m·n)

---

### Q240. Add and Search Word (Wildcards)
**Difficulty:** Medium | **Companies:** Meta, Amazon

**Problem:** Design word dictionary supporting '.' wildcard in search.

**Solution:**
```java
class WordDictionary {
    TrieNode root = new TrieNode();
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c-'a'] == null) curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    public boolean search(String word) { return dfs(word, 0, root); }
    private boolean dfs(String word, int i, TrieNode node) {
        if (i == word.length()) return node.isEnd;
        char c = word.charAt(i);
        if (c == '.') {
            for (TrieNode child : node.children) if (child != null && dfs(word, i+1, child)) return true;
            return false;
        }
        return node.children[c-'a'] != null && dfs(word, i+1, node.children[c-'a']);
    }
}
```
**Time:** O(m) avg, O(m·26^m) worst (wildcards) | **Space:** O(m·n)

---

### Q241. Word Search II
**Difficulty:** Hard | **Companies:** Amazon, Google, Meta

**Problem:** Find all words from dictionary that exist in the board.

**Solution:**
```java
public List<String> findWords(char[][] board, String[] words) {
    TrieNode root = new TrieNode();
    for (String w : words) {
        TrieNode curr = root;
        for (char c : w.toCharArray()) {
            if (curr.children[c-'a'] == null) curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.word = w;
    }
    List<String> result = new ArrayList<>();
    for (int i = 0; i < board.length; i++)
        for (int j = 0; j < board[0].length; j++)
            dfs(board, i, j, root, result);
    return result;
}
private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
    if (i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]=='#') return;
    char c = board[i][j];
    TrieNode next = node.children[c-'a'];
    if (next == null) return;
    if (next.word != null) { result.add(next.word); next.word = null; }
    board[i][j] = '#';
    dfs(board,i+1,j,next,result); dfs(board,i-1,j,next,result);
    dfs(board,i,j+1,next,result); dfs(board,i,j-1,next,result);
    board[i][j] = c;
}
// TrieNode with word field:
class TrieNode { TrieNode[] children = new TrieNode[26]; String word; }
```
**Time:** O(m·n·4·3^(L-1)) | **Space:** O(W·L)

---

### Q242. Replace Words
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Replace words in sentence with shortest root from dictionary.

**Solution:**
```java
public String replaceWords(List<String> dictionary, String sentence) {
    TrieNode root = new TrieNode();
    for (String root2 : dictionary) {
        TrieNode curr = root;
        for (char c : root2.toCharArray()) {
            if (curr.children[c-'a'] == null) curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.word = root2;
    }
    StringBuilder sb = new StringBuilder();
    for (String word : sentence.split(" ")) {
        if (sb.length() > 0) sb.append(' ');
        TrieNode curr = root;
        boolean replaced = false;
        for (char c : word.toCharArray()) {
            if (curr.children[c-'a'] == null) break;
            curr = curr.children[c-'a'];
            if (curr.word != null) { sb.append(curr.word); replaced = true; break; }
        }
        if (!replaced) sb.append(word);
    }
    return sb.toString();
}
class TrieNode { TrieNode[] children = new TrieNode[26]; String word; }
```
**Time:** O(N·L) | **Space:** O(W·L)

---

### Q243. Design Search Autocomplete System
**Difficulty:** Hard | **Companies:** Amazon, Google

**Problem:** Implement an autocomplete system returning top 3 hot sentences matching current input.

**Solution:**
```java
class AutocompleteSystem {
    TrieNode root = new TrieNode();
    StringBuilder current = new StringBuilder();
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();
    }
    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) insert(sentences[i], times[i]);
    }
    private void insert(String s, int count) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
            curr.counts.merge(s, count, Integer::sum);
        }
    }
    public List<String> input(char c) {
        if (c == '#') { insert(current.toString(), 1); current = new StringBuilder(); return new ArrayList<>(); }
        current.append(c);
        TrieNode curr = root;
        for (char ch : current.toString().toCharArray()) {
            if (!curr.children.containsKey(ch)) return new ArrayList<>();
            curr = curr.children.get(ch);
        }
        return curr.counts.entrySet().stream()
            .sorted((a,b)->b.getValue().equals(a.getValue())?a.getKey().compareTo(b.getKey()):b.getValue()-a.getValue())
            .limit(3).map(Map.Entry::getKey).collect(java.util.stream.Collectors.toList());
    }
}
```
**Time:** O(L + n log n) per input | **Space:** O(n·L)

---

### Q244. Palindrome Pairs
**Difficulty:** Hard | **Companies:** Google, Amazon

**Problem:** Find all pairs (i, j) such that words[i]+words[j] is a palindrome.

**Solution:**
```java
public List<List<Integer>> palindromePairs(String[] words) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < words.length; i++) map.put(words[i], i);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
        String w = words[i];
        for (int j = 0; j <= w.length(); j++) {
            String left = w.substring(0, j), right = w.substring(j);
            if (isPalin(left)) {
                String rev = new StringBuilder(right).reverse().toString();
                if (map.containsKey(rev) && map.get(rev) != i) result.add(Arrays.asList(map.get(rev), i));
            }
            if (j != w.length() && isPalin(right)) {
                String rev = new StringBuilder(left).reverse().toString();
                if (map.containsKey(rev) && map.get(rev) != i) result.add(Arrays.asList(i, map.get(rev)));
            }
        }
    }
    return result;
}
private boolean isPalin(String s) {
    int l = 0, r = s.length()-1;
    while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
    return true;
}
```
**Time:** O(n·L²) | **Space:** O(n·L)

---

### Q245. Map Sum Pairs
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Implement insert(key, val) and sum(prefix) — sum of all keys starting with prefix.

**Solution:**
```java
class MapSum {
    TrieNode root = new TrieNode();
    Map<String, Integer> map = new HashMap<>();
    class TrieNode { TrieNode[] c = new TrieNode[26]; int val; }
    public void insert(String key, int val) {
        int diff = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode curr = root;
        for (char ch : key.toCharArray()) {
            if (curr.c[ch-'a'] == null) curr.c[ch-'a'] = new TrieNode();
            curr = curr.c[ch-'a'];
            curr.val += diff;
        }
    }
    public int sum(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.c[c-'a'] == null) return 0;
            curr = curr.c[c-'a'];
        }
        return curr.val;
    }
}
```
**Time:** O(L) per op | **Space:** O(n·L)

---

## SECTION 16: ADVANCED GRAPHS (Q246–Q260)

---

### Q246. Accounts Merge
**Difficulty:** Medium | **Companies:** Amazon, Google, Meta

**Problem:** Merge accounts with same email. Return merged account lists.

**Solution (Union-Find):**
```java
public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, String> parent = new HashMap<>(), owner = new HashMap<>();
    for (List<String> acc : accounts) {
        for (int i = 1; i < acc.size(); i++) {
            parent.putIfAbsent(acc.get(i), acc.get(i));
            owner.put(acc.get(i), acc.get(0));
        }
        for (int i = 2; i < acc.size(); i++) union(parent, acc.get(1), acc.get(i));
    }
    Map<String, TreeSet<String>> groups = new HashMap<>();
    for (String email : parent.keySet())
        groups.computeIfAbsent(find(parent, email), k -> new TreeSet<>()).add(email);
    List<List<String>> result = new ArrayList<>();
    for (Map.Entry<String, TreeSet<String>> e : groups.entrySet()) {
        List<String> list = new ArrayList<>();
        list.add(owner.get(e.getKey()));
        list.addAll(e.getValue());
        result.add(list);
    }
    return result;
}
private String find(Map<String, String> parent, String x) {
    if (!parent.get(x).equals(x)) parent.put(x, find(parent, parent.get(x)));
    return parent.get(x);
}
private void union(Map<String, String> parent, String a, String b) { parent.put(find(parent, a), find(parent, b)); }
```
**Time:** O(n·L log n) | **Space:** O(n·L)

---

### Q247. Critical Connections in a Network
**Difficulty:** Hard | **Companies:** Amazon, Google

**Problem:** Find all critical connections (bridges) in an undirected graph.

**Solution (Tarjan's Bridge Finding):**
```java
public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    List<List<Integer>> graph[] = new List[n];
    for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
    for (List<Integer> c : connections) { graph[c.get(0)].add(c.get(1)); graph[c.get(1)].add(c.get(0)); }
    List<List<Integer>> result = new ArrayList<>();
    int[] disc = new int[n], low = new int[n];
    Arrays.fill(disc, -1);
    dfs(graph, 0, -1, 0, disc, low, result);
    return result;
}
private int timer = 0;
private void dfs(List<Integer>[] graph, int u, int parent, int time, int[] disc, int[] low, List<List<Integer>> result) {
    disc[u] = low[u] = timer++;
    for (int v : graph[u]) {
        if (disc[v] == -1) {
            dfs(graph, v, u, time, disc, low, result);
            low[u] = Math.min(low[u], low[v]);
            if (low[v] > disc[u]) result.add(Arrays.asList(u, v));
        } else if (v != parent) {
            low[u] = Math.min(low[u], disc[v]);
        }
    }
}
```
**Time:** O(V+E) | **Space:** O(V+E)

---

### Q248. Longest Increasing Path in Matrix
**Difficulty:** Hard | **Companies:** Amazon, Google

**Problem:** Find the length of the longest increasing path in a matrix.

**Solution (DFS + Memoization):**
```java
public int longestIncreasingPath(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length, max = 0;
    int[][] memo = new int[m][n];
    for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) max = Math.max(max, dfs(matrix, i, j, memo));
    return max;
}
private int dfs(int[][] matrix, int i, int j, int[][] memo) {
    if (memo[i][j] != 0) return memo[i][j];
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    int best = 1;
    for (int[] d : dirs) {
        int r = i+d[0], c = j+d[1];
        if (r>=0&&r<matrix.length&&c>=0&&c<matrix[0].length&&matrix[r][c]>matrix[i][j])
            best = Math.max(best, 1 + dfs(matrix, r, c, memo));
    }
    return memo[i][j] = best;
}
```
**Time:** O(m·n) | **Space:** O(m·n)

---

### Q249. Reconstruct Itinerary
**Difficulty:** Hard | **Companies:** Amazon, Google

**Problem:** Reconstruct itinerary using all tickets exactly once (lexicographic order).

**Solution (Hierholzer's Eulerian Path):**
```java
public List<String> findItinerary(List<List<String>> tickets) {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    for (List<String> t : tickets)
        graph.computeIfAbsent(t.get(0), k -> new PriorityQueue<>()).offer(t.get(1));
    LinkedList<String> result = new LinkedList<>();
    dfs("JFK", graph, result);
    return result;
}
private void dfs(String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> result) {
    PriorityQueue<String> next = graph.get(airport);
    while (next != null && !next.isEmpty()) dfs(next.poll(), graph, result);
    result.addFirst(airport);
}
```
**Time:** O(E log E) | **Space:** O(E)

---

### Q250. Find Eventual Safe States
**Difficulty:** Medium | **Companies:** Google, Amazon

**Problem:** Find all nodes that are eventually safe (not on cycle).

**Solution:**
```java
public List<Integer> eventualSafeNodes(int[][] graph) {
    int n = graph.length;
    int[] state = new int[n]; // 0=unvisited, 1=visiting, 2=safe
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < n; i++) if (dfs(graph, i, state)) result.add(i);
    return result;
}
private boolean dfs(int[][] graph, int node, int[] state) {
    if (state[node] == 1) return false;
    if (state[node] == 2) return true;
    state[node] = 1;
    for (int next : graph[node]) if (!dfs(graph, next, state)) return false;
    state[node] = 2;
    return true;
}
```
**Time:** O(V+E) | **Space:** O(V)

---

### Q251. Jump Game IV
**Difficulty:** Hard | **Companies:** Amazon

**Problem:** From index i you can go to i±1 or any j where arr[i]==arr[j]. Minimum jumps to reach last index.

**Solution (BFS):**
```java
public int minJumps(int[] arr) {
    int n = arr.length;
    if (n == 1) return 0;
    Map<Integer, List<Integer>> sameVal = new HashMap<>();
    for (int i = 0; i < n; i++) sameVal.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[n];
    queue.offer(0); visited[0] = true;
    int steps = 0;
    while (!queue.isEmpty()) {
        int size = queue.size(); steps++;
        for (int k = 0; k < size; k++) {
            int i = queue.poll();
            List<Integer> neighbors = new ArrayList<>(Arrays.asList(i-1, i+1));
            neighbors.addAll(sameVal.getOrDefault(arr[i], new ArrayList<>()));
            sameVal.remove(arr[i]);
            for (int next : neighbors) {
                if (next == n-1) return steps;
                if (next >= 0 && next < n && !visited[next]) { visited[next] = true; queue.offer(next); }
            }
        }
    }
    return -1;
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q252. Bus Routes
**Difficulty:** Hard | **Companies:** Amazon, Google

**Problem:** Find minimum number of buses to take to reach destination.

**Solution:**
```java
public int numBusesToDestination(int[][] routes, int source, int target) {
    if (source == target) return 0;
    Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
    for (int i = 0; i < routes.length; i++)
        for (int stop : routes[i]) stopToRoutes.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
    Set<Integer> visitedStops = new HashSet<>(), visitedRoutes = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(source); visitedStops.add(source);
    int buses = 0;
    while (!queue.isEmpty()) {
        int size = queue.size(); buses++;
        for (int k = 0; k < size; k++) {
            int stop = queue.poll();
            for (int route : stopToRoutes.getOrDefault(stop, new ArrayList<>())) {
                if (visitedRoutes.contains(route)) continue;
                visitedRoutes.add(route);
                for (int nextStop : routes[route]) {
                    if (nextStop == target) return buses;
                    if (!visitedStops.contains(nextStop)) { visitedStops.add(nextStop); queue.offer(nextStop); }
                }
            }
        }
    }
    return -1;
}
```
**Time:** O(N·M) | **Space:** O(N·M)

---

### Q253. Open the Lock
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find minimum turns to open lock from "0000" to target, avoiding deadends.

**Solution:**
```java
public int openLock(String[] deadends, String target) {
    Set<String> dead = new HashSet<>(Arrays.asList(deadends));
    if (dead.contains("0000")) return -1;
    Queue<String> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    queue.offer("0000"); visited.add("0000");
    int turns = 0;
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int k = 0; k < size; k++) {
            String curr = queue.poll();
            if (curr.equals(target)) return turns;
            for (int i = 0; i < 4; i++) {
                for (int d : new int[]{1, -1}) {
                    char[] next = curr.toCharArray();
                    next[i] = (char)(((next[i]-'0'+d+10)%10)+'0');
                    String s = new String(next);
                    if (!visited.contains(s) && !dead.contains(s)) { visited.add(s); queue.offer(s); }
                }
            }
        }
        turns++;
    }
    return -1;
}
```
**Time:** O(10^4) | **Space:** O(10^4)

---

### Q254. Snakes and Ladders
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find minimum dice rolls to reach the last cell in Snakes and Ladders.

**Solution:**
```java
public int snakesAndLadders(int[][] board) {
    int n = board.length;
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[n*n+1];
    queue.offer(1); visited[1] = true;
    int moves = 0;
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int k = 0; k < size; k++) {
            int curr = queue.poll();
            if (curr == n*n) return moves;
            for (int dice = 1; dice <= 6 && curr+dice <= n*n; dice++) {
                int next = curr + dice;
                int[] pos = getPos(next, n);
                if (board[pos[0]][pos[1]] != -1) next = board[pos[0]][pos[1]];
                if (!visited[next]) { visited[next] = true; queue.offer(next); }
            }
        }
        moves++;
    }
    return -1;
}
private int[] getPos(int num, int n) {
    int r = (num-1)/n, c = (num-1)%n;
    if (r%2 == 1) c = n-1-c;
    return new int[]{n-1-r, c};
}
```
**Time:** O(n²) | **Space:** O(n²)

---

### Q255. Minimum Number of Vertices to Reach All Nodes
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find minimum set of vertices from which all nodes are reachable.

**Solution:**
```java
public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    Set<Integer> hasParent = new HashSet<>();
    for (List<Integer> e : edges) hasParent.add(e.get(1));
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < n; i++) if (!hasParent.contains(i)) result.add(i);
    return result;
}
```
**Time:** O(V+E) | **Space:** O(V)

---

### Q256. Keys and Rooms
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Can you visit all rooms? Room 0 is unlocked; keys in rooms unlock others.

**Solution:**
```java
public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    Set<Integer> visited = new HashSet<>();
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(0);
    while (!stack.isEmpty()) {
        int room = stack.pop();
        visited.add(room);
        for (int key : rooms.get(room)) if (!visited.contains(key)) stack.push(key);
    }
    return visited.size() == rooms.size();
}
```
**Time:** O(V+E) | **Space:** O(V)

---

### Q257. Number of Operations to Make Network Connected
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Minimum cables to move to connect all computers.

**Solution:**
```java
public int makeConnected(int n, int[][] connections) {
    if (connections.length < n-1) return -1;
    int[] parent = new int[n];
    for (int i = 0; i < n; i++) parent[i] = i;
    int components = n;
    for (int[] c : connections) {
        int p1 = find(parent, c[0]), p2 = find(parent, c[1]);
        if (p1 != p2) { parent[p1] = p2; components--; }
    }
    return components - 1;
}
private int find(int[] p, int x) { return p[x]==x?x:(p[x]=find(p,p[x])); }
```
**Time:** O(n·α(n)) | **Space:** O(n)

---

### Q258. Minimum Height Trees
**Difficulty:** Medium | **Companies:** Amazon, Google

**Problem:** Find all roots of minimum height trees in an undirected graph (tree structure).

**Solution (Topological Pruning):**
```java
public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 1) return Collections.singletonList(0);
    List<Set<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) graph.add(new HashSet<>());
    for (int[] e : edges) { graph.get(e[0]).add(e[1]); graph.get(e[1]).add(e[0]); }
    Queue<Integer> leaves = new LinkedList<>();
    for (int i = 0; i < n; i++) if (graph.get(i).size() == 1) leaves.offer(i);
    int remaining = n;
    while (remaining > 2) {
        int size = leaves.size(); remaining -= size;
        for (int k = 0; k < size; k++) {
            int leaf = leaves.poll();
            int neighbor = graph.get(leaf).iterator().next();
            graph.get(neighbor).remove(leaf);
            if (graph.get(neighbor).size() == 1) leaves.offer(neighbor);
        }
    }
    return new ArrayList<>(leaves);
}
```
**Time:** O(n) | **Space:** O(n)

---

### Q259. Alien Dictionary (Verification)
**Difficulty:** Hard | **Companies:** Amazon, Google, Meta

*(See Q171 — included for completeness; focus on edge cases)*

**Additional edge case handling:**
```java
// Key insight: if w1 is prefix of w2 and comes after w2 in list → invalid
// Example: ["abc","ab"] → return ""
```

---

### Q260. Cheapest Price Within K Stops — Dijkstra variant
**Difficulty:** Medium | **Companies:** Amazon, Google

**Solution (Dijkstra with stops constraint):**
```java
public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    Map<Integer, List<int[]>> graph = new HashMap<>();
    for (int[] f : flights) graph.computeIfAbsent(f[0], x->new ArrayList<>()).add(new int[]{f[1],f[2]});
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
    pq.offer(new int[]{0, src, k+1});
    int[] visited = new int[n]; Arrays.fill(visited, -1);
    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int cost=curr[0], node=curr[1], stops=curr[2];
        if (node == dst) return cost;
        if (stops == 0 || (visited[node] >= 0 && visited[node] >= stops)) continue;
        visited[node] = stops;
        for (int[] next : graph.getOrDefault(node, new ArrayList<>())) {
            pq.offer(new int[]{cost+next[1], next[0], stops-1});
        }
    }
    return -1;
}
```
**Time:** O(E·k·log(E·k)) | **Space:** O(n+E)
