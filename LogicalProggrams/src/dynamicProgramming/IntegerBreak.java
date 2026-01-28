package dynamicProgramming;

public class IntegerBreak {
	public static void main(String[] args) {
		
		int result =integerBreak2(10);
		System.out.println(result);
		
	}
	
	 public static int integerBreak(int n) {

	        int[] dp = new int[n + 1];
	        dp[1] = 1;

	        for (int i = 2; i <= n; i++) {
	            for (int j = 1; j < i; j++) {
	            	System.out.println(dp[i]);
	            	System.out.println(j * (i - j));
	            	System.out.println(j * dp[i - j]);
	            	System.out.println("----------------------");
	                dp[i] = Math.max(
	                        dp[i],
	                        Math.max(j * (i - j), j * dp[i - j])
	                );
	            }
	        }
	        return dp[n];
	    }
	 
	 public static int integerBreak2(int n) {

	        if (n == 2) return 1;
	        if (n == 3) return 2;

	        int product = 1;

	        while (n > 4) {
	            product = product * 3;
	            n = n-3;
	        }

	        return product * n;
	    }
	 
	 

}
