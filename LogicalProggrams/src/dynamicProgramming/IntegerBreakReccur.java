package dynamicProgramming;

public class IntegerBreakReccur {
	public static void main(String[] args) {
		
		int result =integerBreakRecur(5);
		System.out.println(result);
		
	}
	
	 public static int integerBreakRecur(int n) {
	        if (n == 1) return 1;

	        int max = 0;

	        for (int i = 1; i < n; i++) {
	            int noBreak = i * (n - i);
	            System.out.println(noBreak);
	            int breakMore = i * integerBreakRecur(n - i);
	            System.out.println("------------");
	            System.out.println(breakMore);

	            max = Math.max(max, Math.max(noBreak, breakMore));
	        }
	        return max;
	    }

}
