package number;

public class SmallestNumberDivisible {
	public static void main(String[] args) {
		 int N = 7;
		 
		    // Function Call
		    smallestNumber(N);
	}

	static void smallestNumber(int N)
	{
	 
	    // Find largest n digit number
	    int L = (int) (Math.pow(10, N) - 1);
	 
	    // Find smallest n digit number
	    int S = (int) Math.pow(10, N - 1);
	 
	    for (int i = S; i <= L; i++) 
	    {
	 
	        // If i is divisible by N,
	        // then print i and return ;
	        if (i % N == 0) 
	        {
	            System.out.print(i);
	            return;
	        }
	    }
	}
}


//Given a positive integers N, the task is to find the smallest N digit number divisible by N.


/*


Input: N = 2 
Output: 10 
Explanation: 
10 is the smallest 2-digit number which is divisible by 2.

Input: N = 3 
Output: 102 
Explanation: 
102 is the smallest 3-digit number which is divisible by 3. 


*/