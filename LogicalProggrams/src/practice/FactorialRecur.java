package practice;

public class FactorialRecur {
public static void main(String[] args) {
	int factorial= getFactorial(5);
	System.out.println("The result is "+factorial);
}

private static int  getFactorial(int n) {
	if(n==0) {
		return 1;
	}
	
	int fact = n * getFactorial(n-1);
	return fact;
}
}
