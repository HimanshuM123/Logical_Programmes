package dynamicProgramming;

public class MinimizeSteps {
	static int minOperation(int k)
	{
	     
	    // dp is initialised
	    // to store the steps
	    int dp[] = new int[k + 1];
	 
	    for(int i = 1; i <= k; i++)
	    {
	       dp[i] = dp[i - 1] + 1;
	        
	       // For all even numbers
	       if (i % 2 == 0)
	       {
	    	 //  System.out.print(dp[i]);
	    	   //System.out.print(dp[i / 2] + 1);
	           dp[i] = Math.min(dp[i], dp[i / 2] + 1);
	       }
	    }
	    return dp[k];
	}
	public static void main(String[] args) {
		 int K = 12;
		    System.out.print( minOperation(K));
	}

}

/*

Given a positive integer K, the task is to find the minimum number of operations of the 
following two types, required to change 0 to K: 
 

Add one to the operand  ( + 1)
Multiply the operand by 2. (* 2)


*/