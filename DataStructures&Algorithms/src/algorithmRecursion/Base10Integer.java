package algorithmRecursion;

public class Base10Integer {
	public static void main(String[] args) {
		printInt1(44);	
	}

	public static void printInt1(int number) {
		char digit = (char) (number % 10 + '0');
		number = number / 10;
		if (number != 0)
			printInt1(number / 10);
		System.out.print(" " + digit);
	}

}
