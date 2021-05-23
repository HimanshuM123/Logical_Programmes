package com.dsa.recur;

public class RecurFactorial {
	int y=0;
	public static void main(String[] args) {
		RecurFactorial factorial = new RecurFactorial();
		System.out.println(factorial.fact(5));

	}

	int fact(int x) {
		if (x <= 0)
			return 1;
		else
			 y= x * fact(x - 1);
		return y;
	}

}
