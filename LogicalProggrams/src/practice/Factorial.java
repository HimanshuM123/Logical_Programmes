package practice;

public class Factorial {
public static void main(String[] args) {
	int n=5;
	int factorial= getFactorial(n);
	System.out.println("The factorial of "+n+" is "+factorial);
	
}

private static int getFactorial(int n) {
	int fact =1;
	for(int i=1;i<=n;i++) {
		fact = fact *i;
}
	return fact;
}
}


// 5!=120;
