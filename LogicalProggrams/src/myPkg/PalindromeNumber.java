package myPkg;

public class PalindromeNumber {
	public static void main(String[] args) {
		int number = 123321;
		int num = number;
		int revNum = 0;

		while (num != 0) {
			revNum = num % 10 + revNum * 10;
			num = num / 10;
		}
		if (number == revNum) {
			System.out.println("The number is palindrome");
		} else {
			System.out.println("The number is not palindrome");
		}
	}

}
