package codingInterview;

public class MazeWayCount {
	
	public static void main(String[] args) {
		int n = 3;
        int m = 3;
        System.out.println(mazeWayCount(m,n));
    }
	
	
	private static int mazeWayCount(int m, int n) {
		int count = 0;
		int[][] dp = new int[m][n];

		// Initialize first row and column
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}

		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}

		// Fill the dp table
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		count = dp[m - 1][n - 1];

		return count;

	}

}

/*
 🚀 Step 2: Initialize First Column
for (int i = 0; i < m; i++) {
    dp[i][0] = 1;
}

Why?

In the first column, you can only move DOWN
There is only ONE way to reach each cell

After this:

[ 1  0  0 ]
[ 1  0  0 ]
[ 1  0  0 ]
🚀 Step 3: Initialize First Row
for (int i = 0; i < n; i++) {
    dp[0][i] = 1;
}

Why?

In the first row, you can only move RIGHT
Again, only ONE way

Now table becomes:

[ 1  1  1 ]
[ 1  0  0 ]
[ 1  0  0 ]
🔁 Step 4: Fill the Rest of the Table
for (int i = 1; i < m; i++) {
    for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    }
}

Now we compute each cell using:

top + left
📊 Example Walkthrough (3x3)
Start:
[ 1  1  1 ]
[ 1  0  0 ]
[ 1  0  0 ]
Cell (1,1):
dp[1][1] = dp[0][1] + dp[1][0]
         = 1 + 1 = 2
[ 1  1  1 ]
[ 1  2  0 ]
[ 1  0  0 ]
Cell (1,2):
dp[1][2] = dp[0][2] + dp[1][1]
         = 1 + 2 = 3
[ 1  1  1 ]
[ 1  2  3 ]
[ 1  0  0 ]
Cell (2,1):
dp[2][1] = dp[1][1] + dp[2][0]
         = 2 + 1 = 3
[ 1  1  1 ]
[ 1  2  3 ]
[ 1  3  0 ]
Cell (2,2):
dp[2][2] = dp[1][2] + dp[2][1]
         = 3 + 3 = 6

Final table:

[ 1  1  1 ]
[ 1  2  3 ]
[ 1  3  6 ]
🎯 Step 5: Return Answer
count = dp[m - 1][n - 1];

👉 Bottom-right cell = total ways

dp[2][2] = 6
 
 
 */
