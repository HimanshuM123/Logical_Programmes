package codingInterview;

/*
 * 
You’re climbing a staircase with n steps.
Each time, you can climb either 1 step or 2 steps.

👉 How many distinct ways are there to reach the top?
 */
public class ClimbingStairs {

	public static void main(String[] args) {
		int result = climbStairs(6);
		System.out.println(result);
		
	}
	
	
	private static int climbStairs(int n) {
		if(n<=2) {
			return n;
		}
		
		int a=1;
		int b=2;
		
		for(int i=3 ; i<=n ;i++) {
			int c=a+b;
			a=b;
			b=c;
		}
		return b;
				
	}
}
