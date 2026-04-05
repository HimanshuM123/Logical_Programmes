package codingInterview;


/*
 Problem

Given an integer n, return true if it is a power of 2. Otherwise, return false.

A number is a power of 2 if:

2^x = n  (for some integer x ≥ 0)
 */
public class PowerOfTwo {
	
	public static void main(String[] args) {
		boolean result = isPowerTwo(8);
		System.out.println(result);
	}
	
	
	private static  boolean isPowerTwo(int n) {
		if(n<=0) return false;
		return (n & (n-1))==0;
	}

}
