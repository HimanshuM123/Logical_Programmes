package myPkg;

public class Factorial {
	public static void main(String[] args) {
		int num = 5;
		int fact = 1;
		for (int i = 0; i < num; i++) {
			fact = fact * (num - i);
		}
		System.out.println(fact);
	}
}
