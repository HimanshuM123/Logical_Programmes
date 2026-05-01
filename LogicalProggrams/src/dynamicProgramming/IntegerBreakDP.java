package dynamicProgramming;

public class IntegerBreakDP {
	public static void main(String[] args) {
		IntegerBreakDP obj = new IntegerBreakDP();
		
		int result =obj.integerBreak(10);
		System.out.println(result);
		
	}
	
	  int[] memo;

	    public int integerBreak(int n) {
	        memo = new int[n + 1];
	        return dfs(n);
	    }

	    private int dfs(int n) {
	        if (n == 1) return 1;
	        if (memo[n] != 0) return memo[n];

	        int max = 0;
	        for (int i = 1; i < n; i++) {
	            int noBreak = i * (n - i);
	            int breakMore = i * dfs(n - i);
	            max = Math.max(max, Math.max(noBreak, breakMore));
	        }

	        memo[n] = max;
	        return max;
	    }

}
